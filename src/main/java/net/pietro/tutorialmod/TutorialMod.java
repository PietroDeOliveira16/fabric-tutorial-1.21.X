package net.pietro.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.pietro.tutorialmod.block.ModBlocks;
import net.pietro.tutorialmod.item.ModItemGroups;
import net.pietro.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItemsToVanillaGroups();
		ModBlocks.registerModBlocks();
	}
}