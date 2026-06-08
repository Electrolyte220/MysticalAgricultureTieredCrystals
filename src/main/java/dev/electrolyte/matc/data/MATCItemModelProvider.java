package dev.electrolyte.matc.data;

import com.blakebr0.mysticalagriculture.init.ModItems;
import dev.electrolyte.matc.MATC;
import dev.electrolyte.matc.ModRegistry;
import dev.electrolyte.matc.client.TieredInfusionCrystalTintSource;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;

class MATCItemModelProvider extends ModelProvider {
    public MATCItemModelProvider(PackOutput output) {
        super(output, MATC.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        generateFlatTintedItem(ModRegistry.INFERIUM_CRYSTAL.get(), ModItems.INFUSION_CRYSTAL.get(), itemModels.modelOutput, itemModels.itemModelOutput, 0x8AB800);
        generateFlatTintedItem(ModRegistry.PRUDENTIUM_CRYSTAL.get(), ModItems.INFUSION_CRYSTAL.get(), itemModels.modelOutput, itemModels.itemModelOutput, 0x00AA00);
        generateFlatTintedItem(ModRegistry.TERTIUM_CRYSTAL.get(), ModItems.INFUSION_CRYSTAL.get(), itemModels.modelOutput, itemModels.itemModelOutput, 0xE35400);
        generateFlatTintedItem(ModRegistry.IMPERIUM_CRYSTAL.get(), ModItems.INFUSION_CRYSTAL.get(), itemModels.modelOutput, itemModels.itemModelOutput, 0x0087E8);
        generateFlatTintedItem(ModRegistry.SUPREMIUM_CRYSTAL.get(), ModItems.INFUSION_CRYSTAL.get(), itemModels.modelOutput, itemModels.itemModelOutput, 0xDD0000);
    }

    public void generateFlatTintedItem(Item item, Item textureDonor, BiConsumer<Identifier, ModelInstance> modelOutput, ItemModelOutput itemModelOutput, int tint) {
        itemModelOutput.accept(item, ItemModelUtils.tintedModel(createFlatItemModel(item, textureDonor, ModelTemplates.FLAT_ITEM, modelOutput), new TieredInfusionCrystalTintSource(tint)));
    }

    public Identifier createFlatItemModel(Item item, Item textureDonor, ModelTemplate template, BiConsumer<Identifier, ModelInstance> modelOutput) {
        return template.create(ModelLocationUtils.getModelLocation(item), TextureMapping.layer0(textureDonor), modelOutput);
    }
}
