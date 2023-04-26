package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.jiukonmod.init.JiukcraftmodModMobEffects;

public class DungeonGlass2QuandoOJogadorComecarADestruirProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(JiukcraftmodModMobEffects.LIVITA_BODY.get()) : false) {
				world.destroyBlock(new BlockPos(x, y, z), false);
			}
		}
	}
}
