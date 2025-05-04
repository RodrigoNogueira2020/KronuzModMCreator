package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.ethernalkronuz.entity.RadiantLordGreenTrialEntity;

public class RadiantLordGreenPhaseManagerProcedure {
	public static void execute(Entity entity) {
		if (entity == null || !entity.isAlive()) {
			entity.getPersistentData().putBoolean("isPerformingPhase", false);
			entity.getPersistentData().putBoolean("isLightningPhase", false);
			return;
		}
		double phaseTickCounter = entity.getPersistentData().getDouble("phaseTickCounter");
		double rangedAttackCounter = entity.getPersistentData().getDouble("rangedAttackCounter");
		double rangedAttackTimer = entity.getPersistentData().getDouble("rangedAttackTimer");
		boolean isPerformingPhase = entity.getPersistentData().getBoolean("isPerformingPhase");
		boolean isLightningPhase = entity.getPersistentData().getBoolean("isLightningPhase");
		double lightningTicks = entity.getPersistentData().getDouble("lightningTicks");
		int lightningCount = entity.getPersistentData().getInt("lightningCount");
		// Lightning Phase
		if (isLightningPhase) {
			entity.setDeltaMovement(0, 0, 0);
			if (entity instanceof RadiantLordGreenTrialEntity)
				((RadiantLordGreenTrialEntity) entity).setAnimation("attack-lightning");
			lightningTicks++;
			if (entity instanceof RadiantLordGreenTrialEntity boss && boss.level instanceof ServerLevel level) {
				LivingEntity target = level.getNearestPlayer(boss, 64);
				if (target != null && lightningTicks % 20 == 0 && lightningCount > 0) {
					double offsetX = (level.random.nextDouble() - 0.5) * 4;
					double offsetZ = (level.random.nextDouble() - 0.5) * 4;
					LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(level);
					if (lightning != null) {
						lightning.moveTo(Vec3.atBottomCenterOf(new BlockPos(target.getX() + offsetX, target.getY(), target.getZ() + offsetZ)));
						lightning.setVisualOnly(false);
						level.addFreshEntity(lightning);
					}
					lightningCount--;
				}
			}
			if (lightningCount <= 0) {
				entity.getPersistentData().putBoolean("isLightningPhase", false);
				entity.getPersistentData().putDouble("lightningTicks", 0);
				entity.setNoGravity(false);
			} else {
				entity.getPersistentData().putDouble("lightningTicks", lightningTicks);
				entity.getPersistentData().putInt("lightningCount", lightningCount);
			}
			return;
		}
		// Random chance to enter lightning phase
		if (!isPerformingPhase && Math.random() < 0.01) {
			entity.getPersistentData().putBoolean("isLightningPhase", true);
			entity.getPersistentData().putDouble("lightningTicks", 0);
			entity.getPersistentData().putInt("lightningCount", 3 + entity.level.random.nextInt(5));
			entity.setNoGravity(true);
			return;
		}
		// Melee Phase
		if (!isPerformingPhase) {
			phaseTickCounter++;
			if (phaseTickCounter >= 400) {
				entity.getPersistentData().putBoolean("isPerformingPhase", true);
				entity.getPersistentData().putDouble("rangedAttackCounter", 0);
				entity.getPersistentData().putDouble("rangedAttackTimer", 0);
				entity.setNoGravity(true);
				entity.setDeltaMovement(entity.getDeltaMovement().x, 0.15, entity.getDeltaMovement().z);
				entity.getPersistentData().putDouble("phaseTickCounter", 0);
			} else
				entity.getPersistentData().putDouble("phaseTickCounter", phaseTickCounter);
		}
		// Ranged Phase
		if (isPerformingPhase) {
			rangedAttackTimer++;
			if (rangedAttackCounter < 10) {
				if (rangedAttackTimer >= 20) {
					if (entity instanceof RadiantLordGreenTrialEntity boss && boss.level instanceof ServerLevel level) {
						LivingEntity target = level.getNearestPlayer(boss, 64);
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
				entity.setDeltaMovement(entity.getDeltaMovement().x, -0.15, entity.getDeltaMovement().z);
				entity.getPersistentData().putBoolean("isPerformingPhase", false);
			}
		}
	}
}
