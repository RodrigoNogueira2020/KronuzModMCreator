package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.client.Minecraft;
import net.minecraft.Util;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

public class KillNonRLsProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity) && ((entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordRoxoPlayer
				|| (entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordVerdePlayer
				|| (entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordVermelhoPlayer))) {
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EthernalKronuzModItems.BLADE_OF_THE_VOID_SETUP.get())) : false) {
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("BODV").bypassArmor(), (float) Double.POSITIVE_INFINITY);
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastMessage(new TextComponent(("Local --> X: " + Math.round(entity.getX()) + " Y: " + Math.round(entity.getY()) + " Z: " + Math.round(entity.getZ()))), ChatType.SYSTEM, Util.NIL_UUID);
				}
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EthernalKronuzModItems.TERRA_BLADE_SETUP.get())) : false) {
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("terrablade").bypassArmor(), (float) Double.POSITIVE_INFINITY);
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastMessage(new TextComponent(("Local --> X: " + Math.ceil(entity.getX()) + " Y: " + Math.ceil(entity.getY()) + " Z: " + Math.ceil(entity.getZ()))), ChatType.SYSTEM, Util.NIL_UUID);
				}
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EthernalKronuzModItems.MURASAMA.get())) : false) {
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("murasama").bypassArmor(), (float) Double.POSITIVE_INFINITY);
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastMessage(new TextComponent(("Local --> X: " + Math.round(entity.getX()) + " Y: " + Math.round(entity.getY()) + " Z: " + Math.round(entity.getZ()))), ChatType.SYSTEM, Util.NIL_UUID);
				}
			}
			if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(EthernalKronuzModItems.NOKKIA_HAMMER.get())) : false) {
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("nokkiahammer").bypassArmor(), (float) Double.POSITIVE_INFINITY);
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastMessage(new TextComponent(("Local --> X: " + Math.round(entity.getX()) + " Y: " + Math.round(entity.getY()) + " Z: " + Math.round(entity.getZ()))), ChatType.SYSTEM, Util.NIL_UUID);
				}
			}
		}
	}
}
