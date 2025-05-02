package net.mcreator.ethernalkronuz.item;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.ChatFormatting;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModTabs;

import java.util.List;

public class NokkiaHammerItem extends PickaxeItem {
	private static final int COOLDOWN_TICKS = 200;
	private static final double RADIUS = 5.0;
	private static final double LAUNCH_POWER = 1.5;

	public NokkiaHammerItem() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 1000f;
			}

			public float getAttackDamageBonus() {
				return 4998f;
			}

			public int getLevel() {
				return 9;
			}

			public int getEnchantmentValue() {
				return 0;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 1, 96f, new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB).fireResistant());
	}

	@Override
	public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
		return 1000f;
	}

	@Override
	public Component getName(ItemStack stack) {
		return new TextComponent("Nokkia Hammer").withStyle(ChatFormatting.DARK_RED);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("§cSpecial Ability: §eSmash Quake").withStyle(ChatFormatting.GOLD));
		list.add(new TextComponent("\u00A7fRight-click §7projects all entities within a 5 block radius").withStyle(ChatFormatting.GRAY));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if (player.getCooldowns().isOnCooldown(itemstack.getItem()))
			return InteractionResultHolder.fail(itemstack);
		if (!world.isClientSide) {
			AABB area = player.getBoundingBox().inflate(RADIUS);
			List<Entity> entities = world.getEntities(player, area);
			for (Entity entity : entities) {
				if (entity instanceof LivingEntity && entity != player) {
					entity.setDeltaMovement(entity.getDeltaMovement().add(0, LAUNCH_POWER, 0));
					entity.hurtMarked = true;
				}
			}
			world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ANVIL_LAND, SoundSource.PLAYERS, 1.0F, 0.5F);
			for (int i = 0; i < 30; i++)
				world.addParticle(ParticleTypes.CLOUD, player.getX(), player.getY() + 1, player.getZ(), (Math.random() - 0.5) * 0.5, 0.5, (Math.random() - 0.5) * 0.5);
			player.getCooldowns().addCooldown(itemstack.getItem(), COOLDOWN_TICKS);
		}
		return InteractionResultHolder.success(itemstack);
	}
}
