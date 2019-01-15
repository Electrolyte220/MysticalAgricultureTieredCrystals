package com.electrolyte220.mysticalagricultureTC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {

	private static Logger Logger;
	public static Logger getLogger() {
		if(Logger == null) {
			Logger = LogManager.getFormatterLogger(Main.MOD_ID);
		}
		return Logger;
	}
}
