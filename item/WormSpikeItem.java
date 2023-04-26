
package net.mcreator.jiukonmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.jiukonmod.init.JiukcraftmodModTabs;

public class WormSpikeItem extends Item {
	public WormSpikeItem() {
		super(new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_MISC).stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
