package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.BlockPos;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModBlocks;

public class FlowerpotdoubleglowplantOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y, z), Blocks.FLOWER_POT.defaultBlockState(), 3);
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(EthernalKronuzModBlocks.DOUBLE_GLOW_PLANT.get());
				_setstack.setCount(1);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
	}
}
