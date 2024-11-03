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
import net.minecraft.core.Direction;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.server.MinecraftServer;

import java.util.List;

public class MuramasaDashAbilityProcedure {
    private static long crouchStartTime = -1;
    private static boolean dashCharged = false;

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;

        boolean isCrouching = entity.isCrouching();
        boolean hasWeaponInMainHand = entity instanceof Player _player && _player.getMainHandItem().equals(itemstack);

        // Verifica se o jogador está agachado e com a arma na mão
        if (isCrouching && hasWeaponInMainHand) {
            // Inicia o timer de crouch caso ainda não tenha sido iniciado
            if (crouchStartTime == -1) {
                crouchStartTime = System.currentTimeMillis();
            }

            // Verifica se o jogador ficou agachado por 3 segundos e o dash ainda não está carregado
            if (!dashCharged && System.currentTimeMillis() - crouchStartTime >= 3000) {
                dashCharged = true; // Marca o dash como carregado
                _player.sendMessage(new TextComponent("Dash Charged!"), _player.getUUID());

                // Envia mensagem ao jogador indicando que o dash foi carregado
                if (entity instanceof Player _player) {
                    _player.sendMessage(new TextComponent("Dash Charged!"), _player.getUUID());
                }
            }
        } else {
            // Reseta o timer e o status de carregamento do dash se o jogador parar de agachar ou tirar a arma da mão
            crouchStartTime = -1;
            dashCharged = false;
        }

        // Define os parâmetros do dash
        int dashRange = entity.isOnGround() ? 13 : 7;
        double dashSpeed = entity.isOnGround() ? 0.5 : 0.2;
        float damageAmount = 19;

        // Aumenta alcance e dano se o dash estiver carregado
        if (dashCharged) {
            dashRange *= 1.5;
            damageAmount *= 1.5f;
        }

        // Verifica se o jogador usa o botão direito para ativar o dash
        if (entity.isShiftKeyDown() || !entity.isCrouching()) {
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
            for (int i = 0; i <= dashRange * 50; i++) {
                double factor = (double) i / (dashRange * 50);
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
                            _entity.hurt(new DamageSource("murasama").bypassArmor(), damageAmount); // Aplica o dano ajustado
                        target.setDeltaMovement(new Vec3(entity.getLookAngle().x * 2, entity.getLookAngle().y + 1, entity.getLookAngle().z * 2));
                    }
                }
            }

            // Aplica a rotação horizontal ao jogador
            if (entity instanceof Player _player) {
                for (int i = 0; i < 3; i++) {
                    _player.setYRot(_player.getYRot() + 120);
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

            // Reseta o estado do dash carregado após a habilidade ser usada
            dashCharged = false;
        }
    }
}