
package net.mcreator.ethernalkronuz.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.ethernalkronuz.entity.BlessingEntity;
import net.mcreator.ethernalkronuz.client.model.Modelbigtesta_blessing;

public class BlessingRenderer extends MobRenderer<BlessingEntity, Modelbigtesta_blessing<BlessingEntity>> {
	public BlessingRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelbigtesta_blessing(context.bakeLayer(Modelbigtesta_blessing.LAYER_LOCATION)), 0.6f);
	}

	@Override
	public ResourceLocation getTextureLocation(BlessingEntity entity) {
		return new ResourceLocation("ethernal_kronuz:textures/entities/bigtesta_blessing.png");
	}
}
