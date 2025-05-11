
package net.mcreator.ethernalkronuz.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.Minecraft;

import net.mcreator.ethernalkronuz.world.inventory.NonRLVotingGUIMenu;
import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class NonRLVotingGUIScreen extends AbstractContainerScreen<NonRLVotingGUIMenu> {
	private final static HashMap<String, Object> guistate = NonRLVotingGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox player1;
	Checkbox tete;
	Checkbox ete;
	Checkbox e;

	public NonRLVotingGUIScreen(NonRLVotingGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("ethernal_kronuz:textures/screens/non_rl_voting_gui.png");

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
		RenderSystem.setShaderTexture(0, new ResourceLocation("ethernal_kronuz:textures/screens/faction_book_gui_frame.png"));
		this.blit(ms, this.leftPos + -50, this.topPos + -63, 0, 0, 288, 288, 288, 288);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		int checkboxWidth = 120;
		int checkboxHeight = 20;
		int maxPerColumn = 4;
		int spacingX = 140;
		int spacingY = 25;
		int baseX = this.leftPos + 10;
		int baseY = this.topPos + 10;
		int column = 0;
		int row = 0;
		for (Player player : world.players()) {
			if (player.getUUID().equals(entity.getUUID())) {
				// Nome do próprio jogador (não votável)
				Checkbox selfCheckbox = new Checkbox(baseX + (column * spacingX), baseY + (row * spacingY), checkboxWidth, checkboxHeight, new TextComponent(player.getName().getString()), false);
				selfCheckbox.active = false;
				selfCheckbox.setAlpha(0.4f);
				this.addRenderableWidget(selfCheckbox);
			} else {
				// Ignorar jogadores Radiant Lords
				boolean isRL = player.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).map(vars -> vars.RadiantLordRoxoPlayer || vars.RadiantLordVermelhoPlayer).orElse(false);
				if (isRL)
					continue;
				Checkbox voteCheckbox = new Checkbox(baseX + (column * spacingX), baseY + (row * spacingY), checkboxWidth, checkboxHeight, new TextComponent(player.getName().getString()), false);
				voteCheckbox.setMessage(new TextComponent(player.getName().getString()));
				voteCheckbox.active = true;
				guistate.put("checkbox:" + player.getUUID().toString(), voteCheckbox);
				this.addRenderableWidget(voteCheckbox);
			}
			row++;
			if (row >= maxPerColumn) {
				row = 0;
				column++;
			}
		}
		// Botão de confirmar voto
		this.addRenderableWidget(new net.minecraft.client.gui.components.Button(baseX, baseY + (maxPerColumn * spacingY) + 10, 100, 20, new TextComponent("Confirm Vote"), button -> {
			for (Object obj : guistate.values()) {
				if (obj instanceof Checkbox checkbox) {
					checkbox.active = false;
				}
			}
			button.active = false;
			// Adiciona aqui a lógica de envio do voto ao servidor
		}));
	}
}
