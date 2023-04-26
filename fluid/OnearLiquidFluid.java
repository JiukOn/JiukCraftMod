
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

public abstract class OnearLiquidFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> JiukcraftmodModFluidTypes.ONEAR_LIQUID_TYPE.get(), () -> JiukcraftmodModFluids.ONEAR_LIQUID.get(),
			() -> JiukcraftmodModFluids.FLOWING_ONEAR_LIQUID.get()).explosionResistance(90f).tickRate(10).bucket(() -> JiukcraftmodModItems.ONEAR_LIQUID_BUCKET.get()).block(() -> (LiquidBlock) JiukcraftmodModBlocks.ONEAR_LIQUID.get());

	private OnearLiquidFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.BUBBLE;
	}

	public static class Source extends OnearLiquidFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends OnearLiquidFluid {
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
