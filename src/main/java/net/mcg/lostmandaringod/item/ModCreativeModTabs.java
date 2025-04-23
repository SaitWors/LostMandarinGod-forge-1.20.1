package net.mcg.lostmandaringod.item;

import net.mcg.lostmandaringod.LostMandarinGod;
import net.mcg.lostmandaringod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LostMandarinGod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> LMG_TAB = CREATIVE_MODE_TABS.register("lmg_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MANDARIN.get()))
                    .title(Component.translatable("creativetab.lmg_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.MANDARIN.get());
                        pOutput.accept(ModItems.MANDARIN_SEGMENT.get());

                        pOutput.accept(ModItems.RAW_LOST_CRYSTAL.get());
                        pOutput.accept(ModItems.LOST_CRYSTAL.get());

                        pOutput.accept(ModBlocks.RAW_LOST_CRYSTAL_BLOCK.get());
                        pOutput.accept(ModBlocks.LOST_CRYSTAL_BLOCK.get());

                        pOutput.accept(ModBlocks.LOST_CRYSTAL_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_LOST_CRYSTAL_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_LOST_CRYSTAL_ORE.get());
                        pOutput.accept(ModBlocks.END_STONE_LOST_CRYSTAL_ORE.get());

                        pOutput.accept(ModBlocks.MANDARIN_BOX.get());

                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                        pOutput.accept(ModItems.LOST_CRYSTAL_STAFF.get());

                        pOutput.accept(ModItems.LOST_COAL.get());

                        pOutput.accept(ModBlocks.LOST_CRYSTAL_STAIRS.get());
                        pOutput.accept(ModBlocks.LOST_CRYSTAL_BUTTON.get());
                        pOutput.accept(ModBlocks.LOST_CRYSTAL_SLAB.get());
                        pOutput.accept(ModBlocks.LOST_CRYSTAL_PRESSURE_PLATE.get());

                        pOutput.accept(ModBlocks.LOST_CRYSTAL_FENCE.get());
                        pOutput.accept(ModBlocks.LOST_CRYSTAL_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.LOST_CRYSTAL_WALL.get());

                        pOutput.accept(ModBlocks.LOST_CRYSTAL_DOOR.get());
                        pOutput.accept(ModBlocks.LOST_CRYSTAL_TRAPDOOR.get());
                    })
                    .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
