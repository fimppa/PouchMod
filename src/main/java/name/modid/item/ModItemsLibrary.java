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

    public static final FoodProperties NICOTINE_POUCH_COMPONENT = new FoodProperties.Builder()
            .alwaysEdible()
            .fast()
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6 * 20, 1), 1.0f)
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 6 * 20, 1), 1.0f)
            .build();

    public static final Item NICOTINE_POUCH = ModItems.register(
            new Item(new Item.Properties().food(NICOTINE_POUCH_COMPONENT)),
            "nicotine_pouch"
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
    public static void load() {}
}
