package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class BlessingOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR) {
			world.setBlock(new BlockPos(x, y + 1, z), Blocks.LIGHT.defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.LIGHT) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x, y + 2, z))).getBlock() == Blocks.LIGHT) {
			world.setBlock(new BlockPos(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == Blocks.LIGHT) {
			world.setBlock(new BlockPos(x + 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x + -1, y + 1, z))).getBlock() == Blocks.LIGHT) {
			world.setBlock(new BlockPos(x + -1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x, y + 1, z + -1))).getBlock() == Blocks.LIGHT) {
			world.setBlock(new BlockPos(x, y + 1, z + -1), Blocks.AIR.defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == Blocks.LIGHT) {
			world.setBlock(new BlockPos(x, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x + 1, y + 1, z + -1))).getBlock() == Blocks.LIGHT) {
			world.setBlock(new BlockPos(x + 1, y + 1, z + -1), Blocks.AIR.defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x + -1, y + 1, z + -1))).getBlock() == Blocks.LIGHT) {
			world.setBlock(new BlockPos(x + -1, y + 1, z + -1), Blocks.AIR.defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x + -1, y + 1, z + 1))).getBlock() == Blocks.LIGHT) {
			world.setBlock(new BlockPos(x + -1, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x + 1, y + 1, z + 1))).getBlock() == Blocks.LIGHT) {
			world.setBlock(new BlockPos(x + 1, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
