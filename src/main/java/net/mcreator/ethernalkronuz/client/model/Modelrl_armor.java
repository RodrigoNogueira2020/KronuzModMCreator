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

// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelrl_armor<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("ethernal_kronuz", "modelrl_armor"), "main");
	public final ModelPart Head;
	public final ModelPart Body;
	public final ModelPart RightArm;
	public final ModelPart LeftArm;
	public final ModelPart RightLeg;
	public final ModelPart LeftLeg;

	public Modelrl_armor(ModelPart root) {
		this.Head = root.getChild("Head");
		this.Body = root.getChild("Body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition left_small_wing = Head.addOrReplaceChild("left_small_wing", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 6.0F));
		PartDefinition cube_r1 = left_small_wing.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(61, 6).addBox(-1.0F, -10.0F, 0.0F, 1.0F, 10.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 6.0F, -1.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition cube_r2 = left_small_wing.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(61, 26).addBox(-1.5F, -1.75F, -0.5F, 1.0F, 5.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.6477F, -6.1293F, -0.5F, 0.0F, 0.0F, 0.1309F));
		PartDefinition cube_r3 = left_small_wing.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(61, 26).addBox(3.5F, 0.25F, -0.5F, 1.0F, 4.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7043F, -6.6637F, -0.5F, 0.0F, 0.0F, 0.3927F));
		PartDefinition cube_r4 = left_small_wing.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(61, 26).addBox(-1.75F, -3.75F, -0.5F, 1.0F, 5.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7043F, -6.6637F, -0.5F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r5 = left_small_wing.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(61, 5).addBox(-1.0F, -10.75F, 0.0F, 1.0F, 10.75F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 6.0F, -1.0F, 0.0F, 0.0F, 0.5498F));
		PartDefinition cube_r6 = left_small_wing.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(61, 4).addBox(-1.0F, -12.0F, 0.0F, 1.0F, 12.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 6.0F, -1.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition right_small_wing = Head.addOrReplaceChild("right_small_wing", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.0F, 6.5F, 0.0F, 3.1416F, 0.0F));
		PartDefinition cube_r7 = right_small_wing.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(60, 6).addBox(3.2426F, -5.7574F, 1.0F, 1.0F, 10.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition cube_r8 = right_small_wing.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(60, 26).addBox(-0.7168F, 4.1987F, 0.5F, 1.0F, 5.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(6.6477F, -12.1293F, 0.5F, 0.0F, 0.0F, 0.1309F));
		PartDefinition cube_r9 = right_small_wing.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(60, 26).addBox(5.7961F, 5.7933F, 0.5F, 1.0F, 4.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7043F, -12.6637F, 0.5F, 0.0F, 0.0F, 0.3927F));
		PartDefinition cube_r10 = right_small_wing.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(60, 26).addBox(-4.0461F, 1.7933F, 0.5F, 1.0F, 5.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(4.7043F, -12.6637F, 0.5F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r11 = right_small_wing.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(60, 5).addBox(2.135F, -5.6342F, 1.0F, 1.0F, 10.75F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5498F));
		PartDefinition cube_r12 = right_small_wing.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(60, 4).addBox(1.2961F, -6.4567F, 1.0F, 1.0F, 12.0F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition crystal = Head.addOrReplaceChild("crystal", CubeListBuilder.create().texOffs(37, 16).addBox(-1.25F, 0.9F, -0.25F, 2.5F, 1.85F, 0.5F, new CubeDeformation(0.0F)).texOffs(0, 0)
				.addBox(-1.2F, -1.0F, -0.25F, 2.4F, 2.0F, 0.5F, new CubeDeformation(0.0F)).texOffs(0, 5).addBox(-1.25F, -2.9F, -0.25F, 2.5F, 1.9F, 0.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -5.25F));
		PartDefinition cube_r13 = crystal.addOrReplaceChild("cube_r13",
				CubeListBuilder.create().texOffs(0, 3).addBox(-1.0F, 1.2F, -0.25F, 2.0F, 0.8F, 0.5F, new CubeDeformation(0.0F)).texOffs(13, 17).addBox(-1.0F, -2.0F, -0.25F, 2.0F, 0.8F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition left_wing = Body.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(78, 1).mirror().addBox(-17.0F, 8.0F, -1.0F, 17.0F, 2.0F, 0.25F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, -3.0F, 4.0F));
		PartDefinition cube_r14 = left_wing.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(27, 0).addBox(-17.0F, -2.0F, 0.75F, 18.0F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 10.0F, -1.75F, 0.0F, 0.0F, 0.2182F));
		PartDefinition cube_r15 = left_wing.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(36, 4).addBox(-8.25F, -2.0F, -0.125F, 10.25F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-14.2652F, -6.2065F, -0.875F, 0.0F, 0.0F, 1.7453F));
		PartDefinition cube_r16 = left_wing.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(35, 12).addBox(0.5F, 4.25F, -0.125F, 3.75F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-17.7092F, -1.3729F, -0.875F, 0.0F, 0.0F, 0.5672F));
		PartDefinition cube_r17 = left_wing.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(42, 9).addBox(-1.5F, 0.5F, -0.125F, 5.25F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-17.7092F, -1.3729F, -0.875F, 0.0F, 0.0F, 0.9599F));
		PartDefinition cube_r18 = left_wing.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(38, 7).addBox(-6.0F, -0.25F, -0.125F, 7.5F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-15.539F, -3.1343F, -0.875F, 0.0F, 0.0F, 1.3526F));
		PartDefinition cube_r19 = left_wing.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(22, 0).addBox(-19.5F, -2.0F, 0.75F, 20.5F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 10.0F, -1.75F, 0.0F, 0.0F, 0.6109F));
		PartDefinition cube_r20 = left_wing.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(22, 0).addBox(-19.5F, -2.0F, 0.75F, 20.5F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 10.0F, -1.75F, 0.0F, 0.0F, 0.7854F));
		PartDefinition cube_r21 = left_wing.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(25, 0).addBox(-18.0F, -2.0F, 0.75F, 19.0F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 10.0F, -1.75F, 0.0F, 0.0F, 0.3927F));
		PartDefinition right_wing = Body.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(78, 1).mirror().addBox(-16.651F, 7.9939F, 1.0F, 17.0F, 2.0F, 0.25F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(1.0F, -3.0F, 4.25F, 3.1416F, 0.0F, 3.1067F));
		PartDefinition cube_r22 = right_wing.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(27, 0).addBox(-14.4962F, 7.6815F, 1.75F, 18.0F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.2182F));
		PartDefinition cube_r23 = right_wing.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(36, 4).addBox(1.5315F, -4.0791F, 0.875F, 10.25F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-14.2652F, -16.2065F, 0.125F, 0.0F, 0.0F, 1.7453F));
		PartDefinition cube_r24 = right_wing.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(35, 12).addBox(6.1641F, 12.4913F, 0.875F, 3.75F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-17.7092F, -11.3729F, 0.125F, 0.0F, 0.0F, 0.5672F));
		PartDefinition cube_r25 = right_wing.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(42, 9).addBox(6.8867F, 5.9464F, 0.875F, 5.25F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-17.7092F, -11.3729F, 0.125F, 0.0F, 0.0F, 0.9599F));
		PartDefinition cube_r26 = right_wing.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(38, 7).addBox(3.8325F, 1.5724F, 0.875F, 7.5F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-15.539F, -13.1343F, 0.125F, 0.0F, 0.0F, 1.3526F));
		PartDefinition cube_r27 = right_wing.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(22, 0).addBox(-13.4818F, 5.9864F, 1.75F, 20.5F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.6109F));
		PartDefinition cube_r28 = right_wing.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(22, 0).mirror().addBox(-12.1865F, 4.82F, 1.75F, 20.5F, 2.0F, 0.25F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(-1.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.7854F));
		PartDefinition cube_r29 = right_wing.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(25, 0).addBox(-13.8531F, 7.0996F, 1.75F, 19.0F, 2.0F, 0.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.3927F));
		PartDefinition crystal2 = Body.addOrReplaceChild("crystal2", CubeListBuilder.create().texOffs(53, 13).addBox(-1.25F, -2.5F, -0.5F, 2.5F, 5.25F, 0.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -3.0F));
		PartDefinition cube_r30 = crystal2.addOrReplaceChild("cube_r30",
				CubeListBuilder.create().texOffs(25, 6).addBox(7.0F, -2.0F, 1.75F, 3.6F, 0.75F, 0.5F, new CubeDeformation(0.0F)).texOffs(25, 4).addBox(7.0F, 1.25F, 1.75F, 3.6F, 0.75F, 0.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -9.0F, -2.25F, 0.0F, 0.0F, 1.5708F));
		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));
		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(40, 16).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)).mirror(false),
				PartPose.offset(5.0F, 2.0F, 0.0F));
		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));
		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch / (180F / (float) Math.PI);
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
