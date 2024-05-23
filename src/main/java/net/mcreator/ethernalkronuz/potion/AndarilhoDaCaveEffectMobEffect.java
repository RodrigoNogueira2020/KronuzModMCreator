
package net.mcreator.ethernalkronuz.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class AndarilhoDaCaveEffectMobEffect extends MobEffect {
	public AndarilhoDaCaveEffectMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16777216);
	}

	@Override
	public String getDescriptionId() {
		return "effect.ethernal_kronuz.andarilho_da_cave_effect";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
