package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.core.BlockPos;
import net.minecraft.Util;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModBlocks;

public class NokkiaHammerClicksCountProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == EthernalKronuzModBlocks.NOKKIA_HAMMER_BLOCK.get() && EthernalKronuzModVariables.MapVariables.get(world).NokkiaHammerCountClicks == 3) {
			if (world instanceof Level _level && !_level.isClientSide()) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EthernalKronuzModItems.NOKKIA_HAMMER.get()));
				entityToSpawn.setPickUpDelay(10);
				entityToSpawn.setUnlimitedLifetime();
				_level.addFreshEntity(entityToSpawn);
			}
			world.destroyBlock(new BlockPos(x, y, z), false);
			for (int index0 = 0; index0 < (int) (5); index0++) {
				if (!world.isClientSide()) {
					MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
					if (_mcserv != null)
						_mcserv.getPlayerList().broadcastMessage(new TextComponent("\u00A74Nokkia Hammer foi spawnado!"), ChatType.SYSTEM, Util.NIL_UUID);
				}
			}
		}
	}
}
