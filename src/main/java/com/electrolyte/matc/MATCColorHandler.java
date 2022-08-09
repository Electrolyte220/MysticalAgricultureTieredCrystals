package com.electrolyte.matc;

import com.blakebr0.cucumber.helper.ColorHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MATC.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class MATCColorHandler {

    @SubscribeEvent
    public static void onItemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, tint) -> {
                float stackDamage = (float) (stack.getMaxDamage() - stack.getDamageValue()) / stack.getMaxDamage();
                return ColorHelper.saturate(0x8AB800, stackDamage);
            }, ModRegistry.INFERIUMCRYSTAL.get());

        event.register((stack, tint) -> {
                float stackDamage = (float) (stack.getMaxDamage() - stack.getDamageValue()) / stack.getMaxDamage();
                return ColorHelper.saturate(0x00AA00, stackDamage);
            }, ModRegistry.PRUDENTIUMCRYSTAL.get());

        event.register((stack, tint) -> {
                float stackDamage = (float) (stack.getMaxDamage() - stack.getDamageValue()) / stack.getMaxDamage();
                return ColorHelper.saturate(0xE35400, stackDamage);
                }, ModRegistry.TERTIUMCRYSTAL.get());

        event.register((stack, tint) -> {
                float stackDamage = (float) (stack.getMaxDamage() - stack.getDamageValue()) / stack.getMaxDamage();
                return ColorHelper.saturate(0x0087E8, stackDamage);
            }, ModRegistry.IMPERIUMCRYSTAL.get());

        event.register((stack, tint) -> {
                float stackDamage = (float) (stack.getMaxDamage() - stack.getDamageValue()) / stack.getMaxDamage();
                return ColorHelper.saturate(0xDD0000, stackDamage);
            }, ModRegistry.SUPREMIUMCRYSTAL.get());
    }
}
