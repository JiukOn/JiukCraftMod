package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class ClearEffectQuandoAPocaoIniciadaaplicadaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.BUBBLE_POP, x, y, z, 10, (Mth.nextInt(RandomSource.create(), -3, 3)), 2, (Mth.nextInt(RandomSource.create(), -3, 3)), 1);
	}
}
