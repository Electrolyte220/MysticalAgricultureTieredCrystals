package com.electrolyte.matc.items;

import com.blakebr0.cucumber.item.BaseReusableItem;
import com.electrolyte.matc.config.MATCModConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Function;

public class TertiumCrystal extends BaseReusableItem {

    public TertiumCrystal(Function<Properties, Properties> properties) {
        super(MATCModConfig.TERTIUM_DURABILITY.get(), properties);
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return false;
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return MATCModConfig.TERTIUM_DURABILITY.get();
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> list, TooltipFlag flagIn) {
        if(MATCModConfig.UPGRADE_TOOLTIP.get()) {
            list.add(new TextComponent(ChatFormatting.GRAY + "Tertium -> Imperium"));
        }

       if(MATCModConfig.TERTIUM_DURABILITY_ENABLED.get() && MATCModConfig.USES_TOOLTIP.get()) {
            list.add(new TextComponent(ChatFormatting.GRAY + "Uses Left: " + ChatFormatting.RED + "" + (stack.getMaxDamage() - getDamage(stack))));
       }

        else if (!MATCModConfig.TERTIUM_DURABILITY_ENABLED.get() && MATCModConfig.USES_TOOLTIP.get()) {
            list.add(new TextComponent(ChatFormatting.GRAY + "Uses Left: " + ChatFormatting.RED + "Unlimited"));
        }
    }
}
