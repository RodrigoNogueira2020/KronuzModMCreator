
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ethernalkronuz.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.ethernalkronuz.EthernalKronuzMod;

public class EthernalKronuzModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, EthernalKronuzMod.MODID);
	public static final RegistryObject<ParticleType<?>> END_PARTICLES = REGISTRY.register("end_particles", () -> new SimpleParticleType(true));
	public static final RegistryObject<ParticleType<?>> HELL_PARTICLE = REGISTRY.register("hell_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<ParticleType<?>> GLOW_PLANT_SPORES = REGISTRY.register("glow_plant_spores", () -> new SimpleParticleType(true));
	public static final RegistryObject<ParticleType<?>> JOTUNHEIMPORTALPARTICLES = REGISTRY.register("jotunheimportalparticles", () -> new SimpleParticleType(false));
	public static final RegistryObject<ParticleType<?>> ASGARD_PORTAL_PARTICLES = REGISTRY.register("asgard_portal_particles", () -> new SimpleParticleType(false));
	public static final RegistryObject<ParticleType<?>> ASGARD_PARTICLE = REGISTRY.register("asgard_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<ParticleType<?>> TERRA_BLADE_PARTICLE = REGISTRY.register("terra_blade_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<ParticleType<?>> BLADE_OF_THE_VOID_PARTICLE = REGISTRY.register("blade_of_the_void_particle", () -> new SimpleParticleType(true));
	public static final RegistryObject<ParticleType<?>> MURASAMA_DASH_PARTICLE = REGISTRY.register("murasama_dash_particle", () -> new SimpleParticleType(true));
}
