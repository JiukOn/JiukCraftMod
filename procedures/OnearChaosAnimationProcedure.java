package net.mcreator.jiukonmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.jiukonmod.network.JiukcraftmodModVariables;
import net.mcreator.jiukonmod.init.JiukcraftmodModMobEffects;
import net.mcreator.jiukonmod.entity.OnearChaosEntity;
import net.mcreator.jiukonmod.JiukcraftmodMod;

import java.util.Comparator;

public class OnearChaosAnimationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity.getCapability(JiukcraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JiukcraftmodModVariables.PlayerVariables())).AttackingBoss == false) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.WITCH, x, y, z, 10, 2, 3, 2, 1);
			if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
				_entity.setTarget(_ent);
			{
				boolean _setval = true;
				entity.getCapability(JiukcraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.AttackingBoss = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof OnearChaosEntity) {
				((OnearChaosEntity) entity).setAnimation("animation.model.attack1");
			}
			sourceentity.hurt(DamageSource.MAGIC, 4);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.illusioner.cast_spell")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.illusioner.cast_spell")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			JiukcraftmodMod.queueServerWork(40, () -> {
				if (entity instanceof OnearChaosEntity) {
					((OnearChaosEntity) entity).setAnimation("animation.model.attack2");
				}
				sourceentity.hurt(DamageSource.MAGIC, 4);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.evoker.cast_spell")), SoundSource.HOSTILE, 2, 2);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.evoker.cast_spell")), SoundSource.HOSTILE, 2, 2, false);
					}
				}
				if (sourceentity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(JiukcraftmodModMobEffects.CHAOTIC_EFFECT.get(), 60, 1));
				{
					boolean _setval = false;
					entity.getCapability(JiukcraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.AttackingBoss = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			});
			if (!sourceentity.isAlive()) {
				JiukcraftmodMod.queueServerWork(60, () -> {
					if (entity instanceof Mob _entity && ((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 10, 10, 10), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof LivingEntity _ent)
						_entity.setTarget(_ent);
					{
						boolean _setval = false;
						entity.getCapability(JiukcraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.AttackingBoss = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
			}
		}
	}
}
