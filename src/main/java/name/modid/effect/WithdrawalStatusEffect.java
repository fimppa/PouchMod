package name.modid.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

// Base for withdrawal status
public class WithdrawalStatusEffect extends MobEffect {
    public WithdrawalStatusEffect() {
        super(
                MobEffectCategory.HARMFUL,
                0x4A2E29
        );
    }
}