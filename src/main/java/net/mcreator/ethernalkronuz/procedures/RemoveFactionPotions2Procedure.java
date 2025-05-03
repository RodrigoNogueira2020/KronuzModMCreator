package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModMobEffects;

public class RemoveFactionPotions2Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BTPlayer = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EthernalKronuzModMobEffects.BT_EFFECT.get()) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(EthernalKronuzModMobEffects.BT_EFFECT.get());
		}
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.LUCK) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.LUCK);
		}
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.SLOW_FALLING) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.SLOW_FALLING);
		}
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.WEAKNESS) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.WEAKNESS);
		}
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.REGENERATION) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.REGENERATION);
		}
	}
}
