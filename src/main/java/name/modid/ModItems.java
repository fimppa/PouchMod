package name.modid;

import name.modid.item.ModItemsLibrary;
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

    // Register a new item method
    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        ResourceLocation itemID = ResourceLocation.fromNamespaceAndPath(PTMod.MOD_ID, id);

        // Return the registered item!
        return Registry.register(BuiltInRegistries.ITEM, itemID, item);
    }

    public static void registerModItems() {
        PTMod.LOGGER.info("Registering Mod Items for " + PTMod.MOD_ID);
        ModItemsLibrary.load();
    }
}