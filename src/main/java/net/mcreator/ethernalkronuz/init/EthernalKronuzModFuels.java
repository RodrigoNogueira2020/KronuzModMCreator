
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ethernalkronuz.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber
public class EthernalKronuzModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == EthernalKronuzModBlocks.YGG_LOG.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == EthernalKronuzModBlocks.STRIPPED_YGG_LOG.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == EthernalKronuzModBlocks.YGG_PLANKS.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == EthernalKronuzModBlocks.YGG_DOOR.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == EthernalKronuzModBlocks.YGG_TRAPDOOR.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == EthernalKronuzModBlocks.YGG_WOOD_SAPPLING.get().asItem())
			event.setBurnTime(200);
		else if (itemstack.getItem() == EthernalKronuzModBlocks.YGG_STAIRS.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == EthernalKronuzModBlocks.YGG_FENCES.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == EthernalKronuzModBlocks.YGG_LEAVES.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == EthernalKronuzModBlocks.STRIPPED_YGG_LOG.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == EthernalKronuzModBlocks.YGG_SLABS.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == EthernalKronuzModBlocks.YGG_GATE.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == EthernalKronuzModBlocks.YGG_PRESURE_PLATE.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == EthernalKronuzModBlocks.YGG_BUTTON.get().asItem())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == EthernalKronuzModBlocks.YGG_WOOD.get().asItem())
			event.setBurnTime(1600);
	}
}
