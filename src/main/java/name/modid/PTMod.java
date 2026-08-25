package name.modid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.item.CreativeModeTabs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PTMod implements ModInitializer {
	public static final String MOD_ID = "ptmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		// Call for a function in ModItems.java as a test
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();

		// Initialize item B13_TECHNO
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS)
				.register((itemGroup) -> itemGroup.accept(ModItems.B13_TECHNO));

		// Initialize item TOBACCO_SEEDS
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS)
				.register((itemGroup) -> itemGroup.accept(ModItems.TOBACCO_SEEDS));

		// Initialize item TOBACCO_GROWN
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS)
				.register((itemGroup) -> itemGroup.accept(ModItems.TOBACCO_GROWN));

		// Initialize NICOTINE_POUCH
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS)
				.register((itemGroup) -> itemGroup.accept(ModItems.NICOTINE_POUCH));

		// Initialize block FRAGILE_CAT
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS)
				.register((itemGroup) -> itemGroup.accept(ModBlocks.FRAGILE_CAT));

		// Make the item burnable
		FuelRegistry.INSTANCE.add(ModItems.B13_TECHNO, 30 * 20);
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
