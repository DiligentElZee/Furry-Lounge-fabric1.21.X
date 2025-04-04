package net.diligentelzee.furrylounge.datagen;

import net.diligentelzee.furrylounge.block.ModBlocks;
import net.diligentelzee.furrylounge.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput,
                           CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BLOCK);
        addDrop(ModBlocks.BLOCK_2);

        addDrop(ModBlocks.MAGIC_BLOCK);

        addDrop(ModBlocks.ORE, oreDrops(ModBlocks.ORE, ModItems.ITEM));
        addDrop(ModBlocks.ORE_2, multipleOreDrops(ModBlocks.ORE_2, ModItems.ITEM_2, 1, 3));

        addDrop(ModBlocks.STAIRS);
        addDrop(ModBlocks.STAIRS_2);

        addDrop(ModBlocks.BUTTON);
        addDrop(ModBlocks.BUTTON_2);

        addDrop(ModBlocks.PRESSURE_PLATE);
        addDrop(ModBlocks.PRESSURE_PLATE_2);

        addDrop(ModBlocks.WALL);
        addDrop(ModBlocks.WALL_2);

        addDrop(ModBlocks.FENCE);
        addDrop(ModBlocks.FENCE_2);

        addDrop(ModBlocks.FENCE_GATE);
        addDrop(ModBlocks.FENCE_GATE_2);

        addDrop(ModBlocks.DOOR, doorDrops(ModBlocks.DOOR));
        addDrop(ModBlocks.DOOR_2, doorDrops(ModBlocks.DOOR_2));

        addDrop(ModBlocks.TRAPDOOR);
        addDrop(ModBlocks.TRAPDOOR_2);

        addDrop(ModBlocks.SLAB, slabDrops(ModBlocks.SLAB));
        addDrop(ModBlocks.SLAB_2, slabDrops(ModBlocks.SLAB_2));
}

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}