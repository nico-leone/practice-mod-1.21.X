package net.nleon.practicemod;

import net.fabricmc.api.ModInitializer;

import net.nleon.practicemod.entities.ModEntities;
import net.nleon.practicemod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PracticeMod implements ModInitializer {
	public static final String MOD_ID = "practicemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModEntities.register();
	}
}