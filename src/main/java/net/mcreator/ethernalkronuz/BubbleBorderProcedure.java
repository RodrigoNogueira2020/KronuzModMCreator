package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.Entity;
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

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;

import java.util.UUID;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;

@Mod.EventBusSubscriber
public class BubbleBorderProcedure {
	// Configuração
	private static final double CENTER_X = 100;
	// cords x do centro da border (ser as mesmas que as cords da estrutura)
	private static final double CENTER_Y = 200;
	// cords y do centro da border (ser as mesmas que as cords da estrutura)
	private static final double CENTER_Z = 100;
	// cords z do centro da border (ser as mesmas que as cords da estrutura)
	private static final double BUBBLE_RADIUS = 25;
	// raio da border (abrangir a estrutura)
	private static final double WARNING_DISTANCE = 20; // distância fora da border para aviso
	private static final ResourceKey<net.minecraft.world.level.Level> ASGARD = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("ethernal_kronuz:asgard"));
	private static final ResourceLocation RAGNAROK_ADVANCEMENT = new ResourceLocation("ethernal_kronuz:ragnarok");
	// Visual
	// "A" = esfera completa sempre visível enquanto há jogadores dentro (mais impacto visual)
	// "B" = discos perto de cada jogador (muito mais leve)
	private static final String VISUAL_MODE = "A";
	// Modo A: densidade da esfera
	// 12 × 24 = 288 partículas por atualização (cada 1 segundo = muito leve)
	private static final int SPHERE_LAT_STEPS = 12;
	private static final int SPHERE_LON_STEPS = 24;
	private static final int SPHERE_TICK_INTERVAL = 20; // 1 atualização/segundo
	// Modo B + discos de aproximação de fora: rings preenchidos
	private static final int PARTICLES_PER_RING = 36;
	private static final int DISK_FILL_RINGS = 4; // anéis concêntricos para preencher
	private static final int RING_COUNT = 3;
	private static final double RING_SPACING = 2.0;
	private static final double VISUAL_DISTANCE = 12.0;
	private static final int RING_TICK_INTERVAL = 4; // 5 atualizações/segundo
	// Intervalo do título de aviso (evita spam)
	private static final int WARNING_TITLE_INTERVAL = 80; // 4 segundos
	private static final Map<UUID, Boolean> wasInsideMap = new HashMap<>();
	private static final Set<UUID> hasEnteredSet = new HashSet<>();
	// Flag partilhada: há algum jogador dentro da bolha?
	// Atualizada no ServerTick, lida no PlayerTick
	private static boolean anyoneInsideCache = false;
	private static int serverTickCount = 0;

	// SERVER TICK — esfera completa (Modo A) + projéteis
	@SubscribeEvent
	public static void onServerTick(TickEvent.ServerTickEvent event) {
		if (event.phase != TickEvent.Phase.END)
			return;
		serverTickCount++;
		var server = net.minecraftforge.server.ServerLifecycleHooks.getCurrentServer();
		if (server == null)
			return;
		ServerLevel asgard = server.getLevel(ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("ethernal_kronuz:asgard")));
		if (asgard == null)
			return;
		if (EthernalKronuzModVariables.WorldVariables.get(asgard).RagnarokHappened) {
			anyoneInsideCache = false;
			return;
		}
		// Atualiza a flag "há alguém dentro"
		anyoneInsideCache = asgard.players().stream().anyMatch(p -> isInsideBorder(p.getX(), p.getY(), p.getZ()));
		// Modo A: esfera completa quando há alguém dentro
		if ("A".equals(VISUAL_MODE) && anyoneInsideCache && serverTickCount % SPHERE_TICK_INTERVAL == 0)
			spawnFullSphere(asgard);
		// Despawn de projéteis que cruzam a border
		// Só verifica projéteis numa AABB à volta da border (eficiente)
		if (serverTickCount % 2 == 0) {
			AABB borderShell = new AABB(CENTER_X - BUBBLE_RADIUS - 3, CENTER_Y - BUBBLE_RADIUS - 3, CENTER_Z - BUBBLE_RADIUS - 3, CENTER_X + BUBBLE_RADIUS + 3, CENTER_Y + BUBBLE_RADIUS + 3, CENTER_Z + BUBBLE_RADIUS + 3);
			for (Projectile proj : asgard.getEntitiesOfClass(Projectile.class, borderShell, p -> true)) {
				Entity owner = proj.getOwner();
				if (owner == null)
					continue;
				boolean ownerInside = isInsideBorder(owner.getX(), owner.getY(), owner.getZ());
				boolean projInside = isInsideBorder(proj.getX(), proj.getY(), proj.getZ());
				if (ownerInside != projInside)
					proj.discard(); // remove o projétil ao cruzar a border
			}
		}
	}

	//   PLAYER TICK - lógica de border + visual por jogador
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase != TickEvent.Phase.END)
			return;
		if (!(event.player instanceof ServerPlayer player))
			return;
		if (!(player.level instanceof ServerLevel level))
			return;
		if (!level.dimension().equals(ASGARD))
			return;
		boolean ragnarokDone = EthernalKronuzModVariables.WorldVariables.get(level).RagnarokHappened;
		double dx = player.getX() - CENTER_X;
		double dy = player.getY() - CENTER_Y;
		double dz = player.getZ() - CENTER_Z;
		double distFromCenter = Math.sqrt(dx * dx + dy * dy + dz * dz);
		double distFromBorder = BUBBLE_RADIUS - distFromCenter;
		boolean isInsideNow = distFromCenter <= BUBBLE_RADIUS;
		boolean wasInside = wasInsideMap.getOrDefault(player.getUUID(), false);
		// Título de 1ª entrada
		if (isInsideNow && !hasEnteredSet.contains(player.getUUID())) {
			hasEnteredSet.add(player.getUUID());
			sendTitle(player, "§4The Doom of Gods", "§cFight for freedom");
		}
		// Jogador está FORA da bolha
		if (!isInsideNow) {
			if (!ragnarokDone) {
				boolean approaching = distFromCenter < BUBBLE_RADIUS + WARNING_DISTANCE;
				// Aviso de aproximação
				if (approaching && player.tickCount % WARNING_TITLE_INTERVAL == 0)
					sendTitle(player, "§c⚠ Battle", "§eYou can get in, but can't get out");
				// Discos preenchidos visíveis de fora (ambos os modos)
				// Aparece quando não há ninguém dentro (estado "convite")
				// OU quando o próprio jogador está a sair (estado "bloqueio")
				if (approaching && !anyoneInsideCache && player.tickCount % RING_TICK_INTERVAL == 0)
					spawnBorderDisks(level, player, Math.abs(distFromBorder));
				// Bloqueio de saída: só age em quem estava dentro
				if (wasInside) {
					double safeX = CENTER_X + (dx / distFromCenter) * (BUBBLE_RADIUS - 1);
					double safeY = CENTER_Y + (dy / distFromCenter) * (BUBBLE_RADIUS - 1);
					double safeZ = CENTER_Z + (dz / distFromCenter) * (BUBBLE_RADIUS - 1);
					player.teleportTo(level, safeX, safeY, safeZ, player.getYRot(), player.getXRot());
					sendTitle(player, "§c⚠ Locked", "§7Defeat the Gods");
					return; // wasInside permanece true (continua dentro após teleporte)
				}
			}
			wasInsideMap.put(player.getUUID(), false);
			return;
		}
		// Jogador está DENTRO da bolha
		wasInsideMap.put(player.getUUID(), true);
		// Modo B: discos perto da border quando está dentro
		if ("B".equals(VISUAL_MODE) && !ragnarokDone && player.tickCount % RING_TICK_INTERVAL == 0 && distFromBorder <= VISUAL_DISTANCE)
			spawnBorderDisks(level, player, distFromBorder);
	}

	//   BLOQUEIO DE ATAQUES CROSS-BORDER (melee + projéteis)
	@SubscribeEvent
	public static void onLivingAttack(LivingAttackEvent event) {
		if (!(event.getEntity().level instanceof ServerLevel level))
			return;
		if (!level.dimension().equals(ASGARD))
			return;
		if (EthernalKronuzModVariables.WorldVariables.get(level).RagnarokHappened)
			return;
		Entity attacker = event.getSource().getEntity();
		if (attacker == null)
			return;
		// Para projéteis, usa a posição do próprio projétil (não do dono)
		Entity direct = event.getSource().getDirectEntity();
		double atkX, atkY, atkZ;
		if (direct instanceof Projectile) {
			atkX = direct.getX();
			atkY = direct.getY();
			atkZ = direct.getZ();
		} else {
			atkX = attacker.getX();
			atkY = attacker.getY();
			atkZ = attacker.getZ();
		}
		boolean targetInside = isInsideBorder(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
		boolean attackerInside = isInsideBorder(atkX, atkY, atkZ);
		// Cancela se atacante e alvo estão em lados diferentes
		if (targetInside != attackerInside)
			event.setCanceled(true);
	}

	//   ADVANCEMENT — Ragnarok conquistado
	@SubscribeEvent
	public static void onAdvancement(AdvancementEvent event) {
		if (!(event.getPlayer() instanceof ServerPlayer player))
			return;
		if (!event.getAdvancement().getId().equals(RAGNAROK_ADVANCEMENT))
			return;
		// Só age quando o advancement fica 100% completo
		if (!player.getAdvancements().getOrStartProgress(event.getAdvancement()).isDone())
			return;
		var server = player.getServer();
		if (server == null)
			return;
		// ── Ativa RagnarokHappened em todas as dimensões ─────
		for (ServerLevel lvl : server.getAllLevels()) {
			var worldVars = EthernalKronuzModVariables.WorldVariables.get(lvl);
			worldVars.RagnarokHappened = true;
			// ⚠️ Verifica o nome exato do método de sync na classe
			// WorldVariables gerada pelo MCreator (pode ser syncData, save, etc.)
			worldVars.syncData(lvl);
		}
		// ── Dá o achievement a TODOS os outros jogadores ─────
		Advancement adv = server.getAdvancements().getAdvancement(RAGNAROK_ADVANCEMENT);
		if (adv == null)
			return;
		for (ServerPlayer other : server.getPlayerList().getPlayers()) {
			if (other.getUUID().equals(player.getUUID()))
				continue; // já tem
			for (String criterion : adv.getCriteria().keySet())
				other.getAdvancements().award(adv, criterion);
		}
	}

	//   LOGOUT — limpa o estado do jogador
	@SubscribeEvent
	public static void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
		UUID id = event.getPlayer().getUUID();
		wasInsideMap.remove(id);
		hasEnteredSet.remove(id);
		// Nota: hasEnteredSet.remove permite que o título de 1ª entrada
		// apareça novamente na próxima sessão. Remove esta linha se
		// quiseres que apareça apenas uma vez por mundo.
	}

	//   VISUAL — Modo A: esfera completa UV
	private static void spawnFullSphere(ServerLevel level) {
		for (int lat = 0; lat < SPHERE_LAT_STEPS; lat++) {
			double theta = Math.PI * lat / SPHERE_LAT_STEPS;
			double sinT = Math.sin(theta);
			double cosT = Math.cos(theta);
			for (int lon = 0; lon < SPHERE_LON_STEPS; lon++) {
				double phi = 2 * Math.PI * lon / SPHERE_LON_STEPS;
				double px = CENTER_X + BUBBLE_RADIUS * sinT * Math.cos(phi);
				double py = CENTER_Y + BUBBLE_RADIUS * cosT;
				double pz = CENTER_Z + BUBBLE_RADIUS * sinT * Math.sin(phi);
				// Envia só a jogadores dentro de 64 blocos deste ponto
				// (evita enviar partículas que o cliente nunca vai ver)
				for (ServerPlayer p : level.players()) {
					double d2 = (p.getX() - px) * (p.getX() - px) + (p.getY() - py) * (p.getY() - py) + (p.getZ() - pz) * (p.getZ() - pz);
					if (d2 < 64 * 64)
						level.sendParticles(p, ParticleTypes.SOUL_FIRE_FLAME, true, px, py, pz, 1, 0, 0, 0, 0);
				}
			}
		}
	}

	//   VISUAL — Modo B + Aproximação: discos preenchidos
	private static void spawnBorderDisks(ServerLevel level, ServerPlayer player, double distFromBorder) {
		double dx = player.getX() - CENTER_X;
		double dy = player.getY() - CENTER_Y;
		double dz = player.getZ() - CENTER_Z;
		double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);
		if (dist == 0)
			return;
		double rx = dx / dist, ry = dy / dist, rz = dz / dist;
		double surfX = CENTER_X + rx * BUBBLE_RADIUS;
		double surfY = CENTER_Y + ry * BUBBLE_RADIUS;
		double surfZ = CENTER_Z + rz * BUBBLE_RADIUS;
		// Vetores perpendiculares ao vetor radial
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
		var particleType = distFromBorder < 5.0 ? ParticleTypes.FLAME : ParticleTypes.SOUL_FIRE_FLAME;
		for (int ring = 0; ring < RING_COUNT; ring++) {
			double offset = (ring - RING_COUNT / 2.0) * RING_SPACING;
			double maxRadius = Math.min(8.0, Math.sqrt(Math.max(0, BUBBLE_RADIUS * BUBBLE_RADIUS - offset * offset * 0.5)));
			double cX = surfX + rx * offset * 0.1;
			double cY = surfY + ry * offset * 0.1;
			double cZ = surfZ + rz * offset * 0.1;
			// ── Disco preenchido: anéis concêntricos ──────────
			for (int f = 1; f <= DISK_FILL_RINGS; f++) {
				double r = maxRadius * f / DISK_FILL_RINGS;
				// Mais pontos nos anéis exteriores para densidade uniforme
				int pts = Math.max(6, (int) (PARTICLES_PER_RING * f / DISK_FILL_RINGS));
				for (int i = 0; i < pts; i++) {
					double angle = 2 * Math.PI * i / pts;
					double cos = Math.cos(angle), sin = Math.sin(angle);
					double ppx = cX + (p1x * cos + p2x * sin) * r;
					double ppy = cY + (p1y * cos + p2y * sin) * r;
					double ppz = cZ + (p1z * cos + p2z * sin) * r;
					level.sendParticles(player, particleType, true, ppx, ppy, ppz, 1, 0, 0, 0, 0);
				}
			}
			// Ponto central
			level.sendParticles(player, particleType, true, cX, cY, cZ, 1, 0, 0, 0, 0);
		}
	}

	//   HELPERS
	private static double distanceFromCenter(double x, double y, double z) {
		double dx = x - CENTER_X, dy = y - CENTER_Y, dz = z - CENTER_Z;
		return Math.sqrt(dx * dx + dy * dy + dz * dz);
	}

	private static boolean isInsideBorder(double x, double y, double z) {
		return distanceFromCenter(x, y, z) <= BUBBLE_RADIUS;
	}

	private static void sendTitle(ServerPlayer player, String title, String subtitle) {
		player.connection.send(new ClientboundSetTitlesAnimationPacket(10, 40, 10));
		player.connection.send(new ClientboundSetTitleTextPacket(new TextComponent(title)));
		player.connection.send(new ClientboundSetSubtitleTextPacket(new TextComponent(subtitle)));
	}
}
