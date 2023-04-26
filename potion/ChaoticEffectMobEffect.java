
package net.mcreator.jiukonmod.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jiukonmod.procedures.ChaoticEffectQuandoAPocaoIniciadaaplicadaProcedure;
import net.mcreator.jiukonmod.procedures.ChaoticEffectNoTickAtivoDoEfeitoProcedure;

public class ChaoticEffectMobEffect extends MobEffect {
	public ChaoticEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -13163247);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jiukcraftmod.chaotic_effect";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		ChaoticEffectQuandoAPocaoIniciadaaplicadaProcedure.execute(entity.level, entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ChaoticEffectNoTickAtivoDoEfeitoProcedure.execute(entity.level, entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
