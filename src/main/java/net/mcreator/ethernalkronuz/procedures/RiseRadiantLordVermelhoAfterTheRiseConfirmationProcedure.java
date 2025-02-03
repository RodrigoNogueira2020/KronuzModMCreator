package net.mcreator.ethernalkronuz.procedures;

import top.theillusivec4.curios.api.CuriosApi;

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
import net.minecraft.Util;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

public class RiseRadiantLordVermelhoAfterTheRiseConfirmationProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player player) {
			ItemStack bifrostKey = new ItemStack(EthernalKronuzModItems.BIFROST_KEY.get());
			equipBifrostKeyInCuriosSlot(player, bifrostKey);
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
		{
			boolean _setval = false;
			entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.HasMinimumForTheRiseVermelho = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = true;
			entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.RadiantLordVermelhoPlayer = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		EthernalKronuzModVariables.MapVariables.get(world).RadiantLordVermelho = true;
		EthernalKronuzModVariables.MapVariables.get(world).syncData(world);
		{
			boolean _setval = true;
			entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.IsRadiantLord = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			boolean _setval = true;
			entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.AllowInJotunheim = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		GiveRadiantLordEffectsProcedure.execute(world, x, y, z, entity);
		entity.setCustomName(new TextComponent("\u00A7cAzakana"));
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(EthernalKronuzModItems.MURASAMA.get());
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(3, new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_HELMET.get()));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_HELMET.get()));
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(2, new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_CHESTPLATE.get()));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_CHESTPLATE.get()));
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(1, new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_LEGGINGS.get()));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_LEGGINGS.get()));
			}
		}
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(0, new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_BOOTS.get()));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_BOOTS.get()));
			}
		}
		for (int index0 = 0; index0 < (int) (5); index0++) {
			if (!world.isClientSide()) {
				MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
				if (_mcserv != null)
					_mcserv.getPlayerList().broadcastMessage(new TextComponent("The Azakana is AMONGUS!"), ChatType.SYSTEM, Util.NIL_UUID);
			}
		}
	}

	private static void equipBifrostKeyInCuriosSlot(Player player, ItemStack itemStack) {
		CuriosApi.getCuriosHelper().getCuriosHandler(player).ifPresent(curiosHandler -> {
			curiosHandler.getCurios().forEach((identifier, stackHandler) -> {
				for (int slot = 0; slot < stackHandler.getSlots(); slot++) {
					ItemStack currentStack = stackHandler.getStacks().getStackInSlot(slot);
					if (currentStack.isEmpty()) {
						stackHandler.getStacks().setStackInSlot(slot, itemStack);
						return;
					}
				}
			});
		});
	}
}
