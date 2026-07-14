
package net.mcreator.ethernalkronuz.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModTabs;
import net.mcreator.ethernalkronuz.entity.ArrowDivineEntity;
import net.minecraft.world.item.ArrowItem;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModEntities;


public class ArrowDivineItem extends ArrowItem {
	public ArrowDivineItem() {
		super(new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB).stacksTo(64));
	}

	@Override
	public AbstractArrow createArrow(Level world, ItemStack stack, LivingEntity shooter){
		return new ArrowDivineEntity(EthernalKronuzModEntities.ARROW_DIVINE.get(), shooter, world);
	}
}
