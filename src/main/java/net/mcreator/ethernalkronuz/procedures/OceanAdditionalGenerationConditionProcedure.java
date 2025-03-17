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

public class OceanAdditionalGenerationConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		int sizeX = 5;
		int sizeZ = 16;
		int sizeY = 6;
		for (int dx = 0; dx < sizeX; dx++) {
			for (int dz = 0; dz < sizeZ; dz++) {
				for (int dy = 0; dy < sizeY; dy++) {
					BlockPos checkPos = new BlockPos(x + dx, y + dy, z + dz);
					if (world.getBlockState(checkPos).getBlock() != Blocks.WATER) {
						return false;
					}
				}
			}
		}
		if (world instanceof ServerLevel _serverworld) {
			StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("ethernal_kronuz", "titan"));
			if (template != null) {
				template.placeInWorld(_serverworld, new BlockPos(x, y, z), new BlockPos(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
			}
		}
		return true;
	}
}
