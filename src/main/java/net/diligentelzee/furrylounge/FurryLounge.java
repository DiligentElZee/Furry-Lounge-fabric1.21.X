package net.diligentelzee.furrylounge;

import net.diligentelzee.furrylounge.block.ModBlocks;
import net.diligentelzee.furrylounge.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.desktop.QuitResponse;

public class FurryLounge implements ModInitializer, QuitResponse {
	public static final String MOD_ID = "furrylounge";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		FurryLounge.LOGGER.info("--- Welcome to the Furry Lounge!! >ω<");
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		FurryLounge.LOGGER.info("Hope you enjoy your time here! ^ω^ ---");
	}
	@Override
	public void performQuit() {
		FurryLounge.LOGGER.info("Hope you enjoyed your time here! •ω•");
	}
	@Override
	public void cancelQuit() {
		FurryLounge.LOGGER.info("You came back!?? 0ω0");
	}
}