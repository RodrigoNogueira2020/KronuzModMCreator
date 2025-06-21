
package net.mcreator.ethernalkronuz.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.ethernalkronuz.entity.model.SkullDamnationModel;
import net.mcreator.ethernalkronuz.entity.layer.SkullDamnationLayer;
import net.mcreator.ethernalkronuz.entity.SkullDamnationEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SkullDamnationRenderer extends GeoEntityRenderer<SkullDamnationEntity> {
	public SkullDamnationRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SkullDamnationModel());
		this.shadowRadius = 0f;
		this.addLayer(new SkullDamnationLayer(this));
	}

	@Override
	public RenderType getRenderType(SkullDamnationEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(4f, 4f, 4f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
