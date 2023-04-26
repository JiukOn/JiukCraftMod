package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class ClearEffectNoTickAtivoDoEfeitoProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (Mth.nextInt(RandomSource.create(), 0, 100) > 60) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeAllEffects();
		}
	}
}
