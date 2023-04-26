
package net.mcreator.jiukonmod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.Component;

import net.mcreator.jiukonmod.init.JiukcraftmodModTabs;

import java.util.List;

public class VenomBreadItem extends Item {
	public VenomBreadItem() {
		super(new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_MISC).stacksTo(64).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(-1).saturationMod(0.1f)

				.build()));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Why did I cook this??"));
	}
}
