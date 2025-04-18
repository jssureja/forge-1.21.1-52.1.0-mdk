package net.jimit.JimitsEndMod.datagen;

import net.jimit.JimitsEndMod.block.ModBlocks;
import net.jimit.JimitsEndMod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ENDERITE_SWORD.get())
                .define('S', Items.STICK)
                .define('E', ModItems.ENDERITE.get())
                .pattern(" E ")
                .pattern(" E ")
                .pattern(" S ")
                .unlockedBy(getHasName(ModItems.ENDERITE_SWORD.get()), has(ModItems.ENDERITE_SWORD.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ENDERITE_PICKAXE.get())
                .define('S', Items.STICK)
                .define('E', ModItems.ENDERITE.get())
                .pattern("EEE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy(getHasName(ModItems.ENDERITE_PICKAXE.get()), has(ModItems.ENDERITE_PICKAXE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ENDERITE_AXE.get())
                .define('S', Items.STICK)
                .define('E', ModItems.ENDERITE.get())
                .pattern("EE ")
                .pattern("ES ")
                .pattern(" S ")
                .unlockedBy(getHasName(ModItems.ENDERITE_AXE.get()), has(ModItems.ENDERITE_AXE.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ENDERITE_SHOVEL.get())
                .define('S', Items.STICK)
                .define('E', ModItems.ENDERITE.get())
                .pattern(" E ")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy(getHasName(ModItems.ENDERITE_SHOVEL.get()), has(ModItems.ENDERITE_SHOVEL.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ENDERITE_HOE.get())
                .define('S', Items.STICK)
                .define('E', ModItems.ENDERITE.get())
                .pattern("EE ")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy(getHasName(ModItems.ENDERITE_HOE.get()), has(ModItems.ENDERITE_HOE.get())).save(pRecipeOutput);
    }
}
