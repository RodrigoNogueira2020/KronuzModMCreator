
package net.mcreator.ethernalkronuz.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ethernalkronuz.procedures.RadiantLordEffectOnEffectActiveTickProcedure;

public class RadiantLordEffectMobEffect extends MobEffect {
	public RadiantLordEffectMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.ethernal_kronuz.radiant_lord_effect";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		RadiantLordEffectOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
