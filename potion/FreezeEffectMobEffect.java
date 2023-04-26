
package net.mcreator.jiukonmod.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jiukonmod.procedures.FreezeEffectQuandoAPocaoIniciadaaplicadaProcedure;
import net.mcreator.jiukonmod.procedures.FreezeEffectNoTickAtivoDoEfeitoProcedure;

public class FreezeEffectMobEffect extends MobEffect {
	public FreezeEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -6684673);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jiukcraftmod.freeze_effect";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		FreezeEffectQuandoAPocaoIniciadaaplicadaProcedure.execute(entity.level, entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		FreezeEffectNoTickAtivoDoEfeitoProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
