
package net.mcreator.jiukonmod.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.jiukonmod.init.JiukcraftmodModItems;
import net.mcreator.jiukonmod.init.JiukcraftmodModFluids;
import net.mcreator.jiukonmod.init.JiukcraftmodModFluidTypes;
import net.mcreator.jiukonmod.init.JiukcraftmodModBlocks;

public abstract class MutantLiquidFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> JiukcraftmodModFluidTypes.MUTANT_LIQUID_TYPE.get(), () -> JiukcraftmodModFluids.MUTANT_LIQUID.get(),
			() -> JiukcraftmodModFluids.FLOWING_MUTANT_LIQUID.get()).explosionResistance(100f).tickRate(3).slopeFindDistance(3).bucket(() -> JiukcraftmodModItems.MUTANT_LIQUID_BUCKET.get())
			.block(() -> (LiquidBlock) JiukcraftmodModBlocks.MUTANT_LIQUID.get());

	private MutantLiquidFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.WITCH;
	}

	public static class Source extends MutantLiquidFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends MutantLiquidFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
