package dev.electrolyte.matc.client;

import com.blakebr0.cucumber.helper.ColorHelper;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public record TieredInfusionCrystalTintSource(int color) implements ItemTintSource {

    public static final MapCodec<TieredInfusionCrystalTintSource> MAP_CODEC = RecordCodecBuilder.mapCodec(
        i -> i.group(ExtraCodecs.RGB_COLOR_CODEC.fieldOf("color").forGetter(TieredInfusionCrystalTintSource::color)).apply(i, TieredInfusionCrystalTintSource::new)
    );

    @Override
    public int calculate(ItemStack itemStack, ClientLevel level, LivingEntity owner) {
        float damage = (float) (itemStack.getMaxDamage() - itemStack.getDamageValue()) / itemStack.getMaxDamage();
        return ColorHelper.saturate(color, damage);
    }

    @Override
    public MapCodec<? extends ItemTintSource> type() {
        return MAP_CODEC;
    }
}
