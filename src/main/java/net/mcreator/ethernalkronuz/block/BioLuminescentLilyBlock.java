
package net.mcreator.ethernalkronuz.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModBlocks;

import java.util.List;
import java.util.Collections;

public class BioLuminescentLilyBlock extends FlowerBlock {
	public BioLuminescentLilyBlock() {
		super(MobEffects.MOVEMENT_SPEED, 100, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).instabreak().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel(s -> 11).noCollission());
	}

	@Override
	public int getEffectDuration() {
		return 100;
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
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		ItemBlockRenderTypes.setRenderLayer(EthernalKronuzModBlocks.BIO_LUMINESCENT_LILY.get(), renderType -> renderType == RenderType.cutout());
	}
}
