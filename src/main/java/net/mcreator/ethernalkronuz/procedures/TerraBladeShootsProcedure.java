package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModEntities;
import net.mcreator.ethernalkronuz.entity.TerraBladeProjectileEntity;

public class TerraBladeShootsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		{
			Entity _shootFrom = entity;
			Level projectileLevel = _shootFrom.level;
			if (!projectileLevel.isClientSide()) {
				Projectile _entityToSpawn = new Object() {
					public Projectile getArrow(Level level, float damage, int knockback, byte piercing) {
						AbstractArrow entityToSpawn = new TerraBladeProjectileEntity(EthernalKronuzModEntities.TERRA_BLADE_PROJECTILE.get(), level);
						entityToSpawn.setBaseDamage(damage);
						entityToSpawn.setKnockback(knockback);
						entityToSpawn.setSilent(true);
						entityToSpawn.setPierceLevel(piercing);
						entityToSpawn.setCritArrow(true);
						entityToSpawn.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
						return entityToSpawn;
					}
				}.getArrow(projectileLevel, 100, 1, (byte) 100);
				double offsetX = _shootFrom.getLookAngle().x;
				double offsetY = _shootFrom.getLookAngle().y;
				double offsetZ = _shootFrom.getLookAngle().z;
				_entityToSpawn.setPos(_shootFrom.getX() + offsetX, _shootFrom.getEyeY() - 0.1 + offsetY, _shootFrom.getZ() + offsetZ);
				_entityToSpawn.shoot(offsetX, offsetY, offsetZ, 100, 0);
				projectileLevel.addFreshEntity(_entityToSpawn);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide())
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ethernal_kronuz:terrabladeshot")), SoundSource.AMBIENT, 1, 1);
			else
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ethernal_kronuz:terrabladeshot")), SoundSource.AMBIENT, 1, 1, false);
		}
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 40);
	}
}