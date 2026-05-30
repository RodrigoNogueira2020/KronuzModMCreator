package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModParticleTypes;

public class PurpleFlameWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (EthernalKronuzModParticleTypes.PURPLE_FLAME_PARTICLE.get()), x, y, z, 4, 0.1, 0.1, 0.1, 0.3);
	}
}
