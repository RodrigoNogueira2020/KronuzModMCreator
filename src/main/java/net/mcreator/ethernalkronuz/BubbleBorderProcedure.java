package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket;
import net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket;
import net.minecraft.network.protocol.game.ClientboundSetSubtitleTextPacket;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.advancements.Advancement;

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber
public class BubbleBorderProcedure {
	private static final double CENTER_X = 100;
	private static final double CENTER_Y = 200;
	private static final double CENTER_Z = 100;
	private static final double BUBBLE_RADIUS = 25;
	private static final double WARNING_DISTANCE = 20;
	private static final ResourceKey<net.minecraft.world.level.Level> ASGARD = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("ethernal_kronuz:asgard"));
	private static final ResourceLocation RAGNAROK_ADVANCEMENT = new ResourceLocation("ethernal_kronuz:ragnarok");
	private static final double VISUAL_DISTANCE = 10;
	private static final int PARTICLES_PER_RING = 48;
	private static final int RING_COUNT = 5;
	private static final double RING_SPACING = 1.5;
	private static final int PARTICLE_TICK_INTERVAL = 2;
	private static int tickCounter = 0;
	// ── Rastreia se o jogador JÁ estava dentro da bolha no tick anterior ──
	// Isto resolve o problema do /tp e da entrada na dimensão:
	// só bloqueia quem estava dentro e está a tentar sair
	private static final Map<UUID, Boolean> wasInsideMap = new HashMap<>();
	// ── A cada quantos ticks mostra o título de aviso (evita spam) ──
	private static final int WARNING_TITLE_INTERVAL = 60; // 3 segundos

	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase != TickEvent.Phase.END)
			return;
		if (!(event.player instanceof ServerPlayer player))
			return;
		if (!(player.level instanceof ServerLevel level))
			return;
		// ── FIX 1: Modo espetador nunca é bloqueado ──────────────
		if (player.isSpectator())
			return;
		if (!level.dimension().equals(ASGARD))
			return;
		double dx = player.getX() - CENTER_X;
		double dy = player.getY() - CENTER_Y;
		double dz = player.getZ() - CENTER_Z;
		double distanceFromCenter = Math.sqrt(dx * dx + dy * dy + dz * dz);
		double distanceFromBorder = BUBBLE_RADIUS - distanceFromCenter;
		boolean isInsideNow = distanceFromCenter <= BUBBLE_RADIUS;
		// ── FIX 2: Só bloqueia saída se o jogador JÁ estava dentro ──
		// Se entrou na dimensão fora da bolha, ou usou /tp para fora,
		// não é bloqueado — só é bloqueado quem tenta SAIR de dentro
		boolean wasInside = wasInsideMap.getOrDefault(player.getUUID(), false);
		if (!isInsideNow) {
			boolean hasAdvancement = hasRagnarokAdvancement(player, level);
			// ── Aviso de título quando se aproxima de fora ──────
			if (!hasAdvancement && distanceFromCenter < BUBBLE_RADIUS + WARNING_DISTANCE) {
				tickCounter++;
				if (tickCounter % WARNING_TITLE_INTERVAL == 0) {
					sendTitle(player, "§c⚠ Battle", "§eYou can get in, but can't get out");
				}
			}
			// ── Bloqueia saída APENAS se estava dentro antes ────
			if (wasInside && !hasAdvancement) {
				double safeX = CENTER_X + (dx / distanceFromCenter) * (BUBBLE_RADIUS - 1);
				double safeY = CENTER_Y + (dy / distanceFromCenter) * (BUBBLE_RADIUS - 1);
				double safeZ = CENTER_Z + (dz / distanceFromCenter) * (BUBBLE_RADIUS - 1);
				player.teleportTo(level, safeX, safeY, safeZ, player.getYRot(), player.getXRot());
				sendTitle(player, "§c⚠ Locked", "§7Defeat the Gods");
				// Mantém wasInside = true (continua dentro após teleporte)
				return;
			}
			// Se chegou aqui: ou tem advancement, ou entrou de fora
			// Atualiza posição (está fora)
			wasInsideMap.put(player.getUUID(), false);
			return;
		}
		// ── Jogador está dentro — atualiza o mapa ───────────────
		wasInsideMap.put(player.getUUID(), true);
		// ── Partículas visuais ───────────────────────────────────
		if (tickCounter % PARTICLE_TICK_INTERVAL == 0) {
			if (distanceFromBorder <= VISUAL_DISTANCE) {
				spawnBorderParticles(level, player, distanceFromBorder);
			}
		}
		tickCounter++;
	}

	private static void spawnBorderParticles(ServerLevel level, ServerPlayer player, double distanceFromBorder) {
		double dx = player.getX() - CENTER_X;
		double dy = player.getY() - CENTER_Y;
		double dz = player.getZ() - CENTER_Z;
		double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);
		if (dist == 0)
			return;
		double rx = dx / dist;
		double ry = dy / dist;
		double rz = dz / dist;
		double surfaceX = CENTER_X + rx * BUBBLE_RADIUS;
		double surfaceY = CENTER_Y + ry * BUBBLE_RADIUS;
		double surfaceZ = CENTER_Z + rz * BUBBLE_RADIUS;
		double p1x, p1y, p1z;
		if (Math.abs(rx) < 0.9) {
			p1x = 0;
			p1y = -rz;
			p1z = ry;
		} else {
			p1x = rz;
			p1y = 0;
			p1z = -rx;
		}
		double p1len = Math.sqrt(p1x * p1x + p1y * p1y + p1z * p1z);
		p1x /= p1len;
		p1y /= p1len;
		p1z /= p1len;
		double p2x = ry * p1z - rz * p1y;
		double p2y = rz * p1x - rx * p1z;
		double p2z = rx * p1y - ry * p1x;
		var particleType = distanceFromBorder < 5.0 ? ParticleTypes.FLAME : ParticleTypes.SOUL_FIRE_FLAME;
		for (int ring = 0; ring < RING_COUNT; ring++) {
			double offset = (ring - RING_COUNT / 2.0) * RING_SPACING;
			double ringRadius = Math.sqrt(Math.max(0, BUBBLE_RADIUS * BUBBLE_RADIUS - offset * offset * 0.5));
			ringRadius = Math.min(ringRadius, 8.0);
			double ringCX = surfaceX + rx * offset * 0.1;
			double ringCY = surfaceY + ry * offset * 0.1;
			double ringCZ = surfaceZ + rz * offset * 0.1;
			for (int i = 0; i < PARTICLES_PER_RING; i++) {
				double angle = (2 * Math.PI * i) / PARTICLES_PER_RING;
				double px = ringCX + (p1x * Math.cos(angle) + p2x * Math.sin(angle)) * ringRadius;
				double py = ringCY + (p1y * Math.cos(angle) + p2y * Math.sin(angle)) * ringRadius;
				double pz = ringCZ + (p1z * Math.cos(angle) + p2z * Math.sin(angle)) * ringRadius;
				level.sendParticles(player, particleType, true, px, py, pz, 1, 0, 0, 0, 0);
			}
		}
	}

	private static boolean hasRagnarokAdvancement(ServerPlayer player, ServerLevel level) {
		Advancement advancement = level.getServer().getAdvancements().getAdvancement(RAGNAROK_ADVANCEMENT);
		if (advancement == null)
			return false;
		return player.getAdvancements().getOrStartProgress(advancement).isDone();
	}

	private static void sendTitle(ServerPlayer player, String title, String subtitle) {
		player.connection.send(new ClientboundSetTitlesAnimationPacket(10, 40, 10));
		player.connection.send(new ClientboundSetTitleTextPacket(new TextComponent(title)));
		player.connection.send(new ClientboundSetSubtitleTextPacket(new TextComponent(subtitle)));
	}
}
