package name.modid.item;

import name.modid.ModBlocks;
import name.modid.ModItems;
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

    private static FoodProperties.Builder basePouch() {
        return new FoodProperties.Builder().alwaysEdible().fast();
    }

    // Let's start by settings base negative and positive effects. The other stuff can be implemented then
    // We need custom effects: Nausea / Withdrawal / Addicted? (Reduces duration of positive effects)

    public static final int[] posDur = {
            15,
            20,
            25,
            30,
            35,
            40,
            45
    };

    public static final FoodProperties NIC_COMP_3 = basePouch()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20 * 20, 0), 1.0f)  // 100 % chance for movement speed I
            // Negative
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 5 * 20, 1), 0.05f)      // 5 % chance for nausea II
            .build();

    public static final FoodProperties NIC_COMP_6 = basePouch()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 25 * 20, 0), 1.0f)  // 100 % chance for movement speed I
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 30 * 20, 0), 0.75f)      // 50 % chance for haste I
            // Negative
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 6 * 20, 1), 0.1f)        // 10 % chance for nausea II
            .build();

    public static final FoodProperties NIC_COMP_12 = basePouch()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30 * 20, 0), 1.0f) // 100 % chance for movement speed I
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 30 * 20, 0), 1.0f)      // 100 % chance for haste I
            // Negative
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 7 * 20, 1), 0.15f)      // 15 % chance for nausea II
            .build();

    public static final FoodProperties NIC_COMP_18 = basePouch()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 30 * 20, 1), 1.0f)  // 100 % chance for movement speed II
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 30 * 20, 0), 1.0f)       // 100 % chance for haste I
            // Negative
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 8 * 20, 1), 0.20f)       // 20 % chance for nausea II
            .build();

    public static final FoodProperties NIC_COMP_30 = basePouch()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 35 * 20, 1), 1.0f) // 100 % chance for movement speed II
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 35 * 20, 1), 1.0f)      // 100 % chance for haste II
            // Negative
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 10 * 20, 1), 0.1f)      // 10 % chance for Darkness
            .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 35 * 20, 0), 0.1f)   // 10 % chance for Mining Fatigue I
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 9 * 20, 1), 0.3f)       // 30 % chance for nausea II
            .build();

    public static final FoodProperties NIC_COMP_90 = basePouch()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6 * 20, 1), 1.0f)  // 100 % chance for movement speed II
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 35 * 20, 1), 1.0f)      // 100 % chance for haste II
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 35 * 20, 1), 0.33f)  // 33 % chance for strength II
            // Negative
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 10 * 20, 1), 0.1f)       // 10 % chance for Darkness
            .effect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 35 * 20, 0), 0.1f)    // 10 % chance for Mining Fatigue I
            .effect(new MobEffectInstance(MobEffects.WEAKNESS, 10 * 20, 0), 0.1f)        // 10 % chance for Weakness
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 10 * 20, 1), 0.5f)       // 50 % chance for nausea II
            .build();

    public static final FoodProperties NIC_COMP_150 = basePouch()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6 * 20, 1), 1.0f)  // 100 % chance for movement speed II
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 35 * 20, 1), 1.0f)      // 100 % chance for haste II
            .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 35 * 20, 1), 0.75f)   // 75 % chance for strength II
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 35 * 20, 0), 0.25f)   // 25 % chance for Resistance I
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
