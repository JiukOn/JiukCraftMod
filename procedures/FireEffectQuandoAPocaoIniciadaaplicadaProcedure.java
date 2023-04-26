package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.jiukonmod.init.JiukcraftmodModMobEffects;

public class FireEffectQuandoAPocaoIniciadaaplicadaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity)
			_entity.removeEffect(JiukcraftmodModMobEffects.FREEZE_EFFECT.get());
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new SmallFireball(EntityType.SMALL_FIREBALL, _level);
			entityToSpawn.moveTo(x, y, z, 0, 0);
			entityToSpawn.setYBodyRot(0);
			entityToSpawn.setYHeadRot(0);
			entityToSpawn.setDeltaMovement(0, (-1), 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
		entity.setSecondsOnFire(entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.FIRE_EFFECT.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.FIRE_EFFECT.get()).getDuration() : 0);
		if (entity instanceof WaterAnimal) {
			entity.hurt(DamageSource.IN_FIRE, 2);
		}
	}
}
