
package net.mcreator.jiukonmod.item;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.Minecraft;

import net.mcreator.jiukonmod.procedures.QuimeraStuffEventProcedure;
import net.mcreator.jiukonmod.procedures.LivitaFeetEventProcedure;
import net.mcreator.jiukonmod.procedures.KingCrownEventProcedure;
import net.mcreator.jiukonmod.procedures.ChaosRobeEventProcedure;
import net.mcreator.jiukonmod.init.JiukcraftmodModTabs;
import net.mcreator.jiukonmod.init.JiukcraftmodModItems;
import net.mcreator.jiukonmod.client.model.Modelcustom_model;

import java.util.function.Consumer;
import java.util.Map;
import java.util.List;
import java.util.Collections;

public abstract class KingCrownItem extends ArmorItem {
	public KingCrownItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 45;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{16, 16, 16, 16}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 100;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_gold"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(JiukcraftmodModItems.KING_CROWN_HELMET.get()), new ItemStack(JiukcraftmodModItems.KING_CROWN_CHESTPLATE.get()), new ItemStack(JiukcraftmodModItems.KING_CROWN_LEGGINGS.get()),
						new ItemStack(JiukcraftmodModItems.KING_CROWN_BOOTS.get()));
			}

			@Override
			public String getName() {
				return "king_crown";
			}

			@Override
			public float getToughness() {
				return 3f;
			}

			@Override
			public float getKnockbackResistance() {
				return 1f;
			}
		}, slot, properties);
	}

	public static class Helmet extends KingCrownItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS).fireResistant());
		}

		@Override
		public void initializeClient(Consumer<IClientItemExtensions> consumer) {
			consumer.accept(new IClientItemExtensions() {
				@Override
				public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
					HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
							Map.of("head", new Modelcustom_model(Minecraft.getInstance().getEntityModels().bakeLayer(Modelcustom_model.LAYER_LOCATION)).Crown, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
					armorModel.crouching = living.isShiftKeyDown();
					armorModel.riding = defaultModel.riding;
					armorModel.young = living.isBaby();
					return armorModel;
				}
			});
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal("The most powerful rare and energized"));
			list.add(Component.literal("treasure you will ever see!"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/entities/kingcrowntexture.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			KingCrownEventProcedure.execute(entity, itemstack);
		}
	}

	public static class Chestplate extends KingCrownItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/models/armor/onearrobe__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			ChaosRobeEventProcedure.execute(entity, itemstack);
		}
	}

	public static class Leggings extends KingCrownItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/models/armor/onearrobe__layer_2.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			QuimeraStuffEventProcedure.execute(entity, itemstack);
		}
	}

	public static class Boots extends KingCrownItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/models/armor/onearrobe__layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			LivitaFeetEventProcedure.execute(entity, itemstack);
		}
	}
}
