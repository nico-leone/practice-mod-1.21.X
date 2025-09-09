package net.nleon.practicemod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.nleon.practicemod.entities.ModEntities;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.nleon.practicemod.renderers.ThrownBombRenderer;

public class practicemodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.THROWN_BOMB, ThrownBombRenderer::new);
    }
}
