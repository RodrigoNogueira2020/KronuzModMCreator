package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class JotunheimPlayerEntersDimensionProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.teleportTo(0, 1000, 0);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(0, 1000, 0, _ent.getYRot(), _ent.getXRot());
		}
	}
}
