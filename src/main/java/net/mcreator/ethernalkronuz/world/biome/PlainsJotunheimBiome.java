
package net.mcreator.ethernalkronuz.world.biome;

import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.core.particles.ParticleTypes;

public class PlainsJotunheimBiome {
	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-5511177).waterColor(4159204).waterFogColor(329011).skyColor(-5511177).foliageColorOverride(10387789).grassColorOverride(9470285)
				.ambientParticle(new AmbientParticleSettings(ParticleTypes.SNOWFLAKE, 0.005f)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NONE).temperature(0f).downfall(0f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build())
				.generationSettings(biomeGenerationSettings.build()).build();
	}
}
