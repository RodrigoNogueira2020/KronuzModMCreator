
package net.mcreator.ethernalkronuz.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.ethernalkronuz.entity.RadiantLordNoColorTrialEntity;
import net.mcreator.ethernalkronuz.client.model.Modelradiantlord;

public class RadiantLordNoColorTrialRenderer extends MobRenderer<RadiantLordNoColorTrialEntity, Modelradiantlord<RadiantLordNoColorTrialEntity>> {
	public RadiantLordNoColorTrialRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelradiantlord(context.bakeLayer(Modelradiantlord.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(RadiantLordNoColorTrialEntity entity) {
		return new ResourceLocation("ethernal_kronuz:textures/entities/rl_base.png");
	}
}
