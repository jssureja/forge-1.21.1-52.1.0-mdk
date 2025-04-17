package net.jimit.JimitsEndMod.datagen;

import net.jimit.JimitsEndMod.JimitsEndMod;
import net.jimit.JimitsEndMod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JimitsEndMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ENDERITE.get());
        basicItem(ModItems.RAW_ENDERITE.get());

        handheldItem(ModItems.ENDERITE_SWORD);
        handheldItem(ModItems.ENDERITE_PICKAXE);
        handheldItem(ModItems.ENDERITE_AXE);
        handheldItem(ModItems.ENDERITE_SHOVEL);
        handheldItem(ModItems.ENDERITE_HOE);
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(JimitsEndMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
