package net.mcreator.jiukonmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.jiukonmod.init.JiukcraftmodModMobEffects;
import net.mcreator.jiukonmod.init.JiukcraftmodModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FreezeAspectProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity instanceof Player) {
			if (EnchantmentHelper.getItemEnchantmentLevel(JiukcraftmodModEnchantments.FREEZE_ASPECT.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(JiukcraftmodModMobEffects.FREEZE_EFFECT.get(), 50, 1));
			}
		}
	}
}
