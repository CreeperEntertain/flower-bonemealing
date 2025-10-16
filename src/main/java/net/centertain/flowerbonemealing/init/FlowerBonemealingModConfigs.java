package net.centertain.flowerbonemealing.init;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.centertain.flowerbonemealing.configuration.SpreadRangeConfiguration;
import net.centertain.flowerbonemealing.FlowerBonemealingMod;

@Mod.EventBusSubscriber(modid = FlowerBonemealingMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FlowerBonemealingModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SpreadRangeConfiguration.SPEC, "Bonemealing Config.toml");
		});
	}
}
