
package net.mcreator.ethernalkronuz.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ethernalkronuz.procedures.AsgardEmpowermentParticleRepeatProcedure;

public class AsgardEmpowermentMobEffect extends MobEffect {
	public AsgardEmpowermentMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.ethernal_kronuz.asgard_empowerment";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		AsgardEmpowermentParticleRepeatProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
