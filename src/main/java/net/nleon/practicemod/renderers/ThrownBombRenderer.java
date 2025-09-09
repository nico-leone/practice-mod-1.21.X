package net.nleon.practicemod.renderers;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.nleon.practicemod.entities.ThrownBombEntity;

public class ThrownBombRenderer extends FlyingItemEntityRenderer<ThrownBombEntity> {

    public ThrownBombRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public void render(ThrownBombEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();
        //calculate a spin value based on age to create the wobble effect when thrown through the air
        //increase the size of the doll at a small exponential scale so it increases in size through the air
        float age = entity.age + tickDelta;
        float ageSeconds = age / 5.0F;
        float spin = age * 20.0F;
        float scale = (float)Math.pow(1.3, ageSeconds);
        scale = Math.min(scale, 12.0F);


        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(spin));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(spin*0.35F));

        matrices.scale(scale, scale, scale);

        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);

        matrices.pop();


    }
}
