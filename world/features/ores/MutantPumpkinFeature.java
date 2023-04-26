
package net.mcreator.jiukonmod.world.features.ores;

import net.minecraft.world.level.levelgen.structure.templatesystem.BlockStateMatchTest;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;

import net.mcreator.jiukonmod.init.JiukcraftmodModBlocks;

import java.util.Set;
import java.util.List;

public class MutantPumpkinFeature extends OreFeature {
	public static MutantPumpkinFeature FEATURE = null;
	public static Holder<ConfiguredFeature<OreConfiguration, ?>> CONFIGURED_FEATURE = null;
	public static Holder<PlacedFeature> PLACED_FEATURE = null;

	public static Feature<?> feature() {
		FEATURE = new MutantPumpkinFeature();
		CONFIGURED_FEATURE = FeatureUtils.register("jiukcraftmod:mutant_pumpkin", FEATURE,
				new OreConfiguration(List.of(OreConfiguration.target(new BlockStateMatchTest(Blocks.PUMPKIN.defaultBlockState()), JiukcraftmodModBlocks.MUTANT_PUMPKIN.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.CARVED_PUMPKIN.defaultBlockState()), JiukcraftmodModBlocks.MUTANT_PUMPKIN.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.GRASS.defaultBlockState()), JiukcraftmodModBlocks.MUTANT_PUMPKIN.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.MANGROVE_LEAVES.defaultBlockState()), JiukcraftmodModBlocks.MUTANT_PUMPKIN.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.TALL_GRASS.defaultBlockState()), JiukcraftmodModBlocks.MUTANT_PUMPKIN.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.DIRT_PATH.defaultBlockState()), JiukcraftmodModBlocks.MUTANT_PUMPKIN.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.SEAGRASS.defaultBlockState()), JiukcraftmodModBlocks.MUTANT_PUMPKIN.get().defaultBlockState()),
						OreConfiguration.target(new BlockStateMatchTest(Blocks.OAK_FENCE.defaultBlockState()), JiukcraftmodModBlocks.MUTANT_PUMPKIN.get().defaultBlockState())), 2));
		PLACED_FEATURE = PlacementUtils.register("jiukcraftmod:mutant_pumpkin", CONFIGURED_FEATURE,
				List.of(CountPlacement.of(2), InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.absolute(50), VerticalAnchor.absolute(128)), BiomeFilter.biome()));
		return FEATURE;
	}

	private final Set<ResourceKey<Level>> generate_dimensions = Set.of(Level.OVERWORLD, ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("jiukcraftmod:jiuk_dimension")));

	public MutantPumpkinFeature() {
		super(OreConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<OreConfiguration> context) {
		WorldGenLevel world = context.level();
		if (!generate_dimensions.contains(world.getLevel().dimension()))
			return false;
		return super.place(context);
	}
}
