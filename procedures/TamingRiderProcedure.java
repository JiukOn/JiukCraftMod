package net.mcreator.jiukonmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.jiukonmod.entity.OnearWingsEntity;
import net.mcreator.jiukonmod.entity.OnearBirdEntity;
import net.mcreator.jiukonmod.entity.MutantTurtleEntity;

import javax.annotation.Nullable;

import java.util.Iterator;

@Mod.EventBusSubscriber
public class TamingRiderProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player && entity.isPassenger()) {
			if (!(entity == ((entity.getVehicle()) instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null))) {
				entity.stopRiding();
			} else {
				if ((entity.getVehicle()) instanceof OnearWingsEntity || (entity.getVehicle()) instanceof MutantTurtleEntity || (entity.getVehicle()) instanceof OnearBirdEntity) {
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("jiukcraftmod:onear_tamer_achievement"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							Iterator _iterator = _ap.getRemainingCriteria().iterator();
							while (_iterator.hasNext())
								_player.getAdvancements().award(_adv, (String) _iterator.next());
						}
					}
				}
			}
		}
	}
}
