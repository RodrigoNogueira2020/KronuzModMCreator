package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;

public class NullEntityKeyBindOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).ADCPlayer
				&& (entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).IsNullEntity == false) {
			{
				boolean _setval = true;
				entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.IsNullEntity = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, (int) Double.POSITIVE_INFINITY, 2, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, (int) Double.POSITIVE_INFINITY, 2, (false), (false)));
		} else if ((entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).IsNullEntity == true) {
			{
				boolean _setval = false;
				entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.IsNullEntity = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.MOVEMENT_SPEED);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.JUMP);
		}
	}
}
