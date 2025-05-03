package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ethernalkronuz.world.inventory.ConfirmRiseGUIVermelhoMenu;
import net.mcreator.ethernalkronuz.world.inventory.ConfirmRiseGUIVerdeMenu;
import net.mcreator.ethernalkronuz.world.inventory.ConfirmRiseGUIRoxoMenu;

public class CloseConfirmRiseGUIProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _plr ? _plr.containerMenu instanceof ConfirmRiseGUIRoxoMenu : false) {
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
		if (entity instanceof Player _plr ? _plr.containerMenu instanceof ConfirmRiseGUIVermelhoMenu : false) {
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
		if (entity instanceof Player _plr ? _plr.containerMenu instanceof ConfirmRiseGUIVerdeMenu : false) {
			if (entity instanceof Player _player)
				_player.closeContainer();
		}
	}
}
