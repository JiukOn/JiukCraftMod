package net.mcreator.jiukonmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.jiukonmod.network.JiukcraftmodModVariables;
import net.mcreator.jiukonmod.entity.LivitaDefensorEntity;
import net.mcreator.jiukonmod.JiukcraftmodMod;

import java.util.Comparator;

public class LivitaDefensorAnimationsProcedure {
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
			if (entity instanceof LivitaDefensorEntity) {
				((LivitaDefensorEntity) entity).setAnimation("animation.LivitaDefensor.attack1");
			}
			sourceentity.hurt(DamageSource.GENERIC, 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.repair")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
			JiukcraftmodMod.queueServerWork(35, () -> {
				if (entity instanceof LivitaDefensorEntity) {
					((LivitaDefensorEntity) entity).setAnimation("animation.LivitaDefensor.attack2");
				}
				sourceentity.hurt(DamageSource.GENERIC, 2);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.guardian.attack")), SoundSource.HOSTILE, 2, 2);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.guardian.attack")), SoundSource.HOSTILE, 2, 2, false);
					}
				}
				JiukcraftmodMod.queueServerWork(30, () -> {
					if (entity instanceof LivitaDefensorEntity) {
						((LivitaDefensorEntity) entity).setAnimation("animation.LivitaDefensor.attack3");
					}
					sourceentity.hurt(DamageSource.CRAMMING, 4);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.attack_impact")), SoundSource.HOSTILE, 1, 2);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.warden.attack_impact")), SoundSource.HOSTILE, 1, 2, false);
						}
					}
					if (entity.getPersistentData().getBoolean("knockbackLogic") == false) {
						entity.getPersistentData().putBoolean("knockbackLogic", (true));
						JiukcraftmodMod.queueServerWork(90, () -> {
							sourceentity.setDeltaMovement(
									new Vec3((Math.sin(Math.toRadians(sourceentity.getYRot() + 30)) * 1.4 * (-1)), ((Math.sin(Math.toRadians(0 - sourceentity.getXRot())) + 0.5) * 1), (Math.cos(Math.toRadians(sourceentity.getYRot())) * 1.2 * (-1))));
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.knockback")), SoundSource.HOSTILE, 4, 1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.knockback")), SoundSource.HOSTILE, 4, 1, false);
								}
							}
						});
						JiukcraftmodMod.queueServerWork(150, () -> {
							entity.getPersistentData().putBoolean("knockbackLogic", (false));
							{
								boolean _setval = false;
								entity.getCapability(JiukcraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.AttackingBoss = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						});
					}
				});
			});
			if (!sourceentity.isAlive()) {
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
