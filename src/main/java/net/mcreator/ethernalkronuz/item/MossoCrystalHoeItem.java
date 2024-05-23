
package net.mcreator.ethernalkronuz.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModTabs;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

public class MossoCrystalHoeItem extends HoeItem {
	public MossoCrystalHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 4062;
			}

			public float getSpeed() {
				return 10f;
			}

			public float getAttackDamageBonus() {
				return 3f;
			}

			public int getLevel() {
				return 5;
			}

			public int getEnchantmentValue() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(EthernalKronuzModItems.MOSSO_CRYSTAL_DUST.get()));
			}
		}, 0, -3f, new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB));
	}
}
