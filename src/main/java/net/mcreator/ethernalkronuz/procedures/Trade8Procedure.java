package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

import java.util.function.Supplier;
import java.util.Map;

public class Trade8Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() == EthernalKronuzModItems.BATTLE_COIN
				.get()) {
			if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(Items.NETHERITE_BOOTS);
				_setstack.setCount(1);
				((Slot) _slots.get(1)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}
