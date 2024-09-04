package net.creepersneedhugs.firstproject;

import net.creepersneedhugs.firstproject.content.registry.ModBlocks;
import net.creepersneedhugs.firstproject.content.registry.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstProject implements ModInitializer {
	public static final String MOD_ID = "firstproject";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		ModItems.initialize();
	}
}