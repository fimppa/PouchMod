package name.modid;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

public class ModBlocks {

    // Tobacco crop
    public static final Block TOBACCO_CROP = register(
            new ModCrop(BlockBehaviour.Properties.of().noCollission()
                    .randomTicks()
                    .instabreak()
                    .pushReaction(PushReaction.DESTROY)
                    .sound(SoundType.CROP)),
            "tobacco_crop",
            false
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