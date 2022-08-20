package com.devmaster.mocreepsandweirdosreborn.misc

import com.devmaster.mocreepsandweirdosreborn.misc.MoreCreepsAndWeirdosReborn;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries

public class ItemRegistryHandler{

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MoreCreepsAndWeirdosReborn.MOD_ID);


public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
