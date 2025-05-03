package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModParticleTypes;

public class AesirPortalBlockClientDisplayRandomTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double randomCoords = 0;
		randomCoords = Math.random() * 10;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (EthernalKronuzModParticleTypes.ASGARD_PORTAL_PARTICLES.get()), x, y, z, 5, randomCoords, randomCoords, randomCoords, 1);
	}
}
