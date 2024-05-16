package net.mcreator.theknocker.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.theknocker.network.TheKnockerModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class EditspawnresetProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		TheKnockerModVariables.MapVariables.get(world).spawn_rate_reset = DoubleArgumentType.getDouble(arguments, "spawn_rate_reset");
		TheKnockerModVariables.MapVariables.get(world).syncData(world);
	}
}
