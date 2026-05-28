package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.Util;

public class RadiantLordPurpleTrialThisEntityKillsAnotherOneProcedure {
	public static void execute(LevelAccessor world) {
		if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY) == true) {
			if (world instanceof Level _level)
				_level.getGameRules().getRule(GameRules.RULE_KEEPINVENTORY).set((false), _level.getServer());
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastMessage(new TextComponent("Keep Inventory: False (Player Died)"), ChatType.SYSTEM, Util.NIL_UUID);
			}
		}
	}
}
