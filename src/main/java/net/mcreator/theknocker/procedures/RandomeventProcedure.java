package net.mcreator.theknocker.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class RandomeventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double radnom = 0;
		radnom = Math.round(Mth.nextDouble(RandomSource.create(), 1, 3));
		if (radnom == 1) {
			SpawnknockerProcedure.execute(world, x, y, z, entity);
			if (Math.random() > 0.5) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:spawn_1")), SoundSource.AMBIENT, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:spawn_1")), SoundSource.AMBIENT, 1, 1, false);
					}
				}
			} else {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:spawn_2")), SoundSource.AMBIENT, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:spawn_2")), SoundSource.AMBIENT, 1, 1, false);
					}
				}
			}
		} else if (radnom == 2) {
			StalkbedProcedure.execute(world, x, y, z);
		} else if (radnom == 3) {
			DeadcoweventProcedure.execute(world, x, y, z);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:knife_sharpening_1")), SoundSource.AMBIENT, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:knife_sharpening_1")), SoundSource.AMBIENT, 1, 1, false);
				}
			}
		}
	}
}
