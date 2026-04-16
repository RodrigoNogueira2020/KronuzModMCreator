
package net.mcreator.ethernalkronuz.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.ethernalkronuz.entity.model.OdinModel;
import net.mcreator.ethernalkronuz.entity.layer.OdinLayer;
import net.mcreator.ethernalkronuz.entity.OdinEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class OdinRenderer extends GeoEntityRenderer<OdinEntity> {
	public OdinRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new OdinModel());
		this.shadowRadius = 0.5f;
		this.addLayer(new OdinLayer(this));
	}

	@Override
	public RenderType getRenderType(OdinEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
