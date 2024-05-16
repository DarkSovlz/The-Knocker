
package net.mcreator.theknocker.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.theknocker.entity.KnockerdeadanimalEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class KnockerdeadanimalRenderer extends HumanoidMobRenderer<KnockerdeadanimalEntity, HumanoidModel<KnockerdeadanimalEntity>> {
	public KnockerdeadanimalRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
		this.addLayer(new RenderLayer<KnockerdeadanimalEntity, HumanoidModel<KnockerdeadanimalEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = new ResourceLocation("the_knocker:textures/entities/the_knocker_glow_jumpscare.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, KnockerdeadanimalEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(LAYER_TEXTURE));
				this.getParentModel().renderToBuffer(poseStack, vertexConsumer, 15728640, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(KnockerdeadanimalEntity entity) {
		return new ResourceLocation("the_knocker:textures/entities/the_knocker_jumpscare.png");
	}

	@Override
	protected boolean isShaking(KnockerdeadanimalEntity entity) {
		return true;
	}
}
