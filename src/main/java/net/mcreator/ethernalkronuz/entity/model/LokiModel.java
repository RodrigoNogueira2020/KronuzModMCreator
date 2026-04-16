package net.mcreator.ethernalkronuz.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.ethernalkronuz.entity.LokiEntity;

public class LokiModel extends AnimatedGeoModel<LokiEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(LokiEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "animations/radiantlordanimated.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(LokiEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "geo/radiantlordanimated.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(LokiEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "textures/entities/" + entity.getTexture() + ".png");
	}

}
