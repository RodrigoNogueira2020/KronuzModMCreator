
package net.mcreator.ethernalkronuz.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModTabs;

public class YggWoodStickItem extends Item {
	public YggWoodStickItem() {
		super(new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB).stacksTo(64).rarity(Rarity.COMMON));
	}
}
