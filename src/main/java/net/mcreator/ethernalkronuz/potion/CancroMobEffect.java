
package net.mcreator.ethernalkronuz.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ethernalkronuz.procedures.CancroOnEffectActiveTickProcedure;

public class CancroMobEffect extends MobEffect {
	public CancroMobEffect() {
		super(MobEffectCategory.HARMFUL, -16751053);
	}

	@Override
	public String getDescriptionId() {
		return "effect.ethernal_kronuz.cancro";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		CancroOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
