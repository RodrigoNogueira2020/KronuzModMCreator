
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ethernalkronuz.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.ethernalkronuz.entity.WarperEntity;
import net.mcreator.ethernalkronuz.entity.TerraBladeProjectileEntity;
import net.mcreator.ethernalkronuz.entity.TechnomortoEntity;
import net.mcreator.ethernalkronuz.entity.TechnobaldeEntity;
import net.mcreator.ethernalkronuz.entity.RedRadiantLordTheRiseEntity;
import net.mcreator.ethernalkronuz.entity.RadiantLordNoColorTrialEntity;
import net.mcreator.ethernalkronuz.entity.RadiantLordGreenTrialEntity;
import net.mcreator.ethernalkronuz.entity.PurpleRadiantLordTheRiseEntity;
import net.mcreator.ethernalkronuz.entity.NullEntityEntity;
import net.mcreator.ethernalkronuz.entity.GriffinAnimatedEntity;
import net.mcreator.ethernalkronuz.entity.GinukaPowerSetupEntity;
import net.mcreator.ethernalkronuz.entity.DivineBowEntity;
import net.mcreator.ethernalkronuz.entity.BlessingEntity;
import net.mcreator.ethernalkronuz.EthernalKronuzMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EthernalKronuzModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, EthernalKronuzMod.MODID);
	public static final RegistryObject<EntityType<WarperEntity>> WARPER = register("warper",
			EntityType.Builder.<WarperEntity>of(WarperEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WarperEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<GinukaPowerSetupEntity>> GINUKA_POWER_SETUP = register("ginuka_power_setup",
			EntityType.Builder.<GinukaPowerSetupEntity>of(GinukaPowerSetupEntity::new, MobCategory.WATER_CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GinukaPowerSetupEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TechnomortoEntity>> TECHNOMORTO = register("technomorto",
			EntityType.Builder.<TechnomortoEntity>of(TechnomortoEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TechnomortoEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<TechnobaldeEntity>> TECHNOBALDE = register("technobalde",
			EntityType.Builder.<TechnobaldeEntity>of(TechnobaldeEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(TechnobaldeEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<NullEntityEntity>> NULL_ENTITY = register("null_entity",
			EntityType.Builder.<NullEntityEntity>of(NullEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NullEntityEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BlessingEntity>> BLESSING = register("blessing",
			EntityType.Builder.<BlessingEntity>of(BlessingEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BlessingEntity::new).fireImmune().sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<GriffinAnimatedEntity>> GRIFFIN_ANIMATED = register("griffin_animated",
			EntityType.Builder.<GriffinAnimatedEntity>of(GriffinAnimatedEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(GriffinAnimatedEntity::new)

					.sized(2f, 2f));
	public static final RegistryObject<EntityType<DivineBowEntity>> DIVINE_BOW = register("projectile_divine_bow",
			EntityType.Builder.<DivineBowEntity>of(DivineBowEntity::new, MobCategory.MISC).setCustomClientFactory(DivineBowEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<TerraBladeProjectileEntity>> TERRA_BLADE_PROJECTILE = register("projectile_terra_blade_projectile", EntityType.Builder.<TerraBladeProjectileEntity>of(TerraBladeProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(TerraBladeProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<RadiantLordNoColorTrialEntity>> RADIANT_LORD_NO_COLOR_TRIAL = register("radiant_lord_no_color_trial",
			EntityType.Builder.<RadiantLordNoColorTrialEntity>of(RadiantLordNoColorTrialEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(RadiantLordNoColorTrialEntity::new).fireImmune().sized(5f, 2.5f));
	public static final RegistryObject<EntityType<RadiantLordGreenTrialEntity>> RADIANT_LORD_GREEN_TRIAL = register("radiant_lord_green_trial", EntityType.Builder.<RadiantLordGreenTrialEntity>of(RadiantLordGreenTrialEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RadiantLordGreenTrialEntity::new).fireImmune().sized(0.6f, 2.7f));
	public static final RegistryObject<EntityType<RedRadiantLordTheRiseEntity>> RED_RADIANT_LORD_THE_RISE = register("red_radiant_lord_the_rise",
			EntityType.Builder.<RedRadiantLordTheRiseEntity>of(RedRadiantLordTheRiseEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(RedRadiantLordTheRiseEntity::new).fireImmune().sized(0.6f, 2.7f));
	public static final RegistryObject<EntityType<PurpleRadiantLordTheRiseEntity>> PURPLE_RADIANT_LORD_THE_RISE = register("purple_radiant_lord_the_rise",
			EntityType.Builder.<PurpleRadiantLordTheRiseEntity>of(PurpleRadiantLordTheRiseEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)
					.setCustomClientFactory(PurpleRadiantLordTheRiseEntity::new).fireImmune().sized(0.6f, 2.7f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			WarperEntity.init();
			GinukaPowerSetupEntity.init();
			TechnomortoEntity.init();
			TechnobaldeEntity.init();
			NullEntityEntity.init();
			BlessingEntity.init();
			GriffinAnimatedEntity.init();
			RadiantLordNoColorTrialEntity.init();
			RadiantLordGreenTrialEntity.init();
			RedRadiantLordTheRiseEntity.init();
			PurpleRadiantLordTheRiseEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(WARPER.get(), WarperEntity.createAttributes().build());
		event.put(GINUKA_POWER_SETUP.get(), GinukaPowerSetupEntity.createAttributes().build());
		event.put(TECHNOMORTO.get(), TechnomortoEntity.createAttributes().build());
		event.put(TECHNOBALDE.get(), TechnobaldeEntity.createAttributes().build());
		event.put(NULL_ENTITY.get(), NullEntityEntity.createAttributes().build());
		event.put(BLESSING.get(), BlessingEntity.createAttributes().build());
		event.put(GRIFFIN_ANIMATED.get(), GriffinAnimatedEntity.createAttributes().build());
		event.put(RADIANT_LORD_NO_COLOR_TRIAL.get(), RadiantLordNoColorTrialEntity.createAttributes().build());
		event.put(RADIANT_LORD_GREEN_TRIAL.get(), RadiantLordGreenTrialEntity.createAttributes().build());
		event.put(RED_RADIANT_LORD_THE_RISE.get(), RedRadiantLordTheRiseEntity.createAttributes().build());
		event.put(PURPLE_RADIANT_LORD_THE_RISE.get(), PurpleRadiantLordTheRiseEntity.createAttributes().build());
	}
}
