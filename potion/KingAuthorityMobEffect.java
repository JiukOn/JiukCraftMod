
package net.mcreator.jiukonmod.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class KingAuthorityMobEffect extends MobEffect {
	public KingAuthorityMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -9884201);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jiukcraftmod.king_authority";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
