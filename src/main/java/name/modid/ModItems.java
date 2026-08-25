package name.modid;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

public class ModItems {
    /*
        If you want to add @override, do it inside new Item(...) ->
    */
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

    // Register a new item method
    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        ResourceLocation itemID = ResourceLocation.fromNamespaceAndPath(PTMod.MOD_ID, id);

        // Return the registered item!
        return Registry.register(BuiltInRegistries.ITEM, itemID, item);
    }

    public static void registerModItems() {
        PTMod.LOGGER.info("Registering Mod Items for " + PTMod.MOD_ID);
    }
}