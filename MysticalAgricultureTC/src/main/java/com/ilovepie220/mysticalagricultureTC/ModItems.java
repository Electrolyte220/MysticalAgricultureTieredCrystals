package com.ilovepie220.mysticalagricultureTC;

import com.ilovepie220.mysticalagricultureTC.items.InferiumInfusionCrystal;
import com.ilovepie220.mysticalagricultureTC.items.IntermediumInfusionCrystal;
import com.ilovepie220.mysticalagricultureTC.items.PrudentiumInfusionCrystal;
import com.ilovepie220.mysticalagricultureTC.items.SuperiumInfusionCrystal;
import com.ilovepie220.mysticalagricultureTC.items.SupremiumInfusionCrystal;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	
	public static Item inferiumcrystal = new InferiumInfusionCrystal("inferiumcrystal").setCreativeTab(Main.tabMatc);
	public static Item prudentiumcrystal = new PrudentiumInfusionCrystal("prudentiumcrystal").setCreativeTab(Main.tabMatc);
	public static Item intermediumcrystal = new IntermediumInfusionCrystal("intermediumcrystal").setCreativeTab(Main.tabMatc);
	public static Item superiumcrystal = new SuperiumInfusionCrystal("superiumcrystal").setCreativeTab(Main.tabMatc);
	public static Item supremiumcrystal = new SupremiumInfusionCrystal("supremiumcrystal").setCreativeTab(Main.tabMatc);
	
	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				inferiumcrystal,
				prudentiumcrystal,
				intermediumcrystal,
				superiumcrystal,
				supremiumcrystal
				);
	}
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		registerRender(inferiumcrystal);
		registerRender(prudentiumcrystal);
		registerRender(intermediumcrystal);
		registerRender(superiumcrystal);
		registerRender(supremiumcrystal);
	}
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
}
