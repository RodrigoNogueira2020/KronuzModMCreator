package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AsgardEmpowermentEffectGiveProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("ethernal_kronuz:asgard")))
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EthernalKronuzModMobEffects.ASGARD_EMPOWERMENT.get()) : false)
				&& (entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).AsgardDeaths == 0) {
			if ((entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordRoxoPlayer
					|| (entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordVerdePlayer
					|| (entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordVermelhoPlayer) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(20);
			} else {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(10);
			}
			{
				double _setval = 1;
				entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.AsgardDeaths = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(EthernalKronuzModMobEffects.ASGARD_EMPOWERMENT.get());
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(EthernalKronuzModMobEffects.ASGARD_EMPOWERMENT_COOLDOWN.get(), 6000, 0, (true), (false)));
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			{
				double _setval = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EthernalKronuzModMobEffects.ASGARD_EMPOWERMENT_COOLDOWN.get())
						? _livEnt.getEffect(EthernalKronuzModMobEffects.ASGARD_EMPOWERMENT_COOLDOWN.get()).getDuration()
						: 0;
				entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.AsgardCooldownRemainTicks = _setval;
					capability.syncPlayerVariables(entity);
				});
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
					{
						double _setval = 0;
						entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.AsgardDeaths = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) (entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).AsgardCooldownRemainTicks);
		} else if ((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("ethernal_kronuz:asgard")))
				&& (entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).AsgardDeaths == 1) {
			{
				double _setval = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(EthernalKronuzModMobEffects.ASGARD_EMPOWERMENT_COOLDOWN.get())
						? _livEnt.getEffect(EthernalKronuzModMobEffects.ASGARD_EMPOWERMENT_COOLDOWN.get()).getDuration()
						: 0;
				entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.AsgardCooldownRemainTicks = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
