package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class RedRadiantLordTheRiseOnEntityTickUpdateProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		Level level = entity.level;
		if (level instanceof ServerLevel serverLevel)
			BossFightsManagerProcedure.execute(serverLevel, entity);
	}
}
