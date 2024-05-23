package net.mcreator.ethernalkronuz.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.ethernalkronuz.entity.WarperEntity;

public class WarperModel extends AnimatedGeoModel<WarperEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(WarperEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "animations/warper.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(WarperEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "geo/warper.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(WarperEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "textures/entities/" + entity.getTexture() + ".png");
	}

}
