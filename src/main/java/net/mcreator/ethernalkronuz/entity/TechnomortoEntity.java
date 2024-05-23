
package net.mcreator.ethernalkronuz.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.BreakDoorGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.chat.TextComponent;

import net.mcreator.ethernalkronuz.procedures.TechnobaldeRightClickedOnEntityProcedure;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModEntities;

import java.util.Set;

@Mod.EventBusSubscriber
public class TechnomortoEntity extends PathfinderMob {
	private static final Set<ResourceLocation> SPAWN_BIOMES = Set.of(new ResourceLocation("warm_ocean"), new ResourceLocation("mushroom_fields"), new ResourceLocation("sunflower_plains"), new ResourceLocation("flower_forest"),
			new ResourceLocation("lush_caves"), new ResourceLocation("cold_ocean"), new ResourceLocation("ice_spikes"), new ResourceLocation("lukewarm_ocean"), new ResourceLocation("dark_forest"), new ResourceLocation("savanna"),
			new ResourceLocation("stony_peaks"), new ResourceLocation("snowy_beach"), new ResourceLocation("frozen_ocean"), new ResourceLocation("savanna_plateau"), new ResourceLocation("dripstone_caves"), new ResourceLocation("snowy_plains"),
			new ResourceLocation("jagged_peaks"), new ResourceLocation("eroded_badlands"), new ResourceLocation("badlands"), new ResourceLocation("windswept_hills"), new ResourceLocation("ocean"), new ResourceLocation("wooded_badlands"),
			new ResourceLocation("windswept_savanna"), new ResourceLocation("jungle"), new ResourceLocation("warped_forest"), new ResourceLocation("frozen_river"), new ResourceLocation("forest"), new ResourceLocation("stony_shore"),
			new ResourceLocation("sparse_jungle"), new ResourceLocation("birch_forest"), new ResourceLocation("deep_lukewarm_ocean"), new ResourceLocation("snowy_slopes"), new ResourceLocation("deep_ocean"), new ResourceLocation("deep_frozen_ocean"),
			new ResourceLocation("nether_wastes"), new ResourceLocation("bamboo_jungle"), new ResourceLocation("soul_sand_valley"), new ResourceLocation("plains"), new ResourceLocation("frozen_peaks"), new ResourceLocation("meadow"),
			new ResourceLocation("old_growth_spruce_taiga"), new ResourceLocation("basalt_deltas"), new ResourceLocation("taiga"), new ResourceLocation("crimson_forest"), new ResourceLocation("snowy_taiga"), new ResourceLocation("swamp"),
			new ResourceLocation("deep_cold_ocean"), new ResourceLocation("old_growth_birch_forest"), new ResourceLocation("grove"), new ResourceLocation("old_growth_pine_taiga"), new ResourceLocation("beach"),
			new ResourceLocation("windswept_forest"), new ResourceLocation("windswept_gravelly_hills"), new ResourceLocation("river"), new ResourceLocation("desert"));

	@SubscribeEvent
	public static void addLivingEntityToBiomes(BiomeLoadingEvent event) {
		if (SPAWN_BIOMES.contains(event.getName()))
			event.getSpawns().getSpawner(MobCategory.AMBIENT).add(new MobSpawnSettings.SpawnerData(EthernalKronuzModEntities.TECHNOMORTO.get(), 1, 1, 1));
	}

	public TechnomortoEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(EthernalKronuzModEntities.TECHNOMORTO.get(), world);
	}

	public TechnomortoEntity(EntityType<TechnomortoEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setCustomName(new TextComponent("Technomorto"));
		setCustomNameVisible(true);
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, true) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1, 40));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(6, new FloatGoal(this));
		this.goalSelector.addGoal(7, new MoveBackToVillageGoal(this, 0.6, false));
		this.goalSelector.addGoal(8, new OpenDoorGoal(this, false));
		this.goalSelector.addGoal(9, new BreakDoorGoal(this, e -> true));
		this.goalSelector.addGoal(10, new OpenDoorGoal(this, true));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ethernal_kronuz:technoblade_never_dies"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level.isClientSide());
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level;

		TechnobaldeRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity);
		return retval;
	}

	public static void init() {
		SpawnPlacements.register(EthernalKronuzModEntities.TECHNOMORTO.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 2);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.5);
		return builder;
	}
}
