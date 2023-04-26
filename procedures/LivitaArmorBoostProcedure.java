package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;

public class LivitaArmorBoostProcedure {
	public static void execute(ItemStack itemstack) {
		boolean IsTranformated = false;
		ItemStack head = ItemStack.EMPTY;
		ItemStack legs = ItemStack.EMPTY;
		ItemStack body = ItemStack.EMPTY;
		ItemStack foot = ItemStack.EMPTY;
		if (!(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLAST_PROTECTION, itemstack) != 0)) {
			(itemstack).enchant(Enchantments.BLAST_PROTECTION, 1);
		}
		if (!(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_PROTECTION, itemstack) != 0)) {
			(itemstack).enchant(Enchantments.FIRE_PROTECTION, 1);
		}
		if (!(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PROJECTILE_PROTECTION, itemstack) != 0)) {
			(itemstack).enchant(Enchantments.PROJECTILE_PROTECTION, 1);
		}
		if (!(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.ALL_DAMAGE_PROTECTION, itemstack) != 0)) {
			(itemstack).enchant(Enchantments.ALL_DAMAGE_PROTECTION, 1);
		}
		if (!(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.UNBREAKING, itemstack) != 0)) {
			(itemstack).enchant(Enchantments.UNBREAKING, 2);
		}
		if (!(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FROST_WALKER, itemstack) != 0)) {
			(itemstack).enchant(Enchantments.FROST_WALKER, 2);
		}
	}
}
