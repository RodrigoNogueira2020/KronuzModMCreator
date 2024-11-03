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
			
		double radianArc = Math.PI;  // 180 degrees for a semi-circle
	    double radianSteps = Math.PI / 64;  // Adjust particle density here
	    double arcStart = Math.toRadians(entity.getYRot());  // Start from the right side of the player
	    double circleDistanceConstant = 6;  // Radius for particle effect
	
	    // Spawn particles in a semi-circle arc in front of the player
	    for (double i = 0; i <= radianArc; i += radianSteps) {
	        double angle = arcStart + i;  // Rotate each particle along the semi-circle
	
	        // Calculate x and z positions for particles based on player's facing direction
	        double x = circleDistanceConstant * Math.cos(angle) + entity.getX();
	        double z = circleDistanceConstant * Math.sin(angle) + entity.getZ();
	        double y = entity.getY() + 1;  // Slightly above player, adjust if needed
	
	        if (world instanceof ServerLevel _level)
	            _level.sendParticles((SimpleParticleType) (EthernalKronuzModParticleTypes.BLADE_OF_THE_VOID_PARTICLE.get()),
	                                 x, y, z, 1, 0, 0, 0, 0);
	    }
	
	    // Set up the semi-circle damage area
	    double radius = 6;
	    double centerX = entity.getX();
	    double centerY = entity.getY() + 1;  // Slightly above the player
	    double centerZ = entity.getZ();
	
	    // Loop through entities in a bounding box around the player
	    for (Entity target : world.getEntitiesOfClass(Entity.class, 
	            new AABB(centerX - radius, centerY - radius / 2, centerZ - radius, centerX + radius, centerY + radius / 2, centerZ + radius))) {
	        
	        if (target != entity && !(target instanceof Player)) {  // Avoid damaging the player
	            double dx = target.getX() - entity.getX();
	            double dz = target.getZ() - entity.getZ();
	            double distanceSquared = dx * dx + dz * dz;

	            if (distanceSquared <= radius * radius) {
	                // Calculate angle to target
	                double targetAngle = Math.atan2(dz, dx);
	                double playerAngle = Math.toRadians(entity.getYRot() +90);
	                double angleDifference = Math.abs(targetAngle - playerAngle);
	
	                // Normalize angle difference to be within [0, π]
	                if (angleDifference > Math.PI)
	                    angleDifference = 2 * Math.PI - angleDifference;
	
	                // Check if within 90 degrees (π/2 radians) in front of the player
	                if (angleDifference <= Math.PI / 2) {
	                    // Deal damage to the target entity
	                    target.hurt(new DamageSource("botv_slash").bypassArmor(), 20);  // Adjust damage as needed
	                }
	            }
	        }
	    }


		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 40);

	}
}
