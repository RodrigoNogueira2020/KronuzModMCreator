package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.Util;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class RadiantLordVerdeProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (!(EthernalKronuzModVariables.MapVariables.get(world).RadiantLordVerde && (((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordRoxoPlayer || ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordVerdePlayer || ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "name");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordVermelhoPlayer))) {
			Entity targetEntity = (new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "name");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity());

			if (targetEntity instanceof Player) {
				Player player = (Player) targetEntity;
				
				boolean isArmorOccupied = false;
				for (int i = 0; i < 4; i++) {
					if (!player.getInventory().armor.get(i).isEmpty()) {
						isArmorOccupied = true;
						break;
					}
				}

				if (isArmorOccupied) {
					if (!world.isClientSide()) {
						MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
						if (_mcserv != null)
							_mcserv.getPlayerList().broadcastMessage(new TextComponent("Desequipar armadura atual!"), ChatType.SYSTEM, Util.NIL_UUID);
					}
					return;
				}

				{
					boolean _setval = true;
					player.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.RadiantLordVerdePlayer = _setval;
						capability.syncPlayerVariables(player);
					});
				}
				EthernalKronuzModVariables.MapVariables.get(world).RadiantLordVerde = true;
				EthernalKronuzModVariables.MapVariables.get(world).syncData(world);
				{
					boolean _setval = true;
					player.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IsRadiantLord = _setval;
						capability.syncPlayerVariables(player);
					});
				}
				{
					boolean _setval = true;
					player.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.AllowInJotunheim = _setval;
						capability.syncPlayerVariables(player);
					});
				}
				GiveRadiantLordEffectsProcedure.execute(world, x, y, z, entity);
				player.setCustomName(new TextComponent("\u00A7aTitan Kaleb"));
				ItemStack _setstack = new ItemStack(EthernalKronuzModItems.TERRA_BLADE_SETUP.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(player, _setstack);
				_setstack = new ItemStack(EthernalKronuzModItems.JOTUNHEIM.get());
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(player, _setstack);

				player.getInventory().armor.set(3, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_HELMET.get()));
				player.getInventory().armor.set(2, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_CHESTPLATE.get()));
				player.getInventory().armor.set(1, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_LEGGINGS.get()));
				player.getInventory().armor.set(0, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_BOOTS.get()));
				player.getInventory().setChanged();

				for (int index0 = 0; index0 < 5; index0++) {
					if (!world.isClientSide()) {
						MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
						if (_mcserv != null)
							_mcserv.getPlayerList().broadcastMessage(new TextComponent("The Titan Kaleb is AMONGUS!"), ChatType.SYSTEM, Util.NIL_UUID);
					}
				}
			}
		}
	}
}