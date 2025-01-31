package net.mcreator.ethernalkronuz;

import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

@Mod.EventBusSubscriber
public class PreventDropEvent {

    @SubscribeEvent
    public static void onItemToss(ItemTossEvent event) {
        ItemStack droppedItem = event.getEntityItem().getItem();

        if (droppedItem.getItem() == EthernalKronuzModItems.TERRA_BLADE_SETUP.get() || 
        	droppedItem.getItem() == EthernalKronuzModItems.BLADE_OF_THE_VOID_SETUP.get() || 
        	droppedItem.getItem() == EthernalKronuzModItems.MURASAMA.get()) {
	            event.setCanceled(true);
	            event.getPlayer().getInventory().add(droppedItem);
        }
    }
}