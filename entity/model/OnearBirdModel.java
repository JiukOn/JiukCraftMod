package net.mcreator.jiukonmod.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.jiukonmod.entity.OnearBirdEntity;

public class OnearBirdModel extends AnimatedGeoModel<OnearBirdEntity> {
	@Override
	public ResourceLocation getAnimationResource(OnearBirdEntity entity) {
		return new ResourceLocation("jiukcraftmod", "animations/onearbird.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(OnearBirdEntity entity) {
		return new ResourceLocation("jiukcraftmod", "geo/onearbird.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(OnearBirdEntity entity) {
		return new ResourceLocation("jiukcraftmod", "textures/entities/" + entity.getTexture() + ".png");
	}

}
