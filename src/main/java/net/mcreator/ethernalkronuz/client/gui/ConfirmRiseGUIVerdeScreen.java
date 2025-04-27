
package net.mcreator.ethernalkronuz.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.ethernalkronuz.world.inventory.ConfirmRiseGUIVerdeMenu;
import net.mcreator.ethernalkronuz.network.ConfirmRiseGUIVerdeButtonMessage;
import net.mcreator.ethernalkronuz.EthernalKronuzMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ConfirmRiseGUIVerdeScreen extends AbstractContainerScreen<ConfirmRiseGUIVerdeMenu> {
	private final static HashMap<String, Object> guistate = ConfirmRiseGUIVerdeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_rise;
	Button button_wait;
	ImageButton imagebutton_faction_book_gui_frame;

	public ConfirmRiseGUIVerdeScreen(ConfirmRiseGUIVerdeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("ethernal_kronuz:textures/screens/confirm_rise_gui_verde.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_confirm_the_rise"), -20, -2, -16777216);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_became_a"), -29, 34, -16777216);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_radiant_lord"), 15, 34, -16738048);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_able_to_fly"), -29, 61, -16777216);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_special_tool"), -29, 79, -16777216);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_special_armor"), -29, 97, -16777216);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_special_display_name"), -29, 115, -16777216);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_double_health"), -29, 133, -16777216);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_atention"), 141, -2, -65536);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_remove_your_current"), 105, 7, -16777216);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_armor_before_the_rise"), 105, 16, -16777216);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_or_your_armor_will_be"), 105, 25, -16777216);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_overwritten"), 105, 34, -3407872);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_begin_the_rise"), 123, 142, -16738048);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_you_will_be_teleported_to_the_tr"), 105, 52, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_to_the_trial_to_claim_your_posit"), 105, 61, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_your_position_as_radiant_lord"), 105, 70, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_radiant_lord_are_you_really_rea"), 105, 79, -16738048);
		this.font.draw(poseStack, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.label_are_you_really_ready"), 105, 106, -12829636);
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
		button_rise = new Button(this.leftPos + 240, this.topPos + 88, 46, 20, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.button_rise"), e -> {
			if (true) {
				EthernalKronuzMod.PACKET_HANDLER.sendToServer(new ConfirmRiseGUIVerdeButtonMessage(0, x, y, z));
				ConfirmRiseGUIVerdeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_rise", button_rise);
		this.addRenderableWidget(button_rise);
		button_wait = new Button(this.leftPos + 240, this.topPos + 115, 46, 20, new TranslatableComponent("gui.ethernal_kronuz.confirm_rise_gui_verde.button_wait"), e -> {
			if (true) {
				EthernalKronuzMod.PACKET_HANDLER.sendToServer(new ConfirmRiseGUIVerdeButtonMessage(1, x, y, z));
				ConfirmRiseGUIVerdeButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_wait", button_wait);
		this.addRenderableWidget(button_wait);
		imagebutton_faction_book_gui_frame = new ImageButton(this.leftPos + -47, this.topPos + -65, 288, 288, 0, 0, 288, new ResourceLocation("ethernal_kronuz:textures/screens/atlas/imagebutton_faction_book_gui_frame.png"), 288, 576, e -> {
		});
		guistate.put("button:imagebutton_faction_book_gui_frame", imagebutton_faction_book_gui_frame);
		this.addRenderableWidget(imagebutton_faction_book_gui_frame);
	}
}
