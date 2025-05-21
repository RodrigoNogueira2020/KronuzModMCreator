package net.mcreator.ethernalkronuz.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.ethernalkronuz.world.inventory.RLVotingGUIMenu;
import net.mcreator.ethernalkronuz.procedures.RiseRadiantLordVerdeAfterTheRiseConfirmationProcedure;
import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.VoteManager;

import java.util.stream.Collectors;
import java.util.UUID;
import java.util.Set;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashSet;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class RLVotingGUIScreen extends AbstractContainerScreen<RLVotingGUIMenu> {
	private final Level world;
	private final Player entity;
	private final int x, y, z;
	private boolean finalized = false;
	private boolean forceVotingActive = true;
	private static final ResourceLocation texture = new ResourceLocation("ethernal_kronuz:textures/screens/rl_voting_gui.png");
	private static final ResourceLocation frameTexture = new ResourceLocation("ethernal_kronuz:textures/screens/faction_book_gui_frame.png");
	private static final int LEFT_PANEL_X = 20;
	private static final int RIGHT_PANEL_X = 180;
	private static final int PANEL_WIDTH = 150;
	private static final int HEADER_Y = 30;
	private static final int CONTENT_Y = 50;
	private static final int ROW_HEIGHT = 20;
	private static final int BUTTON_WIDTH = 120;
	private static final int BUTTON_HEIGHT = 20;

	public RLVotingGUIScreen(RLVotingGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = inventory.player;
		this.imageWidth = 350;
		this.imageHeight = 220;
	}

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.setShaderTexture(0, frameTexture);
		this.blit(ms, this.leftPos + -50, this.topPos + -63, 0, 0, 400, 300, 400, 300);
		RenderSystem.disableBlend();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		long remaining = VoteManager.getRemainingTime();
		int seconds = (int) (remaining / 1000);
		int minutes = seconds / 60;
		int sec = seconds % 60;
		String timerText = String.format("§8Time remaining: %02d:%02d", minutes, sec);
		this.font.draw(poseStack, timerText, this.imageWidth / 2 - this.font.width(timerText) / 2, 5, 0xFFFFFF);
		this.font.draw(poseStack, "§8Votes from Players", LEFT_PANEL_X, HEADER_Y, 0xFFFFFF);
		this.font.draw(poseStack, "§8Vote for Green RL", RIGHT_PANEL_X, HEADER_Y, 0xFFFFFF);
		Map<UUID, Integer> nonRLVotes = VoteManager.getNonRLVotes();
		List<Map.Entry<UUID, Integer>> sortedVotes = nonRLVotes.entrySet().stream().sorted(Map.Entry.<UUID, Integer>comparingByValue().reversed()).collect(Collectors.toList());
		int yPos = CONTENT_Y;
		for (Map.Entry<UUID, Integer> entry : sortedVotes) {
			for (Player player : world.players()) {
				if (player.getUUID().equals(entry.getKey())) {
					String voteText = player.getName().getString() + " - " + entry.getValue() + " vote" + (entry.getValue() != 1 ? "s" : "");
					this.font.draw(poseStack, voteText, LEFT_PANEL_X, yPos, 0xFFFFFF);
					yPos += ROW_HEIGHT;
					break;
				}
			}
			if (yPos > this.imageHeight - 30)
				break;
		}
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256 && forceVotingActive)
			return true;
		return super.keyPressed(key, b, c);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
		if (forceVotingActive) {
			RLVotingGUIScreen newScreen = new RLVotingGUIScreen(this.menu, this.entity.getInventory(), new TextComponent("§8RL Voting"));
			Minecraft.getInstance().setScreen(newScreen);
			newScreen.init(minecraft, Minecraft.getInstance().getWindow().getGuiScaledWidth(), Minecraft.getInstance().getWindow().getGuiScaledHeight());
		}
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		if (!VoteManager.isVotingActive())
			VoteManager.startVoting(5 * 60 * 1000);
		this.clearWidgets();
		int yPos = CONTENT_Y;
		List<Player> nonRLPlayers = world.players().stream().filter(p -> !p.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).map(vars -> vars.RadiantLordRoxoPlayer || vars.RadiantLordVermelhoPlayer).orElse(false))
				.collect(Collectors.toList());
		for (Player player : nonRLPlayers) {
			UUID uuid = player.getUUID();
			Button voteButton = new Button(this.leftPos + RIGHT_PANEL_X, this.topPos + yPos, BUTTON_WIDTH, BUTTON_HEIGHT, new TextComponent("Vote for " + player.getName().getString()), btn -> {
				VoteManager.addRLVote(entity, uuid);
				btn.setMessage(new TextComponent("✓ " + player.getName().getString()));
				btn.active = false;
			});
			if (VoteManager.getRLVotes().getOrDefault(entity.getUUID(), null) == uuid) {
				voteButton.setMessage(new TextComponent("✓ " + player.getName().getString()));
				voteButton.active = false;
			}
			this.addRenderableWidget(voteButton);
			yPos += ROW_HEIGHT;
			if (yPos > this.imageHeight - 50)
				break;
		}
	}

	@Override
	public void containerTick() {
		super.containerTick();
		if (!VoteManager.isVotingActive() && !finalized) {
			finalized = true;
			forceVotingActive = false;
			this.minecraft.player.closeContainer();
			Map<UUID, UUID> rlVotes = VoteManager.getRLVotes();
			Set<UUID> uniqueVotes = new HashSet<>(rlVotes.values());
			UUID chosen;
			if (uniqueVotes.size() == 1)
				chosen = uniqueVotes.iterator().next();
			else {
				List<UUID> candidates = world.players().stream().filter(p -> !p.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).map(vars -> vars.RadiantLordRoxoPlayer || vars.RadiantLordVermelhoPlayer).orElse(false))
						.map(Player::getUUID).collect(Collectors.toList());
				chosen = candidates.isEmpty() ? null : candidates.get(new Random().nextInt(candidates.size()));
			}
			if (chosen != null) {
				for (Player player : world.players()) {
					if (player.getUUID().equals(chosen)) {
						RiseRadiantLordVerdeAfterTheRiseConfirmationProcedure.execute(world, x, y, z, player);
						break;
					}
				}
				for (Player player : world.players())
					player.sendMessage(new TextComponent("§8[Radiant Lords] " + chosen + " was chosen as the new Green Radiant Lord."), player.getUUID());
			}
		}
	}

	@Override
	public boolean isPauseScreen() {
		return false;
	}
}
