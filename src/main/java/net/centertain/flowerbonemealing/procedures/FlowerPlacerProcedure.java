package net.centertain.flowerbonemealing.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.centertain.flowerbonemealing.configuration.SpreadRangeConfiguration;

public class FlowerPlacerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		BlockState placedFlower = Blocks.AIR.defaultBlockState();
		boolean success = false;
		if (!world.isClientSide()) {
			success = Math.random() <= (double) SpreadRangeConfiguration.PERCENTAGE.get();
		}
		if (success && blockstate.canSurvive(world, BlockPos.containing(x, y, z)) && (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.AIR) {
			world.setBlock(BlockPos.containing(x, y, z), blockstate, 3);
		}
	}
}
