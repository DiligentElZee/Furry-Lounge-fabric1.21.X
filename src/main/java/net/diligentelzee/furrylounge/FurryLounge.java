package net.diligentelzee.furrylounge;

import net.diligentelzee.furrylounge.block.ModBlocks;
import net.diligentelzee.furrylounge.item.ModItemGroups;
import net.diligentelzee.furrylounge.item.ModItems;
import net.diligentelzee.furrylounge.item.custom.FuelItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FurryLounge implements ModInitializer {
	public static final String MOD_ID = "furrylounge";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		FurryLounge.LOGGER.info("");
		FurryLounge.LOGGER.info(";3c");
		FurryLounge.LOGGER.info("");
		FurryLounge.LOGGER.info("~~~ Welcome to the Furry Lounge!! >ω<");
		FurryLounge.LOGGER.info("(Initializing the mod for you master!)");
		FurryLoungeDataGenerator.registerModDataGen();
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		FuelItems.registerModFuelItems();
		FurryLounge.LOGGER.info("(Mod has been successfully initialized, nya~!)");
		FurryLounge.LOGGER.info("Hope you enjoy your time here! ^ω^ ~~~");
		FurryLounge.LOGGER.info("");
		FurryLounge.LOGGER.info("<3");
		FurryLounge.LOGGER.info("");
	}
}