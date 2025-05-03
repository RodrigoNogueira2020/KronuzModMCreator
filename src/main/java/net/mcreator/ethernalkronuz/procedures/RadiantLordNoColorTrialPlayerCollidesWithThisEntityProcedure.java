package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModEntities;
import net.mcreator.ethernalkronuz.entity.RadiantLordNoColorTrialEntity;
import net.mcreator.ethernalkronuz.entity.RadiantLordGreenTrialEntity;

public class RadiantLordNoColorTrialPlayerCollidesWithThisEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!(sourceentity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).TouchRLOnce) {
			{
				boolean _setval = true;
				sourceentity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.TouchRLOnce = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
			if (entity instanceof RadiantLordNoColorTrialEntity) {
				((RadiantLordNoColorTrialEntity) entity).setAnimation("wakeup");
			}
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (entity instanceof RadiantLordNoColorTrialEntity) {
						((RadiantLordNoColorTrialEntity) entity).setAnimation("transforming");
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private LevelAccessor world;

						public void start(LevelAccessor world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (sourceentity instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 40, 0, (false), (false)));
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private LevelAccessor world;

								public void start(LevelAccessor world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									if (!entity.level.isClientSide())
										entity.discard();
									if ((sourceentity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).HasMinimumForTheRiseVerde) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = new RadiantLordGreenTrialEntity(EthernalKronuzModEntities.RADIANT_LORD_GREEN_TRIAL.get(), _level);
											entityToSpawn.moveTo(x, y, z, 0, 0);
											entityToSpawn.setYBodyRot(0);
											entityToSpawn.setYHeadRot(0);
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob _mobToSpawn)
												_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
											world.addFreshEntity(entityToSpawn);
										}
									}
									if ((sourceentity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).HasMinimumForTheRiseRoxo) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = new RadiantLordGreenTrialEntity(EthernalKronuzModEntities.RADIANT_LORD_GREEN_TRIAL.get(), _level);
											entityToSpawn.moveTo(x, y, z, 0, 0);
											entityToSpawn.setYBodyRot(0);
											entityToSpawn.setYHeadRot(0);
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob _mobToSpawn)
												_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
											world.addFreshEntity(entityToSpawn);
										}
									}
									if ((sourceentity.getCapability(EthernalKronuzModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new EthernalKronuzModVariables.PlayerVariables())).HasMinimumForTheRiseVermelho) {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = new RadiantLordGreenTrialEntity(EthernalKronuzModEntities.RADIANT_LORD_GREEN_TRIAL.get(), _level);
											entityToSpawn.moveTo(x, y, z, 0, 0);
											entityToSpawn.setYBodyRot(0);
											entityToSpawn.setYHeadRot(0);
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob _mobToSpawn)
												_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
											world.addFreshEntity(entityToSpawn);
										}
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, 20);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, 60);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 20);
		}
	}
}
