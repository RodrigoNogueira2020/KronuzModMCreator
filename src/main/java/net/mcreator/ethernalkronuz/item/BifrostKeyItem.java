
package net.mcreator.ethernalkronuz.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModTabs;

import java.util.List;

public class BifrostKeyItem extends Item implements ICurioItem {
	public BifrostKeyItem() {
		super(new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB).stacksTo(1).rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Key to the Jotunhein"));
	}
}
