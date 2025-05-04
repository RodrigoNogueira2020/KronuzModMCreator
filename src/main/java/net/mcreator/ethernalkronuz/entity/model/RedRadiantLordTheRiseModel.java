package net.mcreator.ethernalkronuz.entity.model;

import software.bernie.geckolib3.model.provider.data.EntityModelData;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.ethernalkronuz.entity.RedRadiantLordTheRiseEntity;

public class RedRadiantLordTheRiseModel extends AnimatedGeoModel<RedRadiantLordTheRiseEntity> {
	@Override
	public ResourceLocation getAnimationFileLocation(RedRadiantLordTheRiseEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "animations/redradiantlord.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(RedRadiantLordTheRiseEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "geo/redradiantlord.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(RedRadiantLordTheRiseEntity entity) {
		return new ResourceLocation("ethernal_kronuz", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(RedRadiantLordTheRiseEntity animatable, int instanceId, AnimationEvent animationEvent) {
		super.setCustomAnimations(animatable, instanceId, animationEvent);
		IBone head = this.getAnimationProcessor().getBone("head");
		EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
		AnimationData manager = animatable.getFactory().getOrCreateAnimationData(instanceId);
		int unpausedMultiplier = !Minecraft.getInstance().isPaused() || manager.shouldPlayWhilePaused ? 1 : 0;
		head.setRotationX(head.getRotationX() + extraData.headPitch * ((float) Math.PI / 180F) * unpausedMultiplier);
		head.setRotationY(head.getRotationY() + extraData.netHeadYaw * ((float) Math.PI / 180F) * unpausedMultiplier);
	}
}
