package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.Mth;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModParticleTypes;

import java.util.Random;

public class YggLeavesUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Mth.nextInt(new Random(), 1, 10) == 1) {
			world.addParticle((SimpleParticleType) (EthernalKronuzModParticleTypes.GLOW_PLANT_SPORES.get()), (x + Math.random()), y, (z + Math.random()), 0, (-1), 0);
		}
	}
}
