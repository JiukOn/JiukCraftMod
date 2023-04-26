package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.jiukonmod.init.JiukcraftmodModBlocks;

public class OnearPortalFlowerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.GRASS_BLOCK && (world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == JiukcraftmodModBlocks.JIUKITA_BLOCK.get()
				&& (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == JiukcraftmodModBlocks.JIUKITA_BLOCK.get() && (world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == JiukcraftmodModBlocks.JIUKITA_BLOCK.get()
				&& (world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == JiukcraftmodModBlocks.JIUKITA_BLOCK.get()) {
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(false);
				_level.addFreshEntity(entityToSpawn);
			}
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y - 1, z), JiukcraftmodModBlocks.ONEAR_PORTAL_BLOCK.get().defaultBlockState(), 3);
		}
	}
}
