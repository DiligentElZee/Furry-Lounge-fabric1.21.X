package net.diligentelzee.furrylounge.datagen;

import net.diligentelzee.furrylounge.item.ModItems;
import net.diligentelzee.furrylounge.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // MagicBlock Tags
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.ITEM).add(Items.COAL).add(Items.CHARCOAL)//DIAMOND
                .add(ModItems.ITEM_2).add(Items.CAKE)//EMERALD
                .add(Items.BREAD).add(Items.APPLE).add(Items.POTATO).add(Items.CARROT).add(Items.BAKED_POTATO).add(Items.GOLDEN_CARROT)//SWEET BERRY
                .add(Items.BUCKET).add(Items.BUBBLE_CORAL).add(Items.BUBBLE_CORAL_BLOCK).add(Items.BUBBLE_CORAL_FAN)//SNEPSI
                .add(Items.COCOA_BEANS)//TWINX
                .add(Items.COOKED_COD).add(Items.COOKED_SALMON);//SUSHI FOX

        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS_TO_DIAMOND)
                .add(ModItems.ITEM)
                .add(Items.COAL)
                .add(Items.CHARCOAL);
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS_TO_EMERALD)
                .add(ModItems.ITEM_2)
                .add(Items.CAKE);
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS_TO_SWEET_BERRY)
                .add(Items.BREAD)
                .add(Items.APPLE)
                .add(Items.POTATO)
                .add(Items.CARROT)
                .add(Items.BAKED_POTATO)
                .add(Items.GOLDEN_CARROT);
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS_TO_SNEPSI)
                .add(Items.BUCKET)
                .add(Items.BUBBLE_CORAL)
                .add(Items.BUBBLE_CORAL_BLOCK)
                .add(Items.BUBBLE_CORAL_FAN);
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS_TO_TWINX)
                .add(Items.COCOA_BEANS);
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS_TO_SUSHI_FOX)
                .add(Items.COOKED_COD)
                .add(Items.COOKED_SALMON);
    }
}
