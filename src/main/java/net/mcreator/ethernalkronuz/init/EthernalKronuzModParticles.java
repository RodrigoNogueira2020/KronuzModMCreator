
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ethernalkronuz.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.Minecraft;

import net.mcreator.ethernalkronuz.client.particle.TerraBladeParticleParticle;
import net.mcreator.ethernalkronuz.client.particle.JotunheimportalparticlesParticle;
import net.mcreator.ethernalkronuz.client.particle.HellParticleParticle;
import net.mcreator.ethernalkronuz.client.particle.GlowPlantSporesParticle;
import net.mcreator.ethernalkronuz.client.particle.EndParticlesParticle;
import net.mcreator.ethernalkronuz.client.particle.BladeOfTheVoidParticleParticle;
import net.mcreator.ethernalkronuz.client.particle.AsgardPortalParticlesParticle;
import net.mcreator.ethernalkronuz.client.particle.AsgardParticleParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EthernalKronuzModParticles {
	@SubscribeEvent
	public static void registerParticles(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) EthernalKronuzModParticleTypes.END_PARTICLES.get(), EndParticlesParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) EthernalKronuzModParticleTypes.HELL_PARTICLE.get(), HellParticleParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) EthernalKronuzModParticleTypes.GLOW_PLANT_SPORES.get(), GlowPlantSporesParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) EthernalKronuzModParticleTypes.JOTUNHEIMPORTALPARTICLES.get(), JotunheimportalparticlesParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) EthernalKronuzModParticleTypes.ASGARD_PORTAL_PARTICLES.get(), AsgardPortalParticlesParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) EthernalKronuzModParticleTypes.ASGARD_PARTICLE.get(), AsgardParticleParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) EthernalKronuzModParticleTypes.TERRA_BLADE_PARTICLE.get(), TerraBladeParticleParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) EthernalKronuzModParticleTypes.BLADE_OF_THE_VOID_PARTICLE.get(), BladeOfTheVoidParticleParticle::provider);
	}
}
