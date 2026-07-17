
package net.mcreator.ethernalkronuz.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.ethernalkronuz.world.inventory.GoToJotunheimRLGUIMenu;
import net.mcreator.ethernalkronuz.network.GoToJotunheimRLGUIButtonMessage;
import net.mcreator.ethernalkronuz.EthernalKronuzMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class GoToJotunheimRLGUIScreen extends AbstractContainerScreen<GoToJotunheimRLGUIMenu> {
	private final static HashMap<String, Object> guistate = GoToJotunheimRLGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_yes;
	Button button_no;

	public GoToJotunheimRLGUIScreen(GoToJotunheimRLGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("ethernal_kronuz:textures/screens/go_to_jotunheim_rlgui.png");

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
		this.blit(ms, this.leftPos + -47, this.topPos + -56, 0, 0, 288, 288, 288, 288);

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
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.go_to_jotunheim_rlgui.label_teleport_to_jotunheim"), -29, 79, -16777216);
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
		button_yes = new Button(this.leftPos + 141, this.topPos + 34, 40, 20, new TranslatableComponent("gui.ethernal_kronuz.go_to_jotunheim_rlgui.button_yes"), e -> {
			if (true) {
				EthernalKronuzMod.PACKET_HANDLER.sendToServer(new GoToJotunheimRLGUIButtonMessage(0, x, y, z));
				GoToJotunheimRLGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_yes", button_yes);
		this.addRenderableWidget(button_yes);
		button_no = new Button(this.leftPos + 141, this.topPos + 88, 35, 20, new TranslatableComponent("gui.ethernal_kronuz.go_to_jotunheim_rlgui.button_no"), e -> {
			if (true) {
				EthernalKronuzMod.PACKET_HANDLER.sendToServer(new GoToJotunheimRLGUIButtonMessage(1, x, y, z));
				GoToJotunheimRLGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_no", button_no);
		this.addRenderableWidget(button_no);
	}
}
