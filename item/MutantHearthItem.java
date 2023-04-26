
package net.mcreator.jiukonmod.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.Component;

import net.mcreator.jiukonmod.init.JiukcraftmodModTabs;

import java.util.List;

public class MutantHearthItem extends Item {
	public MutantHearthItem() {
		super(new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_MISC).stacksTo(64).fireResistant().rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(16).saturationMod(0.5f).alwaysEat().meat().build()));
	}

	@Override
	public int getEnchantmentValue() {
		return 100;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("A rare item that emits great energy."));
	}
}
