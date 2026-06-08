package dev.electrolyte.matc.items;

import com.blakebr0.cucumber.item.BaseReusableItem;
import dev.electrolyte.matc.config.MATCModConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.common.ModConfigSpec.BooleanValue;
import net.neoforged.neoforge.common.ModConfigSpec.IntValue;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Consumer;
import java.util.function.Function;

public class BaseTieredCrystalItem extends BaseReusableItem {

    private IntValue uses;
    private final String tier;
    private BooleanValue durabilityEnabled;

    public BaseTieredCrystalItem(Identifier id, IntValue uses, String tier, BooleanValue durabilityEnabled, Function<Properties, Properties> properties) {
        super(id, uses.getDefault(), properties);
        this.uses = uses;
        this.tier = tier;
        this.durabilityEnabled = durabilityEnabled;
    }

    @Override
    public ItemStackTemplate getCraftingRemainder(ItemInstance stack) {
        int damage = stack.getOrDefault(DataComponents.DAMAGE, 0);
        if(!durabilityEnabled.get()) {
            ItemStackTemplate template = new ItemStackTemplate(stack.typeHolder());
            ItemStack newStack = template.create();
            newStack.setDamageValue(damage);
            return ItemStackTemplate.fromNonEmptyStack(newStack);
        }
        return super.getCraftingRemainder(stack);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return uses.get();
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag flag) {
        if(MATCModConfig.UPGRADE_TOOLTIP.get()) {
            Component tierTooltip = Component.translatable(ChatFormatting.GRAY + tier);
            if(!tier.contains("Insanium") || ModList.get().isLoaded("mysticalagradditions")) {
                builder.accept(tierTooltip);
            }
        }

        if(MATCModConfig.USES_TOOLTIP.get()) {
            String damage = durabilityEnabled.get() ?
                    String.valueOf(stack.getMaxDamage() - getDamage(stack)) :
                    "Unlimited";
            builder.accept(Component.translatable(ChatFormatting.GRAY + "Uses Left: " + ChatFormatting.RED + damage));
        }
    }
}
