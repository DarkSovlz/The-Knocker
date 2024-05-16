package net.mcreator.theknocker.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.theknocker.network.TheKnockerModVariables;

public class TimercommandProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal((TheKnockerModVariables.MapVariables.get(world).spawn_rate_timer + " | " + TheKnockerModVariables.MapVariables.get(world).spawn_rate_reset)), true);
	}
}
