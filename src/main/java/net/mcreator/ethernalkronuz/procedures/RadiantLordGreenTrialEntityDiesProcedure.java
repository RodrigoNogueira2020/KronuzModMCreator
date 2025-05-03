package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.entity.RadiantLordGreenTrialEntity;

import java.util.Iterator;

public class RadiantLordGreenTrialEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof RadiantLordGreenTrialEntity && (sourceentity instanceof Player || sourceentity instanceof ServerPlayer)) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
						"/stopsound @a music ethernal_kronuz:template_boss_music");
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ethernal_kronuz:the_rise_fade_out")), SoundSource.MUSIC, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ethernal_kronuz:the_rise_fade_out")), SoundSource.MUSIC, 1, 1, false);
				}
			}
			if (sourceentity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("ethernal_kronuz:the_rise_complete_advancement"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemainingCriteria().iterator();
					while (_iterator.hasNext())
						_player.getAdvancements().award(_adv, (String) _iterator.next());
				}
			}
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if ((sourceentity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).DimensionBeforeEnterJotunheim == 0) {
						if (sourceentity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
							ResourceKey<Level> destinationType = Level.OVERWORLD;
							if (_player.level.dimension() == destinationType)
								return;
							ServerLevel nextLevel = _player.server.getLevel(destinationType);
							if (nextLevel != null) {
								_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
								_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
								for (MobEffectInstance _effectinstance : _player.getActiveEffects())
									_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
								_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
					if ((sourceentity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).DimensionBeforeEnterJotunheim == 1) {
						if (sourceentity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
							ResourceKey<Level> destinationType = Level.NETHER;
							if (_player.level.dimension() == destinationType)
								return;
							ServerLevel nextLevel = _player.server.getLevel(destinationType);
							if (nextLevel != null) {
								_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
								_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
								for (MobEffectInstance _effectinstance : _player.getActiveEffects())
									_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
								_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
					if ((sourceentity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).DimensionBeforeEnterJotunheim == 2) {
						if (sourceentity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
							ResourceKey<Level> destinationType = Level.END;
							if (_player.level.dimension() == destinationType)
								return;
							ServerLevel nextLevel = _player.server.getLevel(destinationType);
							if (nextLevel != null) {
								_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
								_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
								for (MobEffectInstance _effectinstance : _player.getActiveEffects())
									_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
								_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
					if ((sourceentity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).DimensionBeforeEnterJotunheim == 3) {
						if (sourceentity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("ethernal_kronuz:asgard"));
							if (_player.level.dimension() == destinationType)
								return;
							ServerLevel nextLevel = _player.server.getLevel(destinationType);
							if (nextLevel != null) {
								_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
								_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
								for (MobEffectInstance _effectinstance : _player.getActiveEffects())
									_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance));
								_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
					{
						Entity _ent = sourceentity;
						_ent.teleportTo(((sourceentity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).CoordXBeforeEnterJotunheim),
								((sourceentity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).CoordYBeforeEnterJotunheim),
								((sourceentity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).CoordZBeforeEnterJotunheim));
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(((sourceentity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).CoordXBeforeEnterJotunheim),
									((sourceentity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).CoordYBeforeEnterJotunheim),
									((sourceentity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).CoordZBeforeEnterJotunheim), _ent.getYRot(), _ent.getXRot());
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 400);
		}
	}
}
