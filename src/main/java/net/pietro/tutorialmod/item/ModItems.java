package net.pietro.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pietro.tutorialmod.TutorialMod;

public class ModItems {

    public static final Item SILLY_CAT = registerItem("silly_cat", new Item(new Item.Settings()));
    public static final Item SILLY_INGOT = registerItem("silly_ingot", new Item(new Item.Settings()));
    public static final Item ROSE_BOUQUET = registerItem("rose_bouquet", new Item(new Item.Settings()));
    public static final Item PINK_ROSE_BOUQUET = registerItem("pink_rose_bouquet", new Item(new Item.Settings()));
    public static final Item PICK_BENI = registerItem("pick_beni", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItemsToVanillaGroups() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModItems.ROSE_BOUQUET);
            fabricItemGroupEntries.add(ModItems.PINK_ROSE_BOUQUET);
        });
    }
}
