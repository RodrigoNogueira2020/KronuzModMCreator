
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ethernalkronuz.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.ethernalkronuz.world.inventory.TradeSystemGUITechnoMenu;
import net.mcreator.ethernalkronuz.world.inventory.SuperBackPackGUIMenu;
import net.mcreator.ethernalkronuz.world.inventory.GoToJotunheimRLGUIMenu;
import net.mcreator.ethernalkronuz.world.inventory.GetOutJotunheimRLGUIMenu;
import net.mcreator.ethernalkronuz.world.inventory.GUIFactionBookMenu;
import net.mcreator.ethernalkronuz.world.inventory.ConfirmRiseGUIVermelhoMenu;
import net.mcreator.ethernalkronuz.world.inventory.ConfirmRiseGUIVerdeMenu;
import net.mcreator.ethernalkronuz.world.inventory.ConfirmRiseGUIRoxoMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EthernalKronuzModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<GUIFactionBookMenu> GUI_FACTION_BOOK = register("gui_faction_book", (id, inv, extraData) -> new GUIFactionBookMenu(id, inv, extraData));
	public static final MenuType<TradeSystemGUITechnoMenu> TRADE_SYSTEM_GUI_TECHNO = register("trade_system_gui_techno", (id, inv, extraData) -> new TradeSystemGUITechnoMenu(id, inv, extraData));
	public static final MenuType<SuperBackPackGUIMenu> SUPER_BACK_PACK_GUI = register("super_back_pack_gui", (id, inv, extraData) -> new SuperBackPackGUIMenu(id, inv, extraData));
	public static final MenuType<ConfirmRiseGUIRoxoMenu> CONFIRM_RISE_GUI_ROXO = register("confirm_rise_gui_roxo", (id, inv, extraData) -> new ConfirmRiseGUIRoxoMenu(id, inv, extraData));
	public static final MenuType<ConfirmRiseGUIVermelhoMenu> CONFIRM_RISE_GUI_VERMELHO = register("confirm_rise_gui_vermelho", (id, inv, extraData) -> new ConfirmRiseGUIVermelhoMenu(id, inv, extraData));
	public static final MenuType<ConfirmRiseGUIVerdeMenu> CONFIRM_RISE_GUI_VERDE = register("confirm_rise_gui_verde", (id, inv, extraData) -> new ConfirmRiseGUIVerdeMenu(id, inv, extraData));
	public static final MenuType<GoToJotunheimRLGUIMenu> GO_TO_JOTUNHEIM_RLGUI = register("go_to_jotunheim_rlgui", (id, inv, extraData) -> new GoToJotunheimRLGUIMenu(id, inv, extraData));
	public static final MenuType<GetOutJotunheimRLGUIMenu> GET_OUT_JOTUNHEIM_RLGUI = register("get_out_jotunheim_rlgui", (id, inv, extraData) -> new GetOutJotunheimRLGUIMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
