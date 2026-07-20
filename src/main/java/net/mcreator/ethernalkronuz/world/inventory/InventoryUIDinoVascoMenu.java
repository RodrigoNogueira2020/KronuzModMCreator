package net.mcreator.ethernalkronuz.world.inventory;

import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.IItemHandler;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.Container;
import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.ethernalkronuz.init.EthernalKronuzModMenus;
import net.mcreator.ethernalkronuz.entity.DinoVascoEntity;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

public class InventoryUIDinoVascoMenu extends AbstractContainerMenu implements Supplier<Map<Integer, Slot>> {
	public final static HashMap<String, Object> guistate = new HashMap<>();
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	public final DinoVascoEntity dinoEntity;
	private final SimpleContainer equipmentContainer;
	private static final int SLOT_HEAD = 0;
	private static final int SLOT_CHEST = 1;
	private static final int SLOT_LEGS = 2;
	private static final int SLOT_FEET = 3;
	private static final int SLOT_MAINHAND = 4;

	public InventoryUIDinoVascoMenu(int id, Inventory inv, DinoVascoEntity dino) {
		super(EthernalKronuzModMenus.INVENTORY_UI_DINO_VASCO, id);
		this.entity = inv.player;
		this.world = inv.player.level;
		this.x = (int) dino.getX();
		this.y = (int) dino.getY();
		this.z = (int) dino.getZ();
		this.dinoEntity = dino;
		this.internal = new ItemStackHandler(0);
		this.equipmentContainer = new SimpleContainer(5);
		loadFromEntity(dino);
		addEquipmentSlots();
		addPlayerInventory(inv);
	}

	public InventoryUIDinoVascoMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(EthernalKronuzModMenus.INVENTORY_UI_DINO_VASCO, id);
		this.entity = inv.player;
		this.world = inv.player.level;
		this.internal = new ItemStackHandler(0);
		this.equipmentContainer = new SimpleContainer(5);
		DinoVascoEntity dino = null;
		if (extraData != null) {
			int entityId = extraData.readInt();
			net.minecraft.world.entity.Entity e = inv.player.level.getEntity(entityId);
			if (e instanceof DinoVascoEntity dv) {
				dino = dv;
				this.x = (int) dv.getX();
				this.y = (int) dv.getY();
				this.z = (int) dv.getZ();
				loadFromEntity(dv);
			}
		}
		this.dinoEntity = dino;
		addEquipmentSlots();
		addPlayerInventory(inv);
	}

	private void loadFromEntity(DinoVascoEntity dino) {
		equipmentContainer.setItem(SLOT_HEAD, dino.getItemBySlot(EquipmentSlot.HEAD).copy());
		equipmentContainer.setItem(SLOT_CHEST, dino.getItemBySlot(EquipmentSlot.CHEST).copy());
		equipmentContainer.setItem(SLOT_LEGS, dino.getItemBySlot(EquipmentSlot.LEGS).copy());
		equipmentContainer.setItem(SLOT_FEET, dino.getItemBySlot(EquipmentSlot.FEET).copy());
		equipmentContainer.setItem(SLOT_MAINHAND, dino.getItemBySlot(EquipmentSlot.MAINHAND).copy());
	}

	private void addEquipmentSlots() {
		this.addSlot(new DinoArmorSlot(equipmentContainer, SLOT_HEAD, 53, 21, EquipmentSlot.HEAD));
		this.addSlot(new DinoArmorSlot(equipmentContainer, SLOT_CHEST, 53, 48, EquipmentSlot.CHEST));
		this.addSlot(new DinoArmorSlot(equipmentContainer, SLOT_LEGS, 107, 21, EquipmentSlot.LEGS));
		this.addSlot(new DinoArmorSlot(equipmentContainer, SLOT_FEET, 107, 48, EquipmentSlot.FEET));
		this.addSlot(new Slot(equipmentContainer, SLOT_MAINHAND, 34, 35) {
			@Override
			public int getMaxStackSize() {
				return 1;
			}
		});
	}

	private void addPlayerInventory(Inventory inv) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++)
				this.addSlot(new Slot(inv, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
		}
		for (int col = 0; col < 9; col++)
			this.addSlot(new Slot(inv, col, 8 + col * 18, 142));
	}

	@Override
	public boolean stillValid(Player player) {
		if (dinoEntity == null)
			return false;
		return dinoEntity.isAlive() && dinoEntity.distanceTo(player) < 12.0;
	}

	@Override
	public void removed(Player player) {
		super.removed(player);
		if (dinoEntity != null) {
			dinoEntity.uiOpen = false;
			if (!world.isClientSide()) {
				dinoEntity.setItemSlot(EquipmentSlot.HEAD, equipmentContainer.getItem(SLOT_HEAD));
				dinoEntity.setItemSlot(EquipmentSlot.CHEST, equipmentContainer.getItem(SLOT_CHEST));
				dinoEntity.setItemSlot(EquipmentSlot.LEGS, equipmentContainer.getItem(SLOT_LEGS));
				dinoEntity.setItemSlot(EquipmentSlot.FEET, equipmentContainer.getItem(SLOT_FEET));
				dinoEntity.setItemSlot(EquipmentSlot.MAINHAND, equipmentContainer.getItem(SLOT_MAINHAND));
			}
		}
	}

	@Override
	public ItemStack quickMoveStack(Player player, int index) {
		Slot slot = this.slots.get(index);
		if (slot == null || !slot.hasItem())
			return ItemStack.EMPTY;
		ItemStack stack = slot.getItem();
		ItemStack original = stack.copy();
		if (index < 5) {
			if (!this.moveItemStackTo(stack, 5, 41, true))
				return ItemStack.EMPTY;
		} else {
			if (!this.moveItemStackTo(stack, 0, 5, false))
				return ItemStack.EMPTY;
		}
		if (stack.isEmpty())
			slot.set(ItemStack.EMPTY);
		else
			slot.setChanged();
		return original;
	}

	@Override
	public Map<Integer, Slot> get() {
		return customSlots;
	}

	static class DinoArmorSlot extends Slot {
		private final EquipmentSlot slotType;

		public DinoArmorSlot(Container container, int index, int x, int y, EquipmentSlot slotType) {
			super(container, index, x, y);
			this.slotType = slotType;
		}

		@Override
		public boolean mayPlace(ItemStack stack) {
			return stack.canEquip(slotType, null);
		}

		@Override
		public int getMaxStackSize() {
			return 1;
		}

		@Override
		public boolean mayPickup(Player player) {
			ItemStack stack = this.getItem();
			return !stack.isEmpty() && EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BINDING_CURSE, stack) == 0 || player.isCreative();
		}
	}
}
