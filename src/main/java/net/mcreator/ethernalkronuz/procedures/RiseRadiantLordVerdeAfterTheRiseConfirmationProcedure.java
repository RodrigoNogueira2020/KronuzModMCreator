package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
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

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RiseRadiantLordVerdeAfterTheRiseConfirmationProcedure {
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
		if ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("ethernal_kronuz:the_rise_complete_advancement"))).isDone()
				: false) && !EthernalKronuzModVariables.MapVariables.get(world).RadiantLordVerde) {
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastMessage(new TextComponent("\u00A7aBeginning The Rise"), ChatType.SYSTEM, Util.NIL_UUID);
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
							_mcserv.getPlayerList().broadcastMessage(new TextComponent("\u00A7a3"), ChatType.SYSTEM, Util.NIL_UUID);
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
									_mcserv.getPlayerList().broadcastMessage(new TextComponent("\u00A7a2"), ChatType.SYSTEM, Util.NIL_UUID);
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
											_mcserv.getPlayerList().broadcastMessage(new TextComponent("\u00A7a1"), ChatType.SYSTEM, Util.NIL_UUID);
									}
									if (entity instanceof Player _player)
										_player.closeContainer();
									{
										boolean _setval = false;
										entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.HasMinimumForTheRiseVerde = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										boolean _setval = true;
										entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.RadiantLordVerdePlayer = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									EthernalKronuzModVariables.MapVariables.get(world).RadiantLordVerde = true;
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
									EthernalKronuzModVariables.MapVariables.get(world).RadiantLordRoxo = true;
									EthernalKronuzModVariables.MapVariables.get(world).syncData(world);
									GiveRadiantLordEffectsProcedure.execute(world, x, y, z, entity);
									entity.setCustomName(new TextComponent("\u00A7aTitan Kaleb"));
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(EthernalKronuzModItems.TERRA_BLADE.get());
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
									if (entity instanceof Player _player) {
										ItemStack _setstack = new ItemStack(EthernalKronuzModItems.BIFROST_KEY.get());
										_setstack.setCount(1);
										ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
									}
									{
										Entity _entity = entity;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(3, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_HELMET.get()));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_HELMET.get()));
										}
									}
									{
										Entity _entity = entity;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(2, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_CHESTPLATE.get()));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_CHESTPLATE.get()));
										}
									}
									{
										Entity _entity = entity;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(1, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_LEGGINGS.get()));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_LEGGINGS.get()));
										}
									}
									{
										Entity _entity = entity;
										if (_entity instanceof Player _player) {
											_player.getInventory().armor.set(0, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_BOOTS.get()));
											_player.getInventory().setChanged();
										} else if (_entity instanceof LivingEntity _living) {
											_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_BOOTS.get()));
										}
									}
									for (int index0 = 0; index0 < (int) (5); index0++) {
										if (!world.isClientSide()) {
											MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
											if (_mcserv != null)
												_mcserv.getPlayerList().broadcastMessage(new TextComponent("\u00A7aThe Rise of Titan Kaleb has been completed"), ChatType.SYSTEM, Util.NIL_UUID);
										}
									}
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
