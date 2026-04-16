package net.mcreator.ethernalkronuz.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.ethernalkronuz.entity.OdinEntity;

public class OdinModel extends AnimatedGeoModel<OdinEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(OdinEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "animations/radiantlordanimated.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(OdinEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "geo/radiantlordanimated.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(OdinEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "textures/entities/" + entity.getTexture() + ".png");
	}

}
