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
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class MagicBlock extends Block {
    public static final BooleanProperty LIT = Properties.LIT;

    public MagicBlock(Settings settings) {
        super(settings);
        // Set default state: not lit (passive light level)
        setDefaultState(getStateManager().getDefaultState().with(LIT, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
            // Set the state to lit so that it emits light level 10
            world.setBlockState(pos, state.with(LIT, true), 3);
            // Play a beacon activation sound
            world.playSound(null, pos, SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            // Schedule a tick to revert to the passive state (e.g., after 20 ticks, or 1 second)
            world.scheduleBlockTick(pos, this, 20);
        return ActionResult.SUCCESS;
    }

    // Revert the block state to "not lit" when the scheduled tick fires
    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(LIT)) {
            world.setBlockState(pos, state.with(LIT, false), 3);
        }
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getStack().getItem() == ModItems.ITEM) {
                itemEntity.setStack(new ItemStack(Items.DIAMOND, itemEntity.getStack().getCount()));
                world.setBlockState(pos, state.with(LIT, true), 3);
                world.playSound(null, pos, SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.BLOCKS, 0.5F, 1.1F);
                world.scheduleBlockTick(pos, this, 20);
            }
            if (itemEntity.getStack().getItem() == ModItems.ITEM_2) {
                itemEntity.setStack(new ItemStack(Items.EMERALD, itemEntity.getStack().getCount()));
                world.setBlockState(pos, state.with(LIT, true), 3);
                world.playSound(null, pos, SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.BLOCKS, 0.5F, 1.1F);
                world.scheduleBlockTick(pos, this, 20);
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
                world.setBlockState(pos, state.with(LIT, true), 3);
                world.playSound(null, pos, SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.BLOCKS, 0.5F, 2.5F);
                world.scheduleBlockTick(pos, this, 20);
            }
        }
        super.onSteppedOn(world, pos, state, entity);
    }
}