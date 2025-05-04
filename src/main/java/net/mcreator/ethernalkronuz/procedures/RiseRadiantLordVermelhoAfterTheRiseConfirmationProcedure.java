package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.Util;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

public class RiseRadiantLordVermelhoAfterTheRiseConfirmationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.closeContainer();
		{
			boolean _setval = false;
			entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HasMinimumForTheRiseVermelho = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = true;
			entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.RadiantLordVermelhoPlayer = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		EthernalKronuzModVariables.MapVariables.get(world).RadiantLordVermelho = true;
		EthernalKronuzModVariables.MapVariables.get(world).syncData(world);
		{
			boolean _setval = true;
			entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.IsRadiantLord = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = true;
			entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AllowInJotunheim = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		GiveRadiantLordEffectsProcedure.execute(world, x, y, z, entity);
		entity.setCustomName(new TextComponent("\u00A7cAzakana"));
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(EthernalKronuzModItems.MURASAMA.get());
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		if (!world.isClientSide()) {
			MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
			if (_mcserv != null)
				_mcserv.getPlayerList().broadcastMessage(new TextComponent("\u00A7cAzakana is AMONGUS!"), ChatType.SYSTEM, Util.NIL_UUID);
		}
	}
}
