package dev.electrolyte.matc.client;

import dev.electrolyte.matc.MATC;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

@EventBusSubscriber(modid = MATC.MOD_ID, value = Dist.CLIENT)
public final class MATCColorHandler {

    @SubscribeEvent
    public static void onItemColors(RegisterColorHandlersEvent.ItemTintSources event) {
        event.register(Identifier.fromNamespaceAndPath(MATC.MOD_ID, "infusion_tint"), TieredInfusionCrystalTintSource.MAP_CODEC);
    }
}
