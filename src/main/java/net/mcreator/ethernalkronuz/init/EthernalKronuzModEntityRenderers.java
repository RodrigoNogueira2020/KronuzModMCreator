
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ethernalkronuz.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.ethernalkronuz.client.renderer.WarperRenderer;
import net.mcreator.ethernalkronuz.client.renderer.TerraBladeProjectileRenderer;
import net.mcreator.ethernalkronuz.client.renderer.TechnomortoRenderer;
import net.mcreator.ethernalkronuz.client.renderer.TechnobaldeRenderer;
import net.mcreator.ethernalkronuz.client.renderer.RedRadiantLordTheRiseRenderer;
import net.mcreator.ethernalkronuz.client.renderer.RadiantLordNoColorTrialRenderer;
import net.mcreator.ethernalkronuz.client.renderer.RadiantLordGreenTrialRenderer;
import net.mcreator.ethernalkronuz.client.renderer.PurpleRadiantLordTheRiseRenderer;
import net.mcreator.ethernalkronuz.client.renderer.NullEntityRenderer;
import net.mcreator.ethernalkronuz.client.renderer.GriffinAnimatedRenderer;
import net.mcreator.ethernalkronuz.client.renderer.GinukaPowerSetupRenderer;
import net.mcreator.ethernalkronuz.client.renderer.BlessingRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EthernalKronuzModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EthernalKronuzModEntities.WARPER.get(), WarperRenderer::new);
		event.registerEntityRenderer(EthernalKronuzModEntities.GINUKA_POWER_SETUP.get(), GinukaPowerSetupRenderer::new);
		event.registerEntityRenderer(EthernalKronuzModEntities.TECHNOMORTO.get(), TechnomortoRenderer::new);
		event.registerEntityRenderer(EthernalKronuzModEntities.TECHNOBALDE.get(), TechnobaldeRenderer::new);
		event.registerEntityRenderer(EthernalKronuzModEntities.NULL_ENTITY.get(), NullEntityRenderer::new);
		event.registerEntityRenderer(EthernalKronuzModEntities.BLESSING.get(), BlessingRenderer::new);
		event.registerEntityRenderer(EthernalKronuzModEntities.GRIFFIN_ANIMATED.get(), GriffinAnimatedRenderer::new);
		event.registerEntityRenderer(EthernalKronuzModEntities.DIVINE_BOW.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(EthernalKronuzModEntities.TERRA_BLADE_PROJECTILE.get(), TerraBladeProjectileRenderer::new);
		event.registerEntityRenderer(EthernalKronuzModEntities.RADIANT_LORD_NO_COLOR_TRIAL.get(), RadiantLordNoColorTrialRenderer::new);
		event.registerEntityRenderer(EthernalKronuzModEntities.RADIANT_LORD_GREEN_TRIAL.get(), RadiantLordGreenTrialRenderer::new);
		event.registerEntityRenderer(EthernalKronuzModEntities.RED_RADIANT_LORD_THE_RISE.get(), RedRadiantLordTheRiseRenderer::new);
		event.registerEntityRenderer(EthernalKronuzModEntities.PURPLE_RADIANT_LORD_THE_RISE.get(), PurpleRadiantLordTheRiseRenderer::new);
	}
}
