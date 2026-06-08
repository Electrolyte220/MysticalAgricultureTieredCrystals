package dev.electrolyte.matc.data;

import com.blakebr0.mysticalagriculture.MysticalAgriculture;
import com.blakebr0.mysticalagriculture.init.ModItems;
import dev.electrolyte.matc.MATC;
import dev.electrolyte.matc.ModRegistry;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider.TagLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags.Items;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ItemTagsProvider;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MATCItemTagsProvider extends ItemTagsProvider {
    public MATCItemTagsProvider(PackOutput packOutput, CompletableFuture<Provider> provider) {
        super(packOutput, provider, MATC.MOD_ID);
    }

    @Override
    protected void addTags(Provider provider) {
        this.tag(ModRegistry.INFERIUM_CRYSTALS).add(ModRegistry.INFERIUM_CRYSTAL.get()).add(ModItems.MASTER_INFUSION_CRYSTAL.get());
        this.tag(ModRegistry.PRUDENTIUM_CRYSTALS).add(ModRegistry.PRUDENTIUM_CRYSTAL.get()).add(ModItems.MASTER_INFUSION_CRYSTAL.get());
        this.tag(ModRegistry.TERTIUM_CRYSTALS).add(ModRegistry.TERTIUM_CRYSTAL.get()).add(ModItems.MASTER_INFUSION_CRYSTAL.get());
        this.tag(ModRegistry.IMPERIUM_CRYSTALS).add(ModRegistry.IMPERIUM_CRYSTAL.get()).add(ModItems.MASTER_INFUSION_CRYSTAL.get());
        this.tag(ModRegistry.SUPREMIUM_CRYSTALS).add(ModRegistry.SUPREMIUM_CRYSTAL.get()).add(ModItems.MASTER_INFUSION_CRYSTAL.get());

        this.tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModRegistry.INFERIUM_CRYSTAL.get())
                .add(ModRegistry.PRUDENTIUM_CRYSTAL.get())
                .add(ModRegistry.TERTIUM_CRYSTAL.get())
                .add(ModRegistry.IMPERIUM_CRYSTAL.get())
                .add(ModRegistry.SUPREMIUM_CRYSTAL.get());

        this.tag(Items.HIDDEN_FROM_RECIPE_VIEWERS).add(ModItems.INFUSION_CRYSTAL.get());

        TagKey<Item> INFUSION_CRYSTALS = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(MysticalAgriculture.MOD_ID, "infusion_crystals"));
        this.tag(INFUSION_CRYSTALS).remove(ModItems.INFUSION_CRYSTAL.get()).remove(ModItems.MASTER_INFUSION_CRYSTAL.get()).replace(true);
    }
}
