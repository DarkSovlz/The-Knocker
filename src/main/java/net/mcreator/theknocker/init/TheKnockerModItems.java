
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theknocker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.theknocker.TheKnockerMod;

public class TheKnockerModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TheKnockerMod.MODID);
	public static final RegistryObject<Item> KNOCKER_SPAWN_EGG = REGISTRY.register("knocker_spawn_egg", () -> new ForgeSpawnEggItem(TheKnockerModEntities.KNOCKER, -16777216, -15132391, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> DEADCOW = block(TheKnockerModBlocks.DEADCOW, null);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
