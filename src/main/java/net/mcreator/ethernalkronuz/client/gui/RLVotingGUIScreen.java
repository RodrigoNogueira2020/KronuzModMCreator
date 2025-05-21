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

import java.util.UUID;
import java.util.Set;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class RLVotingGUIScreen extends AbstractContainerScreen<RLVotingGUIMenu> {
	private final Level world;
	private final Player entity;
	private final int x, y, z;
	private boolean finalized = false;
	private boolean forceVotingActive = true;
	// Textures
	private static final ResourceLocation texture = new ResourceLocation("ethernal_kronuz:textures/screens/rl_voting_gui.png");
	private static final ResourceLocation frameTexture = new ResourceLocation("ethernal_kronuz:textures/screens/faction_book_gui_frame.png");

	public RLVotingGUIScreen(RLVotingGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = inventory.player;
		this.imageWidth = 176;
		this.imageHeight = 166;
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
		this.blit(ms, this.leftPos + -50, this.topPos + -63, 0, 0, 288, 288, 288, 288);
		RenderSystem.disableBlend();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		long remaining = VoteManager.getRemainingTime();
		int seconds = (int) (remaining / 1000);
		int minutes = seconds / 60;
		int sec = seconds % 60;
		String timerText = String.format("§8Time remaining: %02d:%02d", minutes, sec);
		this.font.draw(poseStack, timerText, this.imageWidth - 110, 5, 0xFFFFFF);
		// Título da seção de votos dos não-RLs
		this.font.draw(poseStack, "§8Non-RL Votes:", 10, 30, 0xFFFFFF);
		// Título da seção de votos dos RLs
		this.font.draw(poseStack, "§8Your Vote:", 10, 120, 0xFFFFFF);
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
			// Reabre a GUI se tentarem fechar antes do tempo
			RLVotingGUIScreen newScreen = new RLVotingGUIScreen(this.menu, this.entity.getInventory(), new TextComponent("§8RL Voting"));
			Minecraft.getInstance().setScreen(newScreen);
			newScreen.init(minecraft, Minecraft.getInstance().getWindow().getGuiScaledWidth(), Minecraft.getInstance().getWindow().getGuiScaledHeight());
		}
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		if (!VoteManager.isVotingActive()) {
			VoteManager.startVoting(5 * 60 * 1000); // 5 minutos
		}
		int baseX = this.leftPos + 10;
		int baseY = this.topPos + 40;
		int buttonWidth = 120;
		int buttonHeight = 20;
		int spacingY = 25;
		int index = 0;
		// Mostrar votos dos não-RLs
		Map<UUID, Integer> nonRLVotes = VoteManager.getNonRLVotes();
		for (Map.Entry<UUID, Integer> entry : nonRLVotes.entrySet()) {
			for (Player player : world.players()) {
				if (player.getUUID().equals(entry.getKey())) {
					this.font.draw(new PoseStack(), player.getName().getString() + ": " + entry.getValue() + " votes", baseX, baseY + (index * spacingY), 0xFFFFFF);
					index++;
					break;
				}
			}
		}
		// Botões de voto para RLs
		baseY = this.topPos + 140;
		index = 0;
		for (Player player : world.players()) {
			boolean isRL = player.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).map(vars -> vars.RadiantLordRoxoPlayer || vars.RadiantLordVermelhoPlayer).orElse(false);
			if (!isRL) {
				UUID uuid = player.getUUID();
				Button voteButton = new Button(baseX, baseY + (index * spacingY), buttonWidth, buttonHeight, new TextComponent("Vote for " + player.getName().getString()), btn -> {
					VoteManager.addRLVote(entity, uuid);
					btn.setMessage(new TextComponent("Voted: " + player.getName().getString()));
					btn.active = false;
				});
				// Verifica se já votou neste jogador
				if (VoteManager.getRLVotes().getOrDefault(entity.getUUID(), null) == uuid) {
					voteButton.setMessage(new TextComponent("Voted: " + player.getName().getString()));
					voteButton.active = false;
				}
				this.addRenderableWidget(voteButton);
				index++;
			}
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
				// Escolher aleatoriamente entre os não-RLs
				List<UUID> candidates = new ArrayList<>();
				for (Player player : world.players()) {
					boolean isRL = player.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).map(vars -> vars.RadiantLordRoxoPlayer || vars.RadiantLordVermelhoPlayer).orElse(false);
					if (!isRL)
						candidates.add(player.getUUID());
				}
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
