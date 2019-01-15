package com.ilovepie220.mysticalagricultureTC;

import net.minecraftforge.fml.common.Loader;

public class ModChecker {

	public static boolean isMysticalAgradditionsLoaded;
	
	public ModChecker() {
		this.isMysticalAgradditionsLoaded = Loader.isModLoaded("mysticalagradditions");
	}
	public static void printSuccessMessage() {
		if(isMysticalAgradditionsLoaded) {
			Main.logger.info("MysticalAgridditions Found!");
		}
	}
}
