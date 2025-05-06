package net.jimit.jimitsendmod.item;

import net.jimit.jimitsendmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier ENDERITE = new ForgeTier(4062, 27.0F, 8.0F, 10,
            ModTags.Blocks.NEEDS_ENDERITE_TOOL, () -> Ingredient.of(ModItems.ENDERITE.get()),
            ModTags.Blocks.INCORRECT_FOR_ENDERITE_TOOL);
}
