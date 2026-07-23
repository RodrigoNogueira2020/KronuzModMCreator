package net.mcreator.ethernalkronuz;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

@Mod.EventBusSubscriber
public class PreventDropEvent {
	@SubscribeEvent
	public static void onItemToss(ItemTossEvent event) {
		if (event.getPlayer().isCreative())
			return;
		ItemStack droppedItem = event.getEntityItem().getItem();
		Player player = event.getPlayer();
		if (isRestrictedItem(droppedItem, player)) {
			event.setCanceled(true);
			boolean success = player.getInventory().add(droppedItem.copy());
			if (!success) {
				CompoundTag data = player.getPersistentData();
				ListTag list = data.contains("RestrictedItemsQueue", Tag.TAG_LIST) ? data.getList("RestrictedItemsQueue", Tag.TAG_COMPOUND) : new ListTag();
				list.add(droppedItem.save(new CompoundTag()));
				data.put("RestrictedItemsQueue", list);
			}
		}
	}

	@SubscribeEvent
	public static void onMouseClicked(net.minecraftforge.client.event.ScreenEvent.MouseClickedEvent event) {
		if (!(event.getScreen() instanceof net.minecraft.client.gui.screens.inventory.AbstractContainerScreen<?> screen))
			return;
		net.minecraft.client.player.LocalPlayer player = net.minecraft.client.Minecraft.getInstance().player;
		if (player != null && !player.isCreative()) {
			Slot clickedSlot = screen.getSlotUnderMouse();
			if (clickedSlot != null && clickedSlot.hasItem()) {
				ItemStack clickedItem = clickedSlot.getItem();
				if (isRestrictedItem(clickedItem, player)) {
					Slot resolvedSlot = screen.getMenu().getSlot(clickedSlot.index);
					boolean isPlayerInventorySlot = resolvedSlot.container == player.getInventory();
					boolean isCurioSlot = isCurioSlotInMenu(player, resolvedSlot);
					if (!isPlayerInventorySlot && !isCurioSlot) {
						event.setCanceled(true);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onContainerOpen(PlayerContainerEvent.Open event) {
		checkAndRemoveRestrictedItems(event.getContainer(), event.getPlayer());
	}

	@SubscribeEvent
	public static void onContainerClose(PlayerContainerEvent.Close event) {
		checkAndRemoveRestrictedItems(event.getContainer(), event.getPlayer());
	}

	private static void checkAndRemoveRestrictedItems(AbstractContainerMenu container, Player player) {
		if (player.isCreative())
			return;
		for (Slot slot : container.slots) {
			if (slot.hasItem()) {
				ItemStack stack = slot.getItem();
				if (isRestrictedItem(stack, player) && !slot.container.equals(player.getInventory()) && !isCurioSlotInMenu(player, slot)) {
					boolean success = player.getInventory().add(stack.copy());
					if (success)
						slot.set(ItemStack.EMPTY);
					else {
						CompoundTag data = player.getPersistentData();
						ListTag list = data.contains("RestrictedItemsQueue", Tag.TAG_LIST) ? data.getList("RestrictedItemsQueue", Tag.TAG_COMPOUND) : new ListTag();
						list.add(stack.save(new CompoundTag()));
						data.put("RestrictedItemsQueue", list);
						slot.set(ItemStack.EMPTY);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onPlayerDeath(LivingDeathEvent event) {
		if (event.getEntity() instanceof Player player) {
			if (player.isCreative())
				return;
			for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
				ItemStack stack = player.getInventory().getItem(i);
				if (isRestrictedItem(stack, player))
					player.getInventory().setItem(i, ItemStack.EMPTY);
			}
			CuriosApi.getCuriosHelper().getCuriosHandler(player).ifPresent(handler -> {
				handler.getCurios().forEach((slot, stacksHandler) -> {
					for (int i = 0; i < stacksHandler.getStacks().getSlots(); i++) {
						ItemStack stack = stacksHandler.getStacks().getStackInSlot(i);
						if (isRestrictedItem(stack, player))
							stacksHandler.getStacks().setStackInSlot(i, ItemStack.EMPTY);
					}
				});
			});
		}
	}

	@SubscribeEvent
	public static void onPlayerClone(PlayerEvent.Clone event) {
		if (!event.isWasDeath())
			return;
		Player original = event.getOriginal();
		Player player = event.getPlayer();
		for (int i = 0; i < original.getInventory().getContainerSize(); i++) {
			ItemStack stack = original.getInventory().getItem(i);
			if (isRestrictedItem(stack, player))
				player.getInventory().setItem(i, stack.copy());
		}
	}

	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase != TickEvent.Phase.END)
			return;
		Player player = event.player;
		if (player.level.isClientSide)
			return;
		CompoundTag data = player.getPersistentData();
		ListTag list = data.contains("RestrictedItemsQueue", Tag.TAG_LIST) ? data.getList("RestrictedItemsQueue", Tag.TAG_COMPOUND) : new ListTag();
		if (!list.isEmpty()) {
			int freeSlot = player.getInventory().getFreeSlot();
			if (freeSlot != -1) {
				CompoundTag tag = (CompoundTag) list.get(0);
				ItemStack stack = ItemStack.of(tag);
				boolean added = player.getInventory().add(stack);
				if (added)
					list.remove(0);
				data.put("RestrictedItemsQueue", list);
			}
		}
		if (player.containerMenu != null && player.containerMenu != player.inventoryMenu)
			checkAndRemoveRestrictedItems(player.containerMenu, player);
		// Restritos de Curio que apareçam no inventário principal (índices 9–35, ou seja,
		// fora da hotbar 0–8) significam que já existe uma cópia legítima equipada no Curio
		// Slot -> esta é a cópia extra criada pelo drag. Eliminamo-la, sem tentar reequipar.
		for (int i = 9; i < 36; i++) {
			ItemStack stack = player.getInventory().getItem(i);
			if (!stack.isEmpty() && isRestrictedItem(stack, player) && isItemTypeEquippedInCurios(player, stack)) {
				player.getInventory().setItem(i, ItemStack.EMPTY);
			}
		}
	}

	private static boolean isRestrictedItem(ItemStack stack, @javax.annotation.Nullable Player player) {
		return stack.getItem() == EthernalKronuzModItems.TERRA_BLADE.get() || stack.getItem() == EthernalKronuzModItems.BLADE_OF_THE_VOID.get() || stack.getItem() == EthernalKronuzModItems.MURASAMA.get()
				|| stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_HELMET.get() || stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_CHESTPLATE.get() || stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_LEGGINGS.get()
				|| stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_BOOTS.get() || stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_HELMET.get() || stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_CHESTPLATE.get()
				|| stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_LEGGINGS.get() || stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_BOOTS.get() || stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_HELMET.get()
				|| stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_CHESTPLATE.get() || stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_LEGGINGS.get() || stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_BOOTS.get()
				|| stack.getItem() == EthernalKronuzModItems.BIFROST_KEY.get();
	}

	private static boolean isCurioSlotInMenu(Player player, Slot slot) {
		if (!(slot instanceof SlotItemHandler handlerSlot))
			return false;
		var handlerRef = handlerSlot.getItemHandler();
		java.util.concurrent.atomic.AtomicBoolean match = new java.util.concurrent.atomic.AtomicBoolean(false);
		CuriosApi.getCuriosHelper().getCuriosHandler(player).ifPresent(handler -> {
			handler.getCurios().forEach((id, stacksHandler) -> {
				if (stacksHandler.getStacks() == handlerRef)
					match.set(true);
			});
		});
		return match.get();
	}

	/**
	 * Verifica se já existe uma cópia deste TIPO de item equipada nalgum Curio Slot
	 * (comparação por Item, não por instância — ao contrário de isCurioSlotInMenu).
	 * Usado só para detetar a cópia extra que sobra no inventário principal após um drag.
	 */
	private static boolean isItemTypeEquippedInCurios(Player player, ItemStack stack) {
		java.util.concurrent.atomic.AtomicBoolean found = new java.util.concurrent.atomic.AtomicBoolean(false);
		CuriosApi.getCuriosHelper().getCuriosHandler(player).ifPresent(handler -> {
			handler.getCurios().forEach((id, stacksHandler) -> {
				var stacks = stacksHandler.getStacks();
				for (int i = 0; i < stacks.getSlots(); i++) {
					ItemStack curioStack = stacks.getStackInSlot(i);
					if (!curioStack.isEmpty() && curioStack.getItem() == stack.getItem()) {
						found.set(true);
						return;
					}
				}
			});
		});
		return found.get();
	}
}
