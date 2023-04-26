
package net.mcreator.jiukonmod.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class OnearKingSpawnerBlock extends Block {
	public OnearKingSpawnerBlock() {
		super(BlockBehaviour.Properties.of(Material.METAL).sound(SoundType.METAL).strength(-1, 3600000).lightLevel(s -> 2).friction(0.7f).speedFactor(2f).jumpFactor(0.2f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true)
				.noLootTable());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}
}
