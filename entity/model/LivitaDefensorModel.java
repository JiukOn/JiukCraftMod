package net.mcreator.jiukonmod.entity.model;

import software.bernie.geckolib3.model.provider.data.EntityModelData;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.jiukonmod.entity.LivitaDefensorEntity;

public class LivitaDefensorModel extends AnimatedGeoModel<LivitaDefensorEntity> {
	@Override
	public ResourceLocation getAnimationResource(LivitaDefensorEntity entity) {
		return new ResourceLocation("jiukcraftmod", "animations/livitadefensor.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LivitaDefensorEntity entity) {
		return new ResourceLocation("jiukcraftmod", "geo/livitadefensor.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LivitaDefensorEntity entity) {
		return new ResourceLocation("jiukcraftmod", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(LivitaDefensorEntity animatable, int instanceId, AnimationEvent animationEvent) {
		super.setCustomAnimations(animatable, instanceId, animationEvent);
		IBone head = this.getAnimationProcessor().getBone("Head");
		EntityModelData extraData = (EntityModelData) animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
		AnimationData manager = animatable.getFactory().getOrCreateAnimationData(instanceId);
		int unpausedMultiplier = !Minecraft.getInstance().isPaused() || manager.shouldPlayWhilePaused ? 1 : 0;
		head.setRotationX(head.getRotationX() + extraData.headPitch * ((float) Math.PI / 180F) * unpausedMultiplier);
		head.setRotationY(head.getRotationY() + extraData.netHeadYaw * ((float) Math.PI / 180F) * unpausedMultiplier);
	}
}
