
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ethernalkronuz.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.biome.Biome;

import net.mcreator.ethernalkronuz.world.biome.StoneSpikesBiome;
import net.mcreator.ethernalkronuz.world.biome.SkyFieldsBiome;
import net.mcreator.ethernalkronuz.world.biome.PlainsJotunheimBiome;
import net.mcreator.ethernalkronuz.world.biome.FloatingGardenBiome;
import net.mcreator.ethernalkronuz.world.biome.CrystalPillarsBiome;
import net.mcreator.ethernalkronuz.EthernalKronuzMod;

public class EthernalKronuzModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, EthernalKronuzMod.MODID);
	public static final RegistryObject<Biome> PLAINS_JOTUNHEIM = REGISTRY.register("plains_jotunheim", () -> PlainsJotunheimBiome.createBiome());
	public static final RegistryObject<Biome> STONE_SPIKES = REGISTRY.register("stone_spikes", () -> StoneSpikesBiome.createBiome());
	public static final RegistryObject<Biome> CRYSTAL_PILLARS = REGISTRY.register("crystal_pillars", () -> CrystalPillarsBiome.createBiome());
	public static final RegistryObject<Biome> SKY_FIELDS = REGISTRY.register("sky_fields", () -> SkyFieldsBiome.createBiome());
	public static final RegistryObject<Biome> FLOATING_GARDEN = REGISTRY.register("floating_garden", () -> FloatingGardenBiome.createBiome());
}
