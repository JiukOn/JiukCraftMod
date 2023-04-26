package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.jiukonmod.JiukcraftmodMod;

public class FreezeEffectNoTickAtivoDoEfeitoProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 16) {
			if (entity.getPersistentData().getBoolean("spawnsnow") == false) {
				entity.getPersistentData().putBoolean("spawnsnow", (true));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SNOWFLAKE, (entity.getX()), (entity.getY()), (entity.getZ()), 3, (Mth.nextInt(RandomSource.create(), -2, 2)), 2, (Mth.nextInt(RandomSource.create(), -2, 2)), 1);
				JiukcraftmodMod.queueServerWork(20, () -> {
					entity.getPersistentData().putBoolean("spawnsnow", (false));
				});
			}
		}
	}
}
