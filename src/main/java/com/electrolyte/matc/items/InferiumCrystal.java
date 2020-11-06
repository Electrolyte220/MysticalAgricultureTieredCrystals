package com.electrolyte.matc.items;

import com.electrolyte.matc.config.MATCModConfig;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

public class InferiumCrystal extends Item {

    public InferiumCrystal(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isDamageable() {
        return true;
    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        ItemStack item = itemStack.copy();
        if(MATCModConfig.INFERIUM_DURABILITY_ENABLED.get()) {
            item.setDamage(item.getDamage() + 1);
        }
        if(item.getDamage() >= getMaxDamage(item)) {
            item.shrink(1);
        }
        return item;
    }

    @Override
    public boolean isRepairable(ItemStack stack) {
        return false;
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return MATCModConfig.INFERIUM_DURABILITY.get();
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> list, ITooltipFlag flagIn) {
        list.add(new StringTextComponent(TextFormatting.GRAY + "Inferium -> Prudentium"));

       if(MATCModConfig.INFERIUM_DURABILITY_ENABLED.get()) {
            list.add(new StringTextComponent(TextFormatting.GRAY + "Uses Left: " + TextFormatting.RED + "" + (stack.getMaxDamage() - getDamage(stack))));
       }

        else if (!MATCModConfig.INFERIUM_DURABILITY_ENABLED.get()) {
            list.add(new StringTextComponent(TextFormatting.GRAY + "Uses Left: " + TextFormatting.RED + "Unlimited"));
        }
    }
}
