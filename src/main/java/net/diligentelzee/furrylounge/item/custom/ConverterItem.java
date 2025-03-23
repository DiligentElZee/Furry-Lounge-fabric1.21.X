package net.diligentelzee.furrylounge.item.custom;

import net.diligentelzee.furrylounge.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class ConverterItem extends Item {
    private static final Map<Block, Block> CONVERTER_MAP =
            Map.of(
                    ModBlocks.BLOCK, ModBlocks.BLOCK_2,
                    ModBlocks.BLOCK_2, ModBlocks.BLOCK,
                    ModBlocks.ORE, ModBlocks.ORE_2,
                    ModBlocks.ORE_2, ModBlocks.ORE
            );

    public ConverterItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (CONVERTER_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), CONVERTER_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.ENTITY_FOX_TELEPORT, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }
}
