package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.jiukonmod.init.JiukcraftmodModMobEffects;
import net.mcreator.jiukonmod.JiukcraftmodMod;

public class ChaoticEffectQuandoAPocaoIniciadaaplicadaProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (Mth.nextInt(RandomSource.create(), 1, 10) <= 3) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()).getDuration() : 0, 2));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()).getDuration() : 0, 2));
		}
		if (Mth.nextInt(RandomSource.create(), 1, 10) <= 3) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()).getDuration() : 0, 2));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()).getDuration() : 0, 2));
		}
		if (Mth.nextInt(RandomSource.create(), 1, 10) <= 3) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()).getDuration() : 0, 2));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()).getDuration() : 0, 2));
		}
		if (Mth.nextInt(RandomSource.create(), 1, 10) <= 3) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()).getDuration() : 0, 2));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()).getDuration() : 0, 2));
		}
		if (Mth.nextInt(RandomSource.create(), 1, 10) <= 3) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()).getDuration() : 0, 2));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()).getDuration() : 0, 2));
		}
		if (Mth.nextInt(RandomSource.create(), 1, 10) <= 3) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.POISON,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()).getDuration() : 0, 1));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION,
						entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get()).getDuration() : 0, 2));
		}
		if (Mth.nextInt(RandomSource.create(), 0, 30) < 1) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(JiukcraftmodModMobEffects.CLEAR_EFFECT.get(), 20, 1));
		}
		if (entity instanceof Player) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= 26) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + 2));
			}
			JiukcraftmodMod.queueServerWork(100, () -> {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= 26) {
					if (entity instanceof LivingEntity _entity)
						_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) + 1));
				}
			});
		}
	}
}
