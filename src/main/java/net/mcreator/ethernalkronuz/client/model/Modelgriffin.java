package net.mcreator.ethernalkronuz.client.model;

import net.minecraft.world.entity.Entity;
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
public class Modelgriffin<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("ethernal_kronuz", "modelgriffin"), "main");
	public final ModelPart Griffin;
	public final ModelPart Hitbox;

	public Modelgriffin(ModelPart root) {
		this.Griffin = root.getChild("Griffin");
		this.Hitbox = root.getChild("Hitbox");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Griffin = partdefinition.addOrReplaceChild("Griffin", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));
		PartDefinition Body = Griffin.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, 0.0F));
		PartDefinition Neck = Body.addOrReplaceChild("Neck", CubeListBuilder.create(), PartPose.offset(0.5F, -8.1186F, -10.5457F));
		PartDefinition cube_r1 = Neck.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(52, 61).addBox(-1.75F, -5.25F, -3.25F, 3.5F, 4.0F, 3.5F, new CubeDeformation(0.0F)).texOffs(0, 19).addBox(-2.0F, -4.0F, -2.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 1.1186F, 1.5457F, 0.3927F, 0.0F, 0.0F));
		PartDefinition h_head = Neck.addOrReplaceChild("h_head", CubeListBuilder.create(), PartPose.offset(0.01F, -3.4446F, -4.4289F));
		PartDefinition cube_r2 = h_head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(65, 51).addBox(-0.25F, -1.75F, -6.75F, 1.5F, 2.25F, 0.5F, new CubeDeformation(0.0F)).texOffs(8, 72)
				.addBox(-0.25F, -2.0F, -6.25F, 1.5F, 2.0F, 2.75F, new CubeDeformation(0.0F)).texOffs(0, 31).addBox(-1.0F, -3.5F, -4.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.51F, 1.0633F, 2.9746F, 0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r3 = h_head.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(0, 5).addBox(2.05F, -4.0F, -0.25F, 0.0F, 2.0F, 4.25F, new CubeDeformation(0.0F)).texOffs(0, 5).addBox(-1.0F, -4.0F, -0.25F, 0.0F, 2.0F, 4.25F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.51F, 1.0633F, 2.9746F, 0.7854F, 0.0F, 0.0F));
		PartDefinition BackLegs = Body.addOrReplaceChild("BackLegs", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));
		PartDefinition LeftLeg = BackLegs.addOrReplaceChild("LeftLeg",
				CubeListBuilder.create().texOffs(12, 27).mirror().addBox(-0.9833F, -3.875F, -3.3333F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(64, 57).mirror()
						.addBox(-0.8833F, -1.875F, -1.3333F, 1.8F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(65, 65).addBox(-0.6333F, 1.125F, -1.3333F, 1.2F, 2.25F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.8833F, -10.125F, 9.3333F));
		PartDefinition LegHinge3 = LeftLeg.addOrReplaceChild("LegHinge3",
				CubeListBuilder.create().texOffs(42, 67).mirror().addBox(-0.5833F, -2.525F, -3.4833F, 1.1F, 2.25F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(39, 73)
						.addBox(-0.5333F, -1.675F, -0.2333F, 1.05F, 2.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(73, 64).mirror().addBox(-0.3333F, 0.825F, 0.2667F, 0.75F, 2.0F, 1.4F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(-0.05F, 5.85F, 3.15F));
		PartDefinition RightPaw3 = LegHinge3.addOrReplaceChild("RightPaw3",
				CubeListBuilder.create().texOffs(71, 12).addBox(-0.8605F, 0.3469F, -0.6067F, 1.7F, 1.65F, 3.0F, new CubeDeformation(0.0F)).texOffs(47, 61).addBox(-0.3605F, 0.8469F, -1.6567F, 0.75F, 1.15F, 2.5F, new CubeDeformation(0.0F))
						.texOffs(16, 25).addBox(-0.3605F, 1.3469F, -2.6567F, 0.75F, 0.65F, 1.0F, new CubeDeformation(0.0F)).texOffs(56, 65).addBox(-0.7105F, 0.9969F, 1.3433F, 1.45F, 0.9F, 1.75F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0771F, 1.9281F, -0.3766F));
		PartDefinition cube_r4 = RightPaw3.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(0, 31).addBox(-0.725F, -0.45F, -2.5F, 0.75F, 0.65F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 13).addBox(-0.725F, -0.95F, -1.5F, 0.75F, 1.15F, 2.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.1145F, 1.7969F, 0.3933F, 0.0F, -0.3927F, 0.0F));
		PartDefinition cube_r5 = RightPaw3.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(42, 49).addBox(-1.025F, -0.45F, -2.8F, 0.75F, 0.65F, 0.75F, new CubeDeformation(0.0F)).texOffs(0, 72).addBox(-1.025F, -0.95F, -2.05F, 0.75F, 1.15F, 2.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1355F, 1.7969F, 0.3933F, 0.0F, 0.3927F, 0.0F));
		PartDefinition RightLeg = BackLegs
				.addOrReplaceChild(
						"RightLeg", CubeListBuilder.create().texOffs(12, 27).addBox(-1.0167F, -3.875F, -3.3333F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(64, 57)
								.addBox(-0.9167F, -1.875F, -1.3333F, 1.8F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(65, 65).mirror().addBox(-0.5667F, 1.125F, -1.3333F, 1.2F, 2.25F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
						PartPose.offset(-3.0833F, -10.125F, 9.3333F));
		PartDefinition LegHinge4 = RightLeg.addOrReplaceChild("LegHinge4", CubeListBuilder.create().texOffs(42, 67).addBox(-0.4167F, -2.525F, -3.4833F, 1.1F, 2.25F, 4.0F, new CubeDeformation(0.0F)).texOffs(33, 73)
				.addBox(-0.5667F, -1.675F, -0.2333F, 1.05F, 2.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(73, 64).addBox(-0.4667F, 0.825F, 0.2667F, 0.75F, 2.0F, 1.4F, new CubeDeformation(0.0F)), PartPose.offset(-0.05F, 5.85F, 3.15F));
		PartDefinition LeftPaw3 = LegHinge4
				.addOrReplaceChild(
						"LeftPaw3", CubeListBuilder.create().texOffs(70, 27).addBox(0.14F, 0.2F, -0.83F, 1.7F, 1.65F, 3.0F, new CubeDeformation(0.0F)).texOffs(38, 68).addBox(0.64F, 0.7F, -1.88F, 0.75F, 1.15F, 2.5F, new CubeDeformation(0.0F))
								.texOffs(16, 25).addBox(0.64F, 1.2F, -2.88F, 0.75F, 0.65F, 1.0F, new CubeDeformation(0.0F)).texOffs(12, 19).addBox(0.29F, 0.85F, 1.12F, 1.45F, 0.9F, 1.75F, new CubeDeformation(0.0F)),
						PartPose.offset(-1.0567F, 2.075F, -0.1533F));
		PartDefinition cube_r6 = LeftPaw3.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(0, 33).addBox(-0.725F, -0.45F, -2.5F, 0.75F, 0.65F, 1.0F, new CubeDeformation(0.0F)).texOffs(16, 35).addBox(-0.725F, -0.95F, -1.5F, 0.75F, 1.15F, 2.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.115F, 1.65F, 0.17F, 0.0F, -0.3927F, 0.0F));
		PartDefinition cube_r7 = LeftPaw3.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(19, 52).addBox(-1.025F, -0.45F, -2.8F, 0.75F, 0.65F, 0.75F, new CubeDeformation(0.0F)).texOffs(72, 28).addBox(-1.025F, -0.95F, -2.05F, 0.75F, 1.15F, 2.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.865F, 1.65F, 0.17F, 0.0F, 0.3927F, 0.0F));
		PartDefinition FrontLegs = Body.addOrReplaceChild("FrontLegs", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));
		PartDefinition LeftLeg2 = FrontLegs.addOrReplaceChild("LeftLeg2",
				CubeListBuilder.create().texOffs(58, 10).addBox(-1.125F, -4.0F, -3.125F, 2.25F, 6.0F, 4.25F, new CubeDeformation(0.0F)).texOffs(24, 61).addBox(-0.875F, -2.0F, -1.125F, 1.75F, 6.0F, 4.25F, new CubeDeformation(0.0F)),
				PartPose.offset(-4.125F, -10.95F, -2.875F));
		PartDefinition LegHinge = LeftLeg2.addOrReplaceChild("LegHinge", CubeListBuilder.create().texOffs(0, 39).addBox(-0.6417F, -3.3833F, -1.1833F, 1.25F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(67, 72)
				.addBox(-0.4917F, -1.3833F, -0.8833F, 1.05F, 2.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(18, 21).addBox(-0.3917F, 1.0167F, -0.8833F, 0.75F, 2.0F, 1.4F, new CubeDeformation(0.0F)), PartPose.offset(0.0167F, 6.3833F, -0.6917F));
		PartDefinition LeftPaw2 = LegHinge
				.addOrReplaceChild(
						"LeftPaw2", CubeListBuilder.create().texOffs(70, 0).addBox(-0.86F, 0.2F, -1.08F, 1.7F, 1.65F, 3.0F, new CubeDeformation(0.0F)).texOffs(59, 71).addBox(-0.36F, 0.7F, -2.13F, 0.75F, 1.15F, 2.5F, new CubeDeformation(0.0F))
								.texOffs(20, 28).addBox(-0.36F, 1.2F, -3.13F, 0.75F, 0.65F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 58).addBox(-0.71F, 0.85F, 0.87F, 1.45F, 0.9F, 1.75F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0183F, 2.3667F, -1.1033F));
		PartDefinition cube_r8 = LeftPaw2.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(2, 45).addBox(-0.725F, -0.45F, -2.5F, 0.75F, 0.65F, 1.0F, new CubeDeformation(0.0F)).texOffs(32, 61).addBox(-0.725F, -0.95F, -1.5F, 0.75F, 1.15F, 2.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.115F, 1.65F, -0.08F, 0.0F, -0.3927F, 0.0F));
		PartDefinition cube_r9 = LeftPaw2.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(5, 52).addBox(-1.025F, -0.45F, -2.9F, 0.75F, 0.65F, 0.75F, new CubeDeformation(0.0F)).texOffs(72, 43).addBox(-1.025F, -0.95F, -2.15F, 0.75F, 1.15F, 2.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.135F, 1.65F, -0.08F, 0.0F, 0.3927F, 0.0F));
		PartDefinition RightLeg2 = FrontLegs.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(58, 10).mirror().addBox(-1.125F, -4.0F, -3.125F, 2.25F, 6.0F, 4.25F, new CubeDeformation(0.0F)).mirror(false).texOffs(24, 61).mirror()
				.addBox(-0.875F, -2.0F, -1.125F, 1.75F, 6.0F, 4.25F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.875F, -10.95F, -2.875F));
		PartDefinition LegHinge2 = RightLeg2.addOrReplaceChild("LegHinge2",
				CubeListBuilder.create().texOffs(0, 39).mirror().addBox(-0.6083F, -3.4167F, -1.1833F, 1.25F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(67, 72)
						.addBox(-0.5583F, -1.4167F, -0.8833F, 1.05F, 2.5F, 1.5F, new CubeDeformation(0.0F)).texOffs(14, 9).addBox(-0.3583F, 1.0833F, -0.8833F, 0.75F, 2.0F, 1.4F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.0167F, 6.4167F, -0.6917F));
		PartDefinition RightPaw2 = LegHinge2.addOrReplaceChild("RightPaw2",
				CubeListBuilder.create().texOffs(70, 0).mirror().addBox(-0.8605F, 0.3469F, 0.1433F, 1.7F, 1.65F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(28, 72)
						.addBox(-0.3605F, 0.8469F, -0.9067F, 0.75F, 1.15F, 2.5F, new CubeDeformation(0.0F)).texOffs(18, 15).addBox(-0.3605F, 1.3469F, -1.9067F, 0.75F, 0.65F, 1.0F, new CubeDeformation(0.0F)).texOffs(1, 45)
						.addBox(-0.7105F, 0.9969F, 2.0933F, 1.45F, 0.9F, 1.75F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0521F, 2.1865F, -2.3266F));
		PartDefinition cube_r10 = RightPaw2.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(5, 52).addBox(-0.725F, -0.45F, -2.5F, 0.75F, 0.65F, 1.0F, new CubeDeformation(0.0F)).texOffs(42, 54).addBox(-0.725F, -0.95F, -1.5F, 0.75F, 1.15F, 2.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.1145F, 1.7969F, 1.1433F, 0.0F, -0.3927F, 0.0F));
		PartDefinition cube_r11 = RightPaw2.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(42, 50).addBox(-1.025F, -0.45F, -2.9F, 0.75F, 0.65F, 0.75F, new CubeDeformation(0.0F)).texOffs(72, 39).addBox(-1.025F, -0.95F, -2.15F, 0.75F, 1.15F, 2.5F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.1355F, 1.7969F, 1.1433F, 0.0F, 0.3927F, 0.0F));
		PartDefinition LeftWing = Body.addOrReplaceChild("LeftWing", CubeListBuilder.create(), PartPose.offset(-5.75F, -4.5F, -0.25F));
		PartDefinition Hinge = LeftWing.addOrReplaceChild("Hinge", CubeListBuilder.create().texOffs(8, 32).addBox(-16.0F, -1.0F, -3.0F, 18.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(2.75F, 0.5F, -4.75F));
		PartDefinition cube_r12 = Hinge.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(87, 4).addBox(-3.25F, -1.5F, -2.0F, 1.5F, 1.5F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
		PartDefinition Hinge_Small = Hinge.addOrReplaceChild("Hinge_Small",
				CubeListBuilder.create().texOffs(113, 5).addBox(-0.75F, -0.75F, -0.5F, 1.5F, 1.5F, 4.0F, new CubeDeformation(0.0F)).texOffs(8, 16).addBox(0.4668F, -0.2289F, -0.55F, 17.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.4668F, -0.7711F, -2.45F, 0.0F, -1.5708F, 0.0F));
		PartDefinition RightWing = Body.addOrReplaceChild("RightWing", CubeListBuilder.create(), PartPose.offset(6.75F, -4.5F, -0.25F));
		PartDefinition Hinge2 = RightWing.addOrReplaceChild("Hinge2", CubeListBuilder.create().texOffs(8, 32).mirror().addBox(-2.0F, -1.0F, -3.0F, 18.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.75F, 0.5F, -4.75F));
		PartDefinition cube_r13 = Hinge2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(87, 4).addBox(1.75F, -1.5F, -2.0F, 1.5F, 1.5F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
		PartDefinition Hinge_Small2 = Hinge2.addOrReplaceChild("Hinge_Small2", CubeListBuilder.create().texOffs(113, 5).mirror().addBox(-0.75F, -0.75F, -0.5F, 1.5F, 1.5F, 4.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(8, 16).mirror()
				.addBox(-17.5F, -0.25F, -0.55F, 17.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.5F, -0.75F, -2.45F, 0.0F, 1.5708F, 0.0F));
		PartDefinition Tail = Body.addOrReplaceChild("Tail",
				CubeListBuilder.create().texOffs(12, 64).addBox(-1.0F, -4.0F, 10.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(68, 51).addBox(-0.5F, -2.0F, 12.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(19, 71)
						.addBox(0.0F, -3.0F, 12.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(67, 68).addBox(0.0F, -2.0F, 14.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(69, 17)
						.addBox(-0.15F, -1.0F, 14.0F, 1.3F, 2.5F, 3.0F, new CubeDeformation(0.0F)).texOffs(69, 17).addBox(-0.15F, -1.5F, 16.0F, 1.3F, 2.5F, 3.0F, new CubeDeformation(0.0F)).texOffs(17, 0)
						.addBox(0.1F, -3.25F, 18.0F, 0.8F, 3.5F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.1F, -5.75F, 19.0F, 0.8F, 3.5F, 2.0F, new CubeDeformation(0.0F)).texOffs(72, 57)
						.addBox(0.1F, -6.5F, 20.0F, 0.8F, 1.75F, 2.0F, new CubeDeformation(0.0F)).texOffs(7, 68).addBox(0.1F, -7.25F, 21.25F, 0.8F, 0.75F, 2.0F, new CubeDeformation(0.0F)).texOffs(27, 0)
						.addBox(0.4F, -10.3F, 22.35F, 0.0F, 3.5F, 3.3F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition Torso = Body.addOrReplaceChild("Torso",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -9.0F, -6.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 9).addBox(-1.0F, -9.0F, 1.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 52)
						.addBox(-2.0F, -15.0F, 1.0F, 5.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(0, 39).addBox(-3.0F, -16.0F, -8.0F, 7.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(8, 43)
						.addBox(-1.0F, -18.0F, -6.0F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(36, 61).addBox(-1.0F, -16.0F, 1.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(22, 48)
						.addBox(-2.0F, -12.0F, 0.0F, 5.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(50, 40).addBox(-3.0F, -12.0F, -8.0F, 7.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(52, 51)
						.addBox(-2.0F, -18.5F, -9.0F, 5.0F, 6.5F, 3.0F, new CubeDeformation(0.0F)).texOffs(60, 22).addBox(-1.0F, -12.0F, -9.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 11.0F, 0.0F));
		PartDefinition Hitbox = partdefinition.addOrReplaceChild("Hitbox", CubeListBuilder.create().texOffs(0, 81).addBox(-11.0F, -24.0F, -11.0F, 22.0F, 24.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Griffin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Hitbox.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}
