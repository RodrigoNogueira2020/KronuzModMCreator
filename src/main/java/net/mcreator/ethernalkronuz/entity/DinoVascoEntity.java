package net.mcreator.ethernalkronuz.entity;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.ethernalkronuz.world.inventory.InventoryUIDinoVascoMenu;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModEntities;

import javax.annotation.Nullable;

import java.util.UUID;
import java.util.EnumSet;

public class DinoVascoEntity extends PathfinderMob {
	private static final Logger LOGGER = LogManager.getLogger();
	@Nullable
	private UUID ownerUUID;
	private int soundTimer = 0;
	private static final int SOUND_INTERVAL = 1200;
	public boolean uiOpen = false;
	private static final String[] CUSTOM_SOUNDS = {"ethernal_kronuz:irritado-vc", "ethernal_kronuz:choro-vc", "ethernal_kronuz:literalmente-vc", "ethernal_kronuz:morre-no-inferno-vc", "ethernal_kronuz:mano-vc"};

	public DinoVascoEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(EthernalKronuzModEntities.DINO_VASCO.get(), world);
	}

	public DinoVascoEntity(EntityType<DinoVascoEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setCustomName(new TextComponent("Dino Vasco"));
		setCustomNameVisible(true);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(source, looting, recentlyHitIn);
		this.spawnAtLocation(new ItemStack(Items.COOKIE));
	}

	// ── CRÍTICO: DinoVasco NÃO pode atacar outro DinoVasco ───────────────────
	@Override
	public boolean canAttack(LivingEntity target) {
		if (target == this)
			return false;
		if (target instanceof DinoVascoEntity)
			return false; // nunca ataca outro DinoVasco
		return true;
	}

	// ── Goals ─────────────────────────────────────────────────────────────────
	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new FloatGoal(this));
		this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2, true));
		this.goalSelector.addGoal(3, new DinoVascoBedSleepGoal(this));
		this.goalSelector.addGoal(4, new DinoVascoFollowOwnerGoal(this));
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new DinoVascoCopyOwnerTargetGoal(this));
	}

	// ── Dono ─────────────────────────────────────────────────────────────────
	@Nullable
	public UUID getOwnerUUID() {
		return ownerUUID;
	}

	public void setOwnerUUID(@Nullable UUID uuid) {
		this.ownerUUID = uuid;
	}

	public boolean isTamed() {
		return ownerUUID != null;
	}

	@Nullable
	public Player getOwner() {
		if (ownerUUID == null || this.level.isClientSide())
			return null;
		return this.level.getPlayerByUUID(ownerUUID);
	}

	// ── Tick ─────────────────────────────────────────────────────────────────
	@Override
	public void tick() {
		super.tick();
		if (!this.level.isClientSide()) {
			if (uiOpen) {
				this.getNavigation().stop();
				return;
			}
			soundTimer++;
			if (soundTimer >= SOUND_INTERVAL) {
				soundTimer = 0;
				playRandomCustomSound();
			}
		}
	}

	private void playRandomCustomSound() {
		int roll = this.random.nextInt(4);
		if (roll == 3)
			return; // 25% silêncio
		String soundName = CUSTOM_SOUNDS[roll];
		SoundEvent sound = ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(soundName));
		if (sound == null) {
			LOGGER.warn("[DinoVasco] SoundEvent nao encontrado no registry: {}", soundName);
			return;
		}
		this.level.playSound(null, this.getX(), this.getY(), this.getZ(), sound, SoundSource.NEUTRAL, 1.0f, 1.0f);
	}

	// ── Interação botão direito ───────────────────────────────────────────────
	@Override
	protected InteractionResult mobInteract(Player player, InteractionHand hand) {
		if (hand != InteractionHand.MAIN_HAND)
			return super.mobInteract(player, hand);
		ItemStack stack = player.getItemInHand(hand);
		if (!this.level.isClientSide()) {
			if (!isTamed() && stack.is(Items.COOKIE)) {
				ownerUUID = player.getUUID();
				this.level.broadcastEntityEvent(this, (byte) 7);
				if (!player.getAbilities().instabuild)
					stack.shrink(1);
				return InteractionResult.SUCCESS;
			}
			if (isTamed() && player.getUUID().equals(ownerUUID) && stack.is(Items.COOKIE)) {
				if (this.getHealth() < this.getMaxHealth()) {
					this.heal(4.0f);
					if (!player.getAbilities().instabuild)
						stack.shrink(1);
				}
				return InteractionResult.SUCCESS;
			}
			if (isTamed() && player.getUUID().equals(ownerUUID)) {
				uiOpen = true;
				DinoVascoEntity self = this;
				NetworkHooks.openGui((ServerPlayer) player, new SimpleMenuProvider((id, inv, p) -> new InventoryUIDinoVascoMenu(id, inv, self), new TextComponent("Dino Vasco")), buf -> buf.writeInt(this.getId()));
				return InteractionResult.SUCCESS;
			}
		}
		return super.mobInteract(player, hand);
	}

	@Override
	public void handleEntityEvent(byte id) {
		if (id == 7) {
			for (int i = 0; i < 7; i++) {
				this.level.addParticle(ParticleTypes.HEART, this.getX() + this.random.nextFloat() * this.getBbWidth() * 2.0F - this.getBbWidth(), this.getY() + 0.5D + this.random.nextFloat() * this.getBbHeight(),
						this.getZ() + this.random.nextFloat() * this.getBbWidth() * 2.0F - this.getBbWidth(), 0, 0, 0);
			}
		} else {
			super.handleEntityEvent(id);
		}
	}

	// ── NBT ───────────────────────────────────────────────────────────────────
	@Override
	public void addAdditionalSaveData(CompoundTag tag) {
		super.addAdditionalSaveData(tag);
		if (ownerUUID != null)
			tag.putUUID("OwnerUUID", ownerUUID);
		tag.putInt("SoundTimer", soundTimer);
	}

	@Override
	public void readAdditionalSaveData(CompoundTag tag) {
		super.readAdditionalSaveData(tag);
		if (tag.hasUUID("OwnerUUID"))
			ownerUUID = tag.getUUID("OwnerUUID");
		soundTimer = tag.getInt("SoundTimer");
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ethernal_kronuz:mano-vc"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ethernal_kronuz:elementsfootsteps")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		return builder;
	}

	// ═════════════════════════════════════════════════════════════════════════
	//  GOAL: Segue o dono
	// ═════════════════════════════════════════════════════════════════════════
	static class DinoVascoFollowOwnerGoal extends Goal {
		private final DinoVascoEntity dino;
		private Player owner;
		private static final double MIN_DIST_SQ = 9.0;
		private static final double MAX_DIST_SQ = 100.0;

		public DinoVascoFollowOwnerGoal(DinoVascoEntity dino) {
			this.dino = dino;
			this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
		}

		@Override
		public boolean canUse() {
			if (dino.uiOpen)
				return false;
			Player o = dino.getOwner();
			if (o == null || o.isSpectator())
				return false;
			if (dino.distanceToSqr(o) <= MIN_DIST_SQ)
				return false;
			this.owner = o;
			return true;
		}

		@Override
		public boolean canContinueToUse() {
			if (dino.uiOpen || owner == null || owner.isSpectator())
				return false;
			return dino.distanceToSqr(owner) > MIN_DIST_SQ;
		}

		@Override
		public void start() {
			dino.getNavigation().moveTo(owner, 1.2);
		}

		@Override
		public void tick() {
			dino.getLookControl().setLookAt(owner, 10.0f, dino.getMaxHeadXRot());
			if (dino.distanceToSqr(owner) > MAX_DIST_SQ)
				dino.getNavigation().moveTo(owner, 1.4);
		}

		@Override
		public void stop() {
			owner = null;
			dino.getNavigation().stop();
		}
	}

	// ═════════════════════════════════════════════════════════════════════════
	//  GOAL: Copia o alvo do dono — NUNCA define DinoVasco como alvo
	// ═════════════════════════════════════════════════════════════════════════
	static class DinoVascoCopyOwnerTargetGoal extends TargetGoal {
		private final DinoVascoEntity dino;
		private LivingEntity ownerLastHurt;
		private int timestamp;

		public DinoVascoCopyOwnerTargetGoal(DinoVascoEntity dino) {
			super(dino, false);
			this.dino = dino;
			this.setFlags(EnumSet.of(Flag.TARGET));
		}

		@Override
		public boolean canUse() {
			if (!dino.isTamed())
				return false;
			Player owner = dino.getOwner();
			if (owner == null)
				return false;
			LivingEntity target = owner.getLastHurtMob();
			// Ignora: nulo, si próprio, ou outro DinoVasco
			if (target == null)
				return false;
			if (target == dino)
				return false;
			if (target instanceof DinoVascoEntity)
				return false;
			if (owner.getLastHurtMobTimestamp() == timestamp)
				return false;
			this.ownerLastHurt = target;
			this.timestamp = owner.getLastHurtMobTimestamp();
			return true;
		}

		@Override
		public void start() {
			dino.setTarget(ownerLastHurt);
			super.start();
		}

		@Override
		public boolean canContinueToUse() {
			LivingEntity t = dino.getTarget();
			return t != null && t.isAlive() && !(t instanceof DinoVascoEntity);
		}
	}

	// ═════════════════════════════════════════════════════════════════════════
	//  GOAL: Dorme numa cama desocupada perto do dono
	// ═════════════════════════════════════════════════════════════════════════
	static class DinoVascoBedSleepGoal extends Goal {
		private final DinoVascoEntity dino;
		private BlockPos targetBed = null;
		private static final int SEARCH_RADIUS = 16;

		public DinoVascoBedSleepGoal(DinoVascoEntity dino) {
			this.dino = dino;
			this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
		}

		@Override
		public boolean canUse() {
			if (dino.level.isClientSide() || dino.uiOpen)
				return false;
			if (!dino.level.isNight() || dino.getTarget() != null)
				return false;
			Player owner = dino.getOwner();
			if (owner == null)
				return false;
			BlockPos ownerPos = owner.blockPosition();
			for (BlockPos pos : BlockPos.betweenClosed(ownerPos.offset(-SEARCH_RADIUS, -2, -SEARCH_RADIUS), ownerPos.offset(SEARCH_RADIUS, 2, SEARCH_RADIUS))) {
				BlockState state = dino.level.getBlockState(pos);
				if (state.getBlock() instanceof BedBlock) {
					boolean isHead = state.getValue(BedBlock.PART) == BedPart.HEAD;
					boolean isOccupied = state.getValue(BedBlock.OCCUPIED);
					if (isHead && !isOccupied) {
						targetBed = pos.immutable();
						return true;
					}
				}
			}
			return false;
		}

		@Override
		public boolean canContinueToUse() {
			return dino.level.isNight() && dino.getTarget() == null && targetBed != null && !dino.uiOpen;
		}

		@Override
		public void start() {
			if (targetBed != null)
				dino.getNavigation().moveTo(targetBed.getX() + 0.5, targetBed.getY(), targetBed.getZ() + 0.5, 1.0);
		}

		@Override
		public void tick() {
			if (targetBed == null)
				return;
			if (dino.blockPosition().closerThan(targetBed, 1.5)) {
				dino.getNavigation().stop();
				dino.getLookControl().setLookAt(targetBed.getX() + 0.5, targetBed.getY(), targetBed.getZ() + 0.5);
			}
		}

		@Override
		public void stop() {
			targetBed = null;
			dino.getNavigation().stop();
		}
	}
}
