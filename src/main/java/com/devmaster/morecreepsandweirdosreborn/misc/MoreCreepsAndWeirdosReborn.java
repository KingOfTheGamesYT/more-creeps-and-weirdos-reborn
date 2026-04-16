package com.devmaster.morecreepsandweirdosreborn.misc;

import com.devmaster.morecreepsandweirdosreborn.client.render.GuineaPigRender;
import com.devmaster.morecreepsandweirdosreborn.entity.GuineaPig;
import com.devmaster.morecreepsandweirdosreborn.util.RegistryHandler;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("more_creeps_and_weirdos_reborn")
public class MoreCreepsAndWeirdosReborn {
    public static final Logger LOGGER = LogManager.getLogger("More Creeps and Weirdos Reborn");
    public static final String MOD_ID = "more_creeps_and_weirdos_reborn";

    public MoreCreepsAndWeirdosReborn() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        GlobalEntityTypeAttributes.put(RegistryHandler.GUINEA_PIG.get(), GuineaPig.getAttributes().create());

    }
    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(RegistryHandler.GUINEA_PIG.get(), GuineaPigRender::new);

    }
}



