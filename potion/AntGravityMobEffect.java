
package net.mcreator.jiukonmod.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.jiukonmod.procedures.AntGravityQuandoOEfeitoExpiraProcedure;
import net.mcreator.jiukonmod.procedures.AntGravityQuandoAPocaoIniciadaaplicadaProcedure;
import net.mcreator.jiukonmod.procedures.AntGravityNoTickAtivoDoEfeitoProcedure;

public class AntGravityMobEffect extends MobEffect {
	public AntGravityMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -14019751);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jiukcraftmod.ant_gravity";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		AntGravityQuandoAPocaoIniciadaaplicadaProcedure.execute(entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		AntGravityNoTickAtivoDoEfeitoProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		AntGravityQuandoOEfeitoExpiraProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
