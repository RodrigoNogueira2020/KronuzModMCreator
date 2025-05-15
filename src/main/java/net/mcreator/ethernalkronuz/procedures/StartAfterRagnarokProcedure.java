package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;
import net.minecraft.Util;

import net.mcreator.ethernalkronuz.world.inventory.RLVotingGUIMenu;
import net.mcreator.ethernalkronuz.world.inventory.NonRLVotingGUIMenu;
import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;

import javax.annotation.Nullable;

import java.util.ArrayList;

import io.netty.buffer.Unpooled;

@Mod.EventBusSubscriber
public class StartAfterRagnarokProcedure {
	@SubscribeEvent
	public static void onAdvancement(AdvancementEvent event) {
		execute(event, event.getPlayer().level, event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("ethernal_kronuz:ragnarok"))).isDone() : false)
				&& !EthernalKronuzModVariables.MapVariables.get(world).ActivateAfterRagnarok) {
			EthernalKronuzModVariables.MapVariables.get(world).ActivateAfterRagnarok = true;
			EthernalKronuzModVariables.MapVariables.get(world).syncData(world);
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastMessage(new TextComponent("\u00A7eUNKNOW: \u00A7bAfter Ragnar\u00F6k reunion in a week"), ChatType.SYSTEM, Util.NIL_UUID);
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
					for (Entity entityiterator : new ArrayList<>(world.players())) {
						{
							double _setval = entity.getX();
							entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.CoordXBeforeEnterJotunheim = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = entity.getY();
							entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.CoordXBeforeEnterJotunheim = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = entity.getZ();
							entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.CoordXBeforeEnterJotunheim = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof ServerPlayer _player && !_player.level.isClientSide()) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("ethernal_kronuz:jotunheim"));
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
						{
							Entity _ent = entity;
							_ent.teleportTo(0, 1000, 0);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(0, 1000, 0, _ent.getYRot(), _ent.getXRot());
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
								if (!world.isClientSide()) {
									MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
									if (_mcserv != null)
										_mcserv.getPlayerList().broadcastMessage(new TextComponent("\u00A7eUNKNOW: \u00A7bVoting starting in 10 seconds"), ChatType.SYSTEM, Util.NIL_UUID);
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
										if ((entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordRoxoPlayer
												|| (entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordVermelhoPlayer) {
											{
												if (entity instanceof ServerPlayer _ent) {
													BlockPos _bpos = new BlockPos(x, y, z);
													NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
														@Override
														public Component getDisplayName() {
															return new TextComponent("RLVotingGUI");
														}

														@Override
														public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
															return new RLVotingGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
														}
													}, _bpos);
												}
											}
										} else {
											{
												if (entity instanceof ServerPlayer _ent) {
													BlockPos _bpos = new BlockPos(x, y, z);
													NetworkHooks.openGui((ServerPlayer) _ent, new MenuProvider() {
														@Override
														public Component getDisplayName() {
															return new TextComponent("NonRLVotingGUI");
														}

														@Override
														public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
															return new NonRLVotingGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
														}
													}, _bpos);
												}
											}
										}
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, 200);
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, 200);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 200);
		}
	}
}
