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

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

import java.util.Optional;

@Mod.EventBusSubscriber(modid = "ethernalkronuz", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PreventDropEvent {
	@SubscribeEvent
	public static void onItemToss(ItemTossEvent event) {
		Player player = event.getPlayer();
		if (player.isCreative())
			return;
		ItemStack droppedItem = event.getEntityItem().getItem();
		if (isRestrictedItem(droppedItem)) {
			System.out.println("DEBUG: Item toss cancelado - item restrito");
			event.setCanceled(true);
			if (player instanceof ServerPlayer serverPlayer) {
				// Tentar colocar no inventário, senão guardar na fila
				int freeSlot = serverPlayer.getInventory().getFreeSlot();
				if (freeSlot != -1) {
					serverPlayer.getInventory().placeItemBackInInventory(droppedItem.copy());
				} else {
					addToRestrictedQueue(player, droppedItem.copy());
				}
			}
		}
	}

	@SubscribeEvent
	public static void onContainerClose(PlayerContainerEvent.Close event) {
		Player player = event.getPlayer();
		if (player.isCreative())
			return;
		System.out.println("DEBUG: Container fechado - verificação de itens restritos");
		for (Slot slot : player.containerMenu.slots) {
			if (slot.hasItem()) {
				ItemStack stack = slot.getItem();
				if (isRestrictedItem(stack)) {
					boolean found = false;
					for (ItemStack invStack : player.getInventory().items) {
						if (ItemStack.isSameItemSameTags(invStack, stack)) {
							found = true;
							break;
						}
					}
					if (!found && !isItemInCurios(player, stack)) {
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
		if (!(event.getEntity() instanceof Player player) || player.isCreative())
			return;
		System.out.println("DEBUG: Player morreu - limpeza de itens restritos");
		for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
			ItemStack stack = player.getInventory().getItem(i);
			if (isRestrictedItem(stack)) {
				player.getInventory().setItem(i, ItemStack.EMPTY);
			}
		}
		CuriosApi.getCuriosHelper().getCuriosHandler(player).ifPresent(handler -> {
			handler.getCurios().forEach((slot, stacksHandler) -> {
				for (int i = 0; i < stacksHandler.getStacks().getSlots(); i++) {
					ItemStack stack = stacksHandler.getStacks().getStackInSlot(i);
					if (isRestrictedItem(stack)) {
						stacksHandler.getStacks().setStackInSlot(i, ItemStack.EMPTY);
					}
				}
			});
		});
	}

	@SubscribeEvent
	public static void onPlayerClone(PlayerEvent.Clone event) {
		if (!event.isWasDeath())
			return;
		Player original = event.getOriginal();
		Player player = event.getPlayer();
		System.out.println("DEBUG: Clone do jogador após morte - restauração de inventário e fila");
		for (int i = 0; i < original.getInventory().getContainerSize(); i++) {
			ItemStack stack = original.getInventory().getItem(i);
			if (isRestrictedItem(stack)) {
				player.getInventory().setItem(i, stack.copy());
			}
		}
		CompoundTag originalData = original.getPersistentData();
		CompoundTag newData = player.getPersistentData();
		if (originalData.contains("RestrictedItemsQueue", Tag.TAG_LIST)) {
			newData.put("RestrictedItemsQueue", originalData.getList("RestrictedItemsQueue", Tag.TAG_COMPOUND).copy());
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
				if (player instanceof ServerPlayer serverPlayer) {
					serverPlayer.getInventory().placeItemBackInInventory(stack);
					list.remove(0);
					data.put("RestrictedItemsQueue", list);
					System.out.println("DEBUG: Item restrito restaurado da fila");
				}
			}
		}
	}

	// ========== Funções auxiliares ==========
	private static void addToRestrictedQueue(Player player, ItemStack stack) {
		CompoundTag data = player.getPersistentData();
		ListTag list = data.contains("RestrictedItemsQueue", Tag.TAG_LIST) ? data.getList("RestrictedItemsQueue", Tag.TAG_COMPOUND) : new ListTag();
		list.add(stack.save(new CompoundTag()));
		data.put("RestrictedItemsQueue", list);
		System.out.println("DEBUG: Item adicionado à fila de restritos");
	}

	private static boolean isRestrictedItem(ItemStack stack) {
		// TESTE: restringe só à Terra Blade temporariamente
		return stack.getItem() == EthernalKronuzModItems.THE_RISE_PARCHMENT.get();
	}

	private static boolean isItemInCurios(Player player, ItemStack stack) {
		return CuriosApi.getCuriosHelper().findFirstCurio(player, stack.getItem()).isPresent();
	}
}
