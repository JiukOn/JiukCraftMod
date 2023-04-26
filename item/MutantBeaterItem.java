
package net.mcreator.jiukonmod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.jiukonmod.procedures.PoisonMobjogadorColideComOBlocoProcedure;
import net.mcreator.jiukonmod.init.JiukcraftmodModTabs;
import net.mcreator.jiukonmod.init.JiukcraftmodModItems;

import java.util.List;

public class MutantBeaterItem extends SwordItem {
	public MutantBeaterItem() {
		super(new Tier() {
			public int getUses() {
				return 842;
			}

			public float getSpeed() {
				return 7f;
			}

			public float getAttackDamageBonus() {
				return 4f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 70;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(JiukcraftmodModItems.MUTANT_GLAND.get()));
			}
		}, 3, -1f, new Item.Properties().tab(JiukcraftmodModTabs.TAB_JIUK_TOOLS).fireResistant());
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		PoisonMobjogadorColideComOBlocoProcedure.execute(entity);
		return ar;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("I feel magic flowing here!"));
	}
}
