package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class AsgardPlayerEntersDimensionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.teleportTo(26, 65, 21);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(26, 65, 21, _ent.getYRot(), _ent.getXRot());
		}
	}
}
