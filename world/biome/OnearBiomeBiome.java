
package net.mcreator.jiukonmod.world.biome;

import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.AmbientAdditionsSettings;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.AquaticFeatures;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.jiukonmod.world.features.treedecorators.OnearBiomeTrunkDecorator;
import net.mcreator.jiukonmod.world.features.treedecorators.OnearBiomeLeaveDecorator;
import net.mcreator.jiukonmod.world.features.treedecorators.OnearBiomeFruitDecorator;
import net.mcreator.jiukonmod.init.JiukcraftmodModEntities;
import net.mcreator.jiukonmod.init.JiukcraftmodModBlocks;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class OnearBiomeBiome {
	public static final List<Climate.ParameterPoint> PARAMETER_POINTS = List.of(
			new Climate.ParameterPoint(Climate.Parameter.span(-0.8f, 0.7f), Climate.Parameter.span(-0.5f, 0.6f), Climate.Parameter.span(0.3f, 0.9f), Climate.Parameter.span(-0.3f, 0.3f), Climate.Parameter.point(0.0f),
					Climate.Parameter.span(-1f, 0.8f), 0),
			new Climate.ParameterPoint(Climate.Parameter.span(-0.8f, 0.7f), Climate.Parameter.span(-0.5f, 0.6f), Climate.Parameter.span(0.3f, 0.9f), Climate.Parameter.span(-0.3f, 0.3f), Climate.Parameter.point(1.0f),
					Climate.Parameter.span(-1f, 0.8f), 0));

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-3368449).waterColor(-10092442).waterFogColor(-6736897).skyColor(-3368449).foliageColorOverride(-6723841).grassColorOverride(-39169)
				.ambientLoopSound(new SoundEvent(new ResourceLocation("music.overworld.grove"))).ambientAdditionsSound(new AmbientAdditionsSettings(new SoundEvent(new ResourceLocation("ambient.soul_sand_valley.additions")), 0.0111D))
				.backgroundMusic(new Music(new SoundEvent(new ResourceLocation("music.overworld.lush_caves")), 12000, 24000, true)).ambientParticle(new AmbientParticleSettings(ParticleTypes.ENCHANT, 0.002f)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("jiukcraftmod:tree_onear_biome",
						FeatureUtils.register("jiukcraftmod:tree_onear_biome", Feature.TREE,
								new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(JiukcraftmodModBlocks.ONEAR_WOOD_LOG.get().defaultBlockState()), new ForkingTrunkPlacer(9, 2, 2),
										BlockStateProvider.simple(JiukcraftmodModBlocks.ONEAR_WOOD_LEAVES.get().defaultBlockState()), new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2))
										.decorators(ImmutableList.of(OnearBiomeLeaveDecorator.INSTANCE, OnearBiomeTrunkDecorator.INSTANCE, OnearBiomeFruitDecorator.INSTANCE)).build()),
						List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("jiukcraftmod:grass_onear_biome", VegetationFeatures.PATCH_GRASS,
				List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("jiukcraftmod:seagrass_onear_biome", AquaticFeatures.SEAGRASS_SHORT, AquaticPlacements.seagrassPlacement(4)));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("jiukcraftmod:flower_onear_biome", VegetationFeatures.FLOWER_DEFAULT,
				List.of(CountPlacement.of(7), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("jiukcraftmod:disk_gravel_onear_biome",
						FeatureUtils.register("jiukcraftmod:disk_gravel_onear_biome", Feature.DISK,
								new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.GRAVEL), BlockPredicate.matchesBlocks(List.of(Blocks.GRASS_BLOCK, Blocks.DIRT)), UniformInt.of(2, 5), 2)),
						List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome())));
		BiomeDefaultFeatures.addDefaultCrystalFormations(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeGenerationSettings);
		BiomeDefaultFeatures.addDefaultOres(biomeGenerationSettings);
		BiomeDefaultFeatures.addSurfaceFreezing(biomeGenerationSettings);
		BiomeDefaultFeatures.addMeadowVegetation(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(JiukcraftmodModEntities.ONEAR_BIRD.get(), 22, 1, 1));
		mobSpawnInfo.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(JiukcraftmodModEntities.ONEAR_WORM.get(), 22, 1, 3));
		mobSpawnInfo.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(JiukcraftmodModEntities.ONEAR_WINGS.get(), 22, 1, 1));
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).temperature(0.4f).downfall(0.19999999999999998f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build())
				.build();
	}
}
