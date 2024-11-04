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
import net.mcreator.ethernalkronuz.init.EthernalKronuzModBlocks; // Certifica-te de que tens o import correto para o teu bloco de fluido

public class DivinecrystalpillarsmallAdditionalGenerationConditionProcedure {
    public static boolean execute(LevelAccessor world, double x, double y, double z) {
        boolean baseIsSolid = true;
        int baseWidth = 6; // Largura da base da estrutura
        int baseDepth = 6; // Profundidade da base da estrutura
        int offsetX = -3; // Ajusta para centralizar a base na coordenada x
        int offsetZ = -3; // Ajusta para centralizar a base na coordenada z

        // Verifica se a área da base tem blocos sólidos (não-ar e não o fluido personalizado) diretamente abaixo da estrutura
        for (int bx = 0; bx < baseWidth; bx++) {
            for (int bz = 0; bz < baseDepth; bz++) {
                BlockPos checkPos = new BlockPos(x + offsetX + bx, y - 1, z + offsetZ + bz);
                if (world.getBlockState(checkPos).getBlock() == Blocks.AIR ||
                    world.getBlockState(checkPos).getBlock() == Blocks.VOID_AIR ||
                    world.getBlockState(checkPos).getBlock() == Blocks.CAVE_AIR ||
                    world.getBlockState(checkPos).getBlock() == EthernalKronuzModBlocks.CRISTALIZED_DIVINE_WATER.get()) {
                    baseIsSolid = false;
                    break;
                }
            }
            if (!baseIsSolid) break;
        }

        // Se a base estiver sólida, procede com a colocação da estrutura
        if (baseIsSolid) {
            if (world instanceof ServerLevel _serverworld) {
                StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("ethernal_kronuz", "divine_crystal_pillar_small"));
                if (template != null) {
                    template.placeInWorld(_serverworld, new BlockPos(x, y, z), new BlockPos(x, y, z), new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
                }
            }
        }

        return baseIsSolid;
    }
}