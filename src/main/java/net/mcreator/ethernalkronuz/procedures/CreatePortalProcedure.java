package net.mcreator.ethernalkronuz.procedures;

import net.minecraftforge.server.ServerLifecycleHooks;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.core.BlockPos;
import net.minecraft.Util;

import net.mcreator.ethernalkronuz.network.EthernalKronuzModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CreatePortalProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DRAGON_EGG && EthernalKronuzModVariables.MapVariables.get(world).AsgardPortalOpen == false
				&& (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
						? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("minecraft:end/respawn_dragon"))).isDone()
						: false)) {
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.BEDROCK && (world.getBlockState(new BlockPos(x, y - 2, z))).getBlock() == Blocks.BEDROCK
					&& (world.getBlockState(new BlockPos(x, y - 3, z))).getBlock() == Blocks.BEDROCK) {
				if ((world.getBlockState(new BlockPos(x, y - 1, z - 1))).getBlock() == Blocks.DRAGON_WALL_HEAD && (world.getBlockState(new BlockPos(x, y - 1, z + 1))).getBlock() == Blocks.DRAGON_WALL_HEAD
						&& (world.getBlockState(new BlockPos(x - 1, y - 1, z))).getBlock() == Blocks.DRAGON_WALL_HEAD && (world.getBlockState(new BlockPos(x + 1, y - 1, z))).getBlock() == Blocks.DRAGON_WALL_HEAD) {
					if ((world.getBlockState(new BlockPos(x, y - 3, z + 3))).getBlock() == Blocks.CRYING_OBSIDIAN && (world.getBlockState(new BlockPos(x, y - 2, z + 3))).getBlock() == Blocks.CRYING_OBSIDIAN
							&& (world.getBlockState(new BlockPos(x, y - 1, z + 3))).getBlock() == Blocks.CRYING_OBSIDIAN && (world.getBlockState(new BlockPos(x, y, z + 2))).getBlock() == Blocks.CRYING_OBSIDIAN
							&& (world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.CRYING_OBSIDIAN) {
						if ((world.getBlockState(new BlockPos(x, y - 3, z - 3))).getBlock() == Blocks.CRYING_OBSIDIAN && (world.getBlockState(new BlockPos(x, y - 2, z - 3))).getBlock() == Blocks.CRYING_OBSIDIAN
								&& (world.getBlockState(new BlockPos(x, y - 1, z - 3))).getBlock() == Blocks.CRYING_OBSIDIAN && (world.getBlockState(new BlockPos(x, y, z - 2))).getBlock() == Blocks.CRYING_OBSIDIAN
								&& (world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.CRYING_OBSIDIAN) {
							if ((world.getBlockState(new BlockPos(x + 3, y - 3, z))).getBlock() == Blocks.CRYING_OBSIDIAN && (world.getBlockState(new BlockPos(x + 3, y - 2, z))).getBlock() == Blocks.CRYING_OBSIDIAN
									&& (world.getBlockState(new BlockPos(x + 3, y - 1, z))).getBlock() == Blocks.CRYING_OBSIDIAN && (world.getBlockState(new BlockPos(x + 2, y, z))).getBlock() == Blocks.CRYING_OBSIDIAN
									&& (world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.CRYING_OBSIDIAN) {
								if ((world.getBlockState(new BlockPos(x - 3, y - 3, z))).getBlock() == Blocks.CRYING_OBSIDIAN && (world.getBlockState(new BlockPos(x - 3, y - 2, z))).getBlock() == Blocks.CRYING_OBSIDIAN
										&& (world.getBlockState(new BlockPos(x - 3, y - 1, z))).getBlock() == Blocks.CRYING_OBSIDIAN && (world.getBlockState(new BlockPos(x - 2, y, z))).getBlock() == Blocks.CRYING_OBSIDIAN
										&& (world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.CRYING_OBSIDIAN) {
									EthernalKronuzModVariables.MapVariables.get(world).AsgardPortalOpen = true;
									EthernalKronuzModVariables.MapVariables.get(world).syncData(world);
									if (world instanceof ServerLevel _level) {
										LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
										entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
										entityToSpawn.setVisualOnly(true);
										_level.addFreshEntity(entityToSpawn);
									}
									world.destroyBlock(new BlockPos(x, y, z), false);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ethernal_kronuz:aesir_rift_opening")), SoundSource.AMBIENT, 1, 1);
										} else {
											_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ethernal_kronuz:aesir_rift_opening")), SoundSource.AMBIENT, 1, 1, false);
										}
									}
									LightningStrikesBifrostOpenningEventProcedure.execute(world, x, (y - 1), z);
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
											if (world instanceof Level _level && !_level.isClientSide())
												_level.explode(null, x, (y - 40), z, 200, Explosion.BlockInteraction.DESTROY);
											if (world instanceof ServerLevel _serverworld) {
												StructureTemplate template = _serverworld.getStructureManager().getOrCreate(new ResourceLocation("ethernal_kronuz", "aesir_portal_pilar"));
												if (template != null) {
													template.placeInWorld(_serverworld, new BlockPos(x - 1, y - 64, z - 1), new BlockPos(x - 1, y - 64, z - 1),
															new StructurePlaceSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setIgnoreEntities(false), _serverworld.random, 3);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, 600);
									for (int index0 = 0; index0 < (int) (5); index0++) {
										if (!world.isClientSide()) {
											MinecraftServer _mcserv = ServerLifecycleHooks.getCurrentServer();
											if (_mcserv != null)
												_mcserv.getPlayerList().broadcastMessage(new TextComponent((entity.getDisplayName().getString() + " abriu a brecha")), ChatType.SYSTEM, Util.NIL_UUID);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
