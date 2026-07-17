package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.ethernalkronuz.entity.GriffinAnimatedEntity;

public class GriffinUpOnKeyReleasedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getVehicle()) instanceof GriffinAnimatedEntity) {
			(entity.getVehicle()).getPersistentData().putDouble("VerticalMovement", 0);
		}
	}
}
