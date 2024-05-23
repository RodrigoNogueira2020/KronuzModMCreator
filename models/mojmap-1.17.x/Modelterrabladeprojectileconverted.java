// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelterrabladeprojectileconverted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "terrabladeprojectileconverted"), "main");
	private final ModelPart Projectile;

	public Modelterrabladeprojectileconverted(ModelPart root) {
		this.Projectile = root.getChild("Projectile");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Projectile = partdefinition.addOrReplaceChild("Projectile",
				CubeListBuilder.create().texOffs(2, 4)
						.addBox(0.0F, 9.1F, -1.5F, 0.25F, 0.25F, 2.75F, new CubeDeformation(0.0F)).texOffs(0, 2)
						.addBox(0.0F, 9.35F, -2.0F, 0.25F, 0.55F, 3.25F, new CubeDeformation(0.0F)).texOffs(4, 6)
						.addBox(0.0F, 9.9F, -1.5F, 0.25F, 0.25F, 2.75F, new CubeDeformation(0.0F)).texOffs(7, 8)
						.addBox(0.0F, 9.0F, 1.25F, 0.25F, 1.25F, 0.5F, new CubeDeformation(0.0F)).texOffs(2, 3)
						.addBox(0.0F, 8.75F, 1.5F, 0.25F, 0.25F, 0.75F, new CubeDeformation(0.0F)).texOffs(6, 7)
						.addBox(0.0F, 10.25F, 1.5F, 0.25F, 0.25F, 0.75F, new CubeDeformation(0.0F)).texOffs(1, 4)
						.addBox(0.0F, 9.5F, 1.75F, 0.25F, 0.25F, 1.5F, new CubeDeformation(0.0F)).texOffs(0, 1)
						.addBox(0.0F, 9.5F, -2.5F, 0.25F, 0.25F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(9.6F, 20.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Projectile.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}