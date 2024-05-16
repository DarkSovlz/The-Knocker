package net.mcreator.theknocker.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.theknocker.network.TheKnockerModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class SleeptrueProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments) {
		TheKnockerModVariables.MapVariables.get(world).sleep = BoolArgumentType.getBool(arguments, "sleep");
		TheKnockerModVariables.MapVariables.get(world).syncData(world);
	}
}
