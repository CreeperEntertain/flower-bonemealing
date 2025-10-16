package net.centertain.flowerbonemealing.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class SpreadRangeConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	public static final ForgeConfigSpec.ConfigValue<Double> X_SPREAD;
	public static final ForgeConfigSpec.ConfigValue<Double> Y_SPREAD;
	public static final ForgeConfigSpec.ConfigValue<Double> Z_SPREAD;
	public static final ForgeConfigSpec.ConfigValue<Double> PERCENTAGE;
	static {
		BUILDER.push("Spread Range");
		X_SPREAD = BUILDER.define("X Spread", (double) 3);
		Y_SPREAD = BUILDER.define("Y Spread", (double) 1);
		Z_SPREAD = BUILDER.define("Z Spread", (double) 3);
		BUILDER.pop();
		BUILDER.push("Success Rate");
		PERCENTAGE = BUILDER.define("Percentage", (double) 0.05);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
