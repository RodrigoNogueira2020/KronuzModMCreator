package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class LightningStrikesBifrostOpenningEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _origLevel) {
			LevelAccessor _worldorig = world;
			world = _origLevel.getServer().getLevel(Level.END);
			if (world != null) {
				if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.BEDROCK) {
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
							if (world instanceof ServerLevel _level) {
								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
								entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 16, y + 10, z - 11)));
								entityToSpawn.setVisualOnly(true);
								_level.addFreshEntity(entityToSpawn);
							}
							if (world instanceof ServerLevel _level) {
								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
								entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 8, y + 8, z - 8)));
								entityToSpawn.setVisualOnly(true);
								_level.addFreshEntity(entityToSpawn);
							}
							if (world instanceof ServerLevel _level) {
								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
								entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 2, y + 10, z - 15)));
								entityToSpawn.setVisualOnly(true);
								_level.addFreshEntity(entityToSpawn);
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
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 11, y + 8, z - 9)));
										entityToSpawn.setVisualOnly(true);
										_level.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 10, y + 6, z - 4)));
										entityToSpawn.setVisualOnly(true);
										_level.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 0, y + 19, z - 4)));
										entityToSpawn.setVisualOnly(true);
										_level.addFreshEntity(entityToSpawn);
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
											if (world instanceof ServerLevel _level) {
												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
												entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 5, y + 10, z + 10)));
												entityToSpawn.setVisualOnly(true);
												_level.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel _level) {
												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
												entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 9, y + 18, z + 14)));
												entityToSpawn.setVisualOnly(true);
												_level.addFreshEntity(entityToSpawn);
											}
											if (world instanceof ServerLevel _level) {
												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
												entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 9, y + 8, z + 14)));
												entityToSpawn.setVisualOnly(true);
												_level.addFreshEntity(entityToSpawn);
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
													if (world instanceof ServerLevel _level) {
														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
														entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 10, y + 12, z - 8)));
														entityToSpawn.setVisualOnly(true);
														_level.addFreshEntity(entityToSpawn);
													}
													if (world instanceof ServerLevel _level) {
														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
														entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 0, y + 19, z + 11)));
														entityToSpawn.setVisualOnly(true);
														_level.addFreshEntity(entityToSpawn);
													}
													if (world instanceof ServerLevel _level) {
														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
														entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 5, y + 16, z - 2)));
														entityToSpawn.setVisualOnly(true);
														_level.addFreshEntity(entityToSpawn);
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
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 5, y + 11, z + 10)));
																entityToSpawn.setVisualOnly(true);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 15, y + 20, z - 0)));
																entityToSpawn.setVisualOnly(true);
																_level.addFreshEntity(entityToSpawn);
															}
															if (world instanceof ServerLevel _level) {
																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 9, y + 10, z - 15)));
																entityToSpawn.setVisualOnly(true);
																_level.addFreshEntity(entityToSpawn);
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
																	if (world instanceof ServerLevel _level) {
																		LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																		entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 5, y + 20, z - 10)));
																		entityToSpawn.setVisualOnly(true);
																		_level.addFreshEntity(entityToSpawn);
																	}
																	if (world instanceof ServerLevel _level) {
																		LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																		entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 8, y + 14, z + 7)));
																		entityToSpawn.setVisualOnly(true);
																		_level.addFreshEntity(entityToSpawn);
																	}
																	if (world instanceof ServerLevel _level) {
																		LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																		entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 14, y + 13, z - 6)));
																		entityToSpawn.setVisualOnly(true);
																		_level.addFreshEntity(entityToSpawn);
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
																			if (world instanceof ServerLevel _level) {
																				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 16, y + 12, z - 0)));
																				entityToSpawn.setVisualOnly(true);
																				_level.addFreshEntity(entityToSpawn);
																			}
																			if (world instanceof ServerLevel _level) {
																				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 18, y + 0, z + 3)));
																				entityToSpawn.setVisualOnly(true);
																				_level.addFreshEntity(entityToSpawn);
																			}
																			if (world instanceof ServerLevel _level) {
																				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 2, y + 12, z + 4)));
																				entityToSpawn.setVisualOnly(true);
																				_level.addFreshEntity(entityToSpawn);
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
																					if (world instanceof ServerLevel _level) {
																						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																						entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 5, y + 16, z - 14)));
																						entityToSpawn.setVisualOnly(true);
																						_level.addFreshEntity(entityToSpawn);
																					}
																					if (world instanceof ServerLevel _level) {
																						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																						entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 0, y + 18, z - 17)));
																						entityToSpawn.setVisualOnly(true);
																						_level.addFreshEntity(entityToSpawn);
																					}
																					if (world instanceof ServerLevel _level) {
																						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																						entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 11, y + 15, z - 2)));
																						entityToSpawn.setVisualOnly(true);
																						_level.addFreshEntity(entityToSpawn);
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
																							if (world instanceof ServerLevel _level) {
																								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																								entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 5, y + 16, z - 1)));
																								entityToSpawn.setVisualOnly(true);
																								_level.addFreshEntity(entityToSpawn);
																							}
																							if (world instanceof ServerLevel _level) {
																								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																								entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 6, y + 20, z - 5)));
																								entityToSpawn.setVisualOnly(true);
																								_level.addFreshEntity(entityToSpawn);
																							}
																							if (world instanceof ServerLevel _level) {
																								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																								entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 0, y + 13, z + 17)));
																								entityToSpawn.setVisualOnly(true);
																								_level.addFreshEntity(entityToSpawn);
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
																									if (world instanceof ServerLevel _level) {
																										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																										entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 13, y + 13, z + 7)));
																										entityToSpawn.setVisualOnly(true);
																										_level.addFreshEntity(entityToSpawn);
																									}
																									if (world instanceof ServerLevel _level) {
																										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																										entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 10, y + 7, z + 13)));
																										entityToSpawn.setVisualOnly(true);
																										_level.addFreshEntity(entityToSpawn);
																									}
																									if (world instanceof ServerLevel _level) {
																										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																										entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 10, y + 17, z + 1)));
																										entityToSpawn.setVisualOnly(true);
																										_level.addFreshEntity(entityToSpawn);
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
																											if (world instanceof ServerLevel _level) {
																												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																												entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 16, y + 12, z + 1)));
																												entityToSpawn.setVisualOnly(true);
																												_level.addFreshEntity(entityToSpawn);
																											}
																											if (world instanceof ServerLevel _level) {
																												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																												entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 18, y + 15, z - 6)));
																												entityToSpawn.setVisualOnly(true);
																												_level.addFreshEntity(entityToSpawn);
																											}
																											if (world instanceof ServerLevel _level) {
																												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																												entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 13, y + 11, z - 1)));
																												entityToSpawn.setVisualOnly(true);
																												_level.addFreshEntity(entityToSpawn);
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
																													if (world instanceof ServerLevel _level) {
																														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																														entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 4, y + 3, z - 1)));
																														entityToSpawn.setVisualOnly(true);
																														_level.addFreshEntity(entityToSpawn);
																													}
																													if (world instanceof ServerLevel _level) {
																														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																														entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 2, y + 3, z - 9)));
																														entityToSpawn.setVisualOnly(true);
																														_level.addFreshEntity(entityToSpawn);
																													}
																													if (world instanceof ServerLevel _level) {
																														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																														entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 0, y + 10, z - 9)));
																														entityToSpawn.setVisualOnly(true);
																														_level.addFreshEntity(entityToSpawn);
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
																															if (world instanceof ServerLevel _level) {
																																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 7, y + 21, z + 5)));
																																entityToSpawn.setVisualOnly(true);
																																_level.addFreshEntity(entityToSpawn);
																															}
																															if (world instanceof ServerLevel _level) {
																																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 14, y + 4, z + 9)));
																																entityToSpawn.setVisualOnly(true);
																																_level.addFreshEntity(entityToSpawn);
																															}
																															if (world instanceof ServerLevel _level) {
																																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 2, y + 20, z + 5)));
																																entityToSpawn.setVisualOnly(true);
																																_level.addFreshEntity(entityToSpawn);
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
																																	if (world instanceof ServerLevel _level) {
																																		LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																		entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 5, y + 20, z - 10)));
																																		entityToSpawn.setVisualOnly(true);
																																		_level.addFreshEntity(entityToSpawn);
																																	}
																																	if (world instanceof ServerLevel _level) {
																																		LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																		entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 8, y + 14, z + 7)));
																																		entityToSpawn.setVisualOnly(true);
																																		_level.addFreshEntity(entityToSpawn);
																																	}
																																	if (world instanceof ServerLevel _level) {
																																		LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																		entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 14, y + 13, z - 6)));
																																		entityToSpawn.setVisualOnly(true);
																																		_level.addFreshEntity(entityToSpawn);
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
																																			if (world instanceof ServerLevel _level) {
																																				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 13, y + 16, z - 6)));
																																				entityToSpawn.setVisualOnly(true);
																																				_level.addFreshEntity(entityToSpawn);
																																			}
																																			if (world instanceof ServerLevel _level) {
																																				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 11, y + 15, z - 11)));
																																				entityToSpawn.setVisualOnly(true);
																																				_level.addFreshEntity(entityToSpawn);
																																			}
																																			if (world instanceof ServerLevel _level) {
																																				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 13, y + 16, z + 4)));
																																				entityToSpawn.setVisualOnly(true);
																																				_level.addFreshEntity(entityToSpawn);
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
																																					if (world instanceof ServerLevel _level) {
																																						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																						entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 11, y + 21, z + 7)));
																																						entityToSpawn.setVisualOnly(true);
																																						_level.addFreshEntity(entityToSpawn);
																																					}
																																					if (world instanceof ServerLevel _level) {
																																						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																						entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 15, y + 9, z + 9)));
																																						entityToSpawn.setVisualOnly(true);
																																						_level.addFreshEntity(entityToSpawn);
																																					}
																																					if (world instanceof ServerLevel _level) {
																																						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																						entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 7, y + 14, z + 5)));
																																						entityToSpawn.setVisualOnly(true);
																																						_level.addFreshEntity(entityToSpawn);
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
																																							if (world instanceof ServerLevel _level) {
																																								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																								entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 7, y + 12, z + 4)));
																																								entityToSpawn.setVisualOnly(true);
																																								_level.addFreshEntity(entityToSpawn);
																																							}
																																							if (world instanceof ServerLevel _level) {
																																								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																								entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 3, y + 9, z + 15)));
																																								entityToSpawn.setVisualOnly(true);
																																								_level.addFreshEntity(entityToSpawn);
																																							}
																																							if (world instanceof ServerLevel _level) {
																																								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																								entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 1, y + 3, z + 9)));
																																								entityToSpawn.setVisualOnly(true);
																																								_level.addFreshEntity(entityToSpawn);
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
																																									if (world instanceof ServerLevel _level) {
																																										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																										entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x - 3, y + 2, z - 10)));
																																										entityToSpawn.setVisualOnly(true);
																																										_level.addFreshEntity(entityToSpawn);
																																									}
																																									if (world instanceof ServerLevel _level) {
																																										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																										entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 4, y + 3, z - 5)));
																																										entityToSpawn.setVisualOnly(true);
																																										_level.addFreshEntity(entityToSpawn);
																																									}
																																									if (world instanceof ServerLevel _level) {
																																										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																										entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 5, y + 0, z - 2)));
																																										entityToSpawn.setVisualOnly(true);
																																										_level.addFreshEntity(entityToSpawn);
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
																																											if (world instanceof ServerLevel _level) {
																																												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																												entityToSpawn.moveTo(
																																														Vec3.atBottomCenterOf(new BlockPos(x + 16, y + 16, z + 0)));
																																												entityToSpawn.setVisualOnly(true);
																																												_level.addFreshEntity(entityToSpawn);
																																											}
																																											if (world instanceof ServerLevel _level) {
																																												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																												entityToSpawn.moveTo(
																																														Vec3.atBottomCenterOf(new BlockPos(x - 15, y + 17, z + 11)));
																																												entityToSpawn.setVisualOnly(true);
																																												_level.addFreshEntity(entityToSpawn);
																																											}
																																											if (world instanceof ServerLevel _level) {
																																												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
																																												entityToSpawn
																																														.moveTo(Vec3.atBottomCenterOf(new BlockPos(x + 4, y + 5, z + 7)));
																																												entityToSpawn.setVisualOnly(true);
																																												_level.addFreshEntity(entityToSpawn);
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
																																													if (world instanceof ServerLevel _level) {
																																														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																.create(_level);
																																														entityToSpawn.moveTo(Vec3
																																																.atBottomCenterOf(new BlockPos(x - 17, y + 19, z + 8)));
																																														entityToSpawn.setVisualOnly(true);
																																														_level.addFreshEntity(entityToSpawn);
																																													}
																																													if (world instanceof ServerLevel _level) {
																																														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																.create(_level);
																																														entityToSpawn.moveTo(Vec3
																																																.atBottomCenterOf(new BlockPos(x - 13, y + 17, z + 13)));
																																														entityToSpawn.setVisualOnly(true);
																																														_level.addFreshEntity(entityToSpawn);
																																													}
																																													if (world instanceof ServerLevel _level) {
																																														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																.create(_level);
																																														entityToSpawn.moveTo(Vec3
																																																.atBottomCenterOf(new BlockPos(x - 5, y + 20, z - 13)));
																																														entityToSpawn.setVisualOnly(true);
																																														_level.addFreshEntity(entityToSpawn);
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
																																															if (world instanceof ServerLevel _level) {
																																																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																		.create(_level);
																																																entityToSpawn.moveTo(Vec3.atBottomCenterOf(
																																																		new BlockPos(x - 3, y + 14, z + 4)));
																																																entityToSpawn.setVisualOnly(true);
																																																_level.addFreshEntity(entityToSpawn);
																																															}
																																															if (world instanceof ServerLevel _level) {
																																																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																		.create(_level);
																																																entityToSpawn.moveTo(Vec3.atBottomCenterOf(
																																																		new BlockPos(x - 5, y + 13, z - 7)));
																																																entityToSpawn.setVisualOnly(true);
																																																_level.addFreshEntity(entityToSpawn);
																																															}
																																															if (world instanceof ServerLevel _level) {
																																																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																		.create(_level);
																																																entityToSpawn.moveTo(Vec3.atBottomCenterOf(
																																																		new BlockPos(x + 0, y + 11, z + 9)));
																																																entityToSpawn.setVisualOnly(true);
																																																_level.addFreshEntity(entityToSpawn);
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
																																																	if (world instanceof ServerLevel _level) {
																																																		LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																				.create(_level);
																																																		entityToSpawn.moveTo(Vec3.atBottomCenterOf(
																																																				new BlockPos(x - 4, y + 21, z + 14)));
																																																		entityToSpawn.setVisualOnly(true);
																																																		_level.addFreshEntity(entityToSpawn);
																																																	}
																																																	if (world instanceof ServerLevel _level) {
																																																		LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																				.create(_level);
																																																		entityToSpawn.moveTo(Vec3.atBottomCenterOf(
																																																				new BlockPos(x - 11, y + 2, z + 1)));
																																																		entityToSpawn.setVisualOnly(true);
																																																		_level.addFreshEntity(entityToSpawn);
																																																	}
																																																	if (world instanceof ServerLevel _level) {
																																																		LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																				.create(_level);
																																																		entityToSpawn.moveTo(Vec3.atBottomCenterOf(
																																																				new BlockPos(x - 10, y + 9, z + 6)));
																																																		entityToSpawn.setVisualOnly(true);
																																																		_level.addFreshEntity(entityToSpawn);
																																																	}
																																																	new Object() {
																																																		private int ticks = 0;
																																																		private float waitTicks;
																																																		private LevelAccessor world;

																																																		public void start(LevelAccessor world,
																																																				int waitTicks) {
																																																			this.waitTicks = waitTicks;
																																																			MinecraftForge.EVENT_BUS.register(this);
																																																			this.world = world;
																																																		}

																																																		@SubscribeEvent
																																																		public void tick(
																																																				TickEvent.ServerTickEvent event) {
																																																			if (event.phase == TickEvent.Phase.END) {
																																																				this.ticks += 1;
																																																				if (this.ticks >= this.waitTicks)
																																																					run();
																																																			}
																																																		}

																																																		private void run() {
																																																			if (world instanceof ServerLevel _level) {
																																																				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																						.create(_level);
																																																				entityToSpawn.moveTo(Vec3
																																																						.atBottomCenterOf(new BlockPos(
																																																								x - 9, y + 8, z - 0)));
																																																				entityToSpawn.setVisualOnly(true);
																																																				_level.addFreshEntity(entityToSpawn);
																																																			}
																																																			if (world instanceof ServerLevel _level) {
																																																				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																						.create(_level);
																																																				entityToSpawn.moveTo(Vec3
																																																						.atBottomCenterOf(new BlockPos(
																																																								x + 6, y + 16, z - 6)));
																																																				entityToSpawn.setVisualOnly(true);
																																																				_level.addFreshEntity(entityToSpawn);
																																																			}
																																																			if (world instanceof ServerLevel _level) {
																																																				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																						.create(_level);
																																																				entityToSpawn.moveTo(Vec3
																																																						.atBottomCenterOf(new BlockPos(
																																																								x + 9, y + 4, z - 1)));
																																																				entityToSpawn.setVisualOnly(true);
																																																				_level.addFreshEntity(entityToSpawn);
																																																			}
																																																			new Object() {
																																																				private int ticks = 0;
																																																				private float waitTicks;
																																																				private LevelAccessor world;

																																																				public void start(LevelAccessor world,
																																																						int waitTicks) {
																																																					this.waitTicks = waitTicks;
																																																					MinecraftForge.EVENT_BUS
																																																							.register(this);
																																																					this.world = world;
																																																				}

																																																				@SubscribeEvent
																																																				public void tick(
																																																						TickEvent.ServerTickEvent event) {
																																																					if (event.phase == TickEvent.Phase.END) {
																																																						this.ticks += 1;
																																																						if (this.ticks >= this.waitTicks)
																																																							run();
																																																					}
																																																				}

																																																				private void run() {
																																																					if (world instanceof ServerLevel _level) {
																																																						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																								.create(_level);
																																																						entityToSpawn.moveTo(
																																																								Vec3.atBottomCenterOf(
																																																										new BlockPos(
																																																												x + 3,
																																																												y + 11,
																																																												z + 7)));
																																																						entityToSpawn.setVisualOnly(true);
																																																						_level.addFreshEntity(
																																																								entityToSpawn);
																																																					}
																																																					if (world instanceof ServerLevel _level) {
																																																						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																								.create(_level);
																																																						entityToSpawn.moveTo(
																																																								Vec3.atBottomCenterOf(
																																																										new BlockPos(
																																																												x - 8,
																																																												y + 14,
																																																												z + 2)));
																																																						entityToSpawn.setVisualOnly(true);
																																																						_level.addFreshEntity(
																																																								entityToSpawn);
																																																					}
																																																					if (world instanceof ServerLevel _level) {
																																																						LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																								.create(_level);
																																																						entityToSpawn.moveTo(
																																																								Vec3.atBottomCenterOf(
																																																										new BlockPos(
																																																												x + 1,
																																																												y + 8,
																																																												z - 1)));
																																																						entityToSpawn.setVisualOnly(true);
																																																						_level.addFreshEntity(
																																																								entityToSpawn);
																																																					}
																																																					new Object() {
																																																						private int ticks = 0;
																																																						private float waitTicks;
																																																						private LevelAccessor world;

																																																						public void start(
																																																								LevelAccessor world,
																																																								int waitTicks) {
																																																							this.waitTicks = waitTicks;
																																																							MinecraftForge.EVENT_BUS
																																																									.register(this);
																																																							this.world = world;
																																																						}

																																																						@SubscribeEvent
																																																						public void tick(
																																																								TickEvent.ServerTickEvent event) {
																																																							if (event.phase == TickEvent.Phase.END) {
																																																								this.ticks += 1;
																																																								if (this.ticks >= this.waitTicks)
																																																									run();
																																																							}
																																																						}

																																																						private void run() {
																																																							if (world instanceof ServerLevel _level) {
																																																								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																										.create(_level);
																																																								entityToSpawn.moveTo(Vec3
																																																										.atBottomCenterOf(
																																																												new BlockPos(
																																																														x + 7,
																																																														y + 1,
																																																														z + 9)));
																																																								entityToSpawn
																																																										.setVisualOnly(
																																																												true);
																																																								_level.addFreshEntity(
																																																										entityToSpawn);
																																																							}
																																																							if (world instanceof ServerLevel _level) {
																																																								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																										.create(_level);
																																																								entityToSpawn.moveTo(Vec3
																																																										.atBottomCenterOf(
																																																												new BlockPos(
																																																														x - 6,
																																																														y + 20,
																																																														z - 7)));
																																																								entityToSpawn
																																																										.setVisualOnly(
																																																												true);
																																																								_level.addFreshEntity(
																																																										entityToSpawn);
																																																							}
																																																							if (world instanceof ServerLevel _level) {
																																																								LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																										.create(_level);
																																																								entityToSpawn.moveTo(Vec3
																																																										.atBottomCenterOf(
																																																												new BlockPos(
																																																														x - 0,
																																																														y + 18,
																																																														z - 9)));
																																																								entityToSpawn
																																																										.setVisualOnly(
																																																												true);
																																																								_level.addFreshEntity(
																																																										entityToSpawn);
																																																							}
																																																							new Object() {
																																																								private int ticks = 0;
																																																								private float waitTicks;
																																																								private LevelAccessor world;

																																																								public void start(
																																																										LevelAccessor world,
																																																										int waitTicks) {
																																																									this.waitTicks = waitTicks;
																																																									MinecraftForge.EVENT_BUS
																																																											.register(
																																																													this);
																																																									this.world = world;
																																																								}

																																																								@SubscribeEvent
																																																								public void tick(
																																																										TickEvent.ServerTickEvent event) {
																																																									if (event.phase == TickEvent.Phase.END) {
																																																										this.ticks += 1;
																																																										if (this.ticks >= this.waitTicks)
																																																											run();
																																																									}
																																																								}

																																																								private void run() {
																																																									if (world instanceof ServerLevel _level) {
																																																										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																												.create(_level);
																																																										entityToSpawn
																																																												.moveTo(Vec3
																																																														.atBottomCenterOf(
																																																																new BlockPos(
																																																																		x - 0,
																																																																		y + 21,
																																																																		z - 0)));
																																																										entityToSpawn
																																																												.setVisualOnly(
																																																														true);
																																																										_level.addFreshEntity(
																																																												entityToSpawn);
																																																									}
																																																									if (world instanceof ServerLevel _level) {
																																																										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																												.create(_level);
																																																										entityToSpawn
																																																												.moveTo(Vec3
																																																														.atBottomCenterOf(
																																																																new BlockPos(
																																																																		x - 0,
																																																																		y + 3,
																																																																		z - 3)));
																																																										entityToSpawn
																																																												.setVisualOnly(
																																																														true);
																																																										_level.addFreshEntity(
																																																												entityToSpawn);
																																																									}
																																																									if (world instanceof ServerLevel _level) {
																																																										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																												.create(_level);
																																																										entityToSpawn
																																																												.moveTo(Vec3
																																																														.atBottomCenterOf(
																																																																new BlockPos(
																																																																		x - 9,
																																																																		y + 23,
																																																																		z + 1)));
																																																										entityToSpawn
																																																												.setVisualOnly(
																																																														true);
																																																										_level.addFreshEntity(
																																																												entityToSpawn);
																																																									}
																																																									new Object() {
																																																										private int ticks = 0;
																																																										private float waitTicks;
																																																										private LevelAccessor world;

																																																										public void start(
																																																												LevelAccessor world,
																																																												int waitTicks) {
																																																											this.waitTicks = waitTicks;
																																																											MinecraftForge.EVENT_BUS
																																																													.register(
																																																															this);
																																																											this.world = world;
																																																										}

																																																										@SubscribeEvent
																																																										public void tick(
																																																												TickEvent.ServerTickEvent event) {
																																																											if (event.phase == TickEvent.Phase.END) {
																																																												this.ticks += 1;
																																																												if (this.ticks >= this.waitTicks)
																																																													run();
																																																											}
																																																										}

																																																										private void run() {
																																																											if (world instanceof ServerLevel _level) {
																																																												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																														.create(_level);
																																																												entityToSpawn
																																																														.moveTo(Vec3
																																																																.atBottomCenterOf(
																																																																		new BlockPos(
																																																																				x - 3,
																																																																				y + 12,
																																																																				z - 2)));
																																																												entityToSpawn
																																																														.setVisualOnly(
																																																																true);
																																																												_level.addFreshEntity(
																																																														entityToSpawn);
																																																											}
																																																											if (world instanceof ServerLevel _level) {
																																																												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																														.create(_level);
																																																												entityToSpawn
																																																														.moveTo(Vec3
																																																																.atBottomCenterOf(
																																																																		new BlockPos(
																																																																				x - 1,
																																																																				y + 8,
																																																																				z - 3)));
																																																												entityToSpawn
																																																														.setVisualOnly(
																																																																true);
																																																												_level.addFreshEntity(
																																																														entityToSpawn);
																																																											}
																																																											if (world instanceof ServerLevel _level) {
																																																												LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																														.create(_level);
																																																												entityToSpawn
																																																														.moveTo(Vec3
																																																																.atBottomCenterOf(
																																																																		new BlockPos(
																																																																				x + 4,
																																																																				y + 9,
																																																																				z - 3)));
																																																												entityToSpawn
																																																														.setVisualOnly(
																																																																true);
																																																												_level.addFreshEntity(
																																																														entityToSpawn);
																																																											}
																																																											new Object() {
																																																												private int ticks = 0;
																																																												private float waitTicks;
																																																												private LevelAccessor world;

																																																												public void start(
																																																														LevelAccessor world,
																																																														int waitTicks) {
																																																													this.waitTicks = waitTicks;
																																																													MinecraftForge.EVENT_BUS
																																																															.register(
																																																																	this);
																																																													this.world = world;
																																																												}

																																																												@SubscribeEvent
																																																												public void tick(
																																																														TickEvent.ServerTickEvent event) {
																																																													if (event.phase == TickEvent.Phase.END) {
																																																														this.ticks += 1;
																																																														if (this.ticks >= this.waitTicks)
																																																															run();
																																																													}
																																																												}

																																																												private void run() {
																																																													if (world instanceof ServerLevel _level) {
																																																														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																																.create(_level);
																																																														entityToSpawn
																																																																.moveTo(Vec3
																																																																		.atBottomCenterOf(
																																																																				new BlockPos(
																																																																						x - 20,
																																																																						y + 2,
																																																																						z - 5)));
																																																														entityToSpawn
																																																																.setVisualOnly(
																																																																		true);
																																																														_level.addFreshEntity(
																																																																entityToSpawn);
																																																													}
																																																													if (world instanceof ServerLevel _level) {
																																																														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																																.create(_level);
																																																														entityToSpawn
																																																																.moveTo(Vec3
																																																																		.atBottomCenterOf(
																																																																				new BlockPos(
																																																																						x - 9,
																																																																						y + 16,
																																																																						z - 2)));
																																																														entityToSpawn
																																																																.setVisualOnly(
																																																																		true);
																																																														_level.addFreshEntity(
																																																																entityToSpawn);
																																																													}
																																																													if (world instanceof ServerLevel _level) {
																																																														LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																																.create(_level);
																																																														entityToSpawn
																																																																.moveTo(Vec3
																																																																		.atBottomCenterOf(
																																																																				new BlockPos(
																																																																						x + 4,
																																																																						y + 8,
																																																																						z - 13)));
																																																														entityToSpawn
																																																																.setVisualOnly(
																																																																		true);
																																																														_level.addFreshEntity(
																																																																entityToSpawn);
																																																													}
																																																													new Object() {
																																																														private int ticks = 0;
																																																														private float waitTicks;
																																																														private LevelAccessor world;

																																																														public void start(
																																																																LevelAccessor world,
																																																																int waitTicks) {
																																																															this.waitTicks = waitTicks;
																																																															MinecraftForge.EVENT_BUS
																																																																	.register(
																																																																			this);
																																																															this.world = world;
																																																														}

																																																														@SubscribeEvent
																																																														public void tick(
																																																																TickEvent.ServerTickEvent event) {
																																																															if (event.phase == TickEvent.Phase.END) {
																																																																this.ticks += 1;
																																																																if (this.ticks >= this.waitTicks)
																																																																	run();
																																																															}
																																																														}

																																																														private void run() {
																																																															if (world instanceof ServerLevel _level) {
																																																																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																																		.create(_level);
																																																																entityToSpawn
																																																																		.moveTo(Vec3
																																																																				.atBottomCenterOf(
																																																																						new BlockPos(
																																																																								x - 5,
																																																																								y + 20,
																																																																								z + 0)));
																																																																entityToSpawn
																																																																		.setVisualOnly(
																																																																				true);
																																																																_level.addFreshEntity(
																																																																		entityToSpawn);
																																																															}
																																																															if (world instanceof ServerLevel _level) {
																																																																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																																		.create(_level);
																																																																entityToSpawn
																																																																		.moveTo(Vec3
																																																																				.atBottomCenterOf(
																																																																						new BlockPos(
																																																																								x - 5,
																																																																								y + 5,
																																																																								z - 5)));
																																																																entityToSpawn
																																																																		.setVisualOnly(
																																																																				true);
																																																																_level.addFreshEntity(
																																																																		entityToSpawn);
																																																															}
																																																															if (world instanceof ServerLevel _level) {
																																																																LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																																		.create(_level);
																																																																entityToSpawn
																																																																		.moveTo(Vec3
																																																																				.atBottomCenterOf(
																																																																						new BlockPos(
																																																																								x + 4,
																																																																								y + 12,
																																																																								z - 10)));
																																																																entityToSpawn
																																																																		.setVisualOnly(
																																																																				true);
																																																																_level.addFreshEntity(
																																																																		entityToSpawn);
																																																															}
																																																															new Object() {
																																																																private int ticks = 0;
																																																																private float waitTicks;
																																																																private LevelAccessor world;

																																																																public void start(
																																																																		LevelAccessor world,
																																																																		int waitTicks) {
																																																																	this.waitTicks = waitTicks;
																																																																	MinecraftForge.EVENT_BUS
																																																																			.register(
																																																																					this);
																																																																	this.world = world;
																																																																}

																																																																@SubscribeEvent
																																																																public void tick(
																																																																		TickEvent.ServerTickEvent event) {
																																																																	if (event.phase == TickEvent.Phase.END) {
																																																																		this.ticks += 1;
																																																																		if (this.ticks >= this.waitTicks)
																																																																			run();
																																																																	}
																																																																}

																																																																private void run() {
																																																																	if (world instanceof ServerLevel _level) {
																																																																		LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																																				.create(_level);
																																																																		entityToSpawn
																																																																				.moveTo(Vec3
																																																																						.atBottomCenterOf(
																																																																								new BlockPos(
																																																																										x - 11,
																																																																										y + 20,
																																																																										z - 5)));
																																																																		entityToSpawn
																																																																				.setVisualOnly(
																																																																						true);
																																																																		_level.addFreshEntity(
																																																																				entityToSpawn);
																																																																	}
																																																																	if (world instanceof ServerLevel _level) {
																																																																		LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																																				.create(_level);
																																																																		entityToSpawn
																																																																				.moveTo(Vec3
																																																																						.atBottomCenterOf(
																																																																								new BlockPos(
																																																																										x - 8,
																																																																										y + 2,
																																																																										z - 5)));
																																																																		entityToSpawn
																																																																				.setVisualOnly(
																																																																						true);
																																																																		_level.addFreshEntity(
																																																																				entityToSpawn);
																																																																	}
																																																																	if (world instanceof ServerLevel _level) {
																																																																		LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																																				.create(_level);
																																																																		entityToSpawn
																																																																				.moveTo(Vec3
																																																																						.atBottomCenterOf(
																																																																								new BlockPos(
																																																																										x + 4,
																																																																										y + 17,
																																																																										z + 9)));
																																																																		entityToSpawn
																																																																				.setVisualOnly(
																																																																						true);
																																																																		_level.addFreshEntity(
																																																																				entityToSpawn);
																																																																	}
																																																																	new Object() {
																																																																		private int ticks = 0;
																																																																		private float waitTicks;
																																																																		private LevelAccessor world;

																																																																		public void start(
																																																																				LevelAccessor world,
																																																																				int waitTicks) {
																																																																			this.waitTicks = waitTicks;
																																																																			MinecraftForge.EVENT_BUS
																																																																					.register(
																																																																							this);
																																																																			this.world = world;
																																																																		}

																																																																		@SubscribeEvent
																																																																		public void tick(
																																																																				TickEvent.ServerTickEvent event) {
																																																																			if (event.phase == TickEvent.Phase.END) {
																																																																				this.ticks += 1;
																																																																				if (this.ticks >= this.waitTicks)
																																																																					run();
																																																																			}
																																																																		}

																																																																		private void run() {
																																																																			if (world instanceof ServerLevel _level) {
																																																																				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																																						.create(_level);
																																																																				entityToSpawn
																																																																						.moveTo(Vec3
																																																																								.atBottomCenterOf(
																																																																										new BlockPos(
																																																																												x + 1,
																																																																												y + 3,
																																																																												z + 9)));
																																																																				entityToSpawn
																																																																						.setVisualOnly(
																																																																								true);
																																																																				_level.addFreshEntity(
																																																																						entityToSpawn);
																																																																			}
																																																																			if (world instanceof ServerLevel _level) {
																																																																				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																																						.create(_level);
																																																																				entityToSpawn
																																																																						.moveTo(Vec3
																																																																								.atBottomCenterOf(
																																																																										new BlockPos(
																																																																												x + 9,
																																																																												y + 8,
																																																																												z + 7)));
																																																																				entityToSpawn
																																																																						.setVisualOnly(
																																																																								true);
																																																																				_level.addFreshEntity(
																																																																						entityToSpawn);
																																																																			}
																																																																			if (world instanceof ServerLevel _level) {
																																																																				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT
																																																																						.create(_level);
																																																																				entityToSpawn
																																																																						.moveTo(Vec3
																																																																								.atBottomCenterOf(
																																																																										new BlockPos(
																																																																												x + 3,
																																																																												y + 20,
																																																																												z - 12)));
																																																																				entityToSpawn
																																																																						.setVisualOnly(
																																																																								true);
																																																																				_level.addFreshEntity(
																																																																						entityToSpawn);
																																																																			}
																																																																			MinecraftForge.EVENT_BUS
																																																																					.unregister(
																																																																							this);
																																																																		}
																																																																	}.start(world,
																																																																			20);
																																																																	MinecraftForge.EVENT_BUS
																																																																			.unregister(
																																																																					this);
																																																																}
																																																															}.start(world,
																																																																	20);
																																																															MinecraftForge.EVENT_BUS
																																																																	.unregister(
																																																																			this);
																																																														}
																																																													}.start(world,
																																																															20);
																																																													MinecraftForge.EVENT_BUS
																																																															.unregister(
																																																																	this);
																																																												}
																																																											}.start(world,
																																																													20);
																																																											MinecraftForge.EVENT_BUS
																																																													.unregister(
																																																															this);
																																																										}
																																																									}.start(world, 20);
																																																									MinecraftForge.EVENT_BUS
																																																											.unregister(
																																																													this);
																																																								}
																																																							}.start(world, 20);
																																																							MinecraftForge.EVENT_BUS
																																																									.unregister(this);
																																																						}
																																																					}.start(world, 20);
																																																					MinecraftForge.EVENT_BUS
																																																							.unregister(this);
																																																				}
																																																			}.start(world, 20);
																																																			MinecraftForge.EVENT_BUS.unregister(this);
																																																		}
																																																	}.start(world, 20);
																																																	MinecraftForge.EVENT_BUS.unregister(this);
																																																}
																																															}.start(world, 20);
																																															MinecraftForge.EVENT_BUS.unregister(this);
																																														}
																																													}.start(world, 20);
																																													MinecraftForge.EVENT_BUS.unregister(this);
																																												}
																																											}.start(world, 20);
																																											MinecraftForge.EVENT_BUS.unregister(this);
																																										}
																																									}.start(world, 20);
																																									MinecraftForge.EVENT_BUS.unregister(this);
																																								}
																																							}.start(world, 20);
																																							MinecraftForge.EVENT_BUS.unregister(this);
																																						}
																																					}.start(world, 20);
																																					MinecraftForge.EVENT_BUS.unregister(this);
																																				}
																																			}.start(world, 20);
																																			MinecraftForge.EVENT_BUS.unregister(this);
																																		}
																																	}.start(world, 20);
																																	MinecraftForge.EVENT_BUS.unregister(this);
																																}
																															}.start(world, 20);
																															MinecraftForge.EVENT_BUS.unregister(this);
																														}
																													}.start(world, 20);
																													MinecraftForge.EVENT_BUS.unregister(this);
																												}
																											}.start(world, 20);
																											MinecraftForge.EVENT_BUS.unregister(this);
																										}
																									}.start(world, 20);
																									MinecraftForge.EVENT_BUS.unregister(this);
																								}
																							}.start(world, 20);
																							MinecraftForge.EVENT_BUS.unregister(this);
																						}
																					}.start(world, 20);
																					MinecraftForge.EVENT_BUS.unregister(this);
																				}
																			}.start(world, 20);
																			MinecraftForge.EVENT_BUS.unregister(this);
																		}
																	}.start(world, 20);
																	MinecraftForge.EVENT_BUS.unregister(this);
																}
															}.start(world, 20);
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, 20);
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, 20);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, 20);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, 20);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, 20);
				}
			}
			world = _worldorig;
		}
	}
}
