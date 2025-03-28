package net.diligentelzee.furrylounge.item;

import net.diligentelzee.furrylounge.FurryLounge;
import net.diligentelzee.furrylounge.item.custom.ConverterItem;
import net.diligentelzee.furrylounge.item.custom.DrinkItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    // Register new Items here
    public static final Item ITEM = registerItem("item", new Item(new Item.Settings()));
    public static final Item ITEM_2 = registerItem("item_2", new Item(new Item.Settings()));

    public static final Item TWINX = registerItem("twinx", new Item(new Item.Settings()
            .food(ModFoodComponents.TWINX)));
    public static final Item SUSHI_FOX = registerItem("sushi_fox", new Item(new Item.Settings()
            .food(ModFoodComponents.SUSHI_FOX)));
    public static final Item SNEPSI = registerItem("snepsi", new DrinkItem(new Item.Settings()
            .food(ModFoodComponents.SNEPSI)));

    public static final Item CONVERTER = registerItem("converter", new ConverterItem(new Item.Settings()
            .maxDamage(32)
            .rarity(Rarity.EPIC)));

    public static final Item FUEL = registerItem("fuel", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FurryLounge.MOD_ID, name), item);
     }

    public static void registerModItems() {
        FurryLounge.LOGGER.info("Registering Mod Items for mod '" + FurryLounge.MOD_ID + "'!");

    }
}