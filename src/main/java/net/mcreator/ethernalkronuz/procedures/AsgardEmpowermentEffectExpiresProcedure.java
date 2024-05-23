package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModMobEffects;

public class AsgardEmpowermentEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(EthernalKronuzModMobEffects.ASGARD_EMPOWERMENT.get());
	}
}
