package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;

public class SkullDamnationEntityDiesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = false;
			entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.skullDamnationSpawned = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
