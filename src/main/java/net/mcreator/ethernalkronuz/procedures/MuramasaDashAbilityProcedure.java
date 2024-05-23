package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.Direction;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class MuramasaDashAbilityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt ? _livEnt.isFallFlying() : false)) {
			if ((entity.getDirection()) == Direction.NORTH) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() * 10)));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s anchored eyes positioned ~ ~1 ~-1 run function ethernal_kronuz:murasama_special_attack_func");
			}
			if ((entity.getDirection()) == Direction.SOUTH) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() * 10)));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s anchored eyes positioned ~ ~1 ~1 run function ethernal_kronuz:murasama_special_attack_func");
			}
			if ((entity.getDirection()) == Direction.WEST) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 10), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s anchored eyes positioned ~-1 ~1 ~ run function ethernal_kronuz:murasama_special_attack_func");
			}
			if ((entity.getDirection()) == Direction.EAST) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 10), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s anchored eyes positioned ~1 ~1 ~ run function ethernal_kronuz:murasama_special_attack_func");
			}
			if ((entity.getDirection()) == Direction.DOWN) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 10), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s anchored eyes positioned ~ ~ ~ run function ethernal_kronuz:murasama_special_attack_func");
			}
			if ((entity.getDirection()) == Direction.UP) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() * 10), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(),
							"execute as @p at @s anchored eyes positioned ~ ~ ~ run function ethernal_kronuz:murasama_special_attack_func");
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 40);
		}
	}
}
