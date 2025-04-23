package net.mcg.lostmandaringod.datagen.loot;

import net.mcg.lostmandaringod.block.ModBlocks;
import net.mcg.lostmandaringod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.LOST_CRYSTAL_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_LOST_CRYSTAL_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());
        this.dropSelf(ModBlocks.MANDARIN_BOX.get());

        this.add(ModBlocks.LOST_CRYSTAL_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.LOST_CRYSTAL_ORE.get(), ModItems.RAW_LOST_CRYSTAL.get()));

        this.add(ModBlocks.DEEPSLATE_LOST_CRYSTAL_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_LOST_CRYSTAL_ORE.get(), ModItems.RAW_LOST_CRYSTAL.get()));

        this.add(ModBlocks.NETHER_LOST_CRYSTAL_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NETHER_LOST_CRYSTAL_ORE.get(), ModItems.RAW_LOST_CRYSTAL.get()));

        this.add(ModBlocks.END_STONE_LOST_CRYSTAL_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.END_STONE_LOST_CRYSTAL_ORE.get(), ModItems.RAW_LOST_CRYSTAL.get()));

        this.dropSelf(ModBlocks.LOST_CRYSTAL_STAIRS.get());
        this.dropSelf(ModBlocks.LOST_CRYSTAL_BUTTON.get());
        this.dropSelf(ModBlocks.LOST_CRYSTAL_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.LOST_CRYSTAL_TRAPDOOR.get());
        this.dropSelf(ModBlocks.LOST_CRYSTAL_FENCE.get());
        this.dropSelf(ModBlocks.LOST_CRYSTAL_FENCE_GATE.get());
        this.dropSelf(ModBlocks.LOST_CRYSTAL_WALL.get());

        this.add(ModBlocks.LOST_CRYSTAL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.LOST_CRYSTAL_SLAB.get()));
        this.add(ModBlocks.LOST_CRYSTAL_DOOR.get(),
                block -> createDoorTable(ModBlocks.LOST_CRYSTAL_DOOR.get()));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
