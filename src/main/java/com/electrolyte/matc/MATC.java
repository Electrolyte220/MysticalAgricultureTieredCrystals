package com.electrolyte.matc;

import com.electrolyte.matc.config.MATCModConfig;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.List;

@Mod(MATC.MOD_ID)
public class MATC {

    public static final String MOD_ID = "matc";

    public MATC() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MATCModConfig.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MATCModConfig.SERVER_CONFIG);

        ModRegistry.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::registerCreativeTab);
    }

    private void registerCreativeTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(MATC.MOD_ID), configurator -> {
            configurator.title(Component.translatable("matc.tab.title"));
            configurator.icon(() -> new ItemStack(ModRegistry.SUPREMIUMCRYSTAL.get()));
            configurator.displayItems((featureFlagSet, output, p_260123_) ->
                    output.acceptAll(List.of(
                            new ItemStack(ModRegistry.INFERIUMCRYSTAL.get()),
                            new ItemStack(ModRegistry.PRUDENTIUMCRYSTAL.get()),
                            new ItemStack(ModRegistry.TERTIUMCRYSTAL.get()),
                            new ItemStack(ModRegistry.IMPERIUMCRYSTAL.get()),
                            new ItemStack(ModRegistry.SUPREMIUMCRYSTAL.get()))));
            configurator.build();
        });
    }
}
