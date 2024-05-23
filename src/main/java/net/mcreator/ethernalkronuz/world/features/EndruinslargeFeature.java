
package net.mcreator.ethernalkronuz.world.features;

import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockIgnoreProcessor;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;
import net.minecraft.core.BlockPos;

import net.mcreator.ethernalkronuz.procedures.EndruinslargeAdditionalGenerationConditionProcedure;

import java.util.Set;
import java.util.List;

public class EndruinslargeFeature extends Feature<NoneFeatureConfiguration> {
	public static EndruinslargeFeature FEATURE = null;
	public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new EndruinslargeFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("ethernal_kronuz:endruinslarge", FEATURE, FeatureConfiguration.NONE);
		PLACED_FEATURE = PlacementUtils.register("ethernal_kronuz:endruinslarge", CONFIGURED_FEATURE, List.of());
		return FEATURE;
	}

	public static Holder<PlacedFeature> placedFeature() {
		return PLACED_FEATURE;
	}

	public static final Set<ResourceLocation> GENERATE_BIOMES = Set.of(new ResourceLocation("warm_ocean"), new ResourceLocation("mushroom_fields"), new ResourceLocation("sunflower_plains"), new ResourceLocation("flower_forest"),
			new ResourceLocation("lush_caves"), new ResourceLocation("cold_ocean"), new ResourceLocation("ice_spikes"), new ResourceLocation("lukewarm_ocean"), new ResourceLocation("dark_forest"), new ResourceLocation("savanna"),
			new ResourceLocation("stony_peaks"), new ResourceLocation("snowy_beach"), new ResourceLocation("frozen_ocean"), new ResourceLocation("savanna_plateau"), new ResourceLocation("ethernal_kronuz:floating_garden"),
			new ResourceLocation("dripstone_caves"), new ResourceLocation("snowy_plains"), new ResourceLocation("jagged_peaks"), new ResourceLocation("eroded_badlands"), new ResourceLocation("ethernal_kronuz:plains_jotunheim"),
			new ResourceLocation("ethernal_kronuz:crystal_pillars"), new ResourceLocation("badlands"), new ResourceLocation("windswept_hills"), new ResourceLocation("ocean"), new ResourceLocation("wooded_badlands"),
			new ResourceLocation("windswept_savanna"), new ResourceLocation("jungle"), new ResourceLocation("warped_forest"), new ResourceLocation("frozen_river"), new ResourceLocation("forest"), new ResourceLocation("stony_shore"),
			new ResourceLocation("sparse_jungle"), new ResourceLocation("birch_forest"), new ResourceLocation("deep_lukewarm_ocean"), new ResourceLocation("snowy_slopes"), new ResourceLocation("deep_ocean"),
			new ResourceLocation("ethernal_kronuz:stone_spikes"), new ResourceLocation("deep_frozen_ocean"), new ResourceLocation("nether_wastes"), new ResourceLocation("bamboo_jungle"), new ResourceLocation("soul_sand_valley"),
			new ResourceLocation("small_end_islands"), new ResourceLocation("plains"), new ResourceLocation("frozen_peaks"), new ResourceLocation("end_highlands"), new ResourceLocation("meadow"), new ResourceLocation("end_barrens"),
			new ResourceLocation("old_growth_spruce_taiga"), new ResourceLocation("basalt_deltas"), new ResourceLocation("taiga"), new ResourceLocation("crimson_forest"), new ResourceLocation("snowy_taiga"), new ResourceLocation("swamp"),
			new ResourceLocation("deep_cold_ocean"), new ResourceLocation("old_growth_birch_forest"), new ResourceLocation("grove"), new ResourceLocation("ethernal_kronuz:sky_fields"), new ResourceLocation("old_growth_pine_taiga"),
			new ResourceLocation("beach"), new ResourceLocation("windswept_forest"), new ResourceLocation("windswept_gravelly_hills"), new ResourceLocation("river"), new ResourceLocation("desert"));
	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.END, ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("ethernal_kronuz:asgard")));
	private StructureTemplate template = null;

	public EndruinslargeFeature() {
		super(NoneFeatureConfiguration.CODEC);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		if (!generate_dimensions.contains(context.level().getLevel().dimension()))
			return false;
		if (template == null)
			template = context.level().getLevel().getStructureManager().getOrCreate(new ResourceLocation("ethernal_kronuz", "end_ruins_large"));
		if (template == null)
			return false;
		boolean anyPlaced = false;
		if ((context.random().nextInt(1000000) + 1) <= 5000) {
			int count = context.random().nextInt(1) + 1;
			for (int a = 0; a < count; a++) {
				int i = context.origin().getX() + context.random().nextInt(16);
				int k = context.origin().getZ() + context.random().nextInt(16);
				int j = context.level().getHeight(Heightmap.Types.OCEAN_FLOOR_WG, i, k) - 1;
				BlockPos spawnTo = new BlockPos(i + 0, j + -3, k + 0);
				WorldGenLevel world = context.level();
				int x = spawnTo.getX();
				int y = spawnTo.getY();
				int z = spawnTo.getZ();
				if (!EndruinslargeAdditionalGenerationConditionProcedure.execute(world, x, y, z))
					continue;
				if (template.placeInWorld(context.level(), spawnTo, spawnTo, new StructurePlaceSettings().setMirror(Mirror.values()[context.random().nextInt(2)]).setRotation(Rotation.values()[context.random().nextInt(3)]).setRandom(context.random())
						.addProcessor(BlockIgnoreProcessor.STRUCTURE_BLOCK).setIgnoreEntities(false), context.random(), 2)) {
					anyPlaced = true;
				}
			}
		}
		return anyPlaced;
	}
}
