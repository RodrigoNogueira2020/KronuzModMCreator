
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ethernalkronuz.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.ethernalkronuz.network.OpenConfirmRiseGUIMessage;
import net.mcreator.ethernalkronuz.network.NullTPAbilityMessage;
import net.mcreator.ethernalkronuz.network.NullEntityKeyBindMessage;
import net.mcreator.ethernalkronuz.network.NullEntityInvisibilityAbilityKeyBindMessage;
import net.mcreator.ethernalkronuz.network.GriffinUpMessage;
import net.mcreator.ethernalkronuz.network.GriffinDownMessage;
import net.mcreator.ethernalkronuz.network.GoToJotunheimRLKeyBindMessage;
import net.mcreator.ethernalkronuz.EthernalKronuzMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EthernalKronuzModKeyMappings {
	public static final KeyMapping NULL_ENTITY_KEY_BIND = new KeyMapping("key.ethernal_kronuz.null_entity_key_bind", GLFW.GLFW_KEY_Z, "key.categories.gameplay");
	public static final KeyMapping NULL_TP_ABILITY = new KeyMapping("key.ethernal_kronuz.null_tp_ability", GLFW.GLFW_KEY_X, "key.categories.gameplay");
	public static final KeyMapping NULL_ENTITY_INVISIBILITY_ABILITY_KEY_BIND = new KeyMapping("key.ethernal_kronuz.null_entity_invisibility_ability_key_bind", GLFW.GLFW_KEY_V, "key.categories.gameplay");
	public static final KeyMapping GRIFFIN_UP = new KeyMapping("key.ethernal_kronuz.griffin_up", GLFW.GLFW_KEY_Z, "key.categories.misc");
	public static final KeyMapping GRIFFIN_DOWN = new KeyMapping("key.ethernal_kronuz.griffin_down", GLFW.GLFW_KEY_C, "key.categories.misc");
	public static final KeyMapping OPEN_CONFIRM_RISE_GUI = new KeyMapping("key.ethernal_kronuz.open_confirm_rise_gui", GLFW.GLFW_KEY_F6, "key.categories.ui");
	public static final KeyMapping GO_TO_JOTUNHEIM_RL_KEY_BIND = new KeyMapping("key.ethernal_kronuz.go_to_jotunheim_rl_key_bind", GLFW.GLFW_KEY_HOME, "key.categories.ui");
	private static long GRIFFIN_UP_LASTPRESS = 0;
	private static long GRIFFIN_DOWN_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(NULL_ENTITY_KEY_BIND);
		ClientRegistry.registerKeyBinding(NULL_TP_ABILITY);
		ClientRegistry.registerKeyBinding(NULL_ENTITY_INVISIBILITY_ABILITY_KEY_BIND);
		ClientRegistry.registerKeyBinding(GRIFFIN_UP);
		ClientRegistry.registerKeyBinding(GRIFFIN_DOWN);
		ClientRegistry.registerKeyBinding(OPEN_CONFIRM_RISE_GUI);
		ClientRegistry.registerKeyBinding(GO_TO_JOTUNHEIM_RL_KEY_BIND);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == NULL_ENTITY_KEY_BIND.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						EthernalKronuzMod.PACKET_HANDLER.sendToServer(new NullEntityKeyBindMessage(0, 0));
						NullEntityKeyBindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == NULL_TP_ABILITY.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						EthernalKronuzMod.PACKET_HANDLER.sendToServer(new NullTPAbilityMessage(0, 0));
						NullTPAbilityMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == NULL_ENTITY_INVISIBILITY_ABILITY_KEY_BIND.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						EthernalKronuzMod.PACKET_HANDLER.sendToServer(new NullEntityInvisibilityAbilityKeyBindMessage(0, 0));
						NullEntityInvisibilityAbilityKeyBindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == GRIFFIN_UP.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						EthernalKronuzMod.PACKET_HANDLER.sendToServer(new GriffinUpMessage(0, 0));
						GriffinUpMessage.pressAction(Minecraft.getInstance().player, 0, 0);
						GRIFFIN_UP_LASTPRESS = System.currentTimeMillis();
					} else if (event.getAction() == GLFW.GLFW_RELEASE) {
						int dt = (int) (System.currentTimeMillis() - GRIFFIN_UP_LASTPRESS);
						EthernalKronuzMod.PACKET_HANDLER.sendToServer(new GriffinUpMessage(1, dt));
						GriffinUpMessage.pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
				if (event.getKey() == GRIFFIN_DOWN.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						EthernalKronuzMod.PACKET_HANDLER.sendToServer(new GriffinDownMessage(0, 0));
						GriffinDownMessage.pressAction(Minecraft.getInstance().player, 0, 0);
						GRIFFIN_DOWN_LASTPRESS = System.currentTimeMillis();
					} else if (event.getAction() == GLFW.GLFW_RELEASE) {
						int dt = (int) (System.currentTimeMillis() - GRIFFIN_DOWN_LASTPRESS);
						EthernalKronuzMod.PACKET_HANDLER.sendToServer(new GriffinDownMessage(1, dt));
						GriffinDownMessage.pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
				if (event.getKey() == OPEN_CONFIRM_RISE_GUI.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						EthernalKronuzMod.PACKET_HANDLER.sendToServer(new OpenConfirmRiseGUIMessage(0, 0));
						OpenConfirmRiseGUIMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == GO_TO_JOTUNHEIM_RL_KEY_BIND.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						EthernalKronuzMod.PACKET_HANDLER.sendToServer(new GoToJotunheimRLKeyBindMessage(0, 0));
						GoToJotunheimRLKeyBindMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
