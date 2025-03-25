package net.mcreator.ethernalkronuz.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.ethernalkronuz.entity.RadiantLordNoColorTrialEntity;

public class RadiantLordNoColorTrialModel extends AnimatedGeoModel<RadiantLordNoColorTrialEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(RadiantLordNoColorTrialEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "animations/radiantlordanimated.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(RadiantLordNoColorTrialEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "geo/radiantlordanimated.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(RadiantLordNoColorTrialEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "textures/entities/" + entity.getTexture() + ".png");
	}

}
