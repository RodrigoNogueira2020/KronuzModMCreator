package net.mcreator.ethernalkronuz.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.ethernalkronuz.entity.SkullDamnationEntity;

public class SkullDamnationModel extends AnimatedGeoModel<SkullDamnationEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(SkullDamnationEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "animations/skulldamnation.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(SkullDamnationEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "geo/skulldamnation.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(SkullDamnationEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "textures/entities/" + entity.getTexture() + ".png");
	}

}
