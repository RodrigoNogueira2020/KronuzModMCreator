package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Registry;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;

@Mod.EventBusSubscriber
public class SpawnParticlesWhileRagnarokExistsProcedure {
	private static int tickCounter = 0;
	// Ponto de origem da seta (cabo começa aqui)
	private static final double ORIGIN_X = 6;
	private static final double ORIGIN_Y = 75;
	private static final double ORIGIN_Z = 21;
	// Coordenadas para onde a seta aponta
	private static final double TARGET_X = 100;
	private static final double TARGET_Y = 200;
	private static final double TARGET_Z = 100;
	// Comprimento do cabo em blocos (customizável)
	private static final double SHAFT_LENGTH = 5.0;
	// Partículas por bloco no cabo (mais = mais denso)
	private static final int SHAFT_DENSITY = 3;
	// Tamanho da cabeça da seta
	private static final double HEAD_LENGTH = 1.5;
	private static final double HEAD_WIDTH = 1.0;
	private static final int TICK_INTERVAL = 20;

	@SubscribeEvent
	public static void onServerTick(TickEvent.ServerTickEvent event) {
		if (event.phase != TickEvent.Phase.END)
			return;
		tickCounter++;
		if (tickCounter % TICK_INTERVAL != 0)
			return;
		net.minecraft.server.MinecraftServer server = net.minecraftforge.server.ServerLifecycleHooks.getCurrentServer();
		if (server == null)
			return;
		ServerLevel asgard = server.getLevel(ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("ethernal_kronuz:asgard")));
		if (asgard == null)
			return;
		if (EthernalKronuzModVariables.WorldVariables.get(asgard).RagnarokHappened)
			return;
		spawnArrow(asgard);
	}

	private static void spawnArrow(ServerLevel world) {
		double dx = TARGET_X - ORIGIN_X;
		double dy = TARGET_Y - ORIGIN_Y;
		double dz = TARGET_Z - ORIGIN_Z;
		double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);
		if (dist == 0)
			return;
		double nx = dx / dist;
		double ny = dy / dist;
		double nz = dz / dist;
		double p1x, p1y, p1z;
		if (Math.abs(nx) < 0.9) {
			p1x = 0;
			p1y = -nz;
			p1z = ny;
		} else {
			p1x = nz;
			p1y = 0;
			p1z = -nx;
		}
		double p1len = Math.sqrt(p1x * p1x + p1y * p1y + p1z * p1z);
		p1x /= p1len;
		p1y /= p1len;
		p1z /= p1len;
		double p2x = ny * p1z - nz * p1y;
		double p2y = nz * p1x - nx * p1z;
		double p2z = nx * p1y - ny * p1x;
		int shaftPoints = (int) (SHAFT_LENGTH * SHAFT_DENSITY);
		for (int i = 0; i <= shaftPoints; i++) {
			double t = (double) i / shaftPoints * SHAFT_LENGTH;
			spawnParticle(world, ORIGIN_X + nx * t, ORIGIN_Y + ny * t, ORIGIN_Z + nz * t);
		}
		double tipX = ORIGIN_X + nx * SHAFT_LENGTH;
		double tipY = ORIGIN_Y + ny * SHAFT_LENGTH;
		double tipZ = ORIGIN_Z + nz * SHAFT_LENGTH;
		double baseX = tipX - nx * HEAD_LENGTH;
		double baseY = tipY - ny * HEAD_LENGTH;
		double baseZ = tipZ - nz * HEAD_LENGTH;
		double[][] corners = {{baseX + p1x * HEAD_WIDTH, baseY + p1y * HEAD_WIDTH, baseZ + p1z * HEAD_WIDTH}, {baseX - p1x * HEAD_WIDTH, baseY - p1y * HEAD_WIDTH, baseZ - p1z * HEAD_WIDTH},
				{baseX + p2x * HEAD_WIDTH, baseY + p2y * HEAD_WIDTH, baseZ + p2z * HEAD_WIDTH}, {baseX - p2x * HEAD_WIDTH, baseY - p2y * HEAD_WIDTH, baseZ - p2z * HEAD_WIDTH}};
		// Linhas da ponta até cada canto
		int headPoints = 8;
		for (double[] corner : corners) {
			for (int i = 0; i <= headPoints; i++) {
				double t = (double) i / headPoints;
				spawnParticle(world, tipX + (corner[0] - tipX) * t, tipY + (corner[1] - tipY) * t, tipZ + (corner[2] - tipZ) * t);
			}
		}
	}

	private static void spawnParticle(ServerLevel world, double x, double y, double z) {
		world.sendParticles(ParticleTypes.FLAME, x, y, z, 1, // count
				0, 0, 0, // spread
				0 // velocidade
		);
	}
}
