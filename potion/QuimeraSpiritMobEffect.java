
package net.mcreator.jiukonmod.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class QuimeraSpiritMobEffect extends MobEffect {
	public QuimeraSpiritMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16719840);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jiukcraftmod.quimera_spirit";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
