
package net.mcreator.jiukonmod.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.jiukonmod.init.JiukcraftmodModTabs;
import net.mcreator.jiukonmod.init.JiukcraftmodModFluids;

public class MutantLiquidItem extends BucketItem {
	public MutantLiquidItem() {
		super(JiukcraftmodModFluids.MUTANT_LIQUID, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.UNCOMMON).tab(JiukcraftmodModTabs.TAB_JIUK_MISC));
	}
}
