package net.jimit.JimitsEndMod.datagen;

import net.jimit.JimitsEndMod.JimitsEndMod;
import net.jimit.JimitsEndMod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JimitsEndMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.ENDERITE.get());
        basicItem(ModItems.RAW_ENDERITE.get());
    }
}
