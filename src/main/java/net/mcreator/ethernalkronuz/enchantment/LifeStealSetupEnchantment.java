
package net.mcreator.ethernalkronuz.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

import java.util.List;

public class LifeStealSetupEnchantment extends Enchantment {
	public LifeStealSetupEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, slots);
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		Item item = stack.getItem();
		return List.of(EthernalKronuzModItems.MOSSO_CRYSTAL_SWORD.get(), EthernalKronuzModItems.FAKING_ELL_SWORD.get(), EthernalKronuzModItems.AIPORT_STEEL_SWORD.get(), Items.WOODEN_SWORD, Items.STONE_SWORD, Items.IRON_SWORD, Items.GOLDEN_SWORD,
				Items.DIAMOND_SWORD, Items.NETHERITE_SWORD, EthernalKronuzModItems.BLADE_OF_THE_VOID_SETUP.get(), EthernalKronuzModItems.TERRA_BLADE_SETUP.get(), EthernalKronuzModItems.MURASAMA.get(), EthernalKronuzModItems.NOKKIA_HAMMER.get())
				.contains(item);
	}

	@Override
	public boolean isTreasureOnly() {
		return true;
	}

	@Override
	public boolean isDiscoverable() {
		return false;
	}
}
