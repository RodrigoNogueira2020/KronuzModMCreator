package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

public class MurasamaBlockOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordVermelhoPlayer) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof Level _level && !_level.isClientSide()) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(EthernalKronuzModItems.MURASAMA.get()));
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
