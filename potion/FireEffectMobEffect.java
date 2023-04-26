
package net.mcreator.jiukonmod.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jiukonmod.procedures.FireEffectQuandoAPocaoIniciadaaplicadaProcedure;
import net.mcreator.jiukonmod.procedures.FireEffectNoTickAtivoDoEfeitoProcedure;

public class FireEffectMobEffect extends MobEffect {
	public FireEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -52429);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jiukcraftmod.fire_effect";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		FireEffectQuandoAPocaoIniciadaaplicadaProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		FireEffectNoTickAtivoDoEfeitoProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
