package net.pietro.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pietro.tutorialmod.TutorialMod;
import net.pietro.tutorialmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup SILLY_CAT_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "silly_cat_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.SILLY_CAT))
                    .displayName(Text.translatable("itemgroup.tutorialmod.silly_cat_items"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModItems.SILLY_CAT);
                      entries.add(ModItems.SILLY_INGOT);
                      entries.add(ModBlocks.SILLY_INGOT_BLOCK);
                    }).build());

    public static final ItemGroup GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "garnet_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.garnet_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                    }).build());

    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
