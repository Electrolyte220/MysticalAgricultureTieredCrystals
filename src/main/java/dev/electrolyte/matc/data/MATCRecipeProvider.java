package dev.electrolyte.matc.data;

import com.blakebr0.mysticalagriculture.init.ModItems;
import dev.electrolyte.matc.MATC;
import dev.electrolyte.matc.ModRegistry;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.NotCondition;

import java.util.concurrent.CompletableFuture;

public class MATCRecipeProvider extends RecipeProvider {
    public MATCRecipeProvider(Provider provider, RecipeOutput output) {
        super(provider, output);
    }

    @Override
    protected void buildRecipes() {

        shaped(RecipeCategory.MISC, ModRegistry.INFERIUM_CRYSTAL.get())
                .pattern("PEP")
                .pattern("EGE")
                .pattern("PEP")
                .define('E', ModItems.PROSPERITY_SHARD.get())
                .define('P', ModItems.INFERIUM_ESSENCE.get())
                .define('G', ModItems.INFERIUM_GEMSTONE.get())
                .unlockedBy(getHasName(ModItems.INFERIUM_ESSENCE.get()), has(ModItems.INFERIUM_ESSENCE.get()))
                .save(output);

        shaped(RecipeCategory.MISC, ModRegistry.PRUDENTIUM_CRYSTAL.get())
                .pattern("PEP")
                .pattern("EGE")
                .pattern("PEP")
                .define('E', ModItems.PROSPERITY_SHARD.get())
                .define('P', ModItems.PRUDENTIUM_ESSENCE.get())
                .define('G', ModRegistry.INFERIUM_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.PRUDENTIUM_ESSENCE.get()), has(ModItems.PRUDENTIUM_ESSENCE.get()))
                .save(output);

        shaped(RecipeCategory.MISC, ModRegistry.TERTIUM_CRYSTAL.get())
                .pattern("PEP")
                .pattern("EGE")
                .pattern("PEP")
                .define('E', ModItems.PROSPERITY_SHARD.get())
                .define('P', ModItems.TERTIUM_ESSENCE.get())
                .define('G', ModRegistry.PRUDENTIUM_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.TERTIUM_ESSENCE.get()), has(ModItems.TERTIUM_ESSENCE.get()))
                .save(output);

        shaped(RecipeCategory.MISC, ModRegistry.IMPERIUM_CRYSTAL.get())
                .pattern("PEP")
                .pattern("EGE")
                .pattern("PEP")
                .define('E', ModItems.PROSPERITY_SHARD.get())
                .define('P', ModItems.IMPERIUM_ESSENCE.get())
                .define('G', ModRegistry.TERTIUM_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.IMPERIUM_ESSENCE.get()), has(ModItems.IMPERIUM_ESSENCE.get()))
                .save(output);

        shaped(RecipeCategory.MISC, ModRegistry.SUPREMIUM_CRYSTAL.get())
                .pattern("PEP")
                .pattern("EGE")
                .pattern("PEP")
                .define('E', ModItems.PROSPERITY_SHARD.get())
                .define('P', ModItems.SUPREMIUM_ESSENCE.get())
                .define('G', ModRegistry.IMPERIUM_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.SUPREMIUM_ESSENCE.get()), has(ModItems.SUPREMIUM_ESSENCE.get()))
                .save(output);


        shaped(RecipeCategory.MISC, ModItems.PRUDENTIUM_ESSENCE.get())
                .pattern(" E ")
                .pattern("EPE")
                .pattern(" E ")
                .define('P', ModRegistry.INFERIUM_CRYSTALS)
                .define('E', ModItems.INFERIUM_ESSENCE.get())
                .unlockedBy(getHasName(ModRegistry.INFERIUM_CRYSTAL.get()), has(ModRegistry.INFERIUM_CRYSTAL.get()))
                .save(output, Identifier.fromNamespaceAndPath(MATC.MOD_ID, "prudentium_essence").toString());

        shaped(RecipeCategory.MISC, ModItems.TERTIUM_ESSENCE.get())
                .pattern(" E ")
                .pattern("EPE")
                .pattern(" E ")
                .define('P', ModRegistry.PRUDENTIUM_CRYSTALS)
                .define('E', ModItems.PRUDENTIUM_ESSENCE.get())
                .unlockedBy(getHasName(ModRegistry.PRUDENTIUM_CRYSTAL.get()), has(ModRegistry.PRUDENTIUM_CRYSTAL.get()))
                .save(output, Identifier.fromNamespaceAndPath(MATC.MOD_ID, "tertium_essence").toString());

        shaped(RecipeCategory.MISC, ModItems.IMPERIUM_ESSENCE.get())
                .pattern(" E ")
                .pattern("EPE")
                .pattern(" E ")
                .define('P', ModRegistry.TERTIUM_CRYSTALS)
                .define('E', ModItems.TERTIUM_ESSENCE.get())
                .unlockedBy(getHasName(ModRegistry.TERTIUM_CRYSTAL.get()), has(ModRegistry.TERTIUM_CRYSTAL.get()))
                .save(output, Identifier.fromNamespaceAndPath(MATC.MOD_ID, "imperium_essence").toString());

        shaped(RecipeCategory.MISC, ModItems.SUPREMIUM_ESSENCE.get())
                .pattern(" E ")
                .pattern("EPE")
                .pattern(" E ")
                .define('P', ModRegistry.IMPERIUM_CRYSTALS)
                .define('E', ModItems.IMPERIUM_ESSENCE.get())
                .unlockedBy(getHasName(ModRegistry.IMPERIUM_CRYSTAL.get()), has(ModRegistry.IMPERIUM_CRYSTAL.get()))
                .save(output, Identifier.fromNamespaceAndPath(MATC.MOD_ID, "supremium_essence").toString());


        ModLoadedCondition modLoaded = new ModLoadedCondition("mysticalagradditions");
        Item insaniumEssence = BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath("mysticalagradditions", "insanium_essence"));
        shaped(RecipeCategory.MISC, ModItems.MASTER_INFUSION_CRYSTAL.get())
                .pattern("PEP")
                .pattern("EGE")
                .pattern("PEP")
                .define('E', ModItems.PROSPERITY_SHARD.get())
                .define('P', ModItems.SUPREMIUM_ESSENCE.get())
                .define('G', ModRegistry.SUPREMIUM_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.SUPREMIUM_ESSENCE.get()), has(ModItems.SUPREMIUM_ESSENCE.get()))
                .save(output.withConditions(new NotCondition(modLoaded)), Identifier.fromNamespaceAndPath(MATC.MOD_ID, "master_infusion_crystal_superium").toString());

        shaped(RecipeCategory.MISC, ModItems.MASTER_INFUSION_CRYSTAL.get())
                .pattern("PEP")
                .pattern("EGE")
                .pattern("PEP")
                .define('E', ModItems.PROSPERITY_SHARD.get())
                .define('P', insaniumEssence)
                .define('G', ModRegistry.SUPREMIUM_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.SUPREMIUM_ESSENCE.get()), has(ModItems.SUPREMIUM_ESSENCE.get()))
                .save(output.withConditions(modLoaded), Identifier.fromNamespaceAndPath(MATC.MOD_ID, "master_infusion_crystal").toString());

        shaped(RecipeCategory.MISC, insaniumEssence)
                .pattern(" E ")
                .pattern("EPE")
                .pattern(" E ")
                .define('P', ModRegistry.SUPREMIUM_CRYSTALS)
                .define('E', ModItems.SUPREMIUM_ESSENCE.get())
                .unlockedBy(getHasName(ModRegistry.SUPREMIUM_CRYSTAL.get()), has(ModRegistry.SUPREMIUM_CRYSTAL.get()))
                .save(output.withConditions(modLoaded), Identifier.fromNamespaceAndPath(MATC.MOD_ID, "insanium_essence").toString());
    }

    public static class Runner extends RecipeProvider.Runner {

        protected Runner(PackOutput packOutput, CompletableFuture<Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(Provider registries, RecipeOutput output) {
            return new MATCRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return MATC.MOD_ID + " Recipes";
        }
    }
}
