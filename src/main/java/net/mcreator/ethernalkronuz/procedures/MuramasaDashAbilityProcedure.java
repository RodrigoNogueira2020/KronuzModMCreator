package net.mcreator.ethernalkronuz.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.network.chat.TextComponent;

import java.util.List;

public class MuramasaDashAbilityProcedure {

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;

        // Define o alcance do dash com base no estado do jogador (no chão ou no ar)
        int dashRange = entity.isOnGround() ? 13 : 7;

        // Define a velocidade do dash com base no estado do jogador
        double dashSpeed = entity.isOnGround() ? 0.5 : 0.2;

        if (!(entity instanceof LivingEntity _livEnt ? _livEnt.isFallFlying() : false)) {
            Direction direction = entity.getDirection();
            Vec3 initialPosition = entity.position();

            // Calcula a velocidade do dash com base na direção e na velocidade definida
            Vec3 dashVelocity = switch (direction) {
                case NORTH -> new Vec3(0, 0, -dashSpeed);
                case SOUTH -> new Vec3(0, 0, dashSpeed);
                case WEST -> new Vec3(-dashSpeed, 0, 0);
                case EAST -> new Vec3(dashSpeed, 0, 0);
                default -> Vec3.ZERO;
            };

            // Aplica a velocidade do dash à entidade
            entity.setDeltaMovement(dashVelocity.scale(dashRange));

            // Verifica entidades em uma área de 3x3x3 ao redor de cada ponto ao longo do trajeto
            for (int i = 0; i <= dashRange * 50; i++) { // Multiplica dashRange por um fator maior para aumentar a precisão
                double factor = (double) i / (dashRange * 50); // Usa o mesmo fator para percorrer o trajeto com precisão
                double checkX = initialPosition.x + factor * dashRange * dashVelocity.x;
                double checkY = initialPosition.y + factor * dashRange * dashVelocity.y;
                double checkZ = initialPosition.z + factor * dashRange * dashVelocity.z;
                Vec3 checkPosition = new Vec3(checkX, checkY, checkZ);

                // Verifica entidades em uma área de 3x3x3 ao redor de cada ponto
                AABB area = new AABB(checkPosition.add(-1.5, -1.5, -1.5), checkPosition.add(1.5, 1.5, 1.5));
                List<Entity> entities = world.getEntitiesOfClass(Entity.class, area, e -> true);
                for (Entity target : entities) {
                    if (target != entity) {
                        if (target instanceof LivingEntity _entity)
                            _entity.hurt(new DamageSource("murasama").bypassArmor(), 19); // Ajuste o dano conforme necessário
                        target.setDeltaMovement(new Vec3(entity.getLookAngle().x * 2, entity.getLookAngle().y + 1, entity.getLookAngle().z * 2));
                    }
                }
            }

            // Aplica a rotação horizontal ao jogador
            if (entity instanceof Player _player) {
                for (int i = 0; i < 3; i++) { // Garante que a rotação ocorra pelo menos 3 vezes
                    _player.setYRot(_player.getYRot() + 120); // Rotaciona 120 graus cada vez para completar uma volta completa em 3 iterações
                    _player.yRotO = _player.getYRot();
                    _player.xRotO = _player.getXRot();
                }
            }

            // Adiciona cooldown ao item
            if (entity instanceof Player _player)
                _player.getCooldowns().addCooldown(itemstack.getItem(), 40);

            // Executa o comando inicial
            if (world instanceof ServerLevel _level) {
                String command = switch (direction) {
                    case NORTH -> "execute as @p at @s anchored eyes positioned ~ ~1 ~-1 run function ethernal_kronuz:murasama_special_attack_func";
                    case SOUTH -> "execute as @p at @s anchored eyes positioned ~ ~1 ~1 run function ethernal_kronuz:murasama_special_attack_func";
                    case WEST -> "execute as @p at @s anchored eyes positioned ~-1 ~1 ~ run function ethernal_kronuz:murasama_special_attack_func";
                    case EAST -> "execute as @p at @s anchored eyes positioned ~1 ~1 ~ run function ethernal_kronuz:murasama_special_attack_func";
                    default -> "";
                };
                if (!command.isEmpty()) {
                    _level.getServer().getCommands().performCommand(
                        new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", new TextComponent(""), _level.getServer(), null)
                                .withSuppressedOutput(),
                        command
                    );
                }
            }
        }
    }
}
