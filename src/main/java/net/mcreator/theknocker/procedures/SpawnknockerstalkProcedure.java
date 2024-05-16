package net.mcreator.theknocker.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.theknocker.init.TheKnockerModEntities;
import net.mcreator.theknocker.entity.KnockerstalkEntity;
import net.mcreator.theknocker.entity.KnockerEntity;

public class SpawnknockerstalkProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double random = 0;
		found = false;
		if (!(!world.getEntitiesOfClass(KnockerEntity.class, AABB.ofSize(new Vec3(x, y, z), 100, 100, 100), e -> true).isEmpty())) {
			random = Math.round(Mth.nextDouble(RandomSource.create(), 1, 2));
			if (random == 1) {
				if (found == false) {
					sx = -10;
					for (int index0 = 0; index0 < 20; index0++) {
						sy = -10;
						if (found == false) {
							for (int index1 = 0; index1 < 20; index1++) {
								sz = -10;
								if (found == false) {
									for (int index2 = 0; index2 < 20; index2++) {
										if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("forge:glass_panes")))
												|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("forge:glass")))) {
											if (found == false) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = new KnockerstalkEntity(TheKnockerModEntities.KNOCKERSTALK.get(), _level);
													entityToSpawn.moveTo((x + sx + 1), ((y + sy) - 1), (z + sz), world.getRandom().nextFloat() * 360F, 0);
													if (entityToSpawn instanceof Mob _mobToSpawn)
														_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
													world.addFreshEntity(entityToSpawn);
												}
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = new KnockerstalkEntity(TheKnockerModEntities.KNOCKERSTALK.get(), _level);
													entityToSpawn.moveTo(((x + sx) - 1), ((y + sy) - 1), (z + sz), world.getRandom().nextFloat() * 360F, 0);
													if (entityToSpawn instanceof Mob _mobToSpawn)
														_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
													world.addFreshEntity(entityToSpawn);
												}
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = new KnockerstalkEntity(TheKnockerModEntities.KNOCKERSTALK.get(), _level);
													entityToSpawn.moveTo((x + sx), ((y + sy) - 1), (z + sz + 1), world.getRandom().nextFloat() * 360F, 0);
													if (entityToSpawn instanceof Mob _mobToSpawn)
														_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
													world.addFreshEntity(entityToSpawn);
												}
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = new KnockerstalkEntity(TheKnockerModEntities.KNOCKERSTALK.get(), _level);
													entityToSpawn.moveTo((x + sx), ((y + sy) - 1), ((z + sz) - 1), world.getRandom().nextFloat() * 360F, 0);
													if (entityToSpawn instanceof Mob _mobToSpawn)
														_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
													world.addFreshEntity(entityToSpawn);
												}
												found = true;
												random = Math.round(Mth.nextDouble(RandomSource.create(), 1, 2));
												if (random == 1) {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, new BlockPos(x + sx, y + sy, z + sz), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:window_knock_1")), SoundSource.AMBIENT, 1, 1);
														} else {
															_level.playLocalSound((x + sx), (y + sy), (z + sz), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:window_knock_1")), SoundSource.AMBIENT, 1, 1, false);
														}
													}
												} else {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, new BlockPos(x + sx, y + sy, z + sz), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:window_knock_2")), SoundSource.AMBIENT, 1, 1);
														} else {
															_level.playLocalSound((x + sx), (y + sy), (z + sz), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:window_knock_2")), SoundSource.AMBIENT, 1, 1, false);
														}
													}
												}
											}
										}
										sz = sz + 1;
									}
									sy = sy + 1;
								}
							}
							sx = sx + 1;
						}
					}
				}
			} else {
				if (found == false) {
					sx = 10;
					for (int index3 = 0; index3 < 20; index3++) {
						sy = 10;
						if (found == false) {
							for (int index4 = 0; index4 < 20; index4++) {
								sz = 10;
								if (found == false) {
									for (int index5 = 0; index5 < 20; index5++) {
										if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("forge:glass_panes")))
												|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("forge:glass")))) {
											if (found == false) {
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = new KnockerstalkEntity(TheKnockerModEntities.KNOCKERSTALK.get(), _level);
													entityToSpawn.moveTo((x + sx + 1), ((y + sy) - 1), (z + sz), world.getRandom().nextFloat() * 360F, 0);
													if (entityToSpawn instanceof Mob _mobToSpawn)
														_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
													world.addFreshEntity(entityToSpawn);
												}
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = new KnockerstalkEntity(TheKnockerModEntities.KNOCKERSTALK.get(), _level);
													entityToSpawn.moveTo(((x + sx) - 1), ((y + sy) - 1), (z + sz), world.getRandom().nextFloat() * 360F, 0);
													if (entityToSpawn instanceof Mob _mobToSpawn)
														_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
													world.addFreshEntity(entityToSpawn);
												}
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = new KnockerstalkEntity(TheKnockerModEntities.KNOCKERSTALK.get(), _level);
													entityToSpawn.moveTo((x + sx), ((y + sy) - 1), (z + sz + 1), world.getRandom().nextFloat() * 360F, 0);
													if (entityToSpawn instanceof Mob _mobToSpawn)
														_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
													world.addFreshEntity(entityToSpawn);
												}
												if (world instanceof ServerLevel _level) {
													Entity entityToSpawn = new KnockerstalkEntity(TheKnockerModEntities.KNOCKERSTALK.get(), _level);
													entityToSpawn.moveTo((x + sx), ((y + sy) - 1), ((z + sz) - 1), world.getRandom().nextFloat() * 360F, 0);
													if (entityToSpawn instanceof Mob _mobToSpawn)
														_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
													world.addFreshEntity(entityToSpawn);
												}
												found = true;
												random = Math.round(Mth.nextDouble(RandomSource.create(), 1, 2));
												if (random == 1) {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, new BlockPos(x + sx, y + sy, z + sz), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:window_knock_1")), SoundSource.AMBIENT, 1, 1);
														} else {
															_level.playLocalSound((x + sx), (y + sy), (z + sz), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:window_knock_1")), SoundSource.AMBIENT, 1, 1, false);
														}
													}
												} else {
													if (world instanceof Level _level) {
														if (!_level.isClientSide()) {
															_level.playSound(null, new BlockPos(x + sx, y + sy, z + sz), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:window_knock_2")), SoundSource.AMBIENT, 1, 1);
														} else {
															_level.playLocalSound((x + sx), (y + sy), (z + sz), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("the_knocker:window_knock_2")), SoundSource.AMBIENT, 1, 1, false);
														}
													}
												}
											}
										}
										sz = sz - 1;
									}
									sy = sy - 1;
								}
							}
							sx = sx - 1;
						}
					}
				}
			}
		}
	}
}
