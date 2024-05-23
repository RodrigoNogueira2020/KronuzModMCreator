
package net.mcreator.ethernalkronuz.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.ethernalkronuz.procedures.CristalizedDivineWaterMobplayerCollidesBlockProcedure;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModFluids;

public class CristalizedDivineWaterBlock extends LiquidBlock {
	public CristalizedDivineWaterBlock() {
		super(() -> (FlowingFluid) EthernalKronuzModFluids.CRISTALIZED_DIVINE_WATER.get(), BlockBehaviour.Properties.of(Material.WATER).strength(100f)

				.lightLevel(s -> 2));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		CristalizedDivineWaterMobplayerCollidesBlockProcedure.execute(entity);
	}
}
