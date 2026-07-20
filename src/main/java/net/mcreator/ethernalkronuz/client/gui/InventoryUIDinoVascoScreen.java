package net.mcreator.ethernalkronuz.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.ethernalkronuz.world.inventory.InventoryUIDinoVascoMenu;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class InventoryUIDinoVascoScreen extends AbstractContainerScreen<InventoryUIDinoVascoMenu> {
	private final static HashMap<String, Object> guistate = InventoryUIDinoVascoMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public InventoryUIDinoVascoScreen(InventoryUIDinoVascoMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("ethernal_kronuz:textures/screens/inventory_ui_dino_vasco.png");
	private static final int[][] SLOT_POSITIONS = {{53, 21}, // HEAD
			{53, 48}, // CHEST
			{107, 21}, // LEGS
			{107, 48}, // FEET
			{34, 35}, // MAINHAND
	};

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
		RenderSystem.disableBlend();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		for (int[] pos : SLOT_POSITIONS) {
			int sx = this.leftPos + pos[0];
			int sy = this.topPos + pos[1];
			fill(ms, sx, sy, sx + 16, sy + 16, 0xFF8B8B8B);
			fill(ms, sx, sy, sx + 16, sy + 1, 0xFF373737);
			fill(ms, sx, sy, sx + 1, sy + 16, 0xFF373737);
			fill(ms, sx, sy + 15, sx + 16, sy + 16, 0xFFFFFFFF);
			fill(ms, sx + 15, sy, sx + 16, sy + 16, 0xFFFFFFFF);
		}
		if (menu.dinoEntity != null) {
			net.minecraft.network.chat.Component savedName = menu.dinoEntity.getCustomName();
			menu.dinoEntity.setCustomName(null);
			menu.dinoEntity.setCustomNameVisible(false);
			InventoryScreen.renderEntityInInventory(this.leftPos + 88, this.topPos + 75, 25, (float) (this.leftPos + 88) - mouseX, (float) (this.topPos + 45) - mouseY, menu.dinoEntity);
			menu.dinoEntity.setCustomName(savedName);
			menu.dinoEntity.setCustomNameVisible(true);
		}
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
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
	}
}
