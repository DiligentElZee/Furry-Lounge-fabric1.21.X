package net.diligentelzee.furrylounge.item.custom;

import net.diligentelzee.furrylounge.FurryLounge;
import net.diligentelzee.furrylounge.item.ModItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.registry.tag.TagKey;

public class FuelItems implements FuelRegistry {
    @Override
    public Integer get(ItemConvertible itemConvertible) {
        return 0;
    }

    @Override
    public void add(ItemConvertible itemConvertible, Integer integer) {

    }

    @Override
    public void add(TagKey<Item> tagKey, Integer integer) {

    }

    @Override
    public void remove(ItemConvertible itemConvertible) {

    }

    @Override
    public void remove(TagKey<Item> tagKey) {

    }

    @Override
    public void clear(ItemConvertible itemConvertible) {

    }

    @Override
    public void clear(TagKey<Item> tagKey) {

    }

    public static void registerModFuelItems() {
        FuelRegistry.INSTANCE.add(ModItems.FUEL, 1800);
        FurryLounge.LOGGER.info("Registering Mod Fuel Items for '" + FurryLounge.MOD_ID + "'");
    }
}
