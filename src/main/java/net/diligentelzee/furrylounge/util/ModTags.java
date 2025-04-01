package net.diligentelzee.furrylounge.util;

import net.diligentelzee.furrylounge.FurryLounge;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> CONVERTIBLE_BLOCKS = createTag("convertible_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(FurryLounge.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> TRANSFORMABLE_ITEMS_TO_DIAMOND = createTag("transformable_items_to_diamond");
        public static final TagKey<Item> TRANSFORMABLE_ITEMS_TO_EMERALD = createTag("transformable_items_to_emerald");
        public static final TagKey<Item> TRANSFORMABLE_ITEMS_TO_SNEPSI = createTag("transformable_items_to_snepsi");
        public static final TagKey<Item> TRANSFORMABLE_ITEMS_TO_TWINX = createTag("transformable_items_to_twinx");
        public static final TagKey<Item> TRANSFORMABLE_ITEMS_TO_SUSHI_FOX =
                createTag("transformable_items_to_sushi_fox");
        public static final TagKey<Item> TRANSFORMABLE_ITEMS_TO_SWEET_BERRY =
                createTag("transformable_items_to_sweet_berry");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(FurryLounge.MOD_ID, name));
        }
    }
}
