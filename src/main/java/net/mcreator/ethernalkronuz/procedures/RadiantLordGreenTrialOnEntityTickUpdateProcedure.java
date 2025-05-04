package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.entity.Entity;

public class RadiantLordGreenTrialOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		BossFightsManagerProcedure.execute(entity);
	}
}
