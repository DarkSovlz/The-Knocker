package net.mcreator.theknocker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.theknocker.network.TheKnockerModVariables;
import net.mcreator.theknocker.entity.KnockerstalklookedEntity;
import net.mcreator.theknocker.entity.KnockerstalkEntity;
import net.mcreator.theknocker.entity.KnockerEntity;
import net.mcreator.theknocker.TheKnockerMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CansleepProcedure {
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
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.isSleeping()) {
			if (!TheKnockerModVariables.MapVariables.get(world).sleep) {
				TheKnockerMod.queueServerWork(20, () -> {
					entity.hurt(DamageSource.GENERIC, (float) 0.1);
				});
			}
		}
		if (world instanceof Level _lvl4 && _lvl4.isDay()) {
			TheKnockerModVariables.MapVariables.get(world).new_day = true;
			TheKnockerModVariables.MapVariables.get(world).syncData(world);
		}
		if (!(!world.getEntitiesOfClass(KnockerEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(KnockerstalkEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(KnockerstalklookedEntity.class, AABB.ofSize(new Vec3(x, y, z), 300, 300, 300), e -> true).isEmpty())) {
			TheKnockerModVariables.MapVariables.get(world).sleep = true;
			TheKnockerModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
