package net.centertain.flowerbonemealing.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.BonemealEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;

import net.centertain.flowerbonemealing.configuration.SpreadRangeConfiguration;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BonemealUsageProcedure {
	@SubscribeEvent
	public static void onBonemeal(BonemealEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getBlock());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		execute(null, world, x, y, z, blockstate);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double xSpread = 0;
		double ySpread = 0;
		double zSpread = 0;
		if (blockstate.is(BlockTags.create(new ResourceLocation("minecraft:small_flowers"))) && !blockstate.is(BlockTags.create(new ResourceLocation("flower_bonemealing:blacklist")))) {
			if (event != null && event.hasResult()) {
				event.setResult(Event.Result.ALLOW);
			}
			xSpread = (double) SpreadRangeConfiguration.X_SPREAD.get();
			ySpread = (double) SpreadRangeConfiguration.Y_SPREAD.get();
			zSpread = (double) SpreadRangeConfiguration.Z_SPREAD.get();
			sx = xSpread * (-1);
			for (int index0 = 0; index0 < (int) (xSpread * 2); index0++) {
				sy = ySpread * (-1);
				for (int index1 = 0; index1 < (int) (ySpread * 2); index1++) {
					sz = zSpread * (-1);
					for (int index2 = 0; index2 < (int) (zSpread * 2); index2++) {
						FlowerPlacerProcedure.execute(world, (sx + x), (sy + y), (sz + z), blockstate);
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
		}
	}
}
