
package net.mcreator.ethernalkronuz.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModTabs;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModFluids;

public class CristalizedDivineWaterItem extends BucketItem {
	public CristalizedDivineWaterItem() {
		super(EthernalKronuzModFluids.CRISTALIZED_DIVINE_WATER, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.RARE).tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB));
	}
}
