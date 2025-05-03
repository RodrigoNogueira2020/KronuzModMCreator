
package net.mcreator.ethernalkronuz.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModTabs;

public class DivineCrystalShardItem extends Item {
	public DivineCrystalShardItem() {
		super(new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB).stacksTo(64).rarity(Rarity.RARE));
	}
}
