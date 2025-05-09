package net.mcg.lostmandaringod.datagen;

import net.mcg.lostmandaringod.LostMandarinGod;
import net.mcg.lostmandaringod.block.ModBlocks;
import net.mcg.lostmandaringod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> LOST_CRYSTAL_SMELTABLES = List.of(ModItems.RAW_LOST_CRYSTAL.get(),
            ModBlocks.LOST_CRYSTAL_ORE.get(), ModBlocks.DEEPSLATE_LOST_CRYSTAL_ORE.get(), ModBlocks.NETHER_LOST_CRYSTAL_ORE.get(), ModBlocks.END_STONE_LOST_CRYSTAL_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, LOST_CRYSTAL_SMELTABLES, RecipeCategory.MISC, ModItems.LOST_CRYSTAL.get(), 0.25f, 200, "lost_crystal");
        oreBlasting(pWriter, LOST_CRYSTAL_SMELTABLES, RecipeCategory.MISC, ModItems.LOST_CRYSTAL.get(), 0.25f, 100, "lost_crystal");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LOST_CRYSTAL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.LOST_CRYSTAL.get())
                .unlockedBy(getHasName(ModItems.LOST_CRYSTAL.get()), has(ModItems.LOST_CRYSTAL.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LOST_CRYSTAL.get(), 9)
                .requires(ModBlocks.LOST_CRYSTAL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.LOST_CRYSTAL_BLOCK.get()), has(ModBlocks.LOST_CRYSTAL_BLOCK.get()))
                .save(pWriter);
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, LostMandarinGod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
