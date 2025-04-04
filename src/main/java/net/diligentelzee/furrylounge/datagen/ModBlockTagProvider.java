package net.diligentelzee.furrylounge.datagen;

import net.diligentelzee.furrylounge.block.ModBlocks;
import net.diligentelzee.furrylounge.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BLOCK)
                .add(ModBlocks.BLOCK_2)
                .add(ModBlocks.ORE)
                .add(ModBlocks.ORE_2);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ORE_2)
                .add(ModBlocks.ORE);
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BLOCK)
                .add(ModBlocks.BLOCK_2);
        getOrCreateTagBuilder(ModTags.Blocks.ITEM_ORE)
                .add(ModBlocks.ORE);
        getOrCreateTagBuilder(ModTags.Blocks.ITEM_ORE_2)
                .add(ModBlocks.ORE_2);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.FENCE).add(ModBlocks.FENCE_2)
                .add(ModBlocks.FENCE_GATE).add(ModBlocks.FENCE_GATE_2)
                .add(ModBlocks.WALL).add(ModBlocks.WALL_2);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.FENCE).add(ModBlocks.FENCE_2)
                .add(ModBlocks.FENCE_GATE).add(ModBlocks.FENCE_GATE_2)
                .add(ModBlocks.WALL).add(ModBlocks.WALL_2);

        getOrCreateTagBuilder(BlockTags.DOORS)
                .add(ModBlocks.DOOR)
                .add(ModBlocks.DOOR_2);
        getOrCreateTagBuilder(BlockTags.TRAPDOORS)
                .add(ModBlocks.TRAPDOOR)
                .add(ModBlocks.TRAPDOOR_2);

        getOrCreateTagBuilder(BlockTags.SLABS)
                .add(ModBlocks.SLAB)
                .add(ModBlocks.SLAB_2);

        getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.PRESSURE_PLATE_2)
                .add(ModBlocks.PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.BUTTON)
                .add(ModBlocks.BUTTON_2);

        getOrCreateTagBuilder(BlockTags.STAIRS)
                .add(ModBlocks.STAIRS)
                .add(ModBlocks.STAIRS_2);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.WALL)
                .add(ModBlocks.WALL_2);
    }
}
