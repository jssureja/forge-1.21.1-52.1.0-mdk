package net.jimit.jimitsendmod.datagen;

import net.jimit.jimitsendmod.JimitsEndMod;
import net.jimit.jimitsendmod.item.ModItems;
import net.jimit.jimitsendmod.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, JimitsEndMod.MOD_ID, registries);
    }

    @Override
    protected void start(HolderLookup.Provider registries) {
        this.add("ender_essence_from_enderman", new AddItemModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/enderman"))
                        .and(LootItemRandomChanceCondition.randomChance(0.34F)).build()},
                ModItems.ENDER_ESSENCE.get()));
    }
}
