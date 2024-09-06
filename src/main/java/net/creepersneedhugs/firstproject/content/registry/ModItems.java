package net.creepersneedhugs.firstproject.content.registry;

import net.creepersneedhugs.firstproject.FirstProject;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(FirstProject.MOD_ID, "item_group"));

    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.CHAIN_LINK))
            .displayName(Text.translatable("itemGroup.firstproject"))
            .build();

    public static final Item BOILED_LEATHER = register(
            new Item(new Item.Settings()),
            "boiled_leather"
    );

    public static final Item BRONZE_INGOT = register(
            new Item(new Item.Settings()),
            "bronze_ingot"
    );

    public static final Item BRONZE_NUGGET = register(
            new Item(new Item.Settings()),
            "bronze_nugget"
    );

    public static final Item CHAIN_LINK = register(
            new Item(new Item.Settings()),
            "chain_link"
    );

    public static final Item CHAINMAIL = register(
            new Item(new Item.Settings()),
            "chainmail"
    );

    public static final Item RAW_TIN = register(
            new Item(new Item.Settings()),
            "raw_tin"
    );

    public static final Item TIN_INGOT = register(
            new Item(new Item.Settings()),
            "tin_ingot"
    );

    public static final Item TIN_NUGGET = register(
            new Item(new Item.Settings()),
            "tin_nugget"
    );

    public static Item register(Item item, String id) {
        Identifier itemid = Identifier.of(FirstProject.MOD_ID, id);
        Item registeredItem = Registry.register(Registries.ITEM, itemid, item);
        return registeredItem;
    }

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.BOILED_LEATHER);
            itemGroup.add(ModItems.CHAIN_LINK);
            itemGroup.add(ModItems.CHAINMAIL);
            itemGroup.add(ModItems.RAW_TIN);
            itemGroup.add(ModItems.TIN_INGOT);
            itemGroup.add(ModItems.TIN_NUGGET);
        });
    }
}
