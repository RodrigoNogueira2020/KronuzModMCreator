package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;

public class NullBlurDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).ADCPlayer
				&& (entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).IsNullEntity) {
			return true;
		}
		return false;
	}
}
