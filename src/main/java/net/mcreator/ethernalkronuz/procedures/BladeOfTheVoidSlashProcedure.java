package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModParticleTypes;
import net.minecraft.world.item.Item.Properties;


public class BladeOfTheVoidSlashProcedure {


	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null || !(entity instanceof Player player))
			return;
		
		double radianArc = 0;
		double d = 0;
		double verticalOffset = 0;
		double sign = 0;
		double rollAngle = 0;
		double horizontalOffsetDir = 0;
		double i = 0;
		double dMajor = 0;
		double horizontalOffsetMag = 0;
		double circleDistanceConstant = 0;
		double radianSteps = 0;
		double arcStart = 0;
		circleDistanceConstant = 6;
		rollAngle = 0;
		horizontalOffsetMag = 0;
		horizontalOffsetDir = 0;
		verticalOffset = 0;
		dMajor = circleDistanceConstant;
		d = circleDistanceConstant * Math.cos(Math.toRadians(rollAngle));
		i = (-1 * Math.PI) / 2;
		radianArc = (1 * Math.PI) / 2;
		radianSteps = (1 * Math.PI) / 32;
		arcStart = Math.toRadians(entity.getYRot() + 90);
		while (i <= radianArc) {
			if (0 > Math.sin(i)) {
				sign = -1;
			} else {
				sign = 1;
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (EthernalKronuzModParticleTypes.END_PARTICLES.get()),
						(dMajor * Math.cos(i) * Math.cos(arcStart) - d * Math.sin(i) * Math.sin(arcStart) + entity.getX() + horizontalOffsetMag * Math.sin(Math.toRadians(entity.getYRot() + 180 + horizontalOffsetDir))),
						(sign * Math.sqrt(Math.abs(Math.sin(Math.toRadians(rollAngle))) * (Math.pow(dMajor, 2) - Math.pow(dMajor * Math.cos(i), 2))) + entity.getY() + 1 + verticalOffset),
						(dMajor * Math.cos(i) * Math.sin(arcStart) + d * Math.sin(i) * Math.cos(arcStart) + entity.getZ() - horizontalOffsetMag * Math.cos(Math.toRadians(entity.getYRot() + 180 + horizontalOffsetDir))), 1, 0, 0, 0, 0);
			i = i + radianSteps;
		}


		double radius = 6; // Adjust the radius as needed
        double height = 1.0; // Adjust the height as needed
        double centerX = entity.getX();
        double centerY = entity.getY() + 1; // Slightly above the player
        double centerZ = entity.getZ();

        // Calculate the bounding box for the AoE
        AABB areaOfEffect = new AABB(centerX - radius, centerY - height / 2, centerZ - radius,
                                      centerX + radius, centerY + height / 2, centerZ + radius);
        
        // Check for entities within the area and apply damage
        for (Entity target : world.getEntitiesOfClass(Entity.class, areaOfEffect)) {
            if (target != entity && !(target instanceof Player)) { // Avoid damaging the player
                double distanceSquared = target.distanceToSqr(entity);
                if (distanceSquared <= radius * radius) {
                    // Deal damage to the target entity
                    target.hurt(new DamageSource("botv_slash").bypassArmor(), 20); // Adjust damage as needed
                }
            }
        }

		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 40);


 
	}
}
