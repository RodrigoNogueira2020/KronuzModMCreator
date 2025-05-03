package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModParticleTypes;

public class TerraBladeProjectileParticleSpawnerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (EthernalKronuzModParticleTypes.TERRA_BLADE_PARTICLE.get()), x, y, z, 10, 0.2, 0.2, 0.2, 0.1);
	}
}
