
package net.mcreator.jiukonmod.item;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.Minecraft;

import net.mcreator.jiukonmod.init.JiukcraftmodModTabs;
import net.mcreator.jiukonmod.client.model.ModelMutantLegs;
import net.mcreator.jiukonmod.client.model.ModelMutantHead;
import net.mcreator.jiukonmod.client.model.ModelMutantBody;

import java.util.function.Consumer;
import java.util.Map;
import java.util.Collections;

public abstract class PlayerMutantTransformsItem extends ArmorItem {
	public PlayerMutantTransformsItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 30;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{15, 15, 15, 15}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 0;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}

			@Override
			public String getName() {
				return "player_mutant_transforms";
			}

			@Override
			public float getToughness() {
				return 1f;
			}

			@Override
			public float getKnockbackResistance() {
				return 5f;
			}
		}, slot, properties);
	}

	public static class Helmet extends PlayerMutantTransformsItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS).fireResistant());
		}

		@Override
		public void initializeClient(Consumer<IClientItemExtensions> consumer) {
			consumer.accept(new IClientItemExtensions() {
				@Override
				public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
					HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
							Map.of("head", new ModelMutantHead(Minecraft.getInstance().getEntityModels().bakeLayer(ModelMutantHead.LAYER_LOCATION)).Head, "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body",
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
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/entities/mutanthead.png";
		}
	}

	public static class Chestplate extends PlayerMutantTransformsItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS).fireResistant());
		}

		@Override
		public void initializeClient(Consumer<IClientItemExtensions> consumer) {
			consumer.accept(new IClientItemExtensions() {
				@Override
				@OnlyIn(Dist.CLIENT)
				public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
					HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(), Map.of("body", new ModelMutantBody(Minecraft.getInstance().getEntityModels().bakeLayer(ModelMutantBody.LAYER_LOCATION)).Body, "left_arm",
							new ModelMutantBody(Minecraft.getInstance().getEntityModels().bakeLayer(ModelMutantBody.LAYER_LOCATION)).Larm, "right_arm",
							new ModelMutantBody(Minecraft.getInstance().getEntityModels().bakeLayer(ModelMutantBody.LAYER_LOCATION)).Rarm, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat",
							new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
					armorModel.crouching = living.isShiftKeyDown();
					armorModel.riding = defaultModel.riding;
					armorModel.young = living.isBaby();
					return armorModel;
				}
			});
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/entities/mutantbody.png";
		}
	}

	public static class Leggings extends PlayerMutantTransformsItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS).fireResistant());
		}

		@Override
		public void initializeClient(Consumer<IClientItemExtensions> consumer) {
			consumer.accept(new IClientItemExtensions() {
				@Override
				@OnlyIn(Dist.CLIENT)
				public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
					HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
							Map.of("left_leg", new ModelMutantLegs(Minecraft.getInstance().getEntityModels().bakeLayer(ModelMutantLegs.LAYER_LOCATION)).L, "right_leg",
									new ModelMutantLegs(Minecraft.getInstance().getEntityModels().bakeLayer(ModelMutantLegs.LAYER_LOCATION)).R, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
									"left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
					armorModel.crouching = living.isShiftKeyDown();
					armorModel.riding = defaultModel.riding;
					armorModel.young = living.isBaby();
					return armorModel;
				}
			});
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/entities/mutantlegs.png";
		}
	}

	public static class Boots extends PlayerMutantTransformsItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_ARMORS).fireResistant());
		}

		@Override
		public void initializeClient(Consumer<IClientItemExtensions> consumer) {
			consumer.accept(new IClientItemExtensions() {
				@Override
				@OnlyIn(Dist.CLIENT)
				public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
					HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
							Map.of("left_leg", new ModelMutantLegs(Minecraft.getInstance().getEntityModels().bakeLayer(ModelMutantLegs.LAYER_LOCATION)).lfoot, "right_leg",
									new ModelMutantLegs(Minecraft.getInstance().getEntityModels().bakeLayer(ModelMutantLegs.LAYER_LOCATION)).rfoot, "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
									"left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
					armorModel.crouching = living.isShiftKeyDown();
					armorModel.riding = defaultModel.riding;
					armorModel.young = living.isBaby();
					return armorModel;
				}
			});
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jiukcraftmod:textures/entities/mutantlegs.png";
		}
	}
}
