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


    // Might need to move this whole shit to a SEPARATE item library... Insane
    // These are our cleaning tools, our detergents and soaps. Clean up!
    private record Effect(
            Holder<MobEffect> effect,
            int duration,
            int tier,
            float chance
    ) {}

    private static Effect effect(
            Holder<MobEffect> effect,
            int duration,
            int tier,
            float chance
    ) {
        return new Effect (effect, duration, tier, chance);
    }

    private static FoodProperties.Builder basePouch() {
        return new FoodProperties.Builder().alwaysEdible().fast();
    }

    private static FoodProperties.Builder pouch(Effect... effects) {
        FoodProperties.Builder builder = basePouch();

        for (Effect effect : effects) {
            builder.effect(
                    new MobEffectInstance(
                            effect.effect(),
                            effect.duration(),
                            effect.tier()
                    ),
                    effect.chance()
            );
        }

        return builder;
    }

    // Let's start by settings base negative and positive effects. The other stuff can be implemented then
    // We need custom effects: Nausea / Withdrawal / Addicted? (Reduces duration of positive effects)

    public static final int[] pouchDur = {
            15 * 20, 20 * 20, 25 * 20,
            30 * 20, 35 * 20, 40 * 20, 45 * 20
    };

    public static final int[] pouchDurNeg = {
            6 * 20, 9 * 20, 11 * 20,
            13 * 20, 15 * 20, 17 * 20, 19 * 20
    };

    public static final FoodProperties NIC_COMP_3 = pouch(
            effect(MobEffects.MOVEMENT_SPEED,   pouchDur[0], 0, 0.25f),
            effect(MobEffects.DIG_SPEED,        pouchDur[0], 0, 0.15f),
            effect(MobEffects.JUMP,             pouchDur[0], 0, 0.01f),

            // Negative
            effect(MobEffects.CONFUSION,        pouchDurNeg[0], 0, 0.05f)
    ).build();

    public static final FoodProperties NIC_COMP_6 = pouch(
            effect(MobEffects.MOVEMENT_SPEED, pouchDur[1], 0, 0.30f),
            effect(MobEffects.DIG_SPEED,      pouchDur[1], 0, 0.20f),
            effect(MobEffects.JUMP,           pouchDur[1], 0, 0.03f),

            // Negative
            effect(MobEffects.CONFUSION,      pouchDurNeg[1], 0, 0.10f),
            effect(MobEffects.POISON,         pouchDurNeg[1], 0, 0.01f),
            effect(MobEffects.DARKNESS,       pouchDurNeg[1], 0, 0.01f)
    ).build();

    // Movement Speed I - 33%, Haste I - 25%, Jump Boost I - 5%, Resistance I - 1%
    // Nausea II - 15%, Poison I - 1%, Darkness I - 1%, Mining Fatigue I - 1%, Instant Damage I - 1%
    public static final FoodProperties NIC_COMP_12 = pouch(
            effect(MobEffects.MOVEMENT_SPEED,       pouchDur[2], 0, 0.33f),
            effect(MobEffects.DIG_SPEED,            pouchDur[2], 0, 0.25f),
            effect(MobEffects.JUMP,                 pouchDur[2], 0, 0.05f),
            effect(MobEffects.DAMAGE_RESISTANCE,    pouchDur[2], 0, 0.01f),

            // Negative
            effect(MobEffects.CONFUSION,        pouchDurNeg[2], 0, 0.15f),
            effect(MobEffects.POISON,           pouchDurNeg[2], 0, 0.01f),
            effect(MobEffects.DARKNESS,         pouchDurNeg[2], 0, 0.01f),
            effect(MobEffects.DIG_SLOWDOWN,     pouchDurNeg[2], 0, 0.01f),
            effect(MobEffects.HARM,             0, 0, 0.01f)
    ).build();

    public static final FoodProperties NIC_COMP_18 = pouch(
            effect(MobEffects.MOVEMENT_SPEED,       pouchDur[3], 1, 0.35f),
            effect(MobEffects.DIG_SPEED,            pouchDur[3], 0, 0.30f),
            effect(MobEffects.JUMP,                 pouchDur[3], 0, 0.10f),
            effect(MobEffects.DAMAGE_RESISTANCE,    pouchDur[3], 0, 0.02f),

            // Negative
            effect(MobEffects.CONFUSION,        pouchDurNeg[3], 0, 0.20f),
            effect(MobEffects.POISON,           pouchDurNeg[3], 0, 0.02f),
            effect(MobEffects.DARKNESS,         pouchDurNeg[3], 0, 0.05f),
            effect(MobEffects.DIG_SLOWDOWN,     pouchDurNeg[3], 0, 0.05f),
            effect(MobEffects.HARM,             0, 0, 0.02f),
            effect(MobEffects.MOVEMENT_SLOWDOWN,     pouchDurNeg[3], 0, 0.01f),
            effect(MobEffects.WEAKNESS,     pouchDurNeg[3], 0, 0.01f)
    ).build();

    public static final FoodProperties NIC_COMP_30 = pouch(
            effect(MobEffects.MOVEMENT_SPEED,       pouchDur[4], 1, 0.40f),
            effect(MobEffects.DIG_SPEED,            pouchDur[4], 1, 0.35f),
            effect(MobEffects.JUMP,                 pouchDur[4], 0, 0.20f),
            effect(MobEffects.DAMAGE_BOOST,         pouchDur[4], 0, 0.15f),
            effect(MobEffects.DAMAGE_RESISTANCE,    pouchDur[4], 0, 0.03f),

            // Negative
            effect(MobEffects.CONFUSION,        pouchDurNeg[4], 0, 0.30f),
            effect(MobEffects.POISON,           pouchDurNeg[4], 0, 0.05f),
            effect(MobEffects.DARKNESS,         pouchDurNeg[4], 0, 0.10f),
            effect(MobEffects.DIG_SLOWDOWN,     pouchDurNeg[4], 0, 0.10f),
            effect(MobEffects.HARM,             0, 0, 0.03f),
            effect(MobEffects.MOVEMENT_SLOWDOWN,     pouchDurNeg[4], 0, 0.05f),
            effect(MobEffects.WEAKNESS,     pouchDurNeg[4], 0, 0.05f)
    ).build();

    public static final FoodProperties NIC_COMP_90 = pouch(
            effect(MobEffects.MOVEMENT_SPEED,       pouchDur[5], 1, 0.44f),
            effect(MobEffects.DIG_SPEED,            pouchDur[5], 1, 0.40f),
            effect(MobEffects.JUMP,                 pouchDur[5], 1, 0.25f),
            effect(MobEffects.DAMAGE_BOOST,         pouchDur[5], 1, 0.20f),
            effect(MobEffects.DAMAGE_RESISTANCE,    pouchDur[5], 0, 0.04f),

            // Negative
            effect(MobEffects.CONFUSION,        pouchDurNeg[5], 0, 0.50f),
            effect(MobEffects.POISON,           pouchDurNeg[5], 1, 0.10f),
            effect(MobEffects.DARKNESS,         pouchDurNeg[5], 0, 0.10f),
            effect(MobEffects.DIG_SLOWDOWN,     pouchDurNeg[5], 1, 0.15f),
            effect(MobEffects.HARM,             0, 0, 0.04f),
            effect(MobEffects.MOVEMENT_SLOWDOWN,     pouchDurNeg[5], 0, 0.10f),
            effect(MobEffects.WEAKNESS,     pouchDurNeg[5], 0, 0.10f)
    ).build();

    public static final FoodProperties NIC_COMP_150 = pouch(
            effect(MobEffects.MOVEMENT_SPEED,       pouchDur[6], 1, 0.50f),
            effect(MobEffects.DIG_SPEED,            pouchDur[6], 1, 0.40f),
            effect(MobEffects.JUMP,                 pouchDur[6], 1, 0.33f),
            effect(MobEffects.DAMAGE_BOOST,         pouchDur[6], 1, 0.25f),
            effect(MobEffects.DAMAGE_RESISTANCE,    pouchDur[6], 1, 0.05f),

            // Negative
            effect(MobEffects.CONFUSION,        pouchDurNeg[6], 1, 0.50f),
            effect(MobEffects.POISON,           pouchDurNeg[6], 1, 0.20f),
            effect(MobEffects.DARKNESS,         pouchDurNeg[6], 1, 0.20f),
            effect(MobEffects.DIG_SLOWDOWN,     pouchDurNeg[6], 1, 0.25f),
            effect(MobEffects.HARM,             0, 0, 0.05f),
            effect(MobEffects.MOVEMENT_SLOWDOWN,     pouchDurNeg[6], 1, 0.20f),
            effect(MobEffects.WEAKNESS,     pouchDurNeg[6], 1, 0.20f),
            effect(MobEffects.WITHER,     pouchDurNeg[6], 1, 0.01f)
    ).build();

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
