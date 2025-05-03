package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModMobEffects;

public class RemoveFactionPotions1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ADCPlayer = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EthernalKronuzModMobEffects.ANDARILHO_DA_CAVE_EFFECT.get()) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(EthernalKronuzModMobEffects.ANDARILHO_DA_CAVE_EFFECT.get());
		}
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.WEAKNESS) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.WEAKNESS);
		}
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.NIGHT_VISION) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.NIGHT_VISION);
		}
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.DAMAGE_BOOST) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.DAMAGE_BOOST);
		}
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.MOVEMENT_SPEED) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
		}
	}
}
