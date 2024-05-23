
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ethernalkronuz.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.ethernalkronuz.fluid.CristalizedDivineWaterFluid;
import net.mcreator.ethernalkronuz.EthernalKronuzMod;

public class EthernalKronuzModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, EthernalKronuzMod.MODID);
	public static final RegistryObject<Fluid> CRISTALIZED_DIVINE_WATER = REGISTRY.register("cristalized_divine_water", () -> new CristalizedDivineWaterFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_CRISTALIZED_DIVINE_WATER = REGISTRY.register("flowing_cristalized_divine_water", () -> new CristalizedDivineWaterFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(CRISTALIZED_DIVINE_WATER.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_CRISTALIZED_DIVINE_WATER.get(), renderType -> renderType == RenderType.translucent());
		}
	}
}
