package name.modid;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ModCropBU extends CropBlock {
    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.box(0.0,0.0,0.0,16.0,2.0,16.0),
            Block.box(0.0,0.0,0.0,16.0,4.0,16.0),
            Block.box(0.0,0.0,0.0,16.0,6.0,16.0),
            Block.box(0.0,0.0,0.0,16.0,8.0,16.0),
            Block.box(0.0,0.0,0.0,16.0,10.0,16.0),
    };

    public ModCropBU(Properties properties) {
        super(properties);
    }

    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(PTMod.MOD_ID, name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Properties());
            Registry.register(BuiltInRegistries.ITEM, id, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }
/*
    @Override
    public ItemLike getSeedsItem() {
        return
    }
*/
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return AGE_TO_SHAPE[getAge(state)];
    }
}
