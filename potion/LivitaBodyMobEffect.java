
package net.mcreator.jiukonmod.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class LivitaBodyMobEffect extends MobEffect {
	public LivitaBodyMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -15420032);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jiukcraftmod.livita_body";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
