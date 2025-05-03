package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.core.BlockPos;
import net.minecraft.Util;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NokkiaHammerClickVerdeProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getPlayer().getUsedItemHand())
			return;
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).AlreadyClicked == false
				&& (world.getBlockState(new BlockPos(x, y, z))).getBlock() == EthernalKronuzModBlocks.NOKKIA_HAMMER_BLOCK.get()
				&& (entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordVerdePlayer) {
			{
				boolean _setval = true;
				entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.AlreadyClicked = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			EthernalKronuzModVariables.MapVariables.get(world).NokkiaHammerCountClicks = EthernalKronuzModVariables.MapVariables.get(world).NokkiaHammerCountClicks + 1;
			EthernalKronuzModVariables.MapVariables.get(world).syncData(world);
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastMessage(new TextComponent((entity.getDisplayName().getString() + " votou para spawnar o \u00A74Nokkia Hammer")), ChatType.SYSTEM, Util.NIL_UUID);
			}
		}
	}
}
