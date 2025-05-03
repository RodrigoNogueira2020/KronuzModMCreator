package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.ethernalkronuz.entity.RadiantLordGreenTrialEntity;

public class RadiantLordGreenPhaseManagerProcedure {
	public static void execute(Entity entity) {
		double phaseTickCounter = entity.getPersistentData().getDouble("phaseTickCounter");
		double rangedAttackCounter = entity.getPersistentData().getDouble("rangedAttackCounter");
		double rangedAttackTimer = entity.getPersistentData().getDouble("rangedAttackTimer");
		boolean isPerformingPhase = entity.getPersistentData().getBoolean("isPerformingPhase");
		
		// Fase meele: durante 10 segundos (400 ticks)
		if (!isPerformingPhase) {
			phaseTickCounter++;
			if (phaseTickCounter >= 400) {
				entity.getPersistentData().putBoolean("isPerformingPhase", true);
				entity.getPersistentData().putDouble("rangedAttackCounter", 0);
				entity.getPersistentData().putDouble("rangedAttackTimer", 0);
				entity.setNoGravity(true);
				entity.setDeltaMovement(entity.getDeltaMovement().x, 0.25, entity.getDeltaMovement().z); // Sobe
				entity.getPersistentData().putDouble("phaseTickCounter", 0);
			} else
				entity.getPersistentData().putDouble("phaseTickCounter", phaseTickCounter);
		}
		
		// Fase ranged: 10 ranged attacks com intervalo de 1 segundo (20 ticks)
		if (isPerformingPhase) {
			rangedAttackTimer++;
			if (rangedAttackCounter < 10) {
				if (rangedAttackTimer >= 20) {
					if (entity instanceof RadiantLordGreenTrialEntity boss && boss.level instanceof ServerLevel _level) {
						LivingEntity target = _level.getNearestPlayer(boss, 64);
						if (target != null)
							boss.performRangedAttack(target, 1.0f);
					}
					rangedAttackCounter++;
					rangedAttackTimer = 0;
				}
				entity.getPersistentData().putDouble("rangedAttackCounter", rangedAttackCounter);
				entity.getPersistentData().putDouble("rangedAttackTimer", rangedAttackTimer);
			} else {
				entity.setNoGravity(false);
				entity.setDeltaMovement(entity.getDeltaMovement().x, -0.25, entity.getDeltaMovement().z); //Desce
				entity.getPersistentData().putBoolean("isPerformingPhase", false);
			}
		}
	}
}
