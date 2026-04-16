package net.mcreator.ethernalkronuz.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.ethernalkronuz.entity.ThorEntity;

public class ThorModel extends AnimatedGeoModel<ThorEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(ThorEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "animations/radiantlordanimated.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(ThorEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "geo/radiantlordanimated.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(ThorEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "textures/entities/" + entity.getTexture() + ".png");
	}

}
