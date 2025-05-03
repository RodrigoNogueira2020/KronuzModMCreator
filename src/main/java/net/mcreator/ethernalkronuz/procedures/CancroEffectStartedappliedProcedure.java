package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModMobEffects;
import net.mcreator.ethernalkronuz.entity.TechnomortoEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CancroEffectStartedappliedProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EthernalKronuzModMobEffects.CANCRO.get()) : false) && sourceentity instanceof TechnomortoEntity && (entity instanceof ServerPlayer || entity instanceof Player)) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(EthernalKronuzModMobEffects.CANCRO.get(), 4800, 0, (true), (false)));
		}
	}
}
