package name.modid.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

// Base for addiction status
public class AddictionStatusEffect extends MobEffect {
    public AddictionStatusEffect() {
        super(
                MobEffectCategory.HARMFUL,
                0x4A2E29
        );
    }
}