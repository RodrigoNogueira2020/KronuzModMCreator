
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
import net.mcreator.ethernalkronuz.world.inventory.GUIFactionBookMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EthernalKronuzModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<GUIFactionBookMenu> GUI_FACTION_BOOK = register("gui_faction_book", (id, inv, extraData) -> new GUIFactionBookMenu(id, inv, extraData));
	public static final MenuType<TradeSystemGUITechnoMenu> TRADE_SYSTEM_GUI_TECHNO = register("trade_system_gui_techno", (id, inv, extraData) -> new TradeSystemGUITechnoMenu(id, inv, extraData));
	public static final MenuType<SuperBackPackGUIMenu> SUPER_BACK_PACK_GUI = register("super_back_pack_gui", (id, inv, extraData) -> new SuperBackPackGUIMenu(id, inv, extraData));

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
