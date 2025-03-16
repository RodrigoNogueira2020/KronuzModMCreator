package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;

public class AsgardPortalTriggerUsedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.level.dimension()) == (Level.OVERWORLD)) {
			{
				double _setval = entity.getX();
				entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CoordXBeforeEnterAsgard = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = entity.getY();
				entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CoordYBeforeEnterAsgard = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = entity.getZ();
				entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.CoordZBeforeEnterAsgard = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				Direction _setval = entity.getDirection();
				entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DiretionBeforeEnterAsgard = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
