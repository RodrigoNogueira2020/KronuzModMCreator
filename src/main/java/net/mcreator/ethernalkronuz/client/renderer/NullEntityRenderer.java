
package net.mcreator.ethernalkronuz.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.ethernalkronuz.entity.NullEntityEntity;
import net.mcreator.ethernalkronuz.client.model.ModelnullEntity;

public class NullEntityRenderer extends MobRenderer<NullEntityEntity, ModelnullEntity<NullEntityEntity>> {
	public NullEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelnullEntity(context.bakeLayer(ModelnullEntity.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(NullEntityEntity entity) {
		return new ResourceLocation("ethernal_kronuz:textures/entities/nullentity.png");
	}
}
