package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.jiukonmod.init.JiukcraftmodModEntities;
import net.mcreator.jiukonmod.init.JiukcraftmodModBlocks;
import net.mcreator.jiukonmod.entity.LivitaGolemEntity;

import java.util.Iterator;

public class LivitaPumpkinGolemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == JiukcraftmodModBlocks.MUTANT_PUMPKIN.get() && (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == JiukcraftmodModBlocks.LIVITA_BLOCK.get()
				&& (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == JiukcraftmodModBlocks.LIVITA_BLOCK.get() && (world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == JiukcraftmodModBlocks.LIVITA_BLOCK.get()
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == JiukcraftmodModBlocks.LIVITA_BLOCK.get()) {
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x + 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x - 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new LivitaGolemEntity(JiukcraftmodModEntities.LIVITA_GOLEM.get(), _level);
				entityToSpawn.moveTo(x, y, z, 0, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				entityToSpawn.setDeltaMovement(0, 0, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == JiukcraftmodModBlocks.MUTANT_PUMPKIN.get() && (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == JiukcraftmodModBlocks.LIVITA_BLOCK.get()
				&& (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == JiukcraftmodModBlocks.LIVITA_BLOCK.get() && (world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == JiukcraftmodModBlocks.LIVITA_BLOCK.get()
				&& (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == JiukcraftmodModBlocks.LIVITA_BLOCK.get()) {
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 2, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new LivitaGolemEntity(JiukcraftmodModEntities.LIVITA_GOLEM.get(), _level);
				entityToSpawn.moveTo(x, y, z, 0, 0);
				entityToSpawn.setYBodyRot(0);
				entityToSpawn.setYHeadRot(0);
				entityToSpawn.setDeltaMovement(0, 0, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			if (sourceentity instanceof Player) {
				if (sourceentity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jiukcraftmod:livita_golem_achievement"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						Iterator _iterator = _ap.getRemainingCriteria().iterator();
						while (_iterator.hasNext())
							_player.getAdvancements().award(_adv, (String) _iterator.next());
					}
				}
			}
		}
	}
}
