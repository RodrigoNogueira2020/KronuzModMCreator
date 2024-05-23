
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ethernalkronuz.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.ethernalkronuz.enchantment.LifeStealSetupEnchantment;
import net.mcreator.ethernalkronuz.EthernalKronuzMod;

public class EthernalKronuzModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, EthernalKronuzMod.MODID);
	public static final RegistryObject<Enchantment> LIFE_STEAL_SETUP = REGISTRY.register("life_steal_setup", () -> new LifeStealSetupEnchantment());
}
