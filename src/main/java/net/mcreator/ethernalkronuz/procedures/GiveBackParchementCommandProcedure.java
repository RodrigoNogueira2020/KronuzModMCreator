package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

public class GiveBackParchementCommandProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EthernalKronuzModItems.THE_RISE_PARCHMENT.get())) : false) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("You already have The Rise Parchement dumb ass"), (true));
		} else if (!(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EthernalKronuzModItems.THE_RISE_PARCHMENT.get())) : false)
				&& ((entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).HasMinimumForTheRiseRoxo
						|| (entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).HasMinimumForTheRiseVerde
						|| (entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).HasMinimumForTheRiseVermelho)) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(EthernalKronuzModItems.THE_RISE_PARCHMENT.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("You do not have access do this command"), (true));
		}
	}
}
