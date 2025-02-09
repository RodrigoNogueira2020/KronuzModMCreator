package net.mcreator.ethernalkronuz.procedures;

import top.theillusivec4.curios.api.CuriosApi;

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
		EthernalKronuzModVariables.PlayerVariables playerVars = entity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables());
		if (playerVars.RadiantLordVerdePlayer) {
			equipArmorSet(entity, new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_HELMET.get()), new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_CHESTPLATE.get()), new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_LEGGINGS.get()),
					new ItemStack(EthernalKronuzModItems.RL_VERDE_ARMOR_BOOTS.get()));
		}
		if (playerVars.RadiantLordRoxoPlayer) {
			equipArmorSet(entity, new ItemStack(EthernalKronuzModItems.RL_ROXO_ARMOUR_HELMET.get()), new ItemStack(EthernalKronuzModItems.RL_ROXO_ARMOUR_CHESTPLATE.get()), new ItemStack(EthernalKronuzModItems.RL_ROXO_ARMOUR_LEGGINGS.get()),
					new ItemStack(EthernalKronuzModItems.RL_ROXO_ARMOUR_BOOTS.get()));
		}
		if (playerVars.RadiantLordVermelhoPlayer) {
			equipArmorSet(entity, new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_HELMET.get()), new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_CHESTPLATE.get()), new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_LEGGINGS.get()),
					new ItemStack(EthernalKronuzModItems.RL_VERMELHO_ARMOR_BOOTS.get()));
		}
		forceEquipCurio(entity, new ItemStack(EthernalKronuzModItems.BIFROST_KEY.get()));
	}

	private static void equipArmorSet(Entity entity, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots) {
		forceEquipArmor(entity, helmet, EquipmentSlot.HEAD);
		forceEquipArmor(entity, chestplate, EquipmentSlot.CHEST);
		forceEquipArmor(entity, leggings, EquipmentSlot.LEGS);
		forceEquipArmor(entity, boots, EquipmentSlot.FEET);
	}

	private static void forceEquipArmor(Entity entity, ItemStack item, EquipmentSlot slot) {
		if (entity instanceof Player player) {
			if (player.getInventory().armor.get(slot.getIndex()).isEmpty()) {
				player.getInventory().armor.set(slot.getIndex(), item);
				player.getInventory().setChanged();
			}
		} else if (entity instanceof LivingEntity living) {
			if (living.getItemBySlot(slot).isEmpty()) {
				living.setItemSlot(slot, item);
			}
		}
	}

	private static void forceEquipCurio(Entity entity, ItemStack item) {
		if (entity instanceof Player player) {
			CuriosApi.getCuriosHelper().getCuriosHandler(player).ifPresent(handler -> {
				boolean hasCurio = handler.getCurios().values().stream().anyMatch(stackHandler -> stackHandler.getStacks().getSlots() > 0 && !stackHandler.getStacks().getStackInSlot(0).isEmpty());
				if (!hasCurio) {
					handler.getCurios().values().stream().filter(stackHandler -> stackHandler.getStacks().getSlots() > 0 && stackHandler.getStacks().getStackInSlot(0).isEmpty()).findFirst().ifPresent(stackHandler -> {
						stackHandler.getStacks().setStackInSlot(0, item);
						for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
							ItemStack stack = player.getInventory().getItem(i);
							if (stack.getItem() == EthernalKronuzModItems.BIFROST_KEY.get() && stack.getCount() > 0) {
								stack.shrink(1);
								break;
							}
						}
					});
				}
			});
		}
	}
}
