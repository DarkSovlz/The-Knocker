package net.mcreator.theknocker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Difficulty;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.theknocker.network.TheKnockerModVariables;
import net.mcreator.theknocker.entity.KnockerstalkEntity;
import net.mcreator.theknocker.entity.KnockerEntity;
import net.mcreator.theknocker.configuration.KnockerconfigConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RandomspawnProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (KnockerconfigConfiguration.RESPECT_DIFFICULTY.get()) {
			if (world.getDifficulty() == Difficulty.PEACEFUL) {
				TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer = 0;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				TheKnockerModVariables.MapVariables.get(world).sleep = true;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
			} else if (world.getDifficulty() == Difficulty.EASY) {
				if (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getX(), (int) entity.getZ()) - 2 <= entity.getY() && !(world instanceof Level _lvl7 && _lvl7.isDay())
						&& !(!world.getEntitiesOfClass(KnockerEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())
						&& !(!world.getEntitiesOfClass(KnockerstalkEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())) {
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer = TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer + 1;
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
				}
				TheKnockerModVariables.MapVariables.get(world).min_spawn_rate = 5000;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				TheKnockerModVariables.MapVariables.get(world).max_spawn_rate = 7500;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				if (TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer >= TheKnockerModVariables.MapVariables.get(world).spawn_rate_reset) {
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_reset = Math
							.round(Mth.nextDouble(RandomSource.create(), TheKnockerModVariables.MapVariables.get(world).min_spawn_rate, TheKnockerModVariables.MapVariables.get(world).max_spawn_rate));
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer = 0;
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
					RandomeventProcedure.execute(world, x, y, z, entity);
				}
			} else if (world.getDifficulty() == Difficulty.NORMAL) {
				if (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getX(), (int) entity.getZ()) - 2 <= entity.getY() && !(world instanceof Level _lvl16 && _lvl16.isDay())
						&& !(!world.getEntitiesOfClass(KnockerEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())
						&& !(!world.getEntitiesOfClass(KnockerstalkEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())) {
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer = TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer + 1;
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
				}
				TheKnockerModVariables.MapVariables.get(world).min_spawn_rate = 2500;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				TheKnockerModVariables.MapVariables.get(world).max_spawn_rate = 5000;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				if (TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer >= TheKnockerModVariables.MapVariables.get(world).spawn_rate_reset) {
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_reset = Math
							.round(Mth.nextDouble(RandomSource.create(), TheKnockerModVariables.MapVariables.get(world).min_spawn_rate, TheKnockerModVariables.MapVariables.get(world).max_spawn_rate));
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer = 0;
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
					RandomeventProcedure.execute(world, x, y, z, entity);
				}
			} else if (world.getDifficulty() == Difficulty.HARD) {
				if (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getX(), (int) entity.getZ()) - 2 <= entity.getY() && !(world instanceof Level _lvl25 && _lvl25.isDay())
						&& !(!world.getEntitiesOfClass(KnockerEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())
						&& !(!world.getEntitiesOfClass(KnockerstalkEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())) {
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer = TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer + 1;
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
				}
				TheKnockerModVariables.MapVariables.get(world).min_spawn_rate = 1000;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				TheKnockerModVariables.MapVariables.get(world).max_spawn_rate = 2500;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				if (TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer >= TheKnockerModVariables.MapVariables.get(world).spawn_rate_reset) {
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_reset = Math
							.round(Mth.nextDouble(RandomSource.create(), TheKnockerModVariables.MapVariables.get(world).min_spawn_rate, TheKnockerModVariables.MapVariables.get(world).max_spawn_rate));
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer = 0;
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
					RandomeventProcedure.execute(world, x, y, z, entity);
				}
			}
		} else {
			if ((KnockerconfigConfiguration.SPAWN_RATE.get()).equals("common")) {
				if (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getX(), (int) entity.getZ()) - 2 <= entity.getY() && !(world instanceof Level _lvl34 && _lvl34.isDay())
						&& !(!world.getEntitiesOfClass(KnockerEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())
						&& !(!world.getEntitiesOfClass(KnockerstalkEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())) {
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer = TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer + 1;
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
				}
				TheKnockerModVariables.MapVariables.get(world).min_spawn_rate = 2500;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				TheKnockerModVariables.MapVariables.get(world).max_spawn_rate = 5000;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				if (TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer >= TheKnockerModVariables.MapVariables.get(world).spawn_rate_reset) {
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_reset = Math
							.round(Mth.nextDouble(RandomSource.create(), TheKnockerModVariables.MapVariables.get(world).min_spawn_rate, TheKnockerModVariables.MapVariables.get(world).max_spawn_rate));
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer = 0;
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
					RandomeventProcedure.execute(world, x, y, z, entity);
				}
			} else if ((KnockerconfigConfiguration.SPAWN_RATE.get()).equals("rare")) {
				if (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getX(), (int) entity.getZ()) - 2 <= entity.getY() && !(world instanceof Level _lvl43 && _lvl43.isDay())
						&& !(!world.getEntitiesOfClass(KnockerEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())
						&& !(!world.getEntitiesOfClass(KnockerstalkEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())) {
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer = TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer + 1;
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
				}
				TheKnockerModVariables.MapVariables.get(world).min_spawn_rate = 5000;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				TheKnockerModVariables.MapVariables.get(world).max_spawn_rate = 7500;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				if (TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer >= TheKnockerModVariables.MapVariables.get(world).spawn_rate_reset) {
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_reset = Math
							.round(Mth.nextDouble(RandomSource.create(), TheKnockerModVariables.MapVariables.get(world).min_spawn_rate, TheKnockerModVariables.MapVariables.get(world).max_spawn_rate));
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer = 0;
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
					RandomeventProcedure.execute(world, x, y, z, entity);
				}
			} else if ((KnockerconfigConfiguration.SPAWN_RATE.get()).equals("often")) {
				if (world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) entity.getX(), (int) entity.getZ()) - 2 <= entity.getY() && !(world instanceof Level _lvl52 && _lvl52.isDay())
						&& !(!world.getEntitiesOfClass(KnockerEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())
						&& !(!world.getEntitiesOfClass(KnockerstalkEntity.class, AABB.ofSize(new Vec3(x, y, z), 200, 200, 200), e -> true).isEmpty())) {
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer = TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer + 1;
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
				}
				TheKnockerModVariables.MapVariables.get(world).min_spawn_rate = 1000;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				TheKnockerModVariables.MapVariables.get(world).max_spawn_rate = 2500;
				TheKnockerModVariables.MapVariables.get(world).syncData(world);
				if (TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer >= TheKnockerModVariables.MapVariables.get(world).spawn_rate_reset) {
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_reset = Math
							.round(Mth.nextDouble(RandomSource.create(), TheKnockerModVariables.MapVariables.get(world).min_spawn_rate, TheKnockerModVariables.MapVariables.get(world).max_spawn_rate));
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
					TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer = 0;
					TheKnockerModVariables.MapVariables.get(world).syncData(world);
					RandomeventProcedure.execute(world, x, y, z, entity);
				}
			}
		}
	}
}
