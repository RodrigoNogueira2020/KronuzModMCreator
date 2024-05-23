
package net.mcreator.ethernalkronuz.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.ethernalkronuz.entity.TechnobaldeEntity;
import net.mcreator.ethernalkronuz.client.model.Modeltechnoblade;

public class TechnobaldeRenderer extends MobRenderer<TechnobaldeEntity, Modeltechnoblade<TechnobaldeEntity>> {
	public TechnobaldeRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltechnoblade(context.bakeLayer(Modeltechnoblade.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TechnobaldeEntity entity) {
		return new ResourceLocation("ethernal_kronuz:textures/entities/technoblade.png");
	}
}
