
package net.mcreator.ethernalkronuz.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.ethernalkronuz.world.inventory.GoToJotunheimRLGUIMenu;
import net.mcreator.ethernalkronuz.procedures.GoToJotunheimRLYesButtonProcedure;
import net.mcreator.ethernalkronuz.procedures.GoToJotunheimRLNoButtonProcedure;
import net.mcreator.ethernalkronuz.EthernalKronuzMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class GoToJotunheimRLGUIButtonMessage {
	private final int buttonID, x, y, z;

	public GoToJotunheimRLGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public GoToJotunheimRLGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(GoToJotunheimRLGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(GoToJotunheimRLGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = GoToJotunheimRLGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			GoToJotunheimRLYesButtonProcedure.execute(world, entity);
		}
		if (buttonID == 1) {

			GoToJotunheimRLNoButtonProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EthernalKronuzMod.addNetworkMessage(GoToJotunheimRLGUIButtonMessage.class, GoToJotunheimRLGUIButtonMessage::buffer, GoToJotunheimRLGUIButtonMessage::new, GoToJotunheimRLGUIButtonMessage::handler);
	}
}
