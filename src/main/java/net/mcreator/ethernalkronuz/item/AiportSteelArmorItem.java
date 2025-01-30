
package net.mcreator.ethernalkronuz.item;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.client.IItemRenderProperties;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.Minecraft;

import net.mcreator.ethernalkronuz.procedures.AiportSteelArmorLeggingsTickEventProcedure;
import net.mcreator.ethernalkronuz.procedures.AiportSteelArmorHelmetTickEventProcedure;
import net.mcreator.ethernalkronuz.procedures.AiportSteelArmorBootsTickEventProcedure;
import net.mcreator.ethernalkronuz.procedures.AiportSteelArmorBodyTickEventProcedure;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModTabs;
import net.mcreator.ethernalkronuz.init.EthernalKronuzModItems;
import net.mcreator.ethernalkronuz.client.model.Modelairport_steel_armor_no_legs;

import java.util.Map;
import java.util.Collections;

public abstract class AiportSteelArmorItem extends ArmorItem {
	public AiportSteelArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 44;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{10, 13, 15, 10}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 14;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(EthernalKronuzModItems.AIPORT_STEEL_INGOT.get()));
			}

			@Override
			public String getName() {
				return "aiport_steel_armor";
			}

			@Override
			public float getToughness() {
				return 6f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.4f;
			}
		}, slot, properties);
	}

	public static class Helmet extends AiportSteelArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB).fireResistant());
		}

		public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.IItemRenderProperties> consumer) {
			consumer.accept(new IItemRenderProperties() {
				@Override
				public HumanoidModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
					HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
							Map.of("head", new Modelairport_steel_armor_no_legs(Minecraft.getInstance().getEntityModels().bakeLayer(Modelairport_steel_armor_no_legs.LAYER_LOCATION)).Head, "hat",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
									"left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
					armorModel.crouching = living.isShiftKeyDown();
					armorModel.riding = defaultModel.riding;
					armorModel.young = living.isBaby();
					return armorModel;
				}
			});
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "ethernal_kronuz:textures/entities/airport_steel_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			AiportSteelArmorHelmetTickEventProcedure.execute(entity);
		}
	}

	public static class Chestplate extends AiportSteelArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB).fireResistant());
		}

		public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.IItemRenderProperties> consumer) {
			consumer.accept(new IItemRenderProperties() {
				@Override
				@OnlyIn(Dist.CLIENT)
				public HumanoidModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
					HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
							Map.of("body", new Modelairport_steel_armor_no_legs(Minecraft.getInstance().getEntityModels().bakeLayer(Modelairport_steel_armor_no_legs.LAYER_LOCATION)).Body, "left_arm",
									new Modelairport_steel_armor_no_legs(Minecraft.getInstance().getEntityModels().bakeLayer(Modelairport_steel_armor_no_legs.LAYER_LOCATION)).LeftArm, "right_arm",
									new Modelairport_steel_armor_no_legs(Minecraft.getInstance().getEntityModels().bakeLayer(Modelairport_steel_armor_no_legs.LAYER_LOCATION)).RightArm, "head",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
									"left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
					armorModel.crouching = living.isShiftKeyDown();
					armorModel.riding = defaultModel.riding;
					armorModel.young = living.isBaby();
					return armorModel;
				}
			});
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "ethernal_kronuz:textures/entities/airport_steel_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			AiportSteelArmorBodyTickEventProcedure.execute(entity);
		}
	}

	public static class Leggings extends AiportSteelArmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB).fireResistant());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "ethernal_kronuz:textures/entities/airport_steel_layer_2.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			AiportSteelArmorLeggingsTickEventProcedure.execute(entity);
		}
	}

	public static class Boots extends AiportSteelArmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(EthernalKronuzModTabs.TAB_CREATIVE_TAB).fireResistant());
		}

		public void initializeClient(java.util.function.Consumer<net.minecraftforge.client.IItemRenderProperties> consumer) {
			consumer.accept(new IItemRenderProperties() {
				@Override
				@OnlyIn(Dist.CLIENT)
				public HumanoidModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
					HumanoidModel armorModel = new HumanoidModel(new ModelPart(Collections.emptyList(),
							Map.of("left_leg", new Modelairport_steel_armor_no_legs(Minecraft.getInstance().getEntityModels().bakeLayer(Modelairport_steel_armor_no_legs.LAYER_LOCATION)).LeftLeg, "right_leg",
									new Modelairport_steel_armor_no_legs(Minecraft.getInstance().getEntityModels().bakeLayer(Modelairport_steel_armor_no_legs.LAYER_LOCATION)).RightLeg, "head",
									new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
									"right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
					armorModel.crouching = living.isShiftKeyDown();
					armorModel.riding = defaultModel.riding;
					armorModel.young = living.isBaby();
					return armorModel;
				}
			});
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "ethernal_kronuz:textures/entities/airport_steel_layer_1.png";
		}

		@Override
		public void onArmorTick(ItemStack itemstack, Level world, Player entity) {
			AiportSteelArmorBootsTickEventProcedure.execute(entity);
		}
	}
}
