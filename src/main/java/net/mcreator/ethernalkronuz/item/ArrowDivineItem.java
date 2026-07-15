
package net.mcreator.ethernalkronuz.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.Position;
import net.minecraft.core.Direction;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModTabs;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModEntities;
import net.mcreator.ethernalkronuz.entity.ArrowDivineEntity;

public class ArrowDivineItem extends ArrowItem {
	public ArrowDivineItem() {
		super(new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB).stacksTo(64));
	}

	@Override
	public AbstractArrow createArrow(Level world, ItemStack stack, LivingEntity shooter) {
		return new ArrowDivineEntity(EthernalKronuzModEntities.ARROW_DIVINE.get(), shooter, world);
	}
}
