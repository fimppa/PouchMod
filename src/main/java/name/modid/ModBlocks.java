package name.modid;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {

    // Let's be brave and try to make a block with a custom name, destroy time of 0.1f and the sound for
    // glass with a custom texture
    public static final Block FRAGILE_CAT = register(
            new Block(BlockBehaviour.Properties.of().destroyTime(0.1f).sound(SoundType.GLASS)),
            "fragile_cat",
            true
    );

    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(PTMod.MOD_ID, name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Properties());
            Registry.register(BuiltInRegistries.ITEM, id, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void registerModBlocks() {
        PTMod.LOGGER.info("Registering Mod Blocks for " + PTMod.MOD_ID);
    }

}