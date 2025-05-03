
package net.mcreator.ethernalkronuz.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModTabs;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModSounds;

import java.util.List;

public class SafiraItem extends RecordItem {
	public SafiraItem() {
		super(0, EthernalKronuzModSounds.REGISTRY.get(new ResourceLocation("ethernal_kronuz:safira")), new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB).stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Foi bug visual"));
	}
}
