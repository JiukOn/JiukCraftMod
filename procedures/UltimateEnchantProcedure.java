package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;

public class UltimateEnchantProcedure {
	public static void execute(ItemStack itemstack) {
		(itemstack).enchant(Enchantments.FIRE_ASPECT, 1);
		(itemstack).enchant(Enchantments.BLOCK_FORTUNE, 1);
		(itemstack).enchant(Enchantments.UNBREAKING, 1);
	}
}
