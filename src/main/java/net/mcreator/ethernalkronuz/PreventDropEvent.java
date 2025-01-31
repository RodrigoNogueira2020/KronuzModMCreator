package net.mcreator.ethernalkronuz;

import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

@Mod.EventBusSubscriber
public class PreventDropEvent {

    @SubscribeEvent
    public static void onItemToss(ItemTossEvent event) {
        if (event.getPlayer().isCreative())
            return;

        ItemStack droppedItem = event.getEntityItem().getItem();

        if (isRestrictedItem(droppedItem)) {
            event.setCanceled(true);
            event.getPlayer().getInventory().add(droppedItem);
        }
    }

    @SubscribeEvent
    public static void onContainerClose(PlayerContainerEvent.Close event) {
        Player player = event.getPlayer();

        if (player.isCreative())
            return;

        AbstractContainerMenu containerMenu = player.containerMenu;

        if (containerMenu != null) {
            for (Slot slot : containerMenu.slots) {
            	
                if (slot.hasItem()) {
                    ItemStack stack = slot.getItem();
                    
                    if (isRestrictedItem(stack)) {
                        slot.set(ItemStack.EMPTY);
                        player.getInventory().add(stack);
                    }
                }
            }
        }
    }

    private static boolean isRestrictedItem(ItemStack stack) {
        return stack.getItem() == EthernalKronuzModItems.TERRA_BLADE_SETUP.get() ||
               stack.getItem() == EthernalKronuzModItems.BLADE_OF_THE_VOID_SETUP.get() ||
               stack.getItem() == EthernalKronuzModItems.MURASAMA.get();
    }
}
