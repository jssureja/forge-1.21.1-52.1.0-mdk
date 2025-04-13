package net.jimit.JimitsEndMod.datagen;

import net.jimit.JimitsEndMod.block.ModBlocks;
import net.jimit.JimitsEndMod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;


import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.ENDERITE_BLOCK.get());

        this.add(ModBlocks.ENDERITE_ORE.get(),
                block -> createOreDrop(ModBlocks.ENDERITE_ORE.get(), ModItems.RAW_ENDERITE.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
