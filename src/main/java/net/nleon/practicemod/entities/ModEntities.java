package net.nleon.practicemod.entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nleon.practicemod.PracticeMod;

public class ModEntities {
    public static EntityType<ThrownBombEntity> THROWN_BOMB;

    public static void register() {
        THROWN_BOMB = Registry.register(
                Registries.ENTITY_TYPE,
                Identifier.of("practicemod", "thrown_bomb"),
                FabricEntityTypeBuilder.<ThrownBombEntity>create(SpawnGroup.MISC, ThrownBombEntity::new)
                        .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                        .trackRangeBlocks(4)
                        .trackedUpdateRate(10)
                        .build()
        );

    }


}
