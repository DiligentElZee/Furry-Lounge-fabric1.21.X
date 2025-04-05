package net.diligentelzee.furrylounge.block;

import net.diligentelzee.furrylounge.FurryLounge;
import net.diligentelzee.furrylounge.block.custom.MagicBlock;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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

    // Register Non-block Blocks here
    public static final Block STAIRS = registerBlock("stairs",
            new StairsBlock(ModBlocks.BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block STAIRS_2 = registerBlock("stairs_2",
            new StairsBlock(ModBlocks.BLOCK_2.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block SLAB = registerBlock("slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block SLAB_2 = registerBlock("slab_2",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block BUTTON = registerBlock("button",
            new ButtonBlock(BlockSetType.WARPED, 2,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));
    public static final Block BUTTON_2 = registerBlock("button_2",
            new ButtonBlock(BlockSetType.CRIMSON, 2,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));

    public static final Block PRESSURE_PLATE = registerBlock("pressure_plate",
            new PressurePlateBlock(BlockSetType.WARPED,
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block PRESSURE_PLATE_2 = registerBlock("pressure_plate_2",
            new PressurePlateBlock(BlockSetType.CRIMSON,
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block FENCE = registerBlock("fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block FENCE_2 = registerBlock("fence_2",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block FENCE_GATE = registerBlock("fence_gate",
            new FenceGateBlock(WoodType.WARPED, AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block FENCE_GATE_2 = registerBlock("fence_gate_2",
            new FenceGateBlock(WoodType.CRIMSON, AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block WALL = registerBlock("wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block WALL_2 = registerBlock("wall_2",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block DOOR = registerBlock("door",
            new DoorBlock(BlockSetType.WARPED,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
    public static final Block DOOR_2 = registerBlock("door_2",
            new DoorBlock(BlockSetType.CRIMSON,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    public static final Block TRAPDOOR = registerBlock("trapdoor",
            new TrapdoorBlock(BlockSetType.WARPED,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
    public static final Block TRAPDOOR_2 = registerBlock("trapdoor_2",
            new TrapdoorBlock(BlockSetType.CRIMSON,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));

    // Helper Methods
    public static void register() {
        Registry.register(Registries.BLOCK, Identifier.of("furrylounge", "magic_block"), MAGIC_BLOCK);
    }
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
    }
}