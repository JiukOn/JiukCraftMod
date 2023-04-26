
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

import net.mcreator.jiukonmod.procedures.LivitaArmorBoostProcedure;
import net.mcreator.jiukonmod.init.JiukcraftmodModTabs;
import net.mcreator.jiukonmod.init.JiukcraftmodModItems;

public abstract class LivitaArmorArmorItem extends ArmorItem {
	public LivitaArmorArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 37;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{7, 16, 17, 7}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 25;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_diamond"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(JiukcraftmodModItems.LIVITA.get()));
			}

			@Override
			public String getName() {
				return "livita_armor_armor";
			}

			@Override
			public float getToughness() {
				return 2f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.2f;
			}
		}, slot, properties);
	}

	public static class Helmet extends LivitaArmorArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/models/armor/livita__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			LivitaArmorBoostProcedure.execute(itemstack);
		}
	}

	public static class Chestplate extends LivitaArmorArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/models/armor/livita__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			LivitaArmorBoostProcedure.execute(itemstack);
		}
	}

	public static class Leggings extends LivitaArmorArmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/models/armor/livita__layer_2.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			LivitaArmorBoostProcedure.execute(itemstack);
		}
	}

	public static class Boots extends LivitaArmorArmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/models/armor/livita__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			LivitaArmorBoostProcedure.execute(itemstack);
		}
	}
}
