package net.mcreator.ethernalkronuz;

import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.ScreenEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.client.Minecraft;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

import java.util.Optional;

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
				player.getPersistentData().put("RestrictedItemInQueue", droppedItem.save(new CompoundTag()));
				if (!player.level.isClientSide)
					player.displayClientMessage(new TextComponent("Inventário cheio! Item Restrito guardado temporariamente."), true);
			}
		}
	}

	@SubscribeEvent
	public static void onMouseClicked(ScreenEvent.MouseClickedEvent event) {
		if (!(event.getScreen() instanceof net.minecraft.client.gui.screens.inventory.AbstractContainerScreen<?> screen))
			return;
		Player player = Minecraft.getInstance().player;
		if (player != null && !player.isCreative()) {
			Slot clickedSlot = screen.getSlotUnderMouse();
			if (clickedSlot != null && clickedSlot.hasItem()) {
				ItemStack clickedItem = clickedSlot.getItem();
				if (isRestrictedItem(clickedItem)) {
					boolean isPlayerInventorySlot = clickedSlot.container == player.getInventory();
					if (!isPlayerInventorySlot) {
						event.setCanceled(true);
						boolean success = player.getInventory().add(clickedItem.copy());
						if (!success) {
							CompoundTag itemTag = clickedItem.save(new CompoundTag());
							ListTag list = player.getPersistentData().getList("RestrictedItemsQueue", 10);
							list.add(itemTag);
							player.getPersistentData().put("RestrictedItemsQueue", list);
							clickedSlot.set(ItemStack.EMPTY);
							player.displayClientMessage(new TextComponent("Inventário cheio! Item Restrito guardado temporariamente."), true);
						}
					}
				}
			}
		}
	}

	@SubscribeEvent
	public static void onContainerClose(PlayerContainerEvent.Close event) {
		Player player = event.getPlayer();
		if (player.isCreative())
			return;
		for (Slot slot : player.containerMenu.slots) {
			if (slot.hasItem()) {
				ItemStack stack = slot.getItem();
				if (isRestrictedItem(stack)) {
					if (!player.getInventory().contains(stack) && !isItemInCurios(player, stack)) {
						slot.set(ItemStack.EMPTY);
						CuriosApi.getCuriosHelper().getCuriosHandler(player).ifPresent(handler -> {
							Optional<ICurioStacksHandler> curiosSlot = handler.getStacksHandler("curios");
							curiosSlot.ifPresent(stacksHandler -> stacksHandler.getStacks().setStackInSlot(0, stack));
						});
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
		if (player.level.isClientSide || player.isCreative())
			return;
		CompoundTag data = player.getPersistentData();
		if (!data.contains("RestrictedItemsQueue", 9))
			return;
		ListTag list = data.getList("RestrictedItemsQueue", 10);
		if (!list.isEmpty() && player.getInventory().getFreeSlot() != -1) {
			CompoundTag tag = (CompoundTag) list.remove(0);
			ItemStack stack = ItemStack.of(tag);
			player.getInventory().add(stack);
			player.displayClientMessage(new TextComponent("Item Restrito restaurado ao inventário."), true);
			data.put("RestrictedItemsQueue", list);
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
