package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HellEmpowermentEffectsProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		boolean found = false;
		boolean fire_resistance = false;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(EthernalKronuzModMobEffects.HELL_EMPOWERMENT.get()) : false) {
			sx = -3;
			found = false;
			for (int index0 = 0; index0 < (int) (6); index0++) {
				sy = -3;
				for (int index1 = 0; index1 < (int) (6); index1++) {
					sz = -3;
					for (int index2 = 0; index2 < (int) (6); index2++) {
						if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.LAVA || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.LAVA
								|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.FIRE || (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == Blocks.SOUL_FIRE) {
							found = true;
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			if (found == true) {
				fire_resistance = true;
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 999999, 0, (false), (false)));
			} else if (found == false) {
				fire_resistance = false;
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.FIRE_RESISTANCE);
			}
		}
	}
}
