
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ethernalkronuz.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.ethernalkronuz.client.model.Modelundead_technoblade;
import net.mcreator.ethernalkronuz.client.model.Modelterrabladeprojectileconverted;
import net.mcreator.ethernalkronuz.client.model.Modeltechnoblade;
import net.mcreator.ethernalkronuz.client.model.Modelrl_armor;
import net.mcreator.ethernalkronuz.client.model.Modelradiantlord;
import net.mcreator.ethernalkronuz.client.model.ModelnullEntity;
import net.mcreator.ethernalkronuz.client.model.Modelmosso_cyrstal_armor_no_legs;
import net.mcreator.ethernalkronuz.client.model.Modelmosso_crystal_armor_legs;
import net.mcreator.ethernalkronuz.client.model.Modelgriffin;
import net.mcreator.ethernalkronuz.client.model.Modelfaking_ell_armor_no_legs;
import net.mcreator.ethernalkronuz.client.model.Modelfaking_ell_armor_legs;
import net.mcreator.ethernalkronuz.client.model.Modelbigtesta_blessing;
import net.mcreator.ethernalkronuz.client.model.Modelairport_steel_armor_no_legs;
import net.mcreator.ethernalkronuz.client.model.Modelairport_steel_armor_legs;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class EthernalKronuzModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelnullEntity.LAYER_LOCATION, ModelnullEntity::createBodyLayer);
		event.registerLayerDefinition(Modelmosso_crystal_armor_legs.LAYER_LOCATION, Modelmosso_crystal_armor_legs::createBodyLayer);
		event.registerLayerDefinition(Modelairport_steel_armor_no_legs.LAYER_LOCATION, Modelairport_steel_armor_no_legs::createBodyLayer);
		event.registerLayerDefinition(Modelbigtesta_blessing.LAYER_LOCATION, Modelbigtesta_blessing::createBodyLayer);
		event.registerLayerDefinition(Modelterrabladeprojectileconverted.LAYER_LOCATION, Modelterrabladeprojectileconverted::createBodyLayer);
		event.registerLayerDefinition(Modelfaking_ell_armor_no_legs.LAYER_LOCATION, Modelfaking_ell_armor_no_legs::createBodyLayer);
		event.registerLayerDefinition(Modelgriffin.LAYER_LOCATION, Modelgriffin::createBodyLayer);
		event.registerLayerDefinition(Modelrl_armor.LAYER_LOCATION, Modelrl_armor::createBodyLayer);
		event.registerLayerDefinition(Modelfaking_ell_armor_legs.LAYER_LOCATION, Modelfaking_ell_armor_legs::createBodyLayer);
		event.registerLayerDefinition(Modeltechnoblade.LAYER_LOCATION, Modeltechnoblade::createBodyLayer);
		event.registerLayerDefinition(Modelairport_steel_armor_legs.LAYER_LOCATION, Modelairport_steel_armor_legs::createBodyLayer);
		event.registerLayerDefinition(Modelradiantlord.LAYER_LOCATION, Modelradiantlord::createBodyLayer);
		event.registerLayerDefinition(Modelmosso_cyrstal_armor_no_legs.LAYER_LOCATION, Modelmosso_cyrstal_armor_no_legs::createBodyLayer);
		event.registerLayerDefinition(Modelundead_technoblade.LAYER_LOCATION, Modelundead_technoblade::createBodyLayer);
	}
}
