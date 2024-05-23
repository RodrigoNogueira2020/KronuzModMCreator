package net.mcreator.ethernalkronuz.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.ethernalkronuz.entity.GriffinAnimatedEntity;

public class GriffinAnimatedModel extends AnimatedGeoModel<GriffinAnimatedEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(GriffinAnimatedEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "animations/griffin.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(GriffinAnimatedEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "geo/griffin.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(GriffinAnimatedEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "textures/entities/" + entity.getTexture() + ".png");
	}

}
