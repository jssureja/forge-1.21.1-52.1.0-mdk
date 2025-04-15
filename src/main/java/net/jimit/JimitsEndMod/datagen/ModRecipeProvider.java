package net.jimit.JimitsEndMod.datagen;

import net.jimit.JimitsEndMod.block.ModBlocks;
import net.jimit.JimitsEndMod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> ENDERITE_SMELTABLES = List.of(ModItems.RAW_ENDERITE.get(),
                ModBlocks.ENDERITE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ENDERITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ENDERITE.get())
                .unlockedBy(getHasName(ModItems.ENDERITE.get()), has(ModItems.ENDERITE.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ENDERITE.get(), 9)
                .requires(ModBlocks.ENDERITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ENDERITE_BLOCK.get()), has(ModBlocks.ENDERITE_BLOCK.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, ENDERITE_SMELTABLES, RecipeCategory.MISC, ModItems.ENDERITE.get(), 0.50f, 200, "enderite");
        oreBlasting(pRecipeOutput, ENDERITE_SMELTABLES, RecipeCategory.MISC, ModItems.ENDERITE.get(), 0.50f, 100, "enderite");
    }
}
