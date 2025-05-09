package net.mcg.lostmandaringod.datagen;

import net.mcg.lostmandaringod.LostMandarinGod;
import net.mcg.lostmandaringod.block.ModBlocks;
import net.mcg.lostmandaringod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LostMandarinGod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.LOST_CRYSTAL_ORE.get()).addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LOST_CRYSTAL_BLOCK.get(),
                        ModBlocks.RAW_LOST_CRYSTAL_BLOCK.get(),
                        ModBlocks.NETHER_LOST_CRYSTAL_ORE.get(),
                        ModBlocks.END_STONE_LOST_CRYSTAL_ORE.get(),
                        ModBlocks.LOST_CRYSTAL_ORE.get(),
                        ModBlocks.DEEPSLATE_LOST_CRYSTAL_ORE.get(),
                        ModBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LOST_CRYSTAL_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_LOST_CRYSTAL_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.END_STONE_LOST_CRYSTAL_ORE.get());

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.LOST_CRYSTAL_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.LOST_CRYSTAL_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.LOST_CRYSTAL_WALL.get());

    }
}
