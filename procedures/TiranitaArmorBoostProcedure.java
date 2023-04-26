package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;

public class TiranitaArmorBoostProcedure {
	public static void execute(ItemStack itemstack) {
		boolean IsTranformated = false;
		ItemStack head = ItemStack.EMPTY;
		ItemStack legs = ItemStack.EMPTY;
		ItemStack body = ItemStack.EMPTY;
		ItemStack foot = ItemStack.EMPTY;
		if (!(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLAST_PROTECTION, itemstack) != 0)) {
			(itemstack).enchant(Enchantments.BLAST_PROTECTION, 1);
		}
		if (!(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.UNBREAKING, itemstack) != 0)) {
			(itemstack).enchant(Enchantments.UNBREAKING, 1);
		}
		if (!(EnchantmentHelper.getItemEnchantmentLevel(Enchantments.THORNS, itemstack) != 0)) {
			(itemstack).enchant(Enchantments.THORNS, 1);
		}
	}
}
