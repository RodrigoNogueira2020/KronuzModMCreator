package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;
import net.mcreator.ethernalkronuz.entity.RedRadiantLordTheRiseEntity;
import net.mcreator.ethernalkronuz.entity.RadiantLordGreenTrialEntity;
import net.mcreator.ethernalkronuz.entity.PurpleRadiantLordTheRiseEntity;

public class BossFightsManagerProcedure {
	public static void execute(ServerLevel level, Entity entity) {
		if (entity == null || !entity.isAlive()) {
			if (entity != null) {
				entity.getPersistentData().putBoolean("isPerformingPhase", false);
				entity.getPersistentData().putBoolean("isLightningPhase", false);
				entity.getPersistentData().putBoolean("isDashPhase", false);
			}
			return;
		}
		double phaseTickCounter = entity.getPersistentData().getDouble("phaseTickCounter");
		double rangedAttackCounter = entity.getPersistentData().getDouble("rangedAttackCounter");
		double rangedAttackTimer = entity.getPersistentData().getDouble("rangedAttackTimer");
		double lightningTicks = entity.getPersistentData().getDouble("lightningTicks");
		int lightningCount = entity.getPersistentData().getInt("lightningCount");
		boolean isLightningPhase = entity.getPersistentData().getBoolean("isLightningPhase");
		boolean isDashPhase = entity.getPersistentData().getBoolean("isDashPhase");
		boolean isPerformingPhase = entity.getPersistentData().getBoolean("isPerformingPhase");
		boolean isSlashPhase = entity.getPersistentData().getBoolean("isSlashPhase");
		double slashTicks = entity.getPersistentData().getDouble("slashTicks");
		int slashCount = entity.getPersistentData().getInt("slashCount");
		// -------- LIGHTNING PHASE --------
		if (isLightningPhase) {
			entity.setDeltaMovement(0, 0, 0);
			if (entity instanceof RadiantLordGreenTrialEntity)
				((RadiantLordGreenTrialEntity) entity).setAnimation("attack-lightning");
			else if (entity instanceof RedRadiantLordTheRiseEntity)
				((RedRadiantLordTheRiseEntity) entity).setAnimation("attack-lightning");
			else if (entity instanceof PurpleRadiantLordTheRiseEntity)
				((PurpleRadiantLordTheRiseEntity) entity).setAnimation("attack-lightning");
			lightningTicks++;
			LivingEntity target = level.getNearestPlayer(entity, 64);
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
		// -------- DASH PHASE --------
		if (isDashPhase) {
			entity.getPersistentData().putBoolean("isDashPhase", false);
			entity.setNoGravity(false);
			entity.setDeltaMovement(0, 0, 0);
			MuramasaDashAbilityProcedure.execute(level, entity.getX(), entity.getY(), entity.getZ(), entity, null);
			return;
		}
		// -------- SLASH PHASE --------
		if (isSlashPhase) {
			slashTicks++;
			if (slashTicks % 20 == 0 && slashCount > 0) {
				LivingEntity target = level.getNearestPlayer(entity, 64);
				if (entity instanceof LivingEntity living) {
					if (target != null) {
						double dx = target.getX() - entity.getX();
						double dz = target.getZ() - entity.getZ();
						float angle = (float) (Math.atan2(dz, dx) * (180 / Math.PI)) - 90;
						entity.setYRot(angle);
						entity.setYHeadRot(angle);
						living.yBodyRot = angle;
						living.yHeadRot = angle;
					}
					BladeOfTheVoidSlashProcedure.execute(level, living, new ItemStack(EthernalKronuzModItems.BLADE_OF_THE_VOID.get()));
				}
				slashCount--;
			}
			if (slashCount <= 0) {
				entity.getPersistentData().putBoolean("isSlashPhase", false);
				entity.getPersistentData().putDouble("slashTicks", 0);
				entity.setNoGravity(false);
			} else {
				entity.getPersistentData().putDouble("slashTicks", slashTicks);
				entity.getPersistentData().putInt("slashCount", slashCount);
			}
			return;
		}
		// -------- PHASE CHANCE --------
		if (!isPerformingPhase) {
			LivingEntity target = level.getNearestPlayer(entity, 64);
			if (target != null) {
				if (Math.random() < 0.005) {
					entity.getPersistentData().putBoolean("isLightningPhase", true);
					entity.getPersistentData().putDouble("lightningTicks", 0);
					entity.getPersistentData().putInt("lightningCount", 1 + level.random.nextInt(4));
					entity.setNoGravity(true);
					return;
				} else if (entity instanceof RedRadiantLordTheRiseEntity && Math.random() < 0.01) {
					entity.getPersistentData().putBoolean("isDashPhase", true);
					entity.setNoGravity(true);
					return;
				} else if (entity instanceof PurpleRadiantLordTheRiseEntity && Math.random() < 0.01) {
					entity.getPersistentData().putBoolean("isSlashPhase", true);
					entity.getPersistentData().putDouble("slashTicks", 0);
					entity.getPersistentData().putInt("slashCount", 3);
					entity.setNoGravity(true);
					return;
				}
			}
		}
		// -------- MELEE + RANGED PHASE --------
		if (isPerformingPhase && entity instanceof RadiantLordGreenTrialEntity boss) {
			phaseTickCounter++;
			if (phaseTickCounter >= 400) {
				entity.getPersistentData().putBoolean("isPerformingPhase", true);
				entity.getPersistentData().putDouble("rangedAttackCounter", 0);
				entity.getPersistentData().putDouble("rangedAttackTimer", 0);
				entity.setNoGravity(true);
				entity.setDeltaMovement(boss.getDeltaMovement().x, 0.15, boss.getDeltaMovement().z);
				entity.getPersistentData().putDouble("phaseTickCounter", 0);
			} else
				entity.getPersistentData().putDouble("phaseTickCounter", phaseTickCounter);
		}
		if (isPerformingPhase) {
			rangedAttackTimer++;
			if (rangedAttackCounter < 10) {
				if (rangedAttackTimer >= 20) {
					LivingEntity target = level.getNearestPlayer(entity, 64);
					if (target != null && entity instanceof RadiantLordGreenTrialEntity boss)
						boss.performRangedAttack(target, 1.0f);
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
