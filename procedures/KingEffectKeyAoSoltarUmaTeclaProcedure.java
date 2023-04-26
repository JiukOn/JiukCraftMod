package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.jiukonmod.init.JiukcraftmodModMobEffects;
import net.mcreator.jiukonmod.init.JiukcraftmodModEnchantments;

import java.util.Map;

public class KingEffectKeyAoSoltarUmaTeclaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(JiukcraftmodModMobEffects.KING_AUTHORITY.get()) : false) {
			if (EnchantmentHelper.getItemEnchantmentLevel(JiukcraftmodModEnchantments.FREEZE_ASPECT.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				{
					Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
					if (_enchantments.containsKey(JiukcraftmodModEnchantments.FREEZE_ASPECT.get())) {
						_enchantments.remove(JiukcraftmodModEnchantments.FREEZE_ASPECT.get());
						EnchantmentHelper.setEnchantments(_enchantments, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
					}
				}
			} else {
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(JiukcraftmodModEnchantments.FREEZE_ASPECT.get(), 2);
			}
			if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_ASPECT, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				{
					Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
					if (_enchantments.containsKey(Enchantments.FIRE_ASPECT)) {
						_enchantments.remove(Enchantments.FIRE_ASPECT);
						EnchantmentHelper.setEnchantments(_enchantments, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY));
					}
				}
			} else {
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.FIRE_ASPECT, 2);
			}
		}
	}
}
