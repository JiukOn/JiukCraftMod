
package net.mcreator.jiukonmod.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class InnerChaosMobEffect extends MobEffect {
	public InnerChaosMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -851727);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jiukcraftmod.inner_chaos";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
