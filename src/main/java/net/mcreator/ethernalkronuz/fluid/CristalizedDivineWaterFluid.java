
package net.mcreator.ethernalkronuz.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.item.Rarity;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModFluids;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModBlocks;

public abstract class CristalizedDivineWaterFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(EthernalKronuzModFluids.CRISTALIZED_DIVINE_WATER, EthernalKronuzModFluids.FLOWING_CRISTALIZED_DIVINE_WATER,
			FluidAttributes.builder(new ResourceLocation("ethernal_kronuz:blocks/divine_water_still_animated"), new ResourceLocation("ethernal_kronuz:blocks/divine_water_flow_animated"))

					.rarity(Rarity.RARE))
			.explosionResistance(100f)

			.bucket(EthernalKronuzModItems.CRISTALIZED_DIVINE_WATER_BUCKET).block(() -> (LiquidBlock) EthernalKronuzModBlocks.CRISTALIZED_DIVINE_WATER.get());

	private CristalizedDivineWaterFluid() {
		super(PROPERTIES);
	}

	public static class Source extends CristalizedDivineWaterFluid {
		public Source() {
			super();
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends CristalizedDivineWaterFluid {
		public Flowing() {
			super();
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
