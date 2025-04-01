package net.diligentelzee.furrylounge.datagen;

import net.diligentelzee.furrylounge.block.ModBlocks;
import net.diligentelzee.furrylounge.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK_2);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_2);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ITEM_2, Models.GENERATED);

        itemModelGenerator.register(ModItems.CONVERTER, Models.GENERATED);

        itemModelGenerator.register(ModItems.TWINX, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNEPSI, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUSHI_FOX, Models.GENERATED);
        itemModelGenerator.register(ModItems.FUEL, Models.GENERATED);
    }
}
