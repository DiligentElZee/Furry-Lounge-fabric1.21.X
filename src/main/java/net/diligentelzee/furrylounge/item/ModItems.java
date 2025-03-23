package net.diligentelzee.furrylounge.item;

import net.diligentelzee.furrylounge.FurryLounge;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    // Register new Items here
    public static final Item PLACEHOLDER_ITEM = registerItem("placeholder_item", new Item(new Item.Settings()));
    public static final Item PLACEHOLDER_ITEM_2 = registerItem("placeholder_item_2", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FurryLounge.MOD_ID, name), item);
     }

    public static void registerModItems() {
        FurryLounge.LOGGER.info("Registering Mod Items for mod '" + FurryLounge.MOD_ID + "'!");

        // Add Items to Inventory Tabs
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PLACEHOLDER_ITEM);
            entries.add(PLACEHOLDER_ITEM_2);
        });
    }
}