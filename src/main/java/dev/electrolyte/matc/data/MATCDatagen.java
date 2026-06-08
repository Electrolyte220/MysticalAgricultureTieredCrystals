package dev.electrolyte.matc.data;

import dev.electrolyte.matc.MATC;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = MATC.MOD_ID)
public class MATCDatagen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        event.createProvider(MATCItemTagsProvider::new);
        event.createProvider(MATCRecipeProvider.Runner::new);

        event.createProvider(MATCLangProvider::new);
        event.createProvider(MATCItemModelProvider::new);
    }
}
