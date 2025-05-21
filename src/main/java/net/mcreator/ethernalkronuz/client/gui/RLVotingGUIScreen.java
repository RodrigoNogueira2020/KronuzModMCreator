package net.mcreator.ethernalkronuz.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;

import net.mcreator.ethernalkronuz.world.inventory.RLVotingGUIMenu;
import net.mcreator.ethernalkronuz.procedures.RiseRadiantLordVerdeAfterTheRiseConfirmationProcedure;
import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;

import java.util.UUID;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import com.mojang.blaze3d.vertex.PoseStack;

public class RLVotingGUIScreen extends AbstractContainerScreen<RLVotingGUIMenu> {
	private final Level world;
	private final Player entity;
	private final int x, y, z;
	private UUID rl1Vote = null;
	private UUID rl2Vote = null;
	private long votingEndTime = 0;
	private boolean finalized = false;
	private final List<UUID> votablePlayers = new ArrayList<>();

	public RLVotingGUIScreen(RLVotingGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = inventory.player;
	}

	@Override
	public void init() {
		super.init();
		this.votingEndTime = System.currentTimeMillis() + (5 * 60 * 1000); // 5 minutes
		int rightBaseX = this.leftPos + 200;
		int rightBaseY = this.topPos + 10;
		int buttonWidth = 100;
		int buttonHeight = 20;
		int spacingY = 25;
		int index = 0;
		for (Player player : world.players()) {
			boolean isRL = player.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).map(vars -> vars.RadiantLordRoxoPlayer || vars.RadiantLordVermelhoPlayer).orElse(false);
			if (!isRL) {
				UUID uuid = player.getUUID();
				votablePlayers.add(uuid);
				Button voteButtonRL1 = new Button(rightBaseX, rightBaseY + (index * spacingY), buttonWidth, buttonHeight, new TextComponent("RL1: " + player.getName().getString()), btn -> {
					rl1Vote = uuid;
					btn.setMessage(new TextComponent("RL1: " + player.getName().getString()));
				});
				Button voteButtonRL2 = new Button(rightBaseX + buttonWidth + 10, rightBaseY + (index * spacingY), buttonWidth, buttonHeight, new TextComponent("RL2: " + player.getName().getString()), btn -> {
					rl2Vote = uuid;
					btn.setMessage(new TextComponent("RL2: " + player.getName().getString()));
				});
				this.addRenderableWidget(voteButtonRL1);
				this.addRenderableWidget(voteButtonRL2);
				index++;
			}
		}
	}

	@Override
	public void containerTick() {
		super.containerTick();
		if (!finalized && System.currentTimeMillis() >= votingEndTime) {
			finalized = true;
			this.minecraft.player.closeContainer();
			UUID chosen;
			if (rl1Vote != null && rl1Vote.equals(rl2Vote)) {
				chosen = rl1Vote;
			} else if (!votablePlayers.isEmpty()) {
				chosen = votablePlayers.get(new Random().nextInt(votablePlayers.size()));
			} else {
				chosen = null;
			}
			if (chosen != null) {
				for (Player player : world.players()) {
					if (player.getUUID().equals(chosen)) {
						RiseRadiantLordVerdeAfterTheRiseConfirmationProcedure.execute(world, x, y, z, player);
						break;
					}
				}
				for (Player player : world.players()) {
					player.sendMessage(new TextComponent("§8[Radiant Lords] " + chosen + " foi escolhido como o novo Radiant Lord Verde."), player.getUUID());
				}
			}
		}
	}

	@Override
	protected void renderBg(PoseStack poseStack, float partialTicks, int gx, int gy) {
		// Placeholder de fundo, podes pôr a textura da GUI se quiseres
	}

	@Override
	public boolean isPauseScreen() {
		return false;
	}
}
