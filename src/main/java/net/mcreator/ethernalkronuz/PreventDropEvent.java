package net.mcreator.ethernalkronuz;

import top.theillusivec4.curios.api.type.inventory.ICurioStacksHandler;
import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.client.event.ScreenEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
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
		if (isRestrictedItem(droppedItem)) {
			event.setCanceled(true);
			event.getPlayer().getInventory().add(droppedItem);
		}
	}

	@SubscribeEvent
	public static void onMouseClicked(ScreenEvent.MouseClickedEvent event) {
		if (!(event.getScreen() instanceof net.minecraft.client.gui.screens.inventory.AbstractContainerScreen<?>))
			return;
		Player player = Minecraft.getInstance().player;
		if (player != null && !player.isCreative()) {
			Slot clickedSlot = ((net.minecraft.client.gui.screens.inventory.AbstractContainerScreen<?>) event.getScreen()).getSlotUnderMouse();
			if (clickedSlot != null && clickedSlot.hasItem()) {
				ItemStack clickedItem = clickedSlot.getItem();
				if (isRestrictedItem(clickedItem))
					event.setCanceled(true);
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

	private static boolean isRestrictedItem(ItemStack stack) {
		return stack.getItem() == EthernalKronuzModItems.TERRA_BLADE_SETUP.get() || stack.getItem() == EthernalKronuzModItems.BLADE_OF_THE_VOID.get() || stack.getItem() == EthernalKronuzModItems.MURASAMA.get()
				|| stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_HELMET.get() || stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_CHESTPLATE.get() || stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_LEGGINGS.get()
				|| stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_BOOTS.get() || stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_HELMET.get() || stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_CHESTPLATE.get()
				|| stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_LEGGINGS.get() || stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_BOOTS.get() || stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_HELMET.get()
				|| stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_CHESTPLATE.get() || stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_LEGGINGS.get() || stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_BOOTS.get()
				|| stack.getItem() == EthernalKronuzModItems.BIFROST_KEY.get();
	}

	private static boolean isItemInCurios(Player player, ItemStack stack) {
		return CuriosApi.getCuriosHelper().findFirstCurio(player, stack.getItem()).isPresent();
	}
}
