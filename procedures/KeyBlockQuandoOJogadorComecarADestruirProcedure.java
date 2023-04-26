package net.mcreator.jiukonmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.jiukonmod.init.JiukcraftmodModMobEffects;
import net.mcreator.jiukonmod.init.JiukcraftmodModBlocks;

public class KeyBlockQuandoOJogadorComecarADestruirProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(JiukcraftmodModMobEffects.KING_AUTHORITY.get()) : false) {
			if (Mth.nextInt(RandomSource.create(), 0, 28) < Mth.nextInt(RandomSource.create(), 0, 21)) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(JiukcraftmodModBlocks.KEY_BLOCK.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
			world.destroyBlock(new BlockPos(x, y, z), false);
		}
	}
}
