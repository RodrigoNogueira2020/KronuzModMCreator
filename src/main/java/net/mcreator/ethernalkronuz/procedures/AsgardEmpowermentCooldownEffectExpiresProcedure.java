package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModMobEffects;

public class AsgardEmpowermentCooldownEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("ethernal_kronuz:asgard")))) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(EthernalKronuzModMobEffects.ASGARD_EMPOWERMENT.get(), (int) Double.POSITIVE_INFINITY, 0, (true), (false)));
		}
	}
}
