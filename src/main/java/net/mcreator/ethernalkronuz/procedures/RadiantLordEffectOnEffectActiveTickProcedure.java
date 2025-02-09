package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

public class RadiantLordEffectOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			// Remover duplicatas do inventário
			for (int i = 0; i < _player.getInventory().items.size(); i++) {
				ItemStack stack = _player.getInventory().items.get(i);
				if (stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_HELMET.get() || stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_CHESTPLATE.get() || stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_LEGGINGS.get()
						|| stack.getItem() == EthernalKronuzModItems.RL_VERDE_ARMOR_BOOTS.get() || stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_HELMET.get() || stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_CHESTPLATE.get()
						|| stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_LEGGINGS.get() || stack.getItem() == EthernalKronuzModItems.RL_ROXO_ARMOUR_BOOTS.get() || stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_HELMET.get()
						|| stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_CHESTPLATE.get() || stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_LEGGINGS.get()
						|| stack.getItem() == EthernalKronuzModItems.RL_VERMELHO_ARMOR_BOOTS.get()) {
					_player.getInventory().items.set(i, ItemStack.EMPTY);
				}
			}
		}
		if ((entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordVerdePlayer) {
			if (entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_HELMET.get()));
				_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_CHESTPLATE.get()));
				_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_LEGGINGS.get()));
				_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_BOOTS.get()));
			}
		}
		if ((entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordRoxoPlayer) {
			if (entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(EthernalKronuzModItems.RL_ROXO_ARMOUR_HELMET.get()));
				_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(EthernalKronuzModItems.RL_ROXO_ARMOUR_CHESTPLATE.get()));
				_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(EthernalKronuzModItems.RL_ROXO_ARMOUR_LEGGINGS.get()));
				_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(EthernalKronuzModItems.RL_ROXO_ARMOUR_BOOTS.get()));
			}
		}
		if ((entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).RadiantLordVermelhoPlayer) {
			if (entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_HELMET.get()));
				_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_CHESTPLATE.get()));
				_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_LEGGINGS.get()));
				_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_BOOTS.get()));
			}
		}
	}
}
