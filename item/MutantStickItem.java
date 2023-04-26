
package net.mcreator.jiukonmod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.jiukonmod.init.JiukcraftmodModTabs;

import java.util.List;

public class MutantStickItem extends Item {
	public MutantStickItem() {
		super(new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_MISC).stacksTo(64).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("So useful...this is useful"));
		list.add(Component.literal("right?"));
	}
}
