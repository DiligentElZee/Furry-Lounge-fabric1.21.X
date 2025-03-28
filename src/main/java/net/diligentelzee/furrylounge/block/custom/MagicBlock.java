package net.diligentelzee.furrylounge.block.custom;

import net.diligentelzee.furrylounge.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MagicBlock extends Block {
    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        world.playSound(player, pos, SoundEvents.ENTITY_FOX_TELEPORT, SoundCategory.BLOCKS, 1f, 1f);
        return ActionResult.SUCCESS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == ModItems.ITEM) {
                itemEntity.setStack(new ItemStack(Items.DIAMOND, itemEntity.getStack().getCount()));
            }
            if (itemEntity.getStack().getItem() == ModItems.ITEM_2) {
                itemEntity.setStack(new ItemStack(Items.EMERALD, itemEntity.getStack().getCount()));
            }
        }

        if (!world.isClient
                && !(entity instanceof FoxEntity) 
                && !(entity instanceof PlayerEntity)
                && !(entity instanceof ItemEntity)) {
            // Prevent transforming existing foxes, players, and items.

            ServerWorld serverWorld = (ServerWorld) world;
            FoxEntity fox = EntityType.FOX.create(world);

            if (fox != null) {
                // Copy entity's position
                fox.refreshPositionAndAngles(entity.getX(), entity.getY(), entity.getZ(), entity.getYaw(), entity.getPitch());

                // Copy entity's name and other attributes
                if (entity.hasCustomName()) {
                    fox.setCustomName(entity.getCustomName());
                }

                // Remove the original entity and spawn the Fox
                entity.discard();
                serverWorld.spawnEntity(fox);
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}