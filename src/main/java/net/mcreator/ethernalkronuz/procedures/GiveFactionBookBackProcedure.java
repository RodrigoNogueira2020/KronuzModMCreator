package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

public class GiveFactionBookBackProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("ethernal_kronuz:full_set_mosso_crystal"))).isDone()
				: false)
				|| (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
						? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("ethernal_kronuz:full_set_faking_ell"))).isDone()
						: false)
				|| (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
						? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("ethernal_kronuz:full_set_airport_steel"))).isDone()
						: false))
				&& !(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EthernalKronuzModItems.FACTION_BOOK.get())) : false)) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(EthernalKronuzModItems.FACTION_BOOK.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("N\u00E3o podes usar este comando"), (true));
		}
	}
}
