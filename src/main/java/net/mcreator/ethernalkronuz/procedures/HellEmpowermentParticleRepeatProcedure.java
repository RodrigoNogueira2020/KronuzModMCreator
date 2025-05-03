package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModMobEffects;

import javax.annotation.Nullable;

import java.util.Random;

@Mod.EventBusSubscriber
public class HellEmpowermentParticleRepeatProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EthernalKronuzModMobEffects.HELL_EMPOWERMENT.get()) : false) {
			if (Mth.nextInt(new Random(), 1, 100) > 80) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute as @p at @s anchored feet run particle ethernal_kronuz:hell_particle ~ ~0.2 ~ 0.5 0.5 0.5 0.00001 1");
			}
		}
	}
}
