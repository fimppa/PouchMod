package name.modid.item;

import name.modid.ModBlocks;
import name.modid.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

public class ModItemsLibrary {

    // Library for all the items to keep clean.

    public static final Item B13_TECHNO = ModItems.register(
            new Item(new Item.Properties()),
            "b13_techno"
    );


    public static final Item TOBACCO_SEEDS = ModItems.register(
            new ItemNameBlockItem(ModBlocks.TOBACCO_CROP, new Item.Properties()),
            "tobacco_seeds"
    );

    public static final Item TOBACCO_GROWN = ModItems.register(
            new Item(new Item.Properties()),
            "tobacco_grown"
    );

    public static final Item TOBACCO_DRIED = ModItems.register(
            new Item(new Item.Properties()),
            "tobacco_dried"
    );

    public static final Item CIGARETTE = ModItems.register(
            new Item(new Item.Properties()),
            "cigarette"
    );

    /*

        Pouches 3, 6, 12, 18, 30, 90, 150

    */

    private record Effect(
            Holder<MobEffect> effect,
            int duration,
            int amplifier,
            float chance
    ) {}

    private static Effect effect(
            Holder<MobEffect> effect,
            int duration,
            int amplifier,
            float chance
    ) {
        return new Effect (effect, duration, amplifier, chance);
    }

    private static FoodProperties.Builder basePouch() {
        return new FoodProperties.Builder().alwaysEdible().fast();
    }

    // Let's start by settings base negative and positive effects. The other stuff can be implemented then
    // We need custom effects: Nausea / Withdrawal / Addicted? (Reduces duration of positive effects)

    public static final int[] pouchDur = {
            15 * 20, 20 * 20, 25 * 20,
            30 * 20, 35 * 20, 40 * 20, 45 * 20
    };

    // Movement Speed I - 25%, Haste I - 15%, Jump Boost I, 1%
    // Nausea II - 5%
    public static final FoodProperties NIC_COMP_3 = basePouch()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, pouchDur[0], 0), 0.25f)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, pouchDur[0], 0), 0.15f)
            .effect(new MobEffectInstance(MobEffects.JUMP, pouchDur[0], 0), 0.01f)
            // Negative
            .effect(new MobEffectInstance(MobEffects.CONFUSION, pouchDur[0] / 2, 1), 0.05f)
            .build();

    // Movement Speed I - 30%, Haste I - 20%, Jump Boost I, 3%
    // Nausea II - 10%, Poison I - 1%, Darkness I - 1%
    public static final FoodProperties NIC_COMP_6 = basePouch()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, pouchDur[1], 0), 0.30f)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, pouchDur[1], 0), 0.20f)
            .effect(new MobEffectInstance(MobEffects.JUMP, pouchDur[1], 0), 0.03f)
            // Negative
            .effect(new MobEffectInstance(MobEffects.CONFUSION, pouchDur[1] / 2, 1), 0.10f)
            .effect(new MobEffectInstance(MobEffects.POISON, pouchDur[1] / 2, 0), 0.01f)
            .effect(new MobEffectInstance(MobEffects.DARKNESS, pouchDur[1] / 2, 0), 0.01f)

            .build();

    // Movement Speed I - 33%, Haste I - 25%, Jump Boost I - 5%, Resistance I - 1%
    // Nausea II - 15%, Poison I - 1%, Darkness I - 1%, Mining Fatigue I - 1%, Instant Damage I - 1%
    public static final FoodProperties NIC_COMP_12 = basePouch()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, pouchDur[2], 0), 0.33f)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, pouchDur[2], 0), 0.25f)
            .effect(new MobEffectInstance(MobEffects.JUMP, pouchDur[2], 0), 0.05f)
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, pouchDur[2], 0), 0.01f)
            // Negative
            .effect(new MobEffectInstance(MobEffects.CONFUSION, pouchDur[2] / 2, 1), 0.15f)
            .effect(new MobEffectInstance(MobEffects.POISON, pouchDur[2] / 2, 0), 0.01f)
            .effect(new MobEffectInstance(MobEffects.DARKNESS, pouchDur[2] / 2, 0), 0.01f)
            .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, pouchDur[2] / 2, 0), 0.01f)
            .effect(new MobEffectInstance(MobEffects.HARM, 0, 0), 0.01f)
            .build();

    public static final FoodProperties NIC_COMP_18 = basePouch()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, pouchDur[3], 1), 1.0f)  // 100 % chance for movement speed II
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, pouchDur[3], 0), 1.0f)       // 100 % chance for haste I
            // Negative
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 8 * 20, 1), 0.20f)       // 20 % chance for nausea II
            .build();

    public static final FoodProperties NIC_COMP_30 = basePouch()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, pouchDur[4], 1), 1.0f) // 100 % chance for movement speed II
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, pouchDur[4], 1), 1.0f)      // 100 % chance for haste II
            // Negative
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 10 * 20, 1), 0.1f)      // 10 % chance for Darkness
            .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 35 * 20, 0), 0.1f)   // 10 % chance for Mining Fatigue I
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 9 * 20, 1), 0.3f)       // 30 % chance for nausea II
            .build();

    public static final FoodProperties NIC_COMP_90 = basePouch()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, pouchDur[5], 1), 1.0f)  // 100 % chance for movement speed II
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, pouchDur[5], 1), 1.0f)      // 100 % chance for haste II
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, pouchDur[5], 1), 0.33f)  // 33 % chance for strength II
            // Negative
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 10 * 20, 1), 0.1f)       // 10 % chance for Darkness
            .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 35 * 20, 0), 0.1f)    // 10 % chance for Mining Fatigue I
            .effect(new MobEffectInstance(MobEffects.WEAKNESS, 10 * 20, 0), 0.1f)        // 10 % chance for Weakness
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 10 * 20, 1), 0.5f)       // 50 % chance for nausea II
            .build();

    public static final FoodProperties NIC_COMP_150 = basePouch()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, pouchDur[6], 1), 1.0f)  // 100 % chance for movement speed II
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, pouchDur[6], 1), 1.0f)      // 100 % chance for haste II
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, pouchDur[6], 1), 0.75f)   // 75 % chance for strength II
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, pouchDur[6], 0), 0.25f)   // 25 % chance for Resistance I
            // Negative
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 10 * 20, 1), 0.5f)      // 50 % chance for nausea II
            .effect(new MobEffectInstance(MobEffects.POISON, 5 * 20, 0), 0.20f)         // 20 % chance for poison I
            .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 35 * 20, 0), 0.1f)   // 10 % chance for Mining Fatigue I
            .effect(new MobEffectInstance(MobEffects.WEAKNESS, 10 * 20, 0), 0.1f)       // 10 % chance for Weakness
            .effect(new MobEffectInstance(MobEffects.DARKNESS, 10 * 20, 0), 0.1f)       // 10 % chance for darkness
            .effect(new MobEffectInstance(MobEffects.HARM, 20, 1), 0.05f)               // 5 % chance for instant damage
            .build();

    public static final Item POUCH_3 = ModItems.register(
            new Item(new Item.Properties().food(NIC_COMP_3)), "pouch_0"
    );

    public static final Item POUCH_6 = ModItems.register(
            new Item(new Item.Properties().food(NIC_COMP_6)), "pouch_1"
    );

    public static final Item POUCH_12 = ModItems.register(
            new Item(new Item.Properties().food(NIC_COMP_12)), "pouch_2"
    );

    public static final Item POUCH_18 = ModItems.register(
            new Item(new Item.Properties().food(NIC_COMP_18)), "pouch_3"
    );

    public static final Item POUCH_30 = ModItems.register(
            new Item(new Item.Properties().food(NIC_COMP_30)), "pouch_4"
    );

    public static final Item POUCH_90 = ModItems.register(
            new Item(new Item.Properties().food(NIC_COMP_90)), "pouch_5"
    );

    public static final Item POUCH_150 = ModItems.register(
            new Item(new Item.Properties().food(NIC_COMP_150)), "pouch_6"
    );


    public static void load() {}
}
