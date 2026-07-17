package net.mcreator.ethernalkronuz;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemProperties {
	public static void addCustomItemProperties() {
		makeBow(EthernalKronuzModItems.DIVINE_BOW.get());
	}

	private static void makeBow(Item item) {
		ItemProperties.register(item, new ResourceLocation("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
			if (p_174637_ == null)
				return 0.0f;
			else
				return p_174637_.getUseItem() != p_174635_ ? 0.0f : (float) (p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 10.0f;
		});
		ItemProperties.register(item, new ResourceLocation("pulling"), (p_174630_, p_174631_, p_174632_, p_174633_) -> {
			return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0f : 0.0f;
		});
	}
}
