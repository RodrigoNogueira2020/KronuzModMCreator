package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModBlocks;

public class EndruinssmallAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		Block[] allowedBlocks = {EthernalKronuzModBlocks.ASGARDIAN_DIRT.get(), EthernalKronuzModBlocks.ASGARDIAN_DIRT_BLOCK.get(), EthernalKronuzModBlocks.DIVINE_CRYSTAL.get(), EthernalKronuzModBlocks.HEAVEN_STONE.get()};
		int sizeX = 8;
		int sizeZ = 8;
		int sizeY = 3;
		for (int dx = 0; dx < sizeX; dx++) {
			for (int dz = 0; dz < sizeZ; dz++) {
				for (int dy = 0; dy < sizeY; dy++) {
					BlockPos checkPos = new BlockPos(x + dx, y + dy, z + dz);
					Block currentBlock = world.getBlockState(checkPos).getBlock();
					boolean isValid = false;
					for (Block allowed : allowedBlocks) {
						if (currentBlock == allowed) {
							isValid = true;
							break;
						}
					}
					if (!isValid) {
						return false;
					}
				}
			}
		}
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("ethernal_kronuz", "end_ruins_large"));
			if (template != null) {
				template.placeInWorld(_serverworld, new BlockPos(x, y, z), new BlockPos(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
			}
		}
		return true;
	}
}
