package com.ilovepie220.mysticalagricultureTC;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ilovepie220.mysticalagricultureTC.proxy.ClientProxy;
import com.ilovepie220.mysticalagricultureTC.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = Main.MOD_ID, name = Main.NAME, version = Main.VERSION, acceptedMinecraftVersions = Main.ACCEPTED_VERSIONS, dependencies = Main.DEPENDENCIES)
public class Main {
	
	public static final String MOD_ID = "matc";
	public static final String NAME = "Mystical Agriculture Tiered Crystals";
	public static final String VERSION = "1.0.1-hotfix";
	public static final String ACCEPTED_VERSIONS = "[1.12.2]";
	public static final String DEPENDENCIES= "required-after:mysticalagriculture";
	
	public static final String CLIENT_PROXY_CLASS = "com.ilovepie220.mysticalagricultureTC.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.ilovepie220.mysticalagricultureTC.proxy.ServerProxy";
	public static final String COMMON_PROXY_CLASS = "com.ilovepie220.mysticalagricultureTC.proxy.CommonProxy";
	
	public static final Logger logger = LogManager.getFormatterLogger(Main.MOD_ID);
	
	@Instance
	public static Main Instance;
		
	public static ModChecker modChecker;
	
	@SidedProxy(clientSide= Main.CLIENT_PROXY_CLASS, serverSide = Main.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		
		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			ModItems.registerModels(event);
		}
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			ModItems.register(event.getRegistry());
		}	
		@SubscribeEvent
		public static void removeRecipe(RegistryEvent.Register<IRecipe> event) {
			RemoveRecipe.removeRecipes(event);
		}
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.PreInit(event);
	
		Utils.getLogger().info("Pre Init");
		
		modChecker = new ModChecker();
		modChecker.printSuccessMessage();
		
		MinecraftForge.EVENT_BUS.register(new ClientProxy());
		
	}
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		proxy.init(event);
		
		Utils.getLogger().info("Init");
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
		
		Utils.getLogger().info("Post Init");
	}
	
	public static final CreativeTabs tabMatc= new CreativeTabs("tab_matc") {
		
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.supremiumcrystal);
		}
		
		@SideOnly(Side.CLIENT)
		public boolean hasSearchBar() {
			return false;
		}
	};	
}