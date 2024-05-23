
package net.mcreator.ethernalkronuz.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class AsgardEmpowermentCooldownMobEffect extends MobEffect {
	public AsgardEmpowermentCooldownMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.ethernal_kronuz.asgard_empowerment_cooldown";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
