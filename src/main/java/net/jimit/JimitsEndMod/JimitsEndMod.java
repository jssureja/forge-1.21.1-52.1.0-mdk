package net.jimit.JimitsEndMod;

import com.mojang.logging.LogUtils;
import net.jimit.JimitsEndMod.block.ModBlocks;
import net.jimit.JimitsEndMod.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(JimitsEndMod.MOD_ID)
public class JimitsEndMod {
    public static final String MOD_ID = "jimitsendmod";

    private static final Logger LOGGER = LogUtils.getLogger();

    public JimitsEndMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ENDERITE);
            event.accept(ModItems.RAW_ENDERITE);
        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.ENDERITE_BLOCK);
        }

        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.ENDERITE_ORE);
        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.ENDERITE_SWORD);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.ENDERITE_AXE);
            event.accept(ModItems.ENDERITE_PICKAXE);
            event.accept(ModItems.ENDERITE_SHOVEL);
            event.accept(ModItems.ENDERITE_HOE);
        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.ENDERITE_HELMET);
            event.accept(ModItems.ENDERITE_CHESTPLATE);
            event.accept(ModItems.ENDERITE_LEGGINGS);
            event.accept(ModItems.ENDERITE_BOOTS);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
