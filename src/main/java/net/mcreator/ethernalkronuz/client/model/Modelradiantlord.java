package net.mcreator.ethernalkronuz.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.8.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelradiantlord<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("ethernal_kronuz", "modelradiantlord"), "main");
	public final ModelPart head;
	public final ModelPart body;
	public final ModelPart left_arm;
	public final ModelPart right_arm;
	public final ModelPart left_leg;
	public final ModelPart right_leg;
	public final ModelPart left_wing;
	public final ModelPart right_wing;

	public Modelradiantlord(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.left_wing = root.getChild("left_wing");
		this.right_wing = root.getChild("right_wing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -10.0F, -4.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(107, 42).addBox(-1.0F, -3.0F, -4.5F, 2.0F, 2.0F, 0.5F, new CubeDeformation(0.0F)).texOffs(95, 43)
						.addBox(-1.0F, -5.0F, -4.5F, 2.0F, 2.0F, 0.5F, new CubeDeformation(0.0F)).texOffs(95, 47).addBox(-1.0F, -7.0F, -4.5F, 2.0F, 2.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -8.0F, 0.0F));
		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(112, 51).addBox(-1.0F, -2.0F, -0.25F, 2.0F, 1.0F, 0.5F, new CubeDeformation(0.0F)).texOffs(115, 57).addBox(-1.0F, 1.0F, -0.25F, 2.0F, 1.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -4.0F, -4.25F, 0.0F, 0.0F, 1.5708F));
		PartDefinition left_small_wing = head.addOrReplaceChild("left_small_wing", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 6.0F));
		PartDefinition cube_r2 = left_small_wing.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(66, 6).addBox(-1.0F, -10.0F, 0.0F, 1.0F, 10.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition cube_r3 = left_small_wing.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(66, 26).addBox(-1.5F, -1.75F, -0.5F, 1.0F, 5.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.6477F, -12.1293F, 0.5F, 0.0F, 0.0F, 0.1309F));
		PartDefinition cube_r4 = left_small_wing.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(66, 26).addBox(3.5F, 0.25F, -0.5F, 1.0F, 4.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7043F, -12.6637F, 0.5F, 0.0F, 0.0F, 0.3927F));
		PartDefinition cube_r5 = left_small_wing.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(66, 26).addBox(-1.75F, -3.75F, -0.5F, 1.0F, 5.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7043F, -12.6637F, 0.5F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r6 = left_small_wing.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(66, 5).addBox(-1.0F, -10.75F, 0.0F, 1.0F, 10.75F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5498F));
		PartDefinition cube_r7 = left_small_wing.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(66, 4).addBox(-1.0F, -12.0F, 0.0F, 1.0F, 12.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition right_small_wing = head.addOrReplaceChild("right_small_wing", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.0F, 6.5F, 0.0F, 3.1416F, 0.0F));
		PartDefinition cube_r8 = right_small_wing.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(66, 7).addBox(-1.0F, -10.0F, 0.0F, 1.0F, 10.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition cube_r9 = right_small_wing.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(66, 27).addBox(-1.5F, -1.75F, -0.5F, 1.0F, 5.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.6477F, -12.1293F, 0.5F, 0.0F, 0.0F, 0.1309F));
		PartDefinition cube_r10 = right_small_wing.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(66, 27).addBox(3.5F, 0.25F, -0.5F, 1.0F, 4.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7043F, -12.6637F, 0.5F, 0.0F, 0.0F, 0.3927F));
		PartDefinition cube_r11 = right_small_wing.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(66, 27).addBox(-1.75F, -3.75F, -0.5F, 1.0F, 5.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7043F, -12.6637F, 0.5F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r12 = right_small_wing.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(66, 6).addBox(-1.0F, -10.75F, 0.0F, 1.0F, 10.75F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5498F));
		PartDefinition cube_r13 = right_small_wing.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(66, 5).addBox(-1.0F, -12.0F, 0.0F, 1.0F, 12.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 20).addBox(-5.0F, -8.0F, -2.0F, 10.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition crystal = body.addOrReplaceChild("crystal", CubeListBuilder.create().texOffs(89, 48).addBox(-1.0F, -3.0F, -0.5F, 2.0F, 6.0F, 0.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -2.0F));
		PartDefinition cube_r14 = crystal.addOrReplaceChild("cube_r14",
				CubeListBuilder.create().texOffs(66, 60).addBox(7.0F, -2.0F, 1.75F, 4.0F, 1.0F, 0.5F, new CubeDeformation(0.0F)).texOffs(67, 53).addBox(7.0F, 1.0F, 1.75F, 4.0F, 1.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -9.0F, -2.25F, 0.0F, 0.0F, 1.5708F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(22, 42).addBox(-2.5F, 0.0F, -2.0F, 5.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(7.5F, -8.0F, 1.0F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 0).addBox(-2.5F, 0.0F, -2.0F, 5.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.5F, -8.0F, 1.0F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 42).addBox(-2.5F, 0.0F, -3.0F, 5.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 8.0F, 1.0F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(32, 20).addBox(-2.5F, 0.0F, -3.0F, 5.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 8.0F, 1.0F));
		PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(78, 1).mirror().addBox(-17.0F, -2.0F, 0.0F, 17.0F, 2.0F, 0.25F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-1.0F, -3.0F, 4.0F));
		PartDefinition cube_r15 = left_wing.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(78, 5).addBox(-17.0F, -2.0F, 0.75F, 18.0F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.2182F));
		PartDefinition cube_r16 = left_wing.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(78, 34).addBox(-8.25F, -2.0F, -0.125F, 10.25F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-14.2652F, -16.2065F, 0.125F, 0.0F, 0.0F, 1.7453F));
		PartDefinition cube_r17 = left_wing.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(78, 22).addBox(0.5F, 4.25F, -0.125F, 3.75F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-17.7092F, -11.3729F, 0.125F, 0.0F, 0.0F, 0.5672F));
		PartDefinition cube_r18 = left_wing.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(78, 26).addBox(-1.5F, 0.5F, -0.125F, 5.25F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-17.7092F, -11.3729F, 0.125F, 0.0F, 0.0F, 0.9599F));
		PartDefinition cube_r19 = left_wing.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(78, 30).addBox(-6.0F, -0.25F, -0.125F, 7.5F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-15.539F, -13.1343F, 0.125F, 0.0F, 0.0F, 1.3526F));
		PartDefinition cube_r20 = left_wing.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(78, 13).addBox(-19.5F, -2.0F, 0.75F, 20.5F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.6109F));
		PartDefinition cube_r21 = left_wing.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(78, 17).addBox(-19.5F, -2.0F, 0.75F, 20.5F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.7854F));
		PartDefinition cube_r22 = left_wing.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(78, 9).addBox(-18.0F, -2.0F, 0.75F, 19.0F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.3927F));
		PartDefinition right_wing = partdefinition.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(78, 1).mirror().addBox(-17.0F, -2.0F, 0.0F, 17.0F, 2.0F, 0.25F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, -3.0F, 4.25F, 3.1416F, 0.0F, 3.1067F));
		PartDefinition cube_r23 = right_wing.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(78, 5).addBox(-17.0F, -2.0F, 0.75F, 18.0F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.2182F));
		PartDefinition cube_r24 = right_wing.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(78, 34).addBox(-8.25F, -2.0F, -0.125F, 10.25F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-14.2652F, -16.2065F, 0.125F, 0.0F, 0.0F, 1.7453F));
		PartDefinition cube_r25 = right_wing.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(78, 22).addBox(0.5F, 4.25F, -0.125F, 3.75F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-17.7092F, -11.3729F, 0.125F, 0.0F, 0.0F, 0.5672F));
		PartDefinition cube_r26 = right_wing.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(78, 26).addBox(-1.5F, 0.5F, -0.125F, 5.25F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-17.7092F, -11.3729F, 0.125F, 0.0F, 0.0F, 0.9599F));
		PartDefinition cube_r27 = right_wing.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(78, 30).addBox(-6.0F, -0.25F, -0.125F, 7.5F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-15.539F, -13.1343F, 0.125F, 0.0F, 0.0F, 1.3526F));
		PartDefinition cube_r28 = right_wing.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(78, 13).addBox(-19.5F, -2.0F, 0.75F, 20.5F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.6109F));
		PartDefinition cube_r29 = right_wing.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(78, 17).mirror().addBox(-19.5F, -2.0F, 0.75F, 20.5F, 2.0F, 0.25F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.7854F));
		PartDefinition cube_r30 = right_wing.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(78, 9).addBox(-18.0F, -2.0F, 0.75F, 19.0F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.3927F));
		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
