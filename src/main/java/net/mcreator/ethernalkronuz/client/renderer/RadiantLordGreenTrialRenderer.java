
package net.mcreator.ethernalkronuz.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.ethernalkronuz.entity.model.RadiantLordGreenTrialModel;
import net.mcreator.ethernalkronuz.entity.RadiantLordGreenTrialEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class RadiantLordGreenTrialRenderer extends GeoEntityRenderer<RadiantLordGreenTrialEntity> {
	public RadiantLordGreenTrialRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new RadiantLordGreenTrialModel());
		this.shadowRadius = 0.5f;
	}

	@Override
	public RenderType getRenderType(RadiantLordGreenTrialEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

	@Override
	protected float getDeathMaxRotation(RadiantLordGreenTrialEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
