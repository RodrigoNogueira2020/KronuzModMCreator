package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

public class GiveGreenParchmentProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HasMinimumForTheRiseVerde = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (!(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EthernalKronuzModItems.THE_RISE_PARCHMENT.get())) : false)) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(EthernalKronuzModItems.THE_RISE_PARCHMENT.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		}
	}
}
