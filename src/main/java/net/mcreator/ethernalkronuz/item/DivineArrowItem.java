
package net.mcreator.ethernalkronuz.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModTabs;
import net.minecraft.world.item.ArrowItem;

public class DivineArrowItem extends ArrowItem {
	public DivineArrowItem() {
		super(new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB).stacksTo(64).rarity(Rarity.COMMON));
	}

	
}
