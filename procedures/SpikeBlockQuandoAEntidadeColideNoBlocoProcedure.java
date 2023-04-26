package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.jiukonmod.JiukcraftmodMod;

public class SpikeBlockQuandoAEntidadeColideNoBlocoProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity) {
			JiukcraftmodMod.queueServerWork(10, () -> {
				entity.hurt(DamageSource.CACTUS, 1);
			});
		}
	}
}
