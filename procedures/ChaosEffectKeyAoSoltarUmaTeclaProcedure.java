package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.jiukonmod.init.JiukcraftmodModMobEffects;

public class ChaosEffectKeyAoSoltarUmaTeclaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(JiukcraftmodModMobEffects.INNER_CHAOS.get()) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		}
	}
}
