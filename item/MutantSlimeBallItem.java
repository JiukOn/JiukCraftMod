
package net.mcreator.jiukonmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

import net.mcreator.jiukonmod.init.JiukcraftmodModTabs;

public class MutantSlimeBallItem extends Item {
	public MutantSlimeBallItem() {
		super(new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_MISC).stacksTo(64).fireResistant().rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(-4).saturationMod(0.5f)

				.build()));
	}
}
