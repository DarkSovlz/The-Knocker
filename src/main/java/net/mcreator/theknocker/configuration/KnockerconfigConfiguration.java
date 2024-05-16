package net.mcreator.theknocker.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class KnockerconfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<String> SPAWN_RATE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> RESPECT_DIFFICULTY;
	static {
		BUILDER.push("server and client");
		SPAWN_RATE = BUILDER.comment("use if respect_difficulty is false! 'rare, common, often'").define("spawn_rate", "common");
		RESPECT_DIFFICULTY = BUILDER.comment("if true, it will adjust the rareness of the Knocker to the ingame difficulty").define("respect_difficulty", true);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
