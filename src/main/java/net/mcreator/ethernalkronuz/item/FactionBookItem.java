
package net.mcreator.ethernalkronuz.item;

import top.theillusivec4.curios.api.type.capability.ICurioItem;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.ethernalkronuz.procedures.FactionBookRightClickedInAirProcedure;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModTabs;

public class FactionBookItem extends Item implements ICurioItem {
	public FactionBookItem() {
		super(new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB).stacksTo(1).rarity(Rarity.RARE));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		FactionBookRightClickedInAirProcedure.execute(world, x, y, z, entity);
		return ar;
	}
}
