package net.mcreator.theknocker.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.theknocker.network.TheKnockerModVariables;
import net.mcreator.theknocker.configuration.KnockerconfigConfiguration;
import net.mcreator.theknocker.TheKnockerMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class KnocksleepProcedure {
	@SubscribeEvent
	public static void onPlayerInBed(PlayerSleepInBedEvent event) {
		execute(event, event.getEntity().level, event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double xdoor = 0;
		double ydoor = 0;
		double zdoor = 0;
		double random = 0;
		double rarity = 0;
		if ((KnockerconfigConfiguration.SPAWN_RATE.get()).equals("often")) {
			rarity = 0.4;
		} else if ((KnockerconfigConfiguration.SPAWN_RATE.get()).equals("common")) {
			rarity = 0.25;
		} else if ((KnockerconfigConfiguration.SPAWN_RATE.get()).equals("rare")) {
			rarity = 0.1;
		} else if ((KnockerconfigConfiguration.SPAWN_RATE.get()).equals("debug")) {
			rarity = 1;
		}
		if (TheKnockerModVariables.MapVariables.get(world).new_day == true && Math.random() < rarity) {
			TheKnockerMod.queueServerWork(10, () -> {
				if (entity instanceof LivingEntity _livEnt4 && _livEnt4.isSleeping()) {
					KnockeventProcedure.execute(world, x, y, z, entity);
				}
			});
		}
	}
}
