package com.ilovepie220.mysticalagricultureTC;

import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class RemoveRecipe {

	@SubscribeEvent
    public static void removeRecipes(RegistryEvent.Register<IRecipe> event)
    {
    	ResourceLocation infusionCrystal = new ResourceLocation("mysticalagriculture:core/infusion_crystal");
        IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable) event.getRegistry();
        modRegistry.remove(infusionCrystal);
       
        ResourceLocation masterInfusionCrystal = new ResourceLocation("mysticalagriculture:core/master_infusion_crystal");
        IForgeRegistryModifiable modRegistry2 = (IForgeRegistryModifiable) event.getRegistry();
        modRegistry.remove(masterInfusionCrystal);
        
        ResourceLocation Prudentium = new ResourceLocation("mysticalagriculture:core/compression/prudentium_essence_to");
        IForgeRegistryModifiable modRegistry3 = (IForgeRegistryModifiable) event.getRegistry();
        modRegistry.remove(Prudentium);
        
        ResourceLocation Intermedium = new ResourceLocation("mysticalagriculture:core/compression/intermedium_essence_to");
        IForgeRegistryModifiable modRegistry4 = (IForgeRegistryModifiable) event.getRegistry();
        modRegistry.remove(Intermedium);
        
        ResourceLocation Superium = new ResourceLocation("mysticalagriculture:core/compression/superium_essence_to");
        IForgeRegistryModifiable modRegistry5 = (IForgeRegistryModifiable) event.getRegistry();
        modRegistry.remove(Superium);
        
        ResourceLocation Supremeium = new ResourceLocation("mysticalagriculture:core/compression/supremium_essence_to");
        IForgeRegistryModifiable modRegistry6 = (IForgeRegistryModifiable) event.getRegistry();
        modRegistry.remove(Supremeium);
        
        //Disabled MA default recipe because it uses either crystal in the recipe. (First crystal is disabled)
        if(ModChecker.isMysticalAgradditionsLoaded) {
        ResourceLocation Insanium = new ResourceLocation("mysticalagradditions:insanium_essence_to");
        IForgeRegistryModifiable modRegistry7 = (IForgeRegistryModifiable) event.getRegistry();
        modRegistry.remove(Insanium);
        }
        if(!ModChecker.isMysticalAgradditionsLoaded) {
        ResourceLocation Insanium1 = new ResourceLocation("matc:essence/insanium");
        IForgeRegistryModifiable modRegistry8 = (IForgeRegistryModifiable) event.getRegistry();
        modRegistry.remove(Insanium1);
        }	
        if(!ModChecker.isMysticalAgradditionsLoaded) {
            ResourceLocation masterInsanium = new ResourceLocation("matc:essence/masterinsanium");
            IForgeRegistryModifiable modRegistry9 = (IForgeRegistryModifiable) event.getRegistry();
            modRegistry.remove(masterInsanium);
            }	
        if(ModChecker.isMysticalAgradditionsLoaded) {
            ResourceLocation masterInsaniumCrystal = new ResourceLocation("matc:crystals/masterinfusioncrystal");
            IForgeRegistryModifiable modRegistry10 = (IForgeRegistryModifiable) event.getRegistry();
            modRegistry.remove(masterInsaniumCrystal);
            }
    }
}
