package com.electrolyte220.mysticalagricultureTC.proxy;

import com.electrolyte220.mysticalagricultureTC.Main;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void PreInit(FMLPreInitializationEvent e) {
	super.PreInit(e);
	
	}
	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		
	}
	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		
	}
	
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Main.MOD_ID + ":" + id, "inventory"));
	}
}
