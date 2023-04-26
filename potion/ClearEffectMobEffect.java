
package net.mcreator.jiukonmod.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jiukonmod.procedures.ClearEffectQuandoAPocaoIniciadaaplicadaProcedure;
import net.mcreator.jiukonmod.procedures.ClearEffectNoTickAtivoDoEfeitoProcedure;

public class ClearEffectMobEffect extends MobEffect {
	public ClearEffectMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -2740892);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jiukcraftmod.clear_effect";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		ClearEffectQuandoAPocaoIniciadaaplicadaProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ());
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ClearEffectNoTickAtivoDoEfeitoProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
