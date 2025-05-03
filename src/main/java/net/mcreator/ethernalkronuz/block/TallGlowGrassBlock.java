
package net.mcreator.ethernalkronuz.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.common.PlantType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModBlocks;

import java.util.List;
import java.util.Collections;

public class TallGlowGrassBlock extends DoublePlantBlock {
	public TallGlowGrassBlock() {
		super(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS).sound(SoundType.GRASS).instabreak().lightLevel(s -> 5).noCollission());
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		if (state.getValue(HALF) != DoubleBlockHalf.LOWER)
			return Collections.emptyList();
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(EthernalKronuzModBlocks.ASGARDIAN_DIRT.get()) || groundState.is(EthernalKronuzModBlocks.ASGARDIAN_DIRT_BLOCK.get());
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		if (blockstate.getValue(HALF) == DoubleBlockHalf.UPPER)
			return groundState.is(this) && groundState.getValue(HALF) == DoubleBlockHalf.LOWER;
		else
			return this.mayPlaceOn(groundState, worldIn, blockpos);
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.PLAINS;
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		ItemBlockRenderTypes.setRenderLayer(EthernalKronuzModBlocks.TALL_GLOW_GRASS.get(), renderType -> renderType == RenderType.cutout());
	}
}
