
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ethernalkronuz.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.ethernalkronuz.potion.RadiantLordEffectMobEffect;
import net.mcreator.ethernalkronuz.potion.HellEmpowermentMobEffect;
import net.mcreator.ethernalkronuz.potion.EndEmpowermentMobEffect;
import net.mcreator.ethernalkronuz.potion.CancroMobEffect;
import net.mcreator.ethernalkronuz.potion.BTEffectMobEffect;
import net.mcreator.ethernalkronuz.potion.AsgardEmpowermentMobEffect;
import net.mcreator.ethernalkronuz.potion.AsgardEmpowermentCooldownMobEffect;
import net.mcreator.ethernalkronuz.potion.AndarilhoDaCaveEffectMobEffect;
import net.mcreator.ethernalkronuz.EthernalKronuzMod;

public class EthernalKronuzModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, EthernalKronuzMod.MODID);
	public static final RegistryObject<MobEffect> RADIANT_LORD_EFFECT = REGISTRY.register("radiant_lord_effect", () -> new RadiantLordEffectMobEffect());
	public static final RegistryObject<MobEffect> ANDARILHO_DA_CAVE_EFFECT = REGISTRY.register("andarilho_da_cave_effect", () -> new AndarilhoDaCaveEffectMobEffect());
	public static final RegistryObject<MobEffect> BT_EFFECT = REGISTRY.register("bt_effect", () -> new BTEffectMobEffect());
	public static final RegistryObject<MobEffect> HELL_EMPOWERMENT = REGISTRY.register("hell_empowerment", () -> new HellEmpowermentMobEffect());
	public static final RegistryObject<MobEffect> END_EMPOWERMENT = REGISTRY.register("end_empowerment", () -> new EndEmpowermentMobEffect());
	public static final RegistryObject<MobEffect> ASGARD_EMPOWERMENT = REGISTRY.register("asgard_empowerment", () -> new AsgardEmpowermentMobEffect());
	public static final RegistryObject<MobEffect> ASGARD_EMPOWERMENT_COOLDOWN = REGISTRY.register("asgard_empowerment_cooldown", () -> new AsgardEmpowermentCooldownMobEffect());
	public static final RegistryObject<MobEffect> CANCRO = REGISTRY.register("cancro", () -> new CancroMobEffect());
}
