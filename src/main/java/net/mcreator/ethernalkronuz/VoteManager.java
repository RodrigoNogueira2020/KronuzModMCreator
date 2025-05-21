/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.ethernalkronuz as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.ethernalkronuz;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class VoteManager {
	private static final Map<UUID, Integer> nonRLVotes = new HashMap<>();
	private static final Map<UUID, UUID> rlVotes = new HashMap<>();
	private static long votingEndTime = 0;

	public static void startVoting(long duration) {
		nonRLVotes.clear();
		rlVotes.clear();
		votingEndTime = System.currentTimeMillis() + duration;
	}

	public static void addNonRLVote(Player voter, UUID votedFor) {
		if (System.currentTimeMillis() > votingEndTime)
			return;
		nonRLVotes.put(votedFor, nonRLVotes.getOrDefault(votedFor, 0) + 1);
		for (Player player : voter.level.players()) {
			boolean isRL = player.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).map(vars -> vars.RadiantLordRoxoPlayer || vars.RadiantLordVermelhoPlayer).orElse(false);
			if (isRL && player instanceof ServerPlayer serverPlayer)
				serverPlayer.sendMessage(new TextComponent("§8[Voting] New vote for " + votedFor), serverPlayer.getUUID());
		}
	}

	public static void addRLVote(Player rlPlayer, UUID votedFor) {
		if (System.currentTimeMillis() > votingEndTime)
			return;
		rlVotes.put(rlPlayer.getUUID(), votedFor);
	}

	public static Map<UUID, Integer> getNonRLVotes() {
		return Collections.unmodifiableMap(nonRLVotes);
	}

	public static Map<UUID, UUID> getRLVotes() {
		return Collections.unmodifiableMap(rlVotes);
	}

	public static long getRemainingTime() {
		return Math.max(0, votingEndTime - System.currentTimeMillis());
	}

	public static boolean isVotingActive() {
		return System.currentTimeMillis() <= votingEndTime;
	}
}
