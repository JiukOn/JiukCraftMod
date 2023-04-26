package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;

import net.mcreator.jiukonmod.init.JiukcraftmodModMobEffects;
import net.mcreator.jiukonmod.JiukcraftmodMod;

public class FreezeEffectQuandoAPocaoIniciadaaplicadaProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(JiukcraftmodModMobEffects.FIRE_EFFECT.get());
		entity.hurt(DamageSource.FREEZE, 4);
		entity.setTicksFrozen(entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.FREEZE_EFFECT.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.FREEZE_EFFECT.get()).getDuration() : 0);
		if (!(entity instanceof WaterAnimal)) {
			entity.setAirSupply(2);
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= 4) {
			JiukcraftmodMod.queueServerWork(20, () -> {
				entity.hurt(DamageSource.FREEZE, 1);
				{
					ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				JiukcraftmodMod.queueServerWork(20, () -> {
					entity.hurt(DamageSource.FREEZE, 1);
					{
						ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
						if (_ist.hurt(1, RandomSource.create(), null)) {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						}
					}
				});
			});
		}
	}
}
