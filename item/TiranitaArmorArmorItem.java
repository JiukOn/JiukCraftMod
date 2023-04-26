
package net.mcreator.jiukonmod.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.jiukonmod.procedures.TiranitaArmorBoostProcedure;
import net.mcreator.jiukonmod.init.JiukcraftmodModTabs;
import net.mcreator.jiukonmod.init.JiukcraftmodModItems;

public abstract class TiranitaArmorArmorItem extends ArmorItem {
	public TiranitaArmorArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 35;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{3, 11, 10, 5}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 20;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_gold"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(JiukcraftmodModItems.TIRANITA.get()));
			}

			@Override
			public String getName() {
				return "tiranita_armor_armor";
			}

			@Override
			public float getToughness() {
				return 1f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, slot, properties);
	}

	public static class Helmet extends TiranitaArmorArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/models/armor/tiranita__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			TiranitaArmorBoostProcedure.execute(itemstack);
		}
	}

	public static class Chestplate extends TiranitaArmorArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/models/armor/tiranita__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			TiranitaArmorBoostProcedure.execute(itemstack);
		}
	}

	public static class Leggings extends TiranitaArmorArmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/models/armor/tiranita__layer_2.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			TiranitaArmorBoostProcedure.execute(itemstack);
		}
	}

	public static class Boots extends TiranitaArmorArmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/models/armor/tiranita__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			TiranitaArmorBoostProcedure.execute(itemstack);
		}
	}
}
