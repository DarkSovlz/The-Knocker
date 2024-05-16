
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theknocker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.theknocker.TheKnockerMod;

public class TheKnockerModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TheKnockerMod.MODID);
	public static final RegistryObject<SoundEvent> DOOR_KNOCKING_1 = REGISTRY.register("door_knocking_1", () -> new SoundEvent(new ResourceLocation("the_knocker", "door_knocking_1")));
	public static final RegistryObject<SoundEvent> DOOR_KNOCKING_2 = REGISTRY.register("door_knocking_2", () -> new SoundEvent(new ResourceLocation("the_knocker", "door_knocking_2")));
	public static final RegistryObject<SoundEvent> DOOR_KNOCKING_4 = REGISTRY.register("door_knocking_4", () -> new SoundEvent(new ResourceLocation("the_knocker", "door_knocking_4")));
	public static final RegistryObject<SoundEvent> DOOR_KNOCKING_3 = REGISTRY.register("door_knocking_3", () -> new SoundEvent(new ResourceLocation("the_knocker", "door_knocking_3")));
	public static final RegistryObject<SoundEvent> SPAWN_1 = REGISTRY.register("spawn_1", () -> new SoundEvent(new ResourceLocation("the_knocker", "spawn_1")));
	public static final RegistryObject<SoundEvent> SPAWN_2 = REGISTRY.register("spawn_2", () -> new SoundEvent(new ResourceLocation("the_knocker", "spawn_2")));
	public static final RegistryObject<SoundEvent> WINDOW_KNOCK_1 = REGISTRY.register("window_knock_1", () -> new SoundEvent(new ResourceLocation("the_knocker", "window_knock_1")));
	public static final RegistryObject<SoundEvent> WINDOW_KNOCK_2 = REGISTRY.register("window_knock_2", () -> new SoundEvent(new ResourceLocation("the_knocker", "window_knock_2")));
	public static final RegistryObject<SoundEvent> BREATH = REGISTRY.register("breath", () -> new SoundEvent(new ResourceLocation("the_knocker", "breath")));
	public static final RegistryObject<SoundEvent> JUMPSCARE = REGISTRY.register("jumpscare", () -> new SoundEvent(new ResourceLocation("the_knocker", "jumpscare")));
	public static final RegistryObject<SoundEvent> KNIFE_SHARPENING_1 = REGISTRY.register("knife_sharpening_1", () -> new SoundEvent(new ResourceLocation("the_knocker", "knife_sharpening_1")));
	public static final RegistryObject<SoundEvent> SHARPENING_KNIFE_2 = REGISTRY.register("sharpening_knife_2", () -> new SoundEvent(new ResourceLocation("the_knocker", "sharpening_knife_2")));
	public static final RegistryObject<SoundEvent> RISER = REGISTRY.register("riser", () -> new SoundEvent(new ResourceLocation("the_knocker", "riser")));
}
