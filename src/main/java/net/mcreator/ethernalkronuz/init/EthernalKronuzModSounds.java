
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ethernalkronuz.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EthernalKronuzModSounds {
	public static Map<ResourceLocation, SoundEvent> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "freicken"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "freicken")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "away"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "away")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "necromancer"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "necromancer")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "cabuflamanau"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "cabuflamanau")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "pretodaamadora"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "pretodaamadora")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "gandamoca"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "gandamoca")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "saopaulo"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "saopaulo")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "vasco"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "vasco")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "safira"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "safira")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "freaky"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "freaky")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "terrabladeshot"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "terrabladeshot")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "terrablademeele"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "terrablademeele")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "elementsfootsteps"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "elementsfootsteps")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "erika"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "erika")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "aesir_rift_opening"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "aesir_rift_opening")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "nokkia_hammer_spawn"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "nokkia_hammer_spawn")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "angolaenossa"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "angolaenossa")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "technoblade_never_dies"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "technoblade_never_dies")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "griffin_alive"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "griffin_alive")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "griffin-death"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "griffin-death")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "griffin-hurt"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "griffin-hurt")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "warper-alive"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "warper-alive")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "warper-death"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "warper-death")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "warper-hurt"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "warper-hurt")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "sickle-swing"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "sickle-swing")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "sword-dash"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "sword-dash")));
		REGISTRY.put(new ResourceLocation("ethernal_kronuz", "sword-dash-charged"), new SoundEvent(new ResourceLocation("ethernal_kronuz", "sword-dash-charged")));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
}
