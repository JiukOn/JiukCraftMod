
package net.mcreator.jiukonmod.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.jiukonmod.init.JiukcraftmodModItems;

import java.util.List;

public class FreezeAspectEnchantment extends Enchantment {
	public FreezeAspectEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public int getMaxLevel() {
		return 2;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(Items.NETHERITE_SWORD, JiukcraftmodModItems.GOLDAMETHYST_SWORD.get(), JiukcraftmodModItems.ONEAR_SWORD.get(), JiukcraftmodModItems.TIRANITA_SET_SWORD.get(), JiukcraftmodModItems.ULTIMATE_ONEAR_SWORD.get(), Items.WOODEN_SWORD,
				Items.STONE_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD, Items.DIAMOND_SWORD, JiukcraftmodModItems.MUTANT_BEATER.get(), JiukcraftmodModItems.ULTIMATE_ONEAR_PICKAXE.get(), JiukcraftmodModItems.ULTIMATE_ONEAR_AXE.get(),
				JiukcraftmodModItems.ULTIMATE_ONEAR_SHOVEL.get(), JiukcraftmodModItems.ULTIMATE_ONEAR_HOE.get(), Items.TRIDENT).contains(item);
	}
}
