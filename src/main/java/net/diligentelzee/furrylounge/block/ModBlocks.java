package net.diligentelzee.furrylounge.block;

import net.diligentelzee.furrylounge.FurryLounge;
import net.diligentelzee.furrylounge.block.custom.MagicBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.List;

public class ModBlocks {
    // Register new Blocks here
    public static final Block BLOCK = registerBlock("block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f).requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK).instrument(NoteBlockInstrument.HARP)
            ));
    public static final Block BLOCK_2 = registerBlock("block_2",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f).requiresTool()
                    .sounds(BlockSoundGroup.WOOD).instrument(NoteBlockInstrument.BIT)
            ));

    public static final Block ORE = registerBlock("ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                            .strength(3f).requiresTool()
                            .sounds(BlockSoundGroup.AMETHYST_BLOCK).instrument(NoteBlockInstrument.HARP)));
    public static final Block ORE_2 = registerBlock("ore_2",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create()
                            .strength(3f).requiresTool()
                            .sounds(BlockSoundGroup.WOOD).instrument(NoteBlockInstrument.BIT)));

    // Register Custom Blocks here
    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()
                    .luminance(state -> state.get(MagicBlock.LIT) ? 11 : 6)) {
                @Override
                public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
                    tooltip.add(Text.translatable("tooltip.furrylounge.magicblock"));
                    super.appendTooltip(stack, context, tooltip, options);
                }
            });

    public static void register() {
        Registry.register(Registries.BLOCK, Identifier.of("furrylounge", "magic_block"), MAGIC_BLOCK);
    }

    // Helper Methods
    private  static  Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(FurryLounge.MOD_ID, name), block);
    }
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(FurryLounge.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        FurryLounge.LOGGER.info("Registering Mod Blocks for '" + FurryLounge.MOD_ID + "'");

        // Add Blocks to Inventory Tabs
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.BLOCK);
            entries.add(ModBlocks.BLOCK_2);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.ORE);
            entries.add(ModBlocks.ORE_2);
        });
    }
}