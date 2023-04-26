package net.mcreator.jiukonmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.jiukonmod.network.JiukcraftmodModVariables;
import net.mcreator.jiukonmod.entity.OnearKingEntity;
import net.mcreator.jiukonmod.JiukcraftmodMod;

import java.util.Comparator;

public class OnearKingAnimationsAttackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity.getCapability(JiukcraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JiukcraftmodModVariables.PlayerVariables())).AttackingBoss == false) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.DRIPPING_OBSIDIAN_TEAR, x, y, z, 8, 2, 3, 2, 1);
			if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
				_entity.setTarget(_ent);
			{
				boolean _setval = true;
				entity.getCapability(JiukcraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.AttackingBoss = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof OnearKingEntity) {
				((OnearKingEntity) entity).setAnimation("animation.model.attack1");
			}
			sourceentity.hurt(DamageSource.MAGIC, 2);
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 40, 1));
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.growl")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.growl")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			JiukcraftmodMod.queueServerWork(40, () -> {
				if (entity instanceof OnearKingEntity) {
					((OnearKingEntity) entity).setAnimation("animation.model.attack2");
				}
				sourceentity.hurt(DamageSource.MAGIC, 2);
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 1));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.guardian.attack")), SoundSource.HOSTILE, 2, 2);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.guardian.attack")), SoundSource.HOSTILE, 2, 2, false);
					}
				}
				if (entity.getPersistentData().getBoolean("knockbackLogic") == false) {
					JiukcraftmodMod.queueServerWork(10, () -> {
						entity.getPersistentData().putBoolean("knockbackLogic", (true));
						sourceentity.setDeltaMovement(
								new Vec3((Math.sin(Math.toRadians(sourceentity.getYRot() + 50)) * 1.6 * (-1)), ((Math.sin(Math.toRadians(0 - sourceentity.getXRot())) + 0.5) * 1.2), (Math.cos(Math.toRadians(sourceentity.getYRot())) * 1.4 * (-1))));
						sourceentity.hurt(DamageSource.MAGIC, 2);
						if (entity instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 50, 1));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.knockback")), SoundSource.HOSTILE, 2, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.knockback")), SoundSource.HOSTILE, 2, 1, false);
							}
						}
						JiukcraftmodMod.queueServerWork(15, () -> {
							{
								Entity _ent = entity;
								_ent.teleportTo((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()));
								if (_ent instanceof ServerPlayer _serverPlayer)
									_serverPlayer.connection.teleport((sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()), _ent.getYRot(), _ent.getXRot());
							}
						});
					});
				}
				JiukcraftmodMod.queueServerWork(100, () -> {
					entity.getPersistentData().putBoolean("knockbackLogic", (false));
				});
			});
			if (!entity.isAlive()) {
				JiukcraftmodMod.queueServerWork(45, () -> {
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
