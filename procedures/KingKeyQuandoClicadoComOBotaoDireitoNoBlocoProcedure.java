package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.jiukonmod.init.JiukcraftmodModEntities;
import net.mcreator.jiukonmod.init.JiukcraftmodModBlocks;
import net.mcreator.jiukonmod.entity.OnearKingEntity;
import net.mcreator.jiukonmod.entity.OnearChaosEntity;
import net.mcreator.jiukonmod.entity.MutantQuimeraEntity;
import net.mcreator.jiukonmod.entity.LivitaDefensorEntity;

public class KingKeyQuandoClicadoComOBotaoDireitoNoBlocoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == JiukcraftmodModBlocks.ONEAR_KING_SPAWNER.get() && (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == JiukcraftmodModBlocks.TIRANITA_BLOCK.get()) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new OnearKingEntity(JiukcraftmodModEntities.ONEAR_KING.get(), _level);
				entityToSpawn.moveTo(x, (y + 5), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LANDING_OBSIDIAN_TEAR, x, y, z, 5, 3, 4, 3, 1);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == JiukcraftmodModBlocks.TIRANITA_BLOCK.get() && (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == JiukcraftmodModBlocks.ONEAR_KING_SPAWNER.get()) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new OnearKingEntity(JiukcraftmodModEntities.ONEAR_KING.get(), _level);
				entityToSpawn.moveTo(x, (y + 4), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LANDING_OBSIDIAN_TEAR, x, y, z, 5, 3, 4, 3, 1);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == JiukcraftmodModBlocks.ONEAR_CHAOS_SPAWNER.get() && (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == JiukcraftmodModBlocks.TIRANITA_BLOCK.get()) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new OnearChaosEntity(JiukcraftmodModEntities.ONEAR_CHAOS.get(), _level);
				entityToSpawn.moveTo(x, (y + 4), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LANDING_OBSIDIAN_TEAR, x, y, z, 5, 3, 4, 3, 1);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == JiukcraftmodModBlocks.TIRANITA_BLOCK.get() && (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == JiukcraftmodModBlocks.ONEAR_CHAOS_SPAWNER.get()) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new OnearChaosEntity(JiukcraftmodModEntities.ONEAR_CHAOS.get(), _level);
				entityToSpawn.moveTo(x, (y + 3), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LANDING_OBSIDIAN_TEAR, x, y, z, 5, 3, 4, 3, 1);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == JiukcraftmodModBlocks.LIVITA_DEFENSOR_SPAWNER.get() && (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == JiukcraftmodModBlocks.TIRANITA_BLOCK.get()) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new LivitaDefensorEntity(JiukcraftmodModEntities.LIVITA_DEFENSOR.get(), _level);
				entityToSpawn.moveTo(x, (y + 4), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LANDING_OBSIDIAN_TEAR, x, y, z, 5, 3, 4, 3, 1);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == JiukcraftmodModBlocks.TIRANITA_BLOCK.get() && (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == JiukcraftmodModBlocks.LIVITA_DEFENSOR_SPAWNER.get()) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new LivitaDefensorEntity(JiukcraftmodModEntities.LIVITA_DEFENSOR.get(), _level);
				entityToSpawn.moveTo(x, (y + 3), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LANDING_OBSIDIAN_TEAR, x, y, z, 5, 3, 4, 3, 1);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		}
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == JiukcraftmodModBlocks.MUTANT_QUIMERA_SPAWNER.get() && (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == JiukcraftmodModBlocks.TIRANITA_BLOCK.get()) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new MutantQuimeraEntity(JiukcraftmodModEntities.MUTANT_QUIMERA.get(), _level);
				entityToSpawn.moveTo(x, (y + 2), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LANDING_OBSIDIAN_TEAR, x, y, z, 5, 3, 4, 3, 1);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == JiukcraftmodModBlocks.TIRANITA_BLOCK.get() && (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == JiukcraftmodModBlocks.MUTANT_QUIMERA_SPAWNER.get()) {
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new MutantQuimeraEntity(JiukcraftmodModEntities.MUTANT_QUIMERA.get(), _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LANDING_OBSIDIAN_TEAR, x, y, z, 5, 3, 4, 3, 1);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
