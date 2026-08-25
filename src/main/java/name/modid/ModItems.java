package name.modid;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItems {
/*
    If you want to add @override, do it inside new Item(...) ->
*/

    // New item to register. This instance is suspicious_substance
    // Read about item properties here :D :https://wiki.fabricmc.net/tutorial:items
    public static final Item B13_TECHNO = ModItems.register(
            new Item(new Item.Properties()),
            "b13_techno"
    );

    // Register a new item method
    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        ResourceLocation itemID = ResourceLocation.fromNamespaceAndPath(PTMod.MOD_ID, id);

        // Register the item.
        Item registeredItem = Registry.register(BuiltInRegistries.ITEM, itemID, item);

        // Return the registered item!
        return registeredItem;
    }

    public static void registerModItems() {
        PTMod.LOGGER.info("Registering Mod Items for " + PTMod.MOD_ID);
    }
}