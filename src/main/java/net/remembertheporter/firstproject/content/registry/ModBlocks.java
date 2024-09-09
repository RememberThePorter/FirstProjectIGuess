package net.remembertheporter.firstproject.content.registry;

import net.remembertheporter.firstproject.FirstProject;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block BRASS_BLOCK = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).strength(2.5f)),
            "brass_block",
            true
    );

    public static final Block BRONZE_BLOCK = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).strength(5.0f)),
            "bronze_block",
            true
    );

    public static final Block DEEPSLATE_TIN_ORE = register(
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(4.5f)),
            "deepslate_tin_ore",
            true
    );

    public static final Block DEEPSLATE_ZINC_ORE = register(
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create().sounds(BlockSoundGroup.DEEPSLATE).strength(3.0f)),
            "deepslate_zinc_ore",
            true
    );

    public static final Block RAW_TIN_BLOCK = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(5.0f)),
            "raw_tin_block",
            true
    );

    public static final Block RAW_ZINC_BLOCK = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(2.0f)),
            "raw_zinc_block",
            true
    );

    public static final Block TIN_BLOCK = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).strength(5.0f)),
            "tin_block",
            true
    );

    public static final Block TIN_ORE = register(
        new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).strength(3.0f)),
        "tin_ore",
        true
    );

    public static final Block ZINC_BLOCK = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).strength(2.0f)),
            "zinc_block",
            true
    );

    public static final Block ZINC_ORE = register(
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL).strength(1.5f)),
            "zinc_ore",
            true
    );

    public static Block register(Block block, String id, boolean shouldRegisterItem) {
        Identifier blockID = Identifier.of(FirstProject.MOD_ID, id);
        if(shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, blockID, blockItem);
        }
        return Registry.register(Registries.BLOCK, blockID, block);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ModItems.CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModBlocks.BRASS_BLOCK);
            itemGroup.add(ModBlocks.BRONZE_BLOCK);
            itemGroup.add(ModBlocks.DEEPSLATE_TIN_ORE);
            itemGroup.add(ModBlocks.DEEPSLATE_ZINC_ORE);
            itemGroup.add(ModBlocks.RAW_TIN_BLOCK);
            itemGroup.add(ModBlocks.RAW_ZINC_BLOCK);
            itemGroup.add(ModBlocks.TIN_BLOCK);
            itemGroup.add(ModBlocks.TIN_ORE);
            itemGroup.add(ModBlocks.ZINC_BLOCK);
            itemGroup.add(ModBlocks.ZINC_ORE);
        });
    }
}