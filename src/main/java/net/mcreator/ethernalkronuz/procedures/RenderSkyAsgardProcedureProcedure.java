package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.Registry;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Camera;

import javax.annotation.Nullable;

import com.mojang.math.Vector3f;
import com.mojang.math.Matrix4f;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.BufferUploader;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.systems.RenderSystem;

@Mod.EventBusSubscriber(value = {Dist.CLIENT})
public class RenderSkyAsgardProcedureProcedure {
	@SubscribeEvent
	public static void renderSky(TickEvent.RenderTickEvent event) {
		try {
			boolean renderable = Minecraft.getInstance().level != null && Minecraft.getInstance().getCameraEntity() != null;
			if (event.phase == TickEvent.Phase.START && renderable) {
				Minecraft.getInstance().level.effects().setSkyRenderHandler((int ticks, float partialTick, PoseStack poseStack, ClientLevel clientLevel, Minecraft minecraft) -> {
					DimensionSpecialEffects dimensionSpecialEffects = clientLevel.effects();
					GameRenderer gameRenderer = minecraft.gameRenderer;
					Camera camera = gameRenderer.getMainCamera();
					Entity entity = minecraft.getCameraEntity();
					Vec3 cameraPos = camera.getPosition();
					Vec3 entityPos = entity.getPosition(partialTick);
					float renderDistance = gameRenderer.getRenderDistance();
					boolean isFoggy = dimensionSpecialEffects.isFoggyAt(Mth.floor(cameraPos.x()), Mth.floor(cameraPos.y())) || minecraft.gui.getBossOverlay().shouldCreateWorldFog();
					dimensionSpecialEffects.setSkyRenderHandler(null);
					minecraft.levelRenderer.renderSky(poseStack, RenderSystem.getProjectionMatrix(), partialTick, camera, isFoggy, () -> {
						FogRenderer.setupFog(camera, FogRenderer.FogMode.FOG_SKY, renderDistance, isFoggy);
					});
					RenderSystem.depthMask(false);
					RenderSystem.enableBlend();
					RenderSystem.defaultBlendFunc();
					RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
					RenderSystem.setShaderTexture(0, new ResourceLocation("minecraft", "textures/block/grass_block_side.png"));
					poseStack.pushPose();
					execute(null, clientLevel, entity, poseStack);
					poseStack.popPose();
					RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
					RenderSystem.disableBlend();
					RenderSystem.enableCull();
					RenderSystem.enableDepthTest();
					RenderSystem.depthMask(true);
				});
			}
		} catch (Exception e) {
		}
	}

	public static void execute(LevelAccessor world, Entity entity, PoseStack pose) {
		execute(null, world, entity, pose);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, PoseStack pose) {
		if (entity == null || pose == null)
			return;
		if ((entity.level.dimension()) == (ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("ethernal_kronuz:asgard")))) {
			RenderSystem.setShaderTexture(0, new ResourceLocation(("ethernal_kronuz" + ":textures/" + "aesir_sky_concept1" + ".png")));
			if (world instanceof ClientLevel _clientLevel) {
				boolean _b0 = true;
				if (_b0) {
					RenderSystem.enableTexture();
					RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
					BufferBuilder _bufferBuilder = Tesselator.getInstance().getBuilder();
					_bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
					pose.popPose();
					pose.pushPose();
					float _u0 = 0.0F;
					float _v0 = 0.0F;
					float _u1 = 1.0F;
					float _v1 = 1.0F;
					for (int _i = 0; _i < 6; ++_i) {
						if (_i == 0)
							pose.mulPose(Vector3f.YP.rotationDegrees(180.0F));
						else if (_i == 1)
							pose.mulPose(Vector3f.XP.rotationDegrees(180.0F));
						else if (_i == 2) {
							pose.mulPose(Vector3f.YP.rotationDegrees(-180.0F));
							pose.mulPose(Vector3f.XP.rotationDegrees(-90.0F));
						} else if (_i == 3)
							pose.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
						else if (_i == 4)
							pose.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
						else if (_i == 5)
							pose.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
						Matrix4f _matrix4f = pose.last().pose();
						_bufferBuilder.vertex(_matrix4f, -100.0F, -100.0F, -100.0F).uv(_u0, _v0).color(255, 255, 255, 255).endVertex();
						_bufferBuilder.vertex(_matrix4f, -100.0F, -100.0F, 100.0F).uv(_u0, _v1).color(255, 255, 255, 255).endVertex();
						_bufferBuilder.vertex(_matrix4f, 100.0F, -100.0F, 100.0F).uv(_u1, _v1).color(255, 255, 255, 255).endVertex();
						_bufferBuilder.vertex(_matrix4f, 100.0F, -100.0F, -100.0F).uv(_u1, _v0).color(255, 255, 255, 255).endVertex();
					}
					_bufferBuilder.end();
					BufferUploader.end(_bufferBuilder);
					pose.popPose();
					pose.pushPose();
				}
			}
			RenderSystem.setShaderTexture(0, new ResourceLocation(("ethernal_kronuz" + ":textures/" + "blue_planet" + ".png")));
			if (world instanceof ClientLevel _clientLevel) {
				RenderSystem.enableTexture();
				RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
				BufferBuilder _bufferBuilder = Tesselator.getInstance().getBuilder();
				_bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
				Matrix4f _matrix4f = pose.last().pose();
				float _size = 30;
				int _alpha = 255;
				_bufferBuilder.vertex(_matrix4f, _size, _size, 100.0F).uv(0.0F, 0.0F).color(255, 255, 255, _alpha).endVertex();
				_bufferBuilder.vertex(_matrix4f, _size, -_size, 100.0F).uv(0.0F, 1.0F).color(255, 255, 255, _alpha).endVertex();
				_bufferBuilder.vertex(_matrix4f, -_size, -_size, 100.0F).uv(1.0F, 1.0F).color(255, 255, 255, _alpha).endVertex();
				_bufferBuilder.vertex(_matrix4f, -_size, _size, 100.0F).uv(1.0F, 0.0F).color(255, 255, 255, _alpha).endVertex();
				_bufferBuilder.end();
				BufferUploader.end(_bufferBuilder);
			}
			RenderSystem.setShaderTexture(0, new ResourceLocation(("ethernal_kronuz" + ":textures/" + "red_planet" + ".png")));
			if (world instanceof ClientLevel _clientLevel) {
				RenderSystem.enableTexture();
				RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
				BufferBuilder _bufferBuilder = Tesselator.getInstance().getBuilder();
				_bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX_COLOR);
				Matrix4f _matrix4f = pose.last().pose();
				float _size = 30;
				int _alpha = 255;
				_bufferBuilder.vertex(_matrix4f, _size, _size, 50.0F).uv(0.0F, 0.0F).color(255, 255, 255, _alpha).endVertex();
				_bufferBuilder.vertex(_matrix4f, _size, -_size, 50.0F).uv(0.0F, 1.0F).color(255, 255, 255, _alpha).endVertex();
				_bufferBuilder.vertex(_matrix4f, -_size, -_size, 100.0F).uv(1.0F, 1.0F).color(255, 255, 255, _alpha).endVertex();
				_bufferBuilder.vertex(_matrix4f, -_size, _size, 100.0F).uv(1.0F, 0.0F).color(255, 255, 255, _alpha).endVertex();
				_bufferBuilder.end();
				BufferUploader.end(_bufferBuilder);
			}
		}
	}
}
