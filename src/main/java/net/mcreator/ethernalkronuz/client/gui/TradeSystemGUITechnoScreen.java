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

import net.mcreator.ethernalkronuz.world.inventory.TradeSystemGUITechnoMenu;
import net.mcreator.ethernalkronuz.network.TradeSystemGUITechnoButtonMessage;
import net.mcreator.ethernalkronuz.EthernalKronuzMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.gui.components.ImageButton;

public class TradeSystemGUITechnoScreen extends AbstractContainerScreen<TradeSystemGUITechnoMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public TradeSystemGUITechnoScreen(TradeSystemGUITechnoMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 280;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("ethernal_kronuz:textures/screens/trade_system_gui_techno.png");
	private static final ResourceLocation tradeSystem = new ResourceLocation("ethernal_kronuz:textures/tradesystemtechnoicons.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("ethernal_kronuz:textures/trade_arrow.png"));
		this.blit(ms, this.leftPos + 151, this.topPos + 14, 0, 0, 71, 61, 71, 61);

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
		this.font.draw(poseStack, "Technobalde", 157, 7, -12829636);
		this.font.draw(poseStack, "Inventory", 111, 72, -12829636);
		this.font.draw(poseStack, "Trades", 39, 7, -12829636);
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
		this.addRenderableWidget(new ImageButton(this.leftPos + 4, this.topPos + 43, 16, 16, 0, 0, 0, tradeSystem, e -> {
         if (true) {
                EthernalKronuzMod.PACKET_HANDLER.sendToServer(new TradeSystemGUITechnoButtonMessage(0, x, y, z));
                TradeSystemGUITechnoButtonMessage.handleButtonAction(entity, 0, x, y, z); // button action = 0
            }

         ((ImageButton)e).setPosition(this.leftPos + 4, this.topPos + 43);
      }));

		this.addRenderableWidget(new ImageButton(this.leftPos + 40, this.topPos + 43, 16, 16, 0, 16, 0, tradeSystem, e -> {
         if (true) {
                EthernalKronuzMod.PACKET_HANDLER.sendToServer(new TradeSystemGUITechnoButtonMessage(1, x, y, z));
                TradeSystemGUITechnoButtonMessage.handleButtonAction(entity, 1, x, y, z); // button action = 0
            }

         ((ImageButton)e).setPosition(this.leftPos + 40, this.topPos + 43);
      }));

		this.addRenderableWidget(new ImageButton(this.leftPos + 76, this.topPos + 43, 16, 16, 0, 32, 0, tradeSystem, e -> {
         if (true) {
                EthernalKronuzMod.PACKET_HANDLER.sendToServer(new TradeSystemGUITechnoButtonMessage(2, x, y, z));
                TradeSystemGUITechnoButtonMessage.handleButtonAction(entity, 2, x, y, z); // button action = 0
            }

         ((ImageButton)e).setPosition(this.leftPos + 76, this.topPos + 43);
      }));

		this.addRenderableWidget(new ImageButton(this.leftPos + 4, this.topPos + 70, 16, 16, 0, 48, 0, tradeSystem, e -> {
         if (true) {
                EthernalKronuzMod.PACKET_HANDLER.sendToServer(new TradeSystemGUITechnoButtonMessage(3, x, y, z));
                TradeSystemGUITechnoButtonMessage.handleButtonAction(entity, 3, x, y, z); // button action = 0
            }

         ((ImageButton)e).setPosition(this.leftPos + 4, this.topPos + 70);
      }));

		this.addRenderableWidget(new ImageButton(this.leftPos + 40, this.topPos + 70, 16, 16, 0, 64, 0, tradeSystem, e -> {
         if (true) {
                EthernalKronuzMod.PACKET_HANDLER.sendToServer(new TradeSystemGUITechnoButtonMessage(4, x, y, z));
                TradeSystemGUITechnoButtonMessage.handleButtonAction(entity, 4, x, y, z); // button action = 0
            }

         ((ImageButton)e).setPosition(this.leftPos + 40, this.topPos + 70);
      }));

		this.addRenderableWidget(new ImageButton(this.leftPos + 76, this.topPos + 70, 16, 16, 0, 80, 0, tradeSystem, e -> {
         if (true) {
                EthernalKronuzMod.PACKET_HANDLER.sendToServer(new TradeSystemGUITechnoButtonMessage(5, x, y, z));
                TradeSystemGUITechnoButtonMessage.handleButtonAction(entity, 5, x, y, z); // button action = 0
            }

         ((ImageButton)e).setPosition(this.leftPos + 76, this.topPos + 70);
      }));

		this.addRenderableWidget(new ImageButton(this.leftPos + 4, this.topPos + 97, 16, 16, 0, 96, 0, tradeSystem, e -> {
         if (true) {
                EthernalKronuzMod.PACKET_HANDLER.sendToServer(new TradeSystemGUITechnoButtonMessage(6, x, y, z));
                TradeSystemGUITechnoButtonMessage.handleButtonAction(entity, 6, x, y, z); // button action = 0
            }

         ((ImageButton)e).setPosition(this.leftPos + 4, this.topPos + 97);
      }));

		this.addRenderableWidget(new ImageButton(this.leftPos + 40, this.topPos + 97, 16, 16, 0, 112, 0, tradeSystem, e -> {
         if (true) {
                EthernalKronuzMod.PACKET_HANDLER.sendToServer(new TradeSystemGUITechnoButtonMessage(7, x, y, z));
                TradeSystemGUITechnoButtonMessage.handleButtonAction(entity, 7, x, y, z); // button action = 0
            }

         ((ImageButton)e).setPosition(this.leftPos + 40, this.topPos + 97);
      }));

		this.addRenderableWidget(new ImageButton(this.leftPos + 76, this.topPos + 97, 16, 16, 0, 128, 0, tradeSystem, e -> {
         if (true) {
                EthernalKronuzMod.PACKET_HANDLER.sendToServer(new TradeSystemGUITechnoButtonMessage(8, x, y, z));
                TradeSystemGUITechnoButtonMessage.handleButtonAction(entity, 8, x, y, z); // button action = 0
            }

         ((ImageButton)e).setPosition(this.leftPos + 76, this.topPos + 97);
      }));
		
		this.addRenderableWidget(new ImageButton(this.leftPos + 4, this.topPos + 124, 16, 16, 0, 144, 0, tradeSystem, e -> {
         if (true) {
                EthernalKronuzMod.PACKET_HANDLER.sendToServer(new TradeSystemGUITechnoButtonMessage(9, x, y, z));
                TradeSystemGUITechnoButtonMessage.handleButtonAction(entity, 9, x, y, z); // button action = 0
            }

         ((ImageButton)e).setPosition(this.leftPos + 4, this.topPos + 124);
      }));

		this.addRenderableWidget(new ImageButton(this.leftPos + 40, this.topPos + 124, 16, 16, 0, 160, 0, tradeSystem, e -> {
         if (true) {
                EthernalKronuzMod.PACKET_HANDLER.sendToServer(new TradeSystemGUITechnoButtonMessage(10, x, y, z));
                TradeSystemGUITechnoButtonMessage.handleButtonAction(entity, 10, x, y, z); // button action = 0
            }

         ((ImageButton)e).setPosition(this.leftPos + 40, this.topPos + 124);
      }));

		this.addRenderableWidget(new ImageButton(this.leftPos + 76, this.topPos + 124, 16, 16, 0, 176, 0, tradeSystem, e -> {
         if (true) {
                EthernalKronuzMod.PACKET_HANDLER.sendToServer(new TradeSystemGUITechnoButtonMessage(11, x, y, z));
                TradeSystemGUITechnoButtonMessage.handleButtonAction(entity, 11, x, y, z); // button action = 0
            }

         ((ImageButton)e).setPosition(this.leftPos + 76, this.topPos + 124);
      }));
	}
}
