
package net.mcreator.ethernalkronuz.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ethernalkronuz.procedures.AsgardEmpowermentCooldownOnEffectActiveTickProcedure;
import net.mcreator.ethernalkronuz.procedures.AsgardEmpowermentCooldownEffectExpiresProcedure;

public class AsgardEmpowermentCooldownMobEffect extends MobEffect {
	public AsgardEmpowermentCooldownMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.ethernal_kronuz.asgard_empowerment_cooldown";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		AsgardEmpowermentCooldownOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		AsgardEmpowermentCooldownEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
