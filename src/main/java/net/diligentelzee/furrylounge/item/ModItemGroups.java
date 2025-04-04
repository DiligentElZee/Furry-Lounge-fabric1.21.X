package net.diligentelzee.furrylounge.item;

import net.diligentelzee.furrylounge.FurryLounge;
import net.diligentelzee.furrylounge.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup FURRY_LOUNGE_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FurryLounge.MOD_ID, "furry_lounge_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.ITEM))
                    .displayName(Text.translatable("itemgroup.furrylounge.items"))
                    .entries((displayContext, entries) -> {
                        // Add ModItems here
                        entries.add(ModItems.ITEM);
                        entries.add(ModItems.ITEM_2);
                        entries.add(ModItems.CONVERTER);
                    }).build());

    public static final ItemGroup FURRY_LOUNGE_FOOD = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FurryLounge.MOD_ID, "furry_lounge_food"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.TWINX))
                    .displayName(Text.translatable("itemgroup.furrylounge.food"))
                    .entries((displayContext, entries) -> {
                        // Add ModItems here
                        entries.add(ModItems.TWINX);
                        entries.add(ModItems.SUSHI_FOX);
                        entries.add(ModItems.SNEPSI);
                    }).build());

    public static final ItemGroup FURRY_LOUNGE_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FurryLounge.MOD_ID, "furry_lounge_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.BLOCK_2))
                    .displayName(Text.translatable("itemgroup.furrylounge.blocks"))
                    .entries((displayContext, entries) -> {
                        // Add ModBlocks here
                        entries.add(ModBlocks.MAGIC_BLOCK);
                        entries.add(ModBlocks.BLOCK);
                        entries.add(ModBlocks.BLOCK_2);
                        entries.add(ModBlocks.ORE);
                        entries.add(ModBlocks.ORE_2);
                    }).build());
    public static final ItemGroup FURRY_LOUNGE_BUILDING_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FurryLounge.MOD_ID, "furry_lounge_building_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.STAIRS))
                    .displayName(Text.translatable("itemgroup.furrylounge.building"))
                    .entries((displayContext, entries) -> {
                        // Add ModBlocks for Building here
                        entries.add(ModBlocks.STAIRS);
                        entries.add(ModBlocks.SLAB);
                        entries.add(ModBlocks.BUTTON);
                        entries.add(ModBlocks.PRESSURE_PLATE);
                        entries.add(ModBlocks.FENCE);
                        entries.add(ModBlocks.FENCE_GATE);
                        entries.add(ModBlocks.WALL);
                        entries.add(ModBlocks.DOOR);
                        entries.add(ModBlocks.TRAPDOOR);

                        entries.add(ModBlocks.STAIRS_2);
                        entries.add(ModBlocks.SLAB_2);
                        entries.add(ModBlocks.BUTTON_2);
                        entries.add(ModBlocks.PRESSURE_PLATE_2);
                        entries.add(ModBlocks.FENCE_2);
                        entries.add(ModBlocks.FENCE_GATE_2);
                        entries.add(ModBlocks.WALL_2);
                        entries.add(ModBlocks.DOOR_2);
                        entries.add(ModBlocks.TRAPDOOR_2);
                    }).build());


    public static final ItemGroup FURRY_LOUNGE_UNOBTAINABLE = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FurryLounge.MOD_ID, "furry_lounge_unobtainable"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.CONVERTER))
                    .displayName(Text.translatable("itemgroup.furrylounge.unobtainable"))
                    .entries((displayContext, entries) -> {
                        // Add stuff NOT obtainable in Survival here
                        entries.add(ModItems.FUEL);
                    }).build());
    public static void registerItemGroups() {
        FurryLounge.LOGGER.info("Registering ItemGroups for mod '" + FurryLounge.MOD_ID + "'!");
    }
}
