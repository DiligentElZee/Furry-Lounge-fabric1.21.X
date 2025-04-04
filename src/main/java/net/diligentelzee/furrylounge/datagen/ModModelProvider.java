package net.diligentelzee.furrylounge.datagen;

import net.diligentelzee.furrylounge.block.ModBlocks;
import net.diligentelzee.furrylounge.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool blockPool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLOCK);
        BlockStateModelGenerator.BlockTexturePool block2Pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLOCK_2);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_2);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        blockPool.stairs(ModBlocks.STAIRS);
        block2Pool.stairs(ModBlocks.STAIRS_2);

        blockPool.slab(ModBlocks.SLAB);
        block2Pool.slab(ModBlocks.SLAB_2);

        blockPool.button(ModBlocks.BUTTON);
        block2Pool.button(ModBlocks.BUTTON_2);

        blockPool.pressurePlate(ModBlocks.PRESSURE_PLATE);
        block2Pool.pressurePlate(ModBlocks.PRESSURE_PLATE_2);

        blockPool.fence(ModBlocks.FENCE);
        block2Pool.fence(ModBlocks.FENCE_2);

        blockPool.fenceGate(ModBlocks.FENCE_GATE);
        block2Pool.fenceGate(ModBlocks.FENCE_GATE_2);

        blockPool.wall(ModBlocks.WALL);
        block2Pool.wall(ModBlocks.WALL_2);

        blockStateModelGenerator.registerDoor(ModBlocks.DOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.DOOR_2);

        blockStateModelGenerator.registerTrapdoor(ModBlocks.TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.TRAPDOOR_2);
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
