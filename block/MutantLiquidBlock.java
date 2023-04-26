
package net.mcreator.jiukonmod.block;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.jiukonmod.procedures.PoisonMobjogadorColideComOBlocoProcedure;
import net.mcreator.jiukonmod.init.JiukcraftmodModFluids;

public class MutantLiquidBlock extends LiquidBlock {
	public MutantLiquidBlock() {
		super(() -> JiukcraftmodModFluids.MUTANT_LIQUID.get(), BlockBehaviour.Properties.of(Material.LAVA, MaterialColor.COLOR_GREEN).strength(100f).noCollission().noLootTable());
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 4;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		PoisonMobjogadorColideComOBlocoProcedure.execute(entity);
	}
}
