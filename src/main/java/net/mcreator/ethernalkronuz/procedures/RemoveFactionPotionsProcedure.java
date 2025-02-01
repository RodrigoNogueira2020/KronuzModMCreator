package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RemoveFactionPotionsProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).ADCPlayer && ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("ethernal_kronuz:ascender_advancement"))).isDone()
				: false)
				|| (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
						? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("ethernal_kronuz:rl_verde_achievement"))).isDone()
						: false))) {
			{
				boolean _setval = false;
				entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.ADCPlayer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			RemoveFactionPotions1Procedure.execute(entity);
		} else if ((entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).BTPlayer && ((entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
				? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("ethernal_kronuz:ascender_advancement"))).isDone()
				: false)
				|| (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
						? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("ethernal_kronuz:rl_verde_achievement"))).isDone()
						: false))) {
			{
				boolean _setval = false;
				entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BTPlayer = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			RemoveFactionPotions2Procedure.execute(entity);
		}
	}
}
