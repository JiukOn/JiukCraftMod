package net.mcreator.jiukonmod.procedures;

import net.minecraft.world.entity.Entity;

public class AntGravityQuandoOEfeitoExpiraProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setNoGravity((false));
	}
}
