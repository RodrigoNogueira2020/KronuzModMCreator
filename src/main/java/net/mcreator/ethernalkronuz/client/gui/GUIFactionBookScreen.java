
package net.mcreator.ethernalkronuz.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.Minecraft;

import net.mcreator.ethernalkronuz.world.inventory.GUIFactionBookMenu;
import net.mcreator.ethernalkronuz.network.GUIFactionBookButtonMessage;
import net.mcreator.ethernalkronuz.EthernalKronuzMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class GUIFactionBookScreen extends AbstractContainerScreen<GUIFactionBookMenu> {
	private final static HashMap<String, Object> guistate = GUIFactionBookMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_adc_button;
	ImageButton imagebutton_bt_button;

	public GUIFactionBookScreen(GUIFactionBookMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 1;
		this.imageHeight = 1;
	}

	private static final ResourceLocation texture = new ResourceLocation("ethernal_kronuz:textures/screens/gui_faction_book.png");

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
		this.blit(ms, this.leftPos + -135, this.topPos + -146, 0, 0, 288, 288, 288, 288);

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
		imagebutton_adc_button = new ImageButton(this.leftPos + -124, this.topPos + -75, 128, 128, 0, 0, 128,
								new ResourceLocation("ethernal_kronuz:textures/screens/atlas/imagebutton_adc_button.png"), 128, 256, e -> {
			if (true) {
				EthernalKronuzMod.PACKET_HANDLER.sendToServer(new GUIFactionBookButtonMessage(0, x, y, z));
				GUIFactionBookButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_adc_button", imagebutton_adc_button);
		this.addRenderableWidget(imagebutton_adc_button);
		imagebutton_bt_button = new ImageButton(this.leftPos + 10, this.topPos + -75, 128, 128, 0, 0, 128,
								new ResourceLocation("ethernal_kronuz:textures/screens/atlas/imagebutton_bt_button.png"), 128, 256, e -> {
			if (true) {
				EthernalKronuzMod.PACKET_HANDLER.sendToServer(new GUIFactionBookButtonMessage(1, x, y, z));
				GUIFactionBookButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_bt_button", imagebutton_bt_button);
		this.addRenderableWidget(imagebutton_bt_button);
	}
}
