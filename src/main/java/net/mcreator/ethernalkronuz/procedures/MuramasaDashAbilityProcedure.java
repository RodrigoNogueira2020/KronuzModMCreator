package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;  // Corrigido o pacote para DamageSource
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class MuramasaDashAbilityProcedure {
    private static long crouchStartTime = -1;
    private static boolean dashCharged = false;

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;

        boolean isCrouching = entity.isCrouching();
        boolean hasWeaponInMainHand = entity instanceof Player _player && _player.getMainHandItem().equals(itemstack);

        if (isCrouching && hasWeaponInMainHand) {
            if (crouchStartTime == -1) {
                crouchStartTime = System.currentTimeMillis();
            }

            if (!dashCharged && System.currentTimeMillis() - crouchStartTime >= 3000) {
                dashCharged = true;

                if (entity instanceof Player _player) {
                    _player.sendMessage(new TextComponent("Dash Charged!"), _player.getUUID());
                }
            }
        } else {
            crouchStartTime = -1;
            dashCharged = false;
        }

        int dashRange = entity.isOnGround() ? 7 : 3;
        double dashSpeed = entity.isOnGround() ? 0.7 : 0.5;
        float damageAmount = 20;

        if (dashCharged) {
            dashRange *= 2;
            damageAmount *= 2f;
        }

        if (entity.isShiftKeyDown() || !entity.isCrouching()) {
            String soundEvent = dashCharged ? "ethernal_kronuz:sword-dash-charged" : "ethernal_kronuz:sword-dash";
            if (world instanceof ServerLevel _level) {
                _level.playSound(null, entity.getX(), entity.getY(), entity.getZ(),
                        ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(soundEvent)),
                        SoundSource.PLAYERS, 1.0f, 1.0f);
            }

            Vec3 lookDirection = entity.getLookAngle().normalize();
            double maxVerticalOffset = 2.0 / dashRange;
            double adjustedY = Math.max(-maxVerticalOffset, Math.min(maxVerticalOffset, lookDirection.y));
            Vec3 adjustedDirection = new Vec3(lookDirection.x, adjustedY, lookDirection.z).normalize();
            Vec3 dashVelocity = adjustedDirection.scale(dashSpeed * dashRange);

            entity.setDeltaMovement(dashVelocity);

            Vec3 initialPosition = entity.position();

            for (int i = 0; i <= dashRange * 50; i++) {
                double factor = (double) i / (dashRange * 50);
                double checkX = initialPosition.x + factor * dashVelocity.x;
                double checkY = initialPosition.y + factor * dashVelocity.y;
                double checkZ = initialPosition.z + factor * dashVelocity.z;
                Vec3 checkPosition = new Vec3(checkX, checkY, checkZ);

                AABB area = new AABB(checkPosition.add(-1.5, -1.5, -1.5), checkPosition.add(1.5, 1.5, 1.5));
                List<Entity> entities = world.getEntitiesOfClass(Entity.class, area, e -> true);
                for (Entity target : entities) {
                    if (target != entity) {
                        if (target instanceof LivingEntity _entity)
                            _entity.hurt(new DamageSource("murasama").bypassArmor(), damageAmount);
                        target.setDeltaMovement(new Vec3(adjustedDirection.x * 2, adjustedDirection.y + 1, adjustedDirection.z * 2));
                    }
                }
            }

            if (entity instanceof Player _player) {
                for (int i = 0; i < 3; i++) {
                    _player.setYRot(_player.getYRot() + 120);
                    _player.yRotO = _player.getYRot();
                    _player.xRotO = _player.getXRot();
                }
            }

            if (entity instanceof Player _player)
                _player.getCooldowns().addCooldown(itemstack.getItem(), 40);

            if (world instanceof ServerLevel _level) {
                if (!adjustedDirection.equals(Vec3.ZERO)) {
                    String command = String.format(
                        "execute as @p at @s anchored eyes positioned ~%.1f ~%.1f ~%.1f run function ethernal_kronuz:murasama_special_attack_func",
                        adjustedDirection.x, adjustedDirection.y, adjustedDirection.z
                    );
                    _level.getServer().getCommands().performCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null)
                                .withSuppressedOutput(),
                        command
                    );
                }
            }

            dashCharged = false;
        }
    }
}
