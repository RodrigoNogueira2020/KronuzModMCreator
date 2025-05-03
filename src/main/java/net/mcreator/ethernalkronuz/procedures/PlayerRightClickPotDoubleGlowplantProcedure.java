package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PlayerRightClickPotDoubleGlowplantProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getPlayer().getUsedItemHand())
			return;
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.FLOWER_POT
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == EthernalKronuzModBlocks.DOUBLE_GLOW_PLANT.get().asItem()) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y, z), EthernalKronuzModBlocks.FLOWERPOTDOUBLEGLOWPLANT.get().defaultBlockState(), 3);
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(EthernalKronuzModBlocks.DOUBLE_GLOW_PLANT.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
	}
}
