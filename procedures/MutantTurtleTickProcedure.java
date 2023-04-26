package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class MutantTurtleTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isVehicle() && entity.isInWater()) {
			if (entity.getPersistentData().getDouble("VerticalMovement") == 1) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.3, (entity.getDeltaMovement().z())));
			} else if (entity.getPersistentData().getDouble("VerticalMovement") == -1) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (-0.3), (entity.getDeltaMovement().z())));
			}
		}
	}
}
