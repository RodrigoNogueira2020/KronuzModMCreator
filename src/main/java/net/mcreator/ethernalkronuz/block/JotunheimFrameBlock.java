
package net.mcreator.ethernalkronuz.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class JotunheimFrameBlock extends Block {
	public JotunheimFrameBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE).strength(1f, 10f).lightLevel(s -> 8).noDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
