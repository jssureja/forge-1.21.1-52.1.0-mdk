package net.jimit.JimitsEndMod.item;

import net.jimit.JimitsEndMod.JimitsEndMod;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JimitsEndMod.MOD_ID);

    public static final RegistryObject<Item> ENDERITE = ITEMS.register("enderite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_ENDERITE = ITEMS.register("raw_enderite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ENDERITE_SWORD = ITEMS.register("enderite_sword",
            () -> new SwordItem(ModToolTiers.ENDERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.ENDERITE, 3, -2.4f))));

    public static final RegistryObject<Item> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ENDERITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ENDERITE, 1, -2.8f))));

    public static final RegistryObject<Item> ENDERITE_AXE = ITEMS.register("enderite_axe",
            () -> new AxeItem(ModToolTiers.ENDERITE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.ENDERITE, 6, -3.2f))));

    public static final RegistryObject<Item> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel",
            () -> new ShovelItem(ModToolTiers.ENDERITE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ENDERITE, 1.5f, -3.0f))));

    public static final RegistryObject<Item> ENDERITE_HOE = ITEMS.register("enderite_hoe",
            () -> new HoeItem(ModToolTiers.ENDERITE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.ENDERITE, 0, -3.0f))));

    public static final RegistryObject<Item> ENDERITE_HELMET = ITEMS.register("enderite_helmet",
            () -> new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(50))));

    public static final RegistryObject<Item> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50))));

    public static final RegistryObject<Item> ENDERITE_LEGGINGS = ITEMS.register("enderite_leggings",
            () -> new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(50))));

    public static final RegistryObject<Item> ENDERITE_BOOTS = ITEMS.register("enderite_boots",
            () -> new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(50))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
