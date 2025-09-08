package net.nleon.practicemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nleon.practicemod.PracticeMod;

public class ModItems {
    public static final Item PRACTICE_ITEM = registerItem("practice_item", new Item(new Item.Settings()));
    public static final Item PRACTICE_ITEM_BLUE = registerItem("practice_item_blue", new Item(new Item.Settings()));


    private static Item registerItem(String name,Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PracticeMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PracticeMod.LOGGER.info("Registering ModItems" + PracticeMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PRACTICE_ITEM);
            entries.add(PRACTICE_ITEM_BLUE);
        });

    }
}
