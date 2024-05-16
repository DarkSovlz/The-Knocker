
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theknocker.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.theknocker.block.DeadcowBlock;
import net.mcreator.theknocker.TheKnockerMod;

public class TheKnockerModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TheKnockerMod.MODID);
	public static final RegistryObject<Block> DEADCOW = REGISTRY.register("deadcow", () -> new DeadcowBlock());
}
