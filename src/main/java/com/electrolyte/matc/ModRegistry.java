package com.electrolyte.matc;

import com.electrolyte.matc.items.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MATC.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<InferiumCrystal> INFERIUMCRYSTAL = ITEMS.register("inferium_crystal",
            () -> new InferiumCrystal(p -> p.tab(MATC.ITEM_GROUP)));
    public static final RegistryObject<PrudentiumCrystal> PRUDENTIUMCRYSTAL = ITEMS.register("prudentium_crystal",
            () -> new PrudentiumCrystal(p -> p.tab(MATC.ITEM_GROUP)));
    public static final RegistryObject<TertiumCrystal> TERTIUMCRYSTAL = ITEMS.register("tertium_crystal",
            () -> new TertiumCrystal(p -> p.tab(MATC.ITEM_GROUP)));
    public static final RegistryObject<ImperiumCrystal> IMPERIUMCRYSTAL = ITEMS.register("imperium_crystal",
            () -> new ImperiumCrystal(p -> p.tab(MATC.ITEM_GROUP)));
    public static final RegistryObject<SupremiumCrystal> SUPREMIUMCRYSTAL = ITEMS.register("supremium_crystal",
            () -> new SupremiumCrystal(p -> p.tab(MATC.ITEM_GROUP)));
}