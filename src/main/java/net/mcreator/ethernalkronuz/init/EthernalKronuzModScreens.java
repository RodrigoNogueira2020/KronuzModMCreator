
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ethernalkronuz.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.ethernalkronuz.client.gui.TradeSystemGUITechnoScreen;
import net.mcreator.ethernalkronuz.client.gui.SuperBackPackGUIScreen;
import net.mcreator.ethernalkronuz.client.gui.GUIFactionBookScreen;
import net.mcreator.ethernalkronuz.client.gui.ConfirmRiseGUIVermelhoScreen;
import net.mcreator.ethernalkronuz.client.gui.ConfirmRiseGUIVerdeScreen;
import net.mcreator.ethernalkronuz.client.gui.ConfirmRiseGUIRoxoScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class EthernalKronuzModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(EthernalKronuzModMenus.GUI_FACTION_BOOK, GUIFactionBookScreen::new);
			MenuScreens.register(EthernalKronuzModMenus.TRADE_SYSTEM_GUI_TECHNO, TradeSystemGUITechnoScreen::new);
			MenuScreens.register(EthernalKronuzModMenus.SUPER_BACK_PACK_GUI, SuperBackPackGUIScreen::new);
			MenuScreens.register(EthernalKronuzModMenus.CONFIRM_RISE_GUI_ROXO, ConfirmRiseGUIRoxoScreen::new);
			MenuScreens.register(EthernalKronuzModMenus.CONFIRM_RISE_GUI_VERMELHO, ConfirmRiseGUIVermelhoScreen::new);
			MenuScreens.register(EthernalKronuzModMenus.CONFIRM_RISE_GUI_VERDE, ConfirmRiseGUIVerdeScreen::new);
		});
	}
}
