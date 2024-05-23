
package net.mcreator.ethernalkronuz.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.ethernalkronuz.world.inventory.TradeSystemGUITechnoMenu;
import net.mcreator.ethernalkronuz.procedures.Trade9Procedure;
import net.mcreator.ethernalkronuz.procedures.Trade8Procedure;
import net.mcreator.ethernalkronuz.procedures.Trade7Procedure;
import net.mcreator.ethernalkronuz.procedures.Trade6Procedure;
import net.mcreator.ethernalkronuz.procedures.Trade5Procedure;
import net.mcreator.ethernalkronuz.procedures.Trade4Procedure;
import net.mcreator.ethernalkronuz.procedures.Trade3Procedure;
import net.mcreator.ethernalkronuz.procedures.Trade2Procedure;
import net.mcreator.ethernalkronuz.procedures.Trade1Procedure;
import net.mcreator.ethernalkronuz.procedures.Trade12Procedure;
import net.mcreator.ethernalkronuz.procedures.Trade11Procedure;
import net.mcreator.ethernalkronuz.procedures.Trade10Procedure;
import net.mcreator.ethernalkronuz.EthernalKronuzMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TradeSystemGUITechnoButtonMessage {
	private final int buttonID, x, y, z;

	public TradeSystemGUITechnoButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public TradeSystemGUITechnoButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(TradeSystemGUITechnoButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(TradeSystemGUITechnoButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = TradeSystemGUITechnoMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Trade1Procedure.execute(entity);
		}
		if (buttonID == 1) {

			Trade2Procedure.execute(entity);
		}
		if (buttonID == 2) {

			Trade3Procedure.execute(entity);
		}
		if (buttonID == 3) {

			Trade4Procedure.execute(entity);
		}
		if (buttonID == 4) {

			Trade5Procedure.execute(entity);
		}
		if (buttonID == 5) {

			Trade6Procedure.execute(entity);
		}
		if (buttonID == 6) {

			Trade7Procedure.execute(entity);
		}
		if (buttonID == 7) {

			Trade8Procedure.execute(entity);
		}
		if (buttonID == 8) {

			Trade9Procedure.execute(entity);
		}
		if (buttonID == 9) {

			Trade10Procedure.execute(entity);
		}
		if (buttonID == 10) {

			Trade11Procedure.execute(entity);
		}
		if (buttonID == 11) {

			Trade12Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		EthernalKronuzMod.addNetworkMessage(TradeSystemGUITechnoButtonMessage.class, TradeSystemGUITechnoButtonMessage::buffer, TradeSystemGUITechnoButtonMessage::new, TradeSystemGUITechnoButtonMessage::handler);
	}
}
