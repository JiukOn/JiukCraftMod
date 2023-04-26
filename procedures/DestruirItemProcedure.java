package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.item.ItemStack;

public class DestruirItemProcedure {
	public static void execute(ItemStack itemstack) {
		(itemstack).shrink(1);
	}
}
