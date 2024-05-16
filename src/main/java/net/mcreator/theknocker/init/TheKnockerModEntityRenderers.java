
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theknocker.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.theknocker.client.renderer.KnockerstalklookedRenderer;
import net.mcreator.theknocker.client.renderer.KnockerstalkRenderer;
import net.mcreator.theknocker.client.renderer.KnockerdeadanimalRenderer;
import net.mcreator.theknocker.client.renderer.KnockerRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheKnockerModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TheKnockerModEntities.KNOCKER.get(), KnockerRenderer::new);
		event.registerEntityRenderer(TheKnockerModEntities.KNOCKERSTALK.get(), KnockerstalkRenderer::new);
		event.registerEntityRenderer(TheKnockerModEntities.KNOCKERSTALKLOOKED.get(), KnockerstalklookedRenderer::new);
		event.registerEntityRenderer(TheKnockerModEntities.KNOCKERDEADANIMAL.get(), KnockerdeadanimalRenderer::new);
	}
}
