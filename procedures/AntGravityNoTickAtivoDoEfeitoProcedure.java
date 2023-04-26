package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class AntGravityNoTickAtivoDoEfeitoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xl = 0;
		double yl = 0;
		double zl = 0;
		if (Mth.nextInt(RandomSource.create(), 1, 200) <= 5) {
			xl = Mth.nextInt(RandomSource.create(), -5, 5);
			yl = Mth.nextInt(RandomSource.create(), -3, 3);
			zl = Mth.nextInt(RandomSource.create(), -5, 5);
			if ((world.getBlockState(new BlockPos(x + xl, y + yl, z + zl))).getBlock() == Blocks.AIR) {
				{
					Entity _ent = entity;
					_ent.teleportTo((x + xl), (y + yl), (z + zl));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((x + xl), (y + yl), (z + zl), _ent.getYRot(), _ent.getXRot());
				}
			}
		}
	}
}
