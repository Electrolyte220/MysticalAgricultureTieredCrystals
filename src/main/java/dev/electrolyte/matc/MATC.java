package dev.electrolyte.matc;

import dev.electrolyte.matc.config.MATCModConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Supplier;

@Mod(MATC.MOD_ID)
public class MATC {

    public static final String MOD_ID = "matc";
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MATC.MOD_ID);

    public MATC(IEventBus bus, ModContainer container, Dist dist) {
        container.registerConfig(ModConfig.Type.CLIENT, MATCModConfig.CLIENT_CONFIG);
        container.registerConfig(ModConfig.Type.SERVER, MATCModConfig.SERVER_CONFIG);

        if (dist == Dist.CLIENT) {
            container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        }

        ModRegistry.register(bus);
        CREATIVE_MODE_TABS.register(bus);
    }

    private static final Supplier<CreativeModeTab> MATC_TAB = CREATIVE_MODE_TABS.register("matc", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.matc"))
            .icon(() -> new ItemStack(ModRegistry.SUPREMIUM_CRYSTAL.get()))
            .displayItems((displayParameters, output) ->
                    output.acceptAll(List.of(
                            new ItemStack(ModRegistry.INFERIUM_CRYSTAL.get()),
                            new ItemStack(ModRegistry.PRUDENTIUM_CRYSTAL.get()),
                            new ItemStack(ModRegistry.TERTIUM_CRYSTAL.get()),
                            new ItemStack(ModRegistry.IMPERIUM_CRYSTAL.get()),
                            new ItemStack(ModRegistry.SUPREMIUM_CRYSTAL.get())
                    ))).build());
}
