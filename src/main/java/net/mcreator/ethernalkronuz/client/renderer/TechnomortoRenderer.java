
package net.mcreator.ethernalkronuz.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.ethernalkronuz.entity.TechnomortoEntity;
import net.mcreator.ethernalkronuz.client.model.Modelundead_technoblade;

public class TechnomortoRenderer extends MobRenderer<TechnomortoEntity, Modelundead_technoblade<TechnomortoEntity>> {
	public TechnomortoRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelundead_technoblade(context.bakeLayer(Modelundead_technoblade.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(TechnomortoEntity entity) {
		return new ResourceLocation("ethernal_kronuz:textures/entities/undead_technoblade.png");
	}
}
