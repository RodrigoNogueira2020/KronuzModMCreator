
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ethernalkronuz.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Holder;

import net.mcreator.ethernalkronuz.world.features.plants.TallGlowGrassFeature;
import net.mcreator.ethernalkronuz.world.features.plants.NormalGlowGrassFeature;
import net.mcreator.ethernalkronuz.world.features.plants.GlowPlantFeature;
import net.mcreator.ethernalkronuz.world.features.plants.DoubleGlowPlantFeature;
import net.mcreator.ethernalkronuz.world.features.plants.BioLuminescentLilyFeature;
import net.mcreator.ethernalkronuz.world.features.ores.MossoCrystalOreFeature;
import net.mcreator.ethernalkronuz.world.features.ores.HeavenSlateFeature;
import net.mcreator.ethernalkronuz.world.features.ores.FakingEllOreFeature;
import net.mcreator.ethernalkronuz.world.features.YggsmalltreeSkyFieldsFeature;
import net.mcreator.ethernalkronuz.world.features.YggsmalltreeFloatingGardenFeature;
import net.mcreator.ethernalkronuz.world.features.YggsmallbushSkyFieldsFeature;
import net.mcreator.ethernalkronuz.world.features.YggsmallbushFloatingGardenFeature;
import net.mcreator.ethernalkronuz.world.features.YggmediumtreeSkyFieldFeature;
import net.mcreator.ethernalkronuz.world.features.YggmediumtreeFloatingGardenFeature;
import net.mcreator.ethernalkronuz.world.features.YggdrasilgiantstructvoidsFeature;
import net.mcreator.ethernalkronuz.world.features.YggbigtreeSkyFieldsFeature;
import net.mcreator.ethernalkronuz.world.features.YggbigtreeFloatingGardenFeature;
import net.mcreator.ethernalkronuz.world.features.YggbigbushSkyFieldsFeature;
import net.mcreator.ethernalkronuz.world.features.YggbigbushFloatingGardenFeature;
import net.mcreator.ethernalkronuz.world.features.TheRiseChamberRedFeature;
import net.mcreator.ethernalkronuz.world.features.TheRiseChamberPurpleFeature;
import net.mcreator.ethernalkronuz.world.features.TheRiseChamberGreenFeature;
import net.mcreator.ethernalkronuz.world.features.TaigaFeature;
import net.mcreator.ethernalkronuz.world.features.SnowFeature;
import net.mcreator.ethernalkronuz.world.features.SavanhaFeature;
import net.mcreator.ethernalkronuz.world.features.PlainsFeature;
import net.mcreator.ethernalkronuz.world.features.OceanFeature;
import net.mcreator.ethernalkronuz.world.features.JungleFeature;
import net.mcreator.ethernalkronuz.world.features.ForestFeature;
import net.mcreator.ethernalkronuz.world.features.EndruinssmallFeature;
import net.mcreator.ethernalkronuz.world.features.EndruinsmediumFeature;
import net.mcreator.ethernalkronuz.world.features.EndruinslargeFeature;
import net.mcreator.ethernalkronuz.world.features.DivinecrystalspikesmallFeature;
import net.mcreator.ethernalkronuz.world.features.DivinecrystalspikemediumFeature;
import net.mcreator.ethernalkronuz.world.features.DivinecrystalspikelargeFeature;
import net.mcreator.ethernalkronuz.world.features.DivinecrystalspikegiantFeature;
import net.mcreator.ethernalkronuz.world.features.DivinecrystalspikeextralargeFeature;
import net.mcreator.ethernalkronuz.world.features.DivinecrystalpillarsmallFeature;
import net.mcreator.ethernalkronuz.world.features.DivinecrystalpillarmediumFeature;
import net.mcreator.ethernalkronuz.world.features.DivinecrystalpillarlargeFeature;
import net.mcreator.ethernalkronuz.world.features.DivinecrystalpillargiantFeature;
import net.mcreator.ethernalkronuz.world.features.DivinecrystalpillarextralargeFeature;
import net.mcreator.ethernalkronuz.world.features.DesertFeature;
import net.mcreator.ethernalkronuz.world.features.BichFeature;
import net.mcreator.ethernalkronuz.world.features.AsgardTempleEntryFeature;
import net.mcreator.ethernalkronuz.world.features.AfterRagnarokTempleFeature;
import net.mcreator.ethernalkronuz.world.features.AesirPortalStructureFeature;
import net.mcreator.ethernalkronuz.EthernalKronuzMod;

import java.util.function.Supplier;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class EthernalKronuzModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, EthernalKronuzMod.MODID);
	private static final List<FeatureRegistration> FEATURE_REGISTRATIONS = new ArrayList<>();
	public static final RegistryObject<Feature<?>> MOSSO_CRYSTAL_ORE = register("mosso_crystal_ore", MossoCrystalOreFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, MossoCrystalOreFeature.GENERATE_BIOMES, MossoCrystalOreFeature::placedFeature));
	public static final RegistryObject<Feature<?>> FAKING_ELL_ORE = register("faking_ell_ore", FakingEllOreFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, FakingEllOreFeature.GENERATE_BIOMES, FakingEllOreFeature::placedFeature));
	public static final RegistryObject<Feature<?>> HEAVEN_SLATE = register("heaven_slate", HeavenSlateFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, HeavenSlateFeature.GENERATE_BIOMES, HeavenSlateFeature::placedFeature));
	public static final RegistryObject<Feature<?>> BIO_LUMINESCENT_LILY = register("bio_luminescent_lily", BioLuminescentLilyFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION, BioLuminescentLilyFeature.GENERATE_BIOMES, BioLuminescentLilyFeature::placedFeature));
	public static final RegistryObject<Feature<?>> GLOW_PLANT = register("glow_plant", GlowPlantFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION, GlowPlantFeature.GENERATE_BIOMES, GlowPlantFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DOUBLE_GLOW_PLANT = register("double_glow_plant", DoubleGlowPlantFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION, DoubleGlowPlantFeature.GENERATE_BIOMES, DoubleGlowPlantFeature::placedFeature));
	public static final RegistryObject<Feature<?>> TALL_GLOW_GRASS = register("tall_glow_grass", TallGlowGrassFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION, TallGlowGrassFeature.GENERATE_BIOMES, TallGlowGrassFeature::placedFeature));
	public static final RegistryObject<Feature<?>> NORMAL_GLOW_GRASS = register("normal_glow_grass", NormalGlowGrassFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.VEGETAL_DECORATION, NormalGlowGrassFeature.GENERATE_BIOMES, NormalGlowGrassFeature::placedFeature));
	public static final RegistryObject<Feature<?>> AESIR_PORTAL_STRUCTURE = register("aesir_portal_structure", AesirPortalStructureFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.RAW_GENERATION, AesirPortalStructureFeature.GENERATE_BIOMES, AesirPortalStructureFeature::placedFeature));
	public static final RegistryObject<Feature<?>> BICH = register("bich", BichFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, BichFeature.GENERATE_BIOMES, BichFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DESERT = register("desert", DesertFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DesertFeature.GENERATE_BIOMES, DesertFeature::placedFeature));
	public static final RegistryObject<Feature<?>> FOREST = register("forest", ForestFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, ForestFeature.GENERATE_BIOMES, ForestFeature::placedFeature));
	public static final RegistryObject<Feature<?>> JUNGLE = register("jungle", JungleFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, JungleFeature.GENERATE_BIOMES, JungleFeature::placedFeature));
	public static final RegistryObject<Feature<?>> PLAINS = register("plains", PlainsFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, PlainsFeature.GENERATE_BIOMES, PlainsFeature::placedFeature));
	public static final RegistryObject<Feature<?>> SAVANHA = register("savanha", SavanhaFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, SavanhaFeature.GENERATE_BIOMES, SavanhaFeature::placedFeature));
	public static final RegistryObject<Feature<?>> SNOW = register("snow", SnowFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, SnowFeature.GENERATE_BIOMES, SnowFeature::placedFeature));
	public static final RegistryObject<Feature<?>> TAIGA = register("taiga", TaigaFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, TaigaFeature.GENERATE_BIOMES, TaigaFeature::placedFeature));
	public static final RegistryObject<Feature<?>> OCEAN = register("ocean", OceanFeature::feature, new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, OceanFeature.GENERATE_BIOMES, OceanFeature::placedFeature));
	public static final RegistryObject<Feature<?>> ASGARD_TEMPLE_ENTRY = register("asgard_temple_entry", AsgardTempleEntryFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, AsgardTempleEntryFeature.GENERATE_BIOMES, AsgardTempleEntryFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DIVINECRYSTALPILLAREXTRALARGE = register("divinecrystalpillarextralarge", DivinecrystalpillarextralargeFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DivinecrystalpillarextralargeFeature.GENERATE_BIOMES, DivinecrystalpillarextralargeFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DIVINECRYSTALPILLARMEDIUM = register("divinecrystalpillarmedium", DivinecrystalpillarmediumFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DivinecrystalpillarmediumFeature.GENERATE_BIOMES, DivinecrystalpillarmediumFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DIVINECRYSTALPILLARSMALL = register("divinecrystalpillarsmall", DivinecrystalpillarsmallFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DivinecrystalpillarsmallFeature.GENERATE_BIOMES, DivinecrystalpillarsmallFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DIVINECRYSTALSPIKEEXTRALARGE = register("divinecrystalspikeextralarge", DivinecrystalspikeextralargeFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DivinecrystalspikeextralargeFeature.GENERATE_BIOMES, DivinecrystalspikeextralargeFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DIVINECRYSTALSPIKELARGE = register("divinecrystalspikelarge", DivinecrystalspikelargeFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DivinecrystalspikelargeFeature.GENERATE_BIOMES, DivinecrystalspikelargeFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DIVINECRYSTALSPIKEMEDIUM = register("divinecrystalspikemedium", DivinecrystalspikemediumFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DivinecrystalspikemediumFeature.GENERATE_BIOMES, DivinecrystalspikemediumFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DIVINECRYSTALSPIKESMALL = register("divinecrystalspikesmall", DivinecrystalspikesmallFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DivinecrystalspikesmallFeature.GENERATE_BIOMES, DivinecrystalspikesmallFeature::placedFeature));
	public static final RegistryObject<Feature<?>> YGGBIGBUSH_SKY_FIELDS = register("yggbigbush_sky_fields", YggbigbushSkyFieldsFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, YggbigbushSkyFieldsFeature.GENERATE_BIOMES, YggbigbushSkyFieldsFeature::placedFeature));
	public static final RegistryObject<Feature<?>> YGGBIGBUSH_FLOATING_GARDEN = register("yggbigbush_floating_garden", YggbigbushFloatingGardenFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, YggbigbushFloatingGardenFeature.GENERATE_BIOMES, YggbigbushFloatingGardenFeature::placedFeature));
	public static final RegistryObject<Feature<?>> YGGBIGTREE_SKY_FIELDS = register("yggbigtree_sky_fields", YggbigtreeSkyFieldsFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, YggbigtreeSkyFieldsFeature.GENERATE_BIOMES, YggbigtreeSkyFieldsFeature::placedFeature));
	public static final RegistryObject<Feature<?>> YGGBIGTREE_FLOATING_GARDEN = register("yggbigtree_floating_garden", YggbigtreeFloatingGardenFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, YggbigtreeFloatingGardenFeature.GENERATE_BIOMES, YggbigtreeFloatingGardenFeature::placedFeature));
	public static final RegistryObject<Feature<?>> YGGMEDIUMTREE_SKY_FIELD = register("yggmediumtree_sky_field", YggmediumtreeSkyFieldFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, YggmediumtreeSkyFieldFeature.GENERATE_BIOMES, YggmediumtreeSkyFieldFeature::placedFeature));
	public static final RegistryObject<Feature<?>> YGGMEDIUMTREE_FLOATING_GARDEN = register("yggmediumtree_floating_garden", YggmediumtreeFloatingGardenFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, YggmediumtreeFloatingGardenFeature.GENERATE_BIOMES, YggmediumtreeFloatingGardenFeature::placedFeature));
	public static final RegistryObject<Feature<?>> YGGSMALLBUSH_SKY_FIELDS = register("yggsmallbush_sky_fields", YggsmallbushSkyFieldsFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, YggsmallbushSkyFieldsFeature.GENERATE_BIOMES, YggsmallbushSkyFieldsFeature::placedFeature));
	public static final RegistryObject<Feature<?>> YGGSMALLBUSH_FLOATING_GARDEN = register("yggsmallbush_floating_garden", YggsmallbushFloatingGardenFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, YggsmallbushFloatingGardenFeature.GENERATE_BIOMES, YggsmallbushFloatingGardenFeature::placedFeature));
	public static final RegistryObject<Feature<?>> YGGSMALLTREE_SKY_FIELDS = register("yggsmalltree_sky_fields", YggsmalltreeSkyFieldsFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, YggsmalltreeSkyFieldsFeature.GENERATE_BIOMES, YggsmalltreeSkyFieldsFeature::placedFeature));
	public static final RegistryObject<Feature<?>> YGGSMALLTREE_FLOATING_GARDEN = register("yggsmalltree_floating_garden", YggsmalltreeFloatingGardenFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, YggsmalltreeFloatingGardenFeature.GENERATE_BIOMES, YggsmalltreeFloatingGardenFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DIVINECRYSTALPILLARGIANT = register("divinecrystalpillargiant", DivinecrystalpillargiantFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DivinecrystalpillargiantFeature.GENERATE_BIOMES, DivinecrystalpillargiantFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DIVINECRYSTALSPIKEGIANT = register("divinecrystalspikegiant", DivinecrystalspikegiantFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DivinecrystalspikegiantFeature.GENERATE_BIOMES, DivinecrystalspikegiantFeature::placedFeature));
	public static final RegistryObject<Feature<?>> YGGDRASILGIANTSTRUCTVOIDS = register("yggdrasilgiantstructvoids", YggdrasilgiantstructvoidsFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, YggdrasilgiantstructvoidsFeature.GENERATE_BIOMES, YggdrasilgiantstructvoidsFeature::placedFeature));
	public static final RegistryObject<Feature<?>> ENDRUINSLARGE = register("endruinslarge", EndruinslargeFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, EndruinslargeFeature.GENERATE_BIOMES, EndruinslargeFeature::placedFeature));
	public static final RegistryObject<Feature<?>> ENDRUINSMEDIUM = register("endruinsmedium", EndruinsmediumFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, EndruinsmediumFeature.GENERATE_BIOMES, EndruinsmediumFeature::placedFeature));
	public static final RegistryObject<Feature<?>> ENDRUINSSMALL = register("endruinssmall", EndruinssmallFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, EndruinssmallFeature.GENERATE_BIOMES, EndruinssmallFeature::placedFeature));
	public static final RegistryObject<Feature<?>> DIVINECRYSTALPILLARLARGE = register("divinecrystalpillarlarge", DivinecrystalpillarlargeFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, DivinecrystalpillarlargeFeature.GENERATE_BIOMES, DivinecrystalpillarlargeFeature::placedFeature));
	public static final RegistryObject<Feature<?>> THE_RISE_CHAMBER_GREEN = register("the_rise_chamber_green", TheRiseChamberGreenFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, TheRiseChamberGreenFeature.GENERATE_BIOMES, TheRiseChamberGreenFeature::placedFeature));
	public static final RegistryObject<Feature<?>> THE_RISE_CHAMBER_RED = register("the_rise_chamber_red", TheRiseChamberRedFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, TheRiseChamberRedFeature.GENERATE_BIOMES, TheRiseChamberRedFeature::placedFeature));
	public static final RegistryObject<Feature<?>> THE_RISE_CHAMBER_PURPLE = register("the_rise_chamber_purple", TheRiseChamberPurpleFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, TheRiseChamberPurpleFeature.GENERATE_BIOMES, TheRiseChamberPurpleFeature::placedFeature));
	public static final RegistryObject<Feature<?>> AFTER_RAGNAROK_TEMPLE = register("after_ragnarok_temple", AfterRagnarokTempleFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.SURFACE_STRUCTURES, AfterRagnarokTempleFeature.GENERATE_BIOMES, AfterRagnarokTempleFeature::placedFeature));

	private static RegistryObject<Feature<?>> register(String registryname, Supplier<Feature<?>> feature, FeatureRegistration featureRegistration) {
		FEATURE_REGISTRATIONS.add(featureRegistration);
		return REGISTRY.register(registryname, feature);
	}

	@SubscribeEvent
	public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
		for (FeatureRegistration registration : FEATURE_REGISTRATIONS) {
			if (registration.biomes() == null || registration.biomes().contains(event.getName()))
				event.getGeneration().getFeatures(registration.stage()).add(registration.placedFeature().get());
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes, Supplier<Holder<PlacedFeature>> placedFeature) {
	}
}
