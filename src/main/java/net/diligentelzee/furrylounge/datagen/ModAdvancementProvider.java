package net.diligentelzee.furrylounge.datagen;

import net.diligentelzee.furrylounge.FurryLounge;
import net.diligentelzee.furrylounge.block.ModBlocks;
import net.diligentelzee.furrylounge.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.*;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry root = Advancement.Builder.create()
                .display(
                        ModItems.ITEM, // The display icon
                        Text.literal("§b§lFurry Lounge§r"), // The title
                        Text.literal("The §gROOT§r of the §b§lFurry Lounge§r §eadvancements§r!"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"),
                        // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        false, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("join", TickCriterion.Conditions.createTick())
                // Give the advancement an id
                .build(consumer, FurryLounge.MOD_ID + "/root");

        AdvancementEntry youMonster = Advancement.Builder.create()
                .parent(root)
                .display(
                        ModItems.SUSHI_FOX,
                        Text.literal("§4§lYou Monster...§r"),
                        Text.literal("§4§lHow could you??§r"),
                        null, // Children don't need a background, the root advancement takes care of that
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        true
                )
                .criterion("ate_sushi_fox", ConsumeItemCriterion.Conditions.item(ModItems.SUSHI_FOX))
                .build(consumer, FurryLounge.MOD_ID + "/you_monster");

        AdvancementEntry magician = Advancement.Builder.create()
                .parent(root)
                .display(
                        ModBlocks.MAGIC_BLOCK,
                        Text.literal("§dMagician§r"),
                        Text.literal("It's time for some magic-ing!"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("get_magic_block", InventoryChangedCriterion.Conditions.items(ModBlocks.MAGIC_BLOCK))
                .build(consumer, FurryLounge.MOD_ID + "/magician");
    }
}