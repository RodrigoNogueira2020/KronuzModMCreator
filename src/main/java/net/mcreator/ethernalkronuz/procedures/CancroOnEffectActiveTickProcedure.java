package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModMobEffects;

public class CancroOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EthernalKronuzModMobEffects.CANCRO.get()) ? _livEnt.getEffect(EthernalKronuzModMobEffects.CANCRO.get()).getDuration() : 0) < 20) {
			if (entity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("cancro").bypassArmor(), (float) Double.POSITIVE_INFINITY);
		}
	}
}
