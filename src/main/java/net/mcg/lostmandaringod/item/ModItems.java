package net.mcg.lostmandaringod.item;

import net.mcg.lostmandaringod.LostMandarinGod;
import net.mcg.lostmandaringod.item.custom.FuelItem;
import net.mcg.lostmandaringod.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LostMandarinGod.MOD_ID);

    public static final RegistryObject<Item> MANDARIN = ITEMS.register("mandarin",
            () -> new Item(new Item.Properties().food(ModFoods.MANDARIN)));
    public static final RegistryObject<Item> MANDARIN_SEGMENT = ITEMS.register("mandarin_segment",
            () -> new Item(new Item.Properties().food(ModFoods.MANDARIN_SEGMENT)));

    public static final RegistryObject<Item> RAW_LOST_CRYSTAL = ITEMS.register("raw_lost_crystal",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LOST_CRYSTAL = ITEMS.register("lost_crystal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> LOST_CRYSTAL_STAFF = ITEMS.register("lost_crystal_staff",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LOST_COAL = ITEMS.register("lost_coal",
            () -> new FuelItem(new Item.Properties(), 6400));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
