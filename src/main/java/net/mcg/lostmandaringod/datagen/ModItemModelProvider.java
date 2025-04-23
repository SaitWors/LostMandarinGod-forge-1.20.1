package net.mcg.lostmandaringod.datagen;

import net.mcg.lostmandaringod.LostMandarinGod;
import net.mcg.lostmandaringod.block.ModBlocks;
import net.mcg.lostmandaringod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LostMandarinGod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.LOST_CRYSTAL);
        simpleItem(ModItems.RAW_LOST_CRYSTAL);

        simpleItem(ModItems.METAL_DETECTOR);

        simpleItem(ModItems.LOST_COAL);

        simpleItem(ModItems.MANDARIN);
        simpleItem(ModItems.MANDARIN_SEGMENT);

        simpleBlockItem(ModBlocks.LOST_CRYSTAL_DOOR);

        fenceItem(ModBlocks.LOST_CRYSTAL_FENCE, ModBlocks.LOST_CRYSTAL_BLOCK);
        buttonItem(ModBlocks.LOST_CRYSTAL_BUTTON, ModBlocks.LOST_CRYSTAL_BLOCK);
        wallItem(ModBlocks.LOST_CRYSTAL_WALL, ModBlocks.LOST_CRYSTAL_BLOCK);

        evenSimplerBlockItem(ModBlocks.LOST_CRYSTAL_STAIRS);
        evenSimplerBlockItem(ModBlocks.LOST_CRYSTAL_SLAB);
        evenSimplerBlockItem(ModBlocks.LOST_CRYSTAL_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.LOST_CRYSTAL_FENCE_GATE);

        trapdoorItem(ModBlocks.LOST_CRYSTAL_TRAPDOOR);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LostMandarinGod.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(LostMandarinGod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(LostMandarinGod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(LostMandarinGod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(LostMandarinGod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(LostMandarinGod.MOD_ID,"item/" + item.getId().getPath()));
    }
}