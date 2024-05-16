package net.mcreator.theknocker.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.mcreator.theknocker.configuration.KnockerconfigConfiguration;
import net.mcreator.theknocker.TheKnockerMod;

@Mod.EventBusSubscriber(modid = TheKnockerMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheKnockerModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, KnockerconfigConfiguration.SPEC, "knocker.toml");
		});
	}
}
