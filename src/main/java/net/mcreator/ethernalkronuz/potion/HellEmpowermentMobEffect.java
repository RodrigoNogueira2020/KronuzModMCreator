
package net.mcreator.ethernalkronuz.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ethernalkronuz.procedures.HellEmpowermentParticleRepeatProcedure;
import net.mcreator.ethernalkronuz.procedures.HellEmpowermentEffectStartedappliedProcedure;

public class HellEmpowermentMobEffect extends MobEffect {
	public HellEmpowermentMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.ethernal_kronuz.hell_empowerment";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		HellEmpowermentEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		HellEmpowermentParticleRepeatProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
