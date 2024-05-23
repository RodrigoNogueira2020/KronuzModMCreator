// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelbigtesta_blessing<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "bigtesta_blessing"), "main");
	private final ModelPart ALL;

	public Modelbigtesta_blessing(ModelPart root) {
		this.ALL = root.getChild("ALL");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ALL = partdefinition.addOrReplaceChild("ALL", CubeListBuilder.create(),
				PartPose.offset(0.0F, -9.7F, 0.0F));

		PartDefinition antlers = ALL.addOrReplaceChild("antlers",
				CubeListBuilder.create().texOffs(28, 26)
						.addBox(-3.6642F, -6.3107F, -0.5F, 0.5F, 1.25F, 0.5F, new CubeDeformation(0.0F)).texOffs(28, 22)
						.addBox(3.0858F, -6.2107F, -0.5F, 0.5F, 1.25F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition cube_r1 = antlers.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(29, 24)
						.addBox(0.25F, -0.25F, -0.25F, 0.5F, 1.25F, 0.5F, new CubeDeformation(0.0F)).texOffs(13, 24)
						.addBox(-1.0F, -1.75F, -0.25F, 0.5F, 2.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(3.0836F, -4.6339F, -0.25F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r2 = antlers.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(24, 25)
						.addBox(-1.0F, -5.25F, -0.25F, 0.5F, 0.75F, 0.5F, new CubeDeformation(0.0F)).texOffs(17, 24)
						.addBox(-1.0F, -4.0F, -0.25F, 0.5F, 2.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0784F, -0.568F, -0.25F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r3 = antlers.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(21, 24)
						.addBox(-0.75F, -0.25F, -0.25F, 0.5F, 1.25F, 0.5F, new CubeDeformation(0.0F)).texOffs(9, 21)
						.addBox(0.75F, -1.75F, -0.25F, 0.5F, 2.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-3.1642F, -4.8107F, -0.25F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r4 = antlers.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(29, 28)
						.addBox(-0.5F, -2.0F, -0.25F, 0.5F, 1.0F, 0.5F, new CubeDeformation(0.0F)).texOffs(29, 19)
						.addBox(-0.5F, -0.55F, -0.25F, 0.5F, 2.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.75F, -3.75F, -0.25F, 0.0F, 0.0F, -0.7854F));

		PartDefinition sphere = ALL.addOrReplaceChild("sphere",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(15, 15)
						.addBox(-1.5F, -1.5F, 1.75F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(8, 12)
						.addBox(-1.5F, -1.5F, -2.75F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r5 = sphere.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(8, 8)
						.addBox(-1.5F, -1.0F, -2.75F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 8)
						.addBox(-1.5F, -1.5F, 1.75F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r6 = sphere.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(12, 0)
						.addBox(-1.5F, -1.5F, -2.75F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 12)
						.addBox(-1.5F, -1.5F, 1.75F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		ALL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.ALL.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.ALL.xRot = headPitch / (180F / (float) Math.PI);
	}
}