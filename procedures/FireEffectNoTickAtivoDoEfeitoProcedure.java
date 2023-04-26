package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.jiukonmod.JiukcraftmodMod;

public class FireEffectNoTickAtivoDoEfeitoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 1) {
			if (entity.getPersistentData().getBoolean("fireeffect") == false) {
				entity.getPersistentData().putBoolean("fireeffect", (true));
				JiukcraftmodMod.queueServerWork(20, () -> {
					entity.hurt(DamageSource.ON_FIRE, 1);
					{
						ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
					entity.getPersistentData().putBoolean("fireeffect", (false));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 4, (Mth.nextInt(RandomSource.create(), -2, 3)), 3, (Mth.nextInt(RandomSource.create(), -2, 3)), 1);
				});
			}
		}
	}
}
