package net.nleon.practicemod.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.nleon.practicemod.item.ModItems;

public class ThrownBombEntity extends ThrownItemEntity {
    public ThrownBombEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ThrownBombEntity(World world, LivingEntity owner) {
        super(ModEntities.THROWN_BOMB, owner, world);
    }

    public ThrownBombEntity(World world, double x, double y, double z) {
        super(ModEntities.THROWN_BOMB, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.BOMB != null ? ModItems.BOMB : Items.TNT;
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);

        if(!this.getWorld().isClient){

            //increased power depending on distance thrown
            float power = 3.0F + (this.age / 20.0F);
            power = Math.min(power, 40.0F);


            this.getWorld().createExplosion(this,
                    this.getX(), this.getY(), this.getZ(), power,
                    World.ExplosionSourceType.TNT
            );
            this.discard();
        }
    }





}
