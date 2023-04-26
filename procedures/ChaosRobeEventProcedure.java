package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.jiukonmod.network.JiukcraftmodModVariables;
import net.mcreator.jiukonmod.init.JiukcraftmodModMobEffects;

public class ChaosRobeEventProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if ((entity.getCapability(JiukcraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JiukcraftmodModVariables.PlayerVariables())).IsHealthBoosted2 == false) {
				{
					boolean _setval = true;
					entity.getCapability(JiukcraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IsHealthBoosted2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1000000,
							(int) (1 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEALTH_BOOST) ? _livEnt.getEffect(MobEffects.HEALTH_BOOST).getAmplifier() : 0)), (false), (false)));
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.INNER_CHAOS.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.INNER_CHAOS.get()).getAmplifier() : 0) <= 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(JiukcraftmodModMobEffects.INNER_CHAOS.get(), 100, 1, (false), (false)));
			}
		}
	}
}
