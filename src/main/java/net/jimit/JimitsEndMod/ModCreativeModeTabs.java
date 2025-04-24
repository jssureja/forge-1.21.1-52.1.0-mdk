package net.jimit.JimitsEndMod;

import net.jimit.JimitsEndMod.block.ModBlocks;
import net.jimit.JimitsEndMod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JimitsEndMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOD_STUFF = CREATIVE_MODE_TABS.register("mod_stuff",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ENDERITE.get()))
                    .title(Component.translatable("creativetab.jimitsendmod.mod_stuff"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ENDERITE_ORE.get());
                        output.accept(ModBlocks.ENDERITE_BLOCK.get());
                        ModItems.MODDED_ITEMS.forEach(item -> output.accept(item.get()));
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
