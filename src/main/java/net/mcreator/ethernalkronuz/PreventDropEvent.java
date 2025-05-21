package net.mcreator.ethernalkronuz;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

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
		if (isRestrictedItem(droppedItem)) {
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

	@OnlyIn(Dist.CLIENT)
	@Mod.EventBusSubscriber(value = Dist.CLIENT)
	public static class ClientEvents {
		@SubscribeEvent
		public static void onMouseClicked(net.minecraftforge.client.event.ScreenEvent.MouseClickedEvent event) {
			if (!(event.getScreen() instanceof net.minecraft.client.gui.screens.inventory.AbstractContainerScreen<?> screen))
				return;
			net.minecraft.client.player.LocalPlayer player = net.minecraft.client.Minecraft.getInstance().player;
			if (player != null && !player.isCreative()) {
				Slot clickedSlot = screen.getSlotUnderMouse();
				if (clickedSlot != null && clickedSlot.hasItem()) {
					ItemStack clickedItem = clickedSlot.getItem();
					if (isRestrictedItem(clickedItem)) {
						boolean isPlayerInventorySlot = screen.getMenu().getSlot(clickedSlot.index).container == player.getInventory();
						if (!isPlayerInventorySlot) {
							event.setCanceled(true);
							boolean success = player.getInventory().add(clickedItem.copy());
							if (!success) {
								CompoundTag itemTag = clickedItem.save(new CompoundTag());
								CompoundTag data = player.getPersistentData();
								ListTag list = data.contains("RestrictedItemsQueue", Tag.TAG_LIST) ? data.getList("RestrictedItemsQueue", Tag.TAG_COMPOUND) : new ListTag();
								list.add(itemTag);
								data.put("RestrictedItemsQueue", list);
								clickedSlot.set(ItemStack.EMPTY);
							}
						}
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
				if (isRestrictedItem(stack) && !slot.container.equals(player.getInventory())) {
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
				if (isRestrictedItem(stack))
					player.getInventory().setItem(i, ItemStack.EMPTY);
			}
			CuriosApi.getCuriosHelper().getCuriosHandler(player).ifPresent(handler -> {
				handler.getCurios().forEach((slot, stacksHandler) -> {
					for (int i = 0; i < stacksHandler.getStacks().getSlots(); i++) {
						ItemStack stack = stacksHandler.getStacks().getStackInSlot(i);
						if (isRestrictedItem(stack))
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
			if (isRestrictedItem(stack))
				player.getInventory().setItem(i, stack.copy());
		}
	}

	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
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
	}

	private static boolean isRestrictedItem(ItemStack stack) {
		return stack.getItem() == EthernalKronuzModItems.TERRA_BLADE.get() || stack.getItem() == EthernalKronuzModItems.BLADE_OF_THE_VOID.get() || stack.getItem() == EthernalKronuzModItems.MURASAMA.get()
				|| stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_HELMET.get() || stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_CHESTPLATE.get() || stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_LEGGINGS.get()
				|| stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_BOOTS.get() || stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_HELMET.get() || stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_CHESTPLATE.get()
				|| stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_LEGGINGS.get() || stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_BOOTS.get() || stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_HELMET.get()
				|| stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_CHESTPLATE.get() || stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_LEGGINGS.get() || stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_BOOTS.get()
				|| stack.getItem() == EthernalKronuzModItems.BIFROST_KEY.get() || stack.getItem() == EthernalKronuzModItems.THE_RISE_PARCHMENT.get();
	}

	private static boolean isItemInCurios(Player player, ItemStack stack) {
		return CuriosApi.getCuriosHelper().findFirstCurio(player, stack.getItem()).isPresent();
	}
}
