package net.nleon.practicemod.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.nleon.practicemod.entities.ThrownBombEntity;

public class BombItem extends Item {
    public BombItem(Settings settings) {
        super(settings);
    }


    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if(!world.isClient) {
            ThrownBombEntity bomb = new ThrownBombEntity(world, user);
            bomb.setItem(new ItemStack(ModItems.BOMB));
            bomb.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.2F, 1.0F);
            world.spawnEntity(bomb);

        }


        if(!user.getAbilities().creativeMode) {
            stack.decrement(1);
        }

        return TypedActionResult.success(stack, world.isClient());

    }
}
