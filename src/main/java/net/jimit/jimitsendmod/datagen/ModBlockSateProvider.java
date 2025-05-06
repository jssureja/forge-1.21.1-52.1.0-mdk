package net.jimit.jimitsendmod.datagen;

import net.jimit.jimitsendmod.JimitsEndMod;
import net.jimit.jimitsendmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockSateProvider extends BlockStateProvider {
    public ModBlockSateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JimitsEndMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blocWithItem(ModBlocks.ENDERITE_BLOCK);
        blocWithItem(ModBlocks.ENDERITE_ORE);
    }

    private void blocWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
