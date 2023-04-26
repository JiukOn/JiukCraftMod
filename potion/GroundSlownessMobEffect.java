
package net.mcreator.jiukonmod.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jiukonmod.procedures.GroundSlownessNoTickAtivoDoEfeitoProcedure;

public class GroundSlownessMobEffect extends MobEffect {
	public GroundSlownessMobEffect() {
		super(MobEffectCategory.HARMFUL, -7561596);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jiukcraftmod.ground_slowness";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		GroundSlownessNoTickAtivoDoEfeitoProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
