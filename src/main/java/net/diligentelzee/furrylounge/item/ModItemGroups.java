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
                    }).build());
    public static final ItemGroup FURRY_LOUNGE_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(FurryLounge.MOD_ID, "furry_lounge_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.BLOCK_2))
                    .displayName(Text.translatable("itemgroup.furrylounge.blocks"))
                    .entries((displayContext, entries) -> {
                        // Add ModBlocks here
                        entries.add(ModBlocks.BLOCK);
                        entries.add(ModBlocks.BLOCK_2);
                        entries.add(ModBlocks.ORE);
                        entries.add(ModBlocks.ORE_2);
                    }).build());

    public static void registerItemGroups() {
        FurryLounge.LOGGER.info("Registering ItemGroups for mod '" + FurryLounge.MOD_ID + "'!");
    }
}
