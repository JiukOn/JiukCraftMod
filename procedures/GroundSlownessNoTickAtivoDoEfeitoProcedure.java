package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.BlockPos;

import net.mcreator.jiukonmod.init.JiukcraftmodModBlocks;

public class GroundSlownessNoTickAtivoDoEfeitoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.WATER || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.WATER)) {
			if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) : false)) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 3, (false), (false)));
			}
		} else if (!((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.WATER || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.WATER)) {
			if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) : false)) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 3, (false), (false)));
			}
		} else if (!((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.BUBBLE_COLUMN || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.BUBBLE_COLUMN)) {
			if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) : false)) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 3, (false), (false)));
			}
		} else if (!((world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == JiukcraftmodModBlocks.ONEAR_LIQUID.get() || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == JiukcraftmodModBlocks.ONEAR_LIQUID.get())) {
			if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) : false)) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 3, (false), (false)));
			}
		} else {
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN) : false) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
			}
		}
	}
}
