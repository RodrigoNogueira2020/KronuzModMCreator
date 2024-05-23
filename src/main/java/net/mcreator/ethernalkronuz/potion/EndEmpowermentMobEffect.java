
package net.mcreator.ethernalkronuz.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ethernalkronuz.procedures.EndEmpowermentParticlesRepeatProcedure;
import net.mcreator.ethernalkronuz.procedures.EndEmpowermentEffectsProcedure;

public class EndEmpowermentMobEffect extends MobEffect {
	public EndEmpowermentMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.ethernal_kronuz.end_empowerment";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		EndEmpowermentEffectsProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		EndEmpowermentParticlesRepeatProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
