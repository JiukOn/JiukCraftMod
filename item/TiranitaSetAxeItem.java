
package net.mcreator.jiukonmod.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

import net.mcreator.jiukonmod.init.JiukcraftmodModTabs;
import net.mcreator.jiukonmod.init.JiukcraftmodModItems;

public class TiranitaSetAxeItem extends AxeItem {
	public TiranitaSetAxeItem() {
		super(new Tier() {
			public int getUses() {
				return 1000;
			}

			public float getSpeed() {
				return 5f;
			}

			public float getAttackDamageBonus() {
				return 0.3f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 35;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(JiukcraftmodModItems.TIRANITA.get()));
			}
		}, 1, -3f, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_TOOLS));
	}
}
