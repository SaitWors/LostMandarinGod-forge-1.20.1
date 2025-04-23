package net.mcg.lostmandaringod.datagen;

import net.mcg.lostmandaringod.LostMandarinGod;
import net.mcg.lostmandaringod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LostMandarinGod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.LOST_CRYSTAL_BLOCK);
        blockWithItem(ModBlocks.RAW_LOST_CRYSTAL_BLOCK);

        blockWithItem(ModBlocks.LOST_CRYSTAL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_LOST_CRYSTAL_ORE);
        blockWithItem(ModBlocks.NETHER_LOST_CRYSTAL_ORE);
        blockWithItem(ModBlocks.END_STONE_LOST_CRYSTAL_ORE);

        blockWithItem(ModBlocks.SOUND_BLOCK);

        blockWithItem(ModBlocks.MANDARIN_BOX);

        stairsBlock(((StairBlock) ModBlocks.LOST_CRYSTAL_STAIRS.get()), blockTexture(ModBlocks.LOST_CRYSTAL_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.LOST_CRYSTAL_SLAB.get()), blockTexture(ModBlocks.LOST_CRYSTAL_BLOCK.get()), blockTexture(ModBlocks.LOST_CRYSTAL_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.LOST_CRYSTAL_BUTTON.get()), blockTexture(ModBlocks.LOST_CRYSTAL_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.LOST_CRYSTAL_PRESSURE_PLATE.get()), blockTexture(ModBlocks.LOST_CRYSTAL_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.LOST_CRYSTAL_FENCE.get()), blockTexture(ModBlocks.LOST_CRYSTAL_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.LOST_CRYSTAL_FENCE_GATE.get()), blockTexture(ModBlocks.LOST_CRYSTAL_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.LOST_CRYSTAL_WALL.get()), blockTexture(ModBlocks.LOST_CRYSTAL_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.LOST_CRYSTAL_DOOR.get()), modLoc("block/lost_crystal_door_bottom"), modLoc("block/lost_crystal_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.LOST_CRYSTAL_TRAPDOOR.get()), modLoc("block/lost_crystal_trapdoor"), true, "cutout");

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
