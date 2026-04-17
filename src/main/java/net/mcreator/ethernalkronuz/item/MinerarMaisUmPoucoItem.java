
package net.mcreator.ethernalkronuz.item;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModTabs;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModSounds;

public class MinerarMaisUmPoucoItem extends RecordItem {
	public MinerarMaisUmPoucoItem() {
		super(0, EthernalKronuzModSounds.REGISTRY.get(new ResourceLocation("ethernal_kronuz:minerar_mais_um_pouco")), new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB).stacksTo(1).rarity(Rarity.RARE));
	}
}
