
package net.mcreator.ethernalkronuz.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.ethernalkronuz.entity.model.GriffinAnimatedModel;
import net.mcreator.ethernalkronuz.entity.GriffinAnimatedEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class GriffinAnimatedRenderer extends GeoEntityRenderer<GriffinAnimatedEntity> {
	public GriffinAnimatedRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new GriffinAnimatedModel());
		this.shadowRadius = 1f;
	}

	@Override
	public RenderType getRenderType(GriffinAnimatedEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
