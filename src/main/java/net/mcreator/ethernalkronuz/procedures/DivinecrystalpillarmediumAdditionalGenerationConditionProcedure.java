package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModBlocks;

public class DivinecrystalpillarmediumAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		boolean baseIsSolid = true;
		int baseWidth = 2;
		int baseDepth = 2;
		int offsetX = 0;
		int offsetZ = 0;
		for (int bx = 0; bx < baseWidth; bx++) {
			for (int bz = 0; bz < baseDepth; bz++) {
				BlockPos basePos = new BlockPos(x + offsetX + bx, y, z + offsetZ + bz);
				if (world.getBlockState(basePos).getBlock() == Blocks.AIR || world.getBlockState(basePos).getBlock() == Blocks.VOID_AIR || world.getBlockState(basePos).getBlock() == Blocks.CAVE_AIR
						|| world.getBlockState(basePos).getBlock() == EthernalKronuzModBlocks.CRISTALIZED_DIVINE_WATER.get()) {
					baseIsSolid = false;
					break;
				}
				BlockPos belowPos = new BlockPos(x + offsetX + bx, y - 1, z + offsetZ + bz);
				if (world.getBlockState(belowPos).getBlock() == Blocks.AIR || world.getBlockState(belowPos).getBlock() == Blocks.VOID_AIR || world.getBlockState(belowPos).getBlock() == Blocks.CAVE_AIR
						|| world.getBlockState(belowPos).getBlock() == EthernalKronuzModBlocks.CRISTALIZED_DIVINE_WATER.get()) {
					baseIsSolid = false;
					break;
				}
			}
			if (!baseIsSolid)
				break;
		}
		if (baseIsSolid) {
			if (world instanceof ServerLevel _serverworld) {
				StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("ethernal_kronuz", "divine_crystal_pillar_medium"));
				if (template != null) {
					template.placeInWorld(_serverworld, new BlockPos(x, y, z), new BlockPos(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
				}
			}
		}
		return baseIsSolid;
	}
}
