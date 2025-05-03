
package net.mcreator.ethernalkronuz.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.SlotContext;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.ethernalkronuz.procedures.TheEndingEyeBaubleIsUnequippedProcedure;
import net.mcreator.ethernalkronuz.procedures.TheEndingEyeBaubleIsEquippedProcedure;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModTabs;

import java.util.List;

public class TheEndingEyeItem extends Item implements ICurioItem {
	public TheEndingEyeItem() {
		super(new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB).stacksTo(1).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public boolean makesPiglinsNeutral(SlotContext slotContext, ItemStack stack) {
		return true;
	}

	@Override
	public boolean isEnderMask(SlotContext slotContext, EnderMan enderMan, ItemStack stack) {
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Open the Third Eye"));
	}

	@Override
	public void curioTick(SlotContext slotContext, ItemStack stack) {
		TheEndingEyeBaubleIsEquippedProcedure.execute(slotContext.entity());
	}

	@Override
	public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
		TheEndingEyeBaubleIsUnequippedProcedure.execute(slotContext.entity());
	}
}
