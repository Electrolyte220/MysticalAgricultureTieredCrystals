package com.electrolyte.matc;

import com.electrolyte.matc.config.MATCModConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

@Mod(MATC.MOD_ID)
public class MATC {

    public static final String MOD_ID = "matc";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MATC.MOD_ID);

    public MATC() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MATCModConfig.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MATCModConfig.SERVER_CONFIG);

        ModRegistry.init();
        CREATIVE_MODE_TABS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private static final RegistryObject<CreativeModeTab> MATC_TAB = CREATIVE_MODE_TABS.register("matc", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.matc"))
            .icon(() -> new ItemStack(ModRegistry.SUPREMIUMCRYSTAL.get()))
            .displayItems((displayParameters, output) ->
                    output.acceptAll(List.of(
                            new ItemStack(ModRegistry.INFERIUMCRYSTAL.get()),
                            new ItemStack(ModRegistry.PRUDENTIUMCRYSTAL.get()),
                            new ItemStack(ModRegistry.TERTIUMCRYSTAL.get()),
                            new ItemStack(ModRegistry.IMPERIUMCRYSTAL.get()),
                            new ItemStack(ModRegistry.SUPREMIUMCRYSTAL.get())
                    ))).build());
}
