package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.jiukonmod.entity.OnearWingsEntity;
import net.mcreator.jiukonmod.entity.MutantTurtleEntity;

public class DownOnearWingsAoPressionarUmaTeclaProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getVehicle()) instanceof OnearWingsEntity == true) {
			(entity.getVehicle()).getPersistentData().putDouble("VerticalMovement", (-1));
		}
		if ((entity.getVehicle()) instanceof MutantTurtleEntity == true) {
			(entity.getVehicle()).getPersistentData().putDouble("VerticalMovement", (-1));
		}
	}
}
