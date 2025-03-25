package net.mcreator.ethernalkronuz.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.ethernalkronuz.entity.RadiantLordGreenTrialEntity;

public class RadiantLordGreenTrialModel extends AnimatedGeoModel<RadiantLordGreenTrialEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(RadiantLordGreenTrialEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "animations/radiantlordanimated.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(RadiantLordGreenTrialEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "geo/radiantlordanimated.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(RadiantLordGreenTrialEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "textures/entities/" + entity.getTexture() + ".png");
	}

}
