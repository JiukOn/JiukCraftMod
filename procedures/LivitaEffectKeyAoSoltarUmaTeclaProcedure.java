package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.jiukonmod.init.JiukcraftmodModMobEffects;

public class LivitaEffectKeyAoSoltarUmaTeclaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(JiukcraftmodModMobEffects.LIVITA_BODY.get()) : false) {
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE) : false) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
			} else {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1000000, 2, (false), (false)));
			}
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.JUMP) : false) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.JUMP);
			} else {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 1000000, 1, (false), (false)));
			}
		}
	}
}
