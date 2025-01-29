package net.mcreator.ethernalkronuz.procedures;

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

import java.util.Random;

public class AsgardEmpowermentParticleRepeatProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EthernalKronuzModMobEffects.ASGARD_EMPOWERMENT.get()) : false) {
			if (Mth.nextInt(new Random(), 1, 100) > 90) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute as @p at @s anchored feet run particle ethernal_kronuz:asgard_particle ~ ~0.5 ~ 0.5 0.5 0.5 0.00001 1");
			}
		}
	}
}
