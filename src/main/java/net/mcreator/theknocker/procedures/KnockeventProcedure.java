package net.mcreator.theknocker.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.theknocker.network.TheKnockerModVariables;
import net.mcreator.theknocker.TheKnockerMod;

public class KnockeventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double random = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double xdoor = 0;
		double zdoor = 0;
		double rarity = 0;
		double ydoor = 0;
		if (Math.random() > 0.5) {
			if (TheKnockerModVariables.MapVariables.get(world).sleep == true) {
				TheKnockerModVariables.MapVariables.get(world).new_day = false;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				SpawnknockerstalkProcedure.execute(world, x, y, z);
				TheKnockerMod.queueServerWork(20, () -> {
					TheKnockerModVariables.MapVariables.get(world).sleep = false;
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
				});
			}
		} else {
			if (Math.random() > 0.5) {
				sx = -10;
				TheKnockerModVariables.MapVariables.get(world).new_day = false;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				found = false;
				for (int index0 = 0; index0 < 40; index0++) {
					sy = -20;
					for (int index1 = 0; index1 < 40; index1++) {
						sz = -20;
						for (int index2 = 0; index2 < 40; index2++) {
							if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("minecraft:doors")))) {
								found = true;
								xdoor = x + sx;
								ydoor = y + sy;
								zdoor = z + sz;
							}
							sz = sz + 1;
						}
						sy = sy + 1;
					}
					sx = sx + 1;
				}
				if (found == true && TheKnockerModVariables.MapVariables.get(world).sleep == true) {
					TheKnockerModVariables.knocker_trigger_knock = true;
					SpawnknockerProcedure.execute(world, x, y, z, entity);
					TheKnockerMod.queueServerWork(20, () -> {
						TheKnockerModVariables.MapVariables.get(world).sleep = false;
						TheKnockerModVariables.MapVariables.get(world).syncData(world);
					});
					random = Math.round(Mth.nextDouble(RandomSource.create(), 1, 4));
					if (random == 1) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(xdoor, ydoor, zdoor), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:door_knocking_1")), SoundSource.AMBIENT, 1, 1);
							} else {
								_level.playLocalSound(xdoor, ydoor, zdoor, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:door_knocking_1")), SoundSource.AMBIENT, 1, 1, false);
							}
						}
					} else if (random == 2) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(xdoor, ydoor, zdoor), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:door_knocking_2")), SoundSource.AMBIENT, 1, 1);
							} else {
								_level.playLocalSound(xdoor, ydoor, zdoor, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:door_knocking_2")), SoundSource.AMBIENT, 1, 1, false);
							}
						}
					} else if (random == 3) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(xdoor, ydoor, zdoor), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:door_knocking_3")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(xdoor, ydoor, zdoor, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:door_knocking_3")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					} else if (random == 4) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(xdoor, ydoor, zdoor), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:door_knocking_4")), SoundSource.AMBIENT, 1, 1);
							} else {
								_level.playLocalSound(xdoor, ydoor, zdoor, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:door_knocking_4")), SoundSource.AMBIENT, 1, 1, false);
							}
						}
					}
				}
			} else {
				TheKnockerModVariables.MapVariables.get(world).new_day = false;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				EnterhouseeventProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
