
package net.mcreator.jiukonmod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.jiukonmod.init.JiukcraftmodModTabs;

import java.util.List;

public class MutantGlandItem extends Item {
	public MutantGlandItem() {
		super(new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_MISC).stacksTo(64).rarity(Rarity.RARE));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("That's strange..."));
	}
}
