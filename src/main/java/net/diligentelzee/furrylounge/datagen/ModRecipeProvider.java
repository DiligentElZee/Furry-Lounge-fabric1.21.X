package net.diligentelzee.furrylounge.datagen;

import net.diligentelzee.furrylounge.FurryLounge;
import net.diligentelzee.furrylounge.block.ModBlocks;
import net.diligentelzee.furrylounge.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> ITEM_SMELTABLES = List.of(ModItems.ITEM_2, ModBlocks.ORE);
        List<ItemConvertible> ITEM_2_SMELTABLES = List.of(ModItems.ITEM, ModBlocks.ORE_2);

        offerSmelting(exporter, ITEM_SMELTABLES, RecipeCategory.MISC, ModItems.ITEM, 0.25f, 210, "item");
        offerBlasting(exporter, ITEM_SMELTABLES, RecipeCategory.MISC, ModItems.ITEM, 0.25f, 105, "item");

        offerSmelting(exporter, ITEM_2_SMELTABLES, RecipeCategory.MISC, ModItems.ITEM_2, 0.25f, 210, "item_2");
        offerBlasting(exporter, ITEM_2_SMELTABLES, RecipeCategory.MISC, ModItems.ITEM_2, 0.25f, 105, "item_2");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ITEM,
                RecipeCategory.MISC, ModBlocks.BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ITEM_2,
                RecipeCategory.MISC, ModBlocks.BLOCK_2);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK)
                .pattern("SDS")
                .pattern("ESE")
                .pattern("SDS")
                .input('D', Items.DIAMOND)
                .input('E', Items.EMERALD)
                .input('S', Items.SWEET_BERRIES)
                .criterion(hasItem(Items.SWEET_BERRIES), conditionsFromItem(Items.SWEET_BERRIES))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SNEPSI, 1)
                .input(Items.BUCKET)
                .input(Items.BUBBLE_CORAL)
                .criterion(hasItem(Items.BUCKET), conditionsFromItem(Items.BUCKET))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ITEM, 32)
                .input(ModBlocks.MAGIC_BLOCK)
                .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                .offerTo(exporter, Identifier.of(FurryLounge.MOD_ID, "item_from_magic_block"));

         createDoorRecipe(ModBlocks.DOOR, Ingredient.ofItems(ModItems.ITEM))
                 .criterion(hasItem(ModItems.ITEM), conditionsFromItem(ModItems.ITEM))
                 .offerTo(exporter);
         createDoorRecipe(ModBlocks.DOOR_2, Ingredient.ofItems(ModItems.ITEM_2))
                 .criterion(hasItem(ModItems.ITEM_2), conditionsFromItem(ModItems.ITEM_2))
                 .offerTo(exporter);

         createTrapdoorRecipe(ModBlocks.TRAPDOOR, Ingredient.ofItems(ModItems.ITEM));
         createTrapdoorRecipe(ModBlocks.TRAPDOOR_2, Ingredient.ofItems(ModItems.ITEM_2));

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SLAB, Ingredient.ofItems(ModBlocks.BLOCK))
                .criterion("has_block", conditionsFromItem(ModBlocks.BLOCK))
                .offerTo(exporter);
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SLAB_2, Ingredient.ofItems(ModBlocks.BLOCK_2))
                .criterion("has_block_2", conditionsFromItem(ModBlocks.BLOCK_2))
                .offerTo(exporter);

        createFenceRecipe(ModBlocks.FENCE, Ingredient.ofItems(ModItems.ITEM));
        createFenceRecipe(ModBlocks.FENCE_2, Ingredient.ofItems(ModItems.ITEM_2));

        createFenceGateRecipe(ModBlocks.FENCE_GATE, Ingredient.ofItems(ModItems.ITEM));
        createFenceGateRecipe(ModBlocks.FENCE_GATE_2, Ingredient.ofItems(ModItems.ITEM_2));

        getWallRecipe(RecipeCategory.DECORATIONS, ModBlocks.WALL, Ingredient.ofItems(ModItems.ITEM));
        getWallRecipe(RecipeCategory.DECORATIONS, ModBlocks.WALL_2, Ingredient.ofItems(ModItems.ITEM_2));

        createTransmutationRecipe(ModBlocks.BUTTON, Ingredient.ofItems(ModItems.ITEM));
        createTransmutationRecipe(ModBlocks.BUTTON_2, Ingredient.ofItems(ModItems.ITEM_2));

        createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.PRESSURE_PLATE,
                Ingredient.ofItems(ModItems.ITEM));
        createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.PRESSURE_PLATE_2,
                Ingredient.ofItems(ModItems.ITEM_2));
    }
}
