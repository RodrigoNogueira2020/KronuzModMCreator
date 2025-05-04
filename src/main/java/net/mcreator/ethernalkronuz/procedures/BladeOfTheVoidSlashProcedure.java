package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModParticleTypes;

public class BladeOfTheVoidSlashProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null || !(entity instanceof LivingEntity livingEntity))
			return;
		if (world instanceof Level _level)
			_level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ethernal_kronuz:sickle-swing")), SoundSource.PLAYERS, 1.0f, 1.0f);
		double radianArc = Math.PI;
		double radianSteps = Math.PI / 64;
		double arcStart = Math.toRadians(entity.getYRot());
		double circleDistanceConstant = 6;
		for (double i = 0; i <= radianArc; i += radianSteps) {
			double angle = arcStart + i;
			double x = circleDistanceConstant * Math.cos(angle) + entity.getX();
			double z = circleDistanceConstant * Math.sin(angle) + entity.getZ();
			double y = entity.getY() + 1;
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (EthernalKronuzModParticleTypes.BLADE_OF_THE_VOID_PARTICLE.get()), x, y, z, 1, 0, 0, 0, 0);
		}
		double radius = 6;
		double centerX = entity.getX();
		double centerY = entity.getY() + 1;
		double centerZ = entity.getZ();
		for (Entity target : world.getEntitiesOfClass(Entity.class, new AABB(centerX - radius, centerY - radius / 2, centerZ - radius, centerX + radius, centerY + radius / 2, centerZ + radius))) {
			if (target != entity && target.isAlive() && !target.isSpectator()) {
				double dx = target.getX() - entity.getX();
				double dz = target.getZ() - entity.getZ();
				double distanceSquared = dx * dx + dz * dz;
				if (distanceSquared <= radius * radius) {
					double targetAngle = Math.atan2(dz, dx);
					double playerAngle = Math.toRadians(entity.getYRot() + 90);
					double angleDifference = Math.abs(targetAngle - playerAngle);
					if (angleDifference > Math.PI)
						angleDifference = 2 * Math.PI - angleDifference;
					if (angleDifference <= Math.PI / 2)
						target.hurt(new DamageSource("botv_slash").bypassArmor(), 20);
				}
			}
		}
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 40);
	}
}
