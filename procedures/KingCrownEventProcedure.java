package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.jiukonmod.network.JiukcraftmodModVariables;
import net.mcreator.jiukonmod.init.JiukcraftmodModMobEffects;

public class KingCrownEventProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
			if ((entity.getCapability(JiukcraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JiukcraftmodModVariables.PlayerVariables())).IsHealthBoosted1 == false) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1000000,
							(int) (4 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEALTH_BOOST) ? _livEnt.getEffect(MobEffects.HEALTH_BOOST).getAmplifier() : 0)), (false), (false)));
				{
					boolean _setval = true;
					entity.getCapability(JiukcraftmodModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IsHealthBoosted1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JiukcraftmodModMobEffects.KING_AUTHORITY.get()) ? _livEnt.getEffect(JiukcraftmodModMobEffects.KING_AUTHORITY.get()).getAmplifier() : 0) <= 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(JiukcraftmodModMobEffects.KING_AUTHORITY.get(), 100, 1, (false), (false)));
			}
		}
	}
}
