package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.Util;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

public class RiseRadiantLordVermelhoAfterTheRiseConfirmationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("ethernal_kronuz:the_rise_complete_advancement"))).isDone()
				: false) && !EthernalKronuzModVariables.MapVariables.get(world).RadiantLordVermelho) {
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastMessage(new TextComponent("\u00A7cBeginning The Rise"), ChatType.SYSTEM, Util.NIL_UUID);
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
							_mcserv.getPlayerList().broadcastMessage(new TextComponent("\u00A7c3"), ChatType.SYSTEM, Util.NIL_UUID);
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
									_mcserv.getPlayerList().broadcastMessage(new TextComponent("\u00A7c2"), ChatType.SYSTEM, Util.NIL_UUID);
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
											_mcserv.getPlayerList().broadcastMessage(new TextComponent("\u00A7c1"), ChatType.SYSTEM, Util.NIL_UUID);
									}
									if (entity instanceof Player _player)
										_player.closeContainer();
									{
										boolean _setval = false;
										entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.HasMinimumForTheRiseVermelho = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										boolean _setval = true;
										entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.RadiantLordVermelhoPlayer = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									EthernalKronuzModVariables.MapVariables.get(world).RadiantLordVermelho = true;
									EthernalKronuzModVariables.MapVariables.get(world).syncData(world);
									{
										boolean _setval = true;
										entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.IsRadiantLord = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										boolean _setval = true;
										entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.AllowInJotunheim = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									GiveRadiantLordEffectsProcedure.execute(world, x, y, z, entity);
									entity.setCustomName(new TextComponent("\u00A7cAzakana"));
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(EthernalKronuzModItems.MURASAMA.get());
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
									if (!world.isClientSide()) {
										MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
										if (_mcserv != null)
											_mcserv.getPlayerList().broadcastMessage(new TextComponent("\u00A7cAzakana is AMONGUS!"), ChatType.SYSTEM, Util.NIL_UUID);
									}
									if (entity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(new TextComponent("In 10 seconds you'll go back to where you were before The Rise"), (true));
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, 20);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, 20);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 20);
		}
	}
}
