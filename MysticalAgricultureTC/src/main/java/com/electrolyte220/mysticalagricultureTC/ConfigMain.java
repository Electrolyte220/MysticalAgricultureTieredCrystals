package com.electrolyte220.mysticalagricultureTC;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
@Config(modid = Main.MOD_ID)
@Config.LangKey("matc.config.title.matcconfig")

public class ConfigMain {

	@Config.LangKey("matc.config.infusiondurabilities")
	@Config.Comment("Change the durabilities of the Infusion Crystals")
	public static final Client infusiondurabilities = new Client();
	public static class Client {
		
		@Config.Comment("Inferium Infusion Durability")
		@Config.LangKey("matc.config.infusiondurabilities.inferiumDurability")
		@Config.RequiresMcRestart
		@Config.RangeInt(min = 1, max = 2147483647)
		public int inferiumDurability = 256;
		
		@Config.Comment("Prudentium Infusion Durability")
		@Config.LangKey("matc.config.infusiondurabilities.prudentiumDurability")
		@Config.RequiresMcRestart
		@Config.RangeInt(min = 1, max = 2147483647)
		public int prudentiumDurability = 512;
		
		@Config.Comment("Intermedium Infusion Durability")
		@Config.LangKey("matc.config.infusiondurabilities.intermediumDurability")
		@Config.RequiresMcRestart
		@Config.RangeInt(min = 1, max = 2147483647)
		public int intermediumDurability = 1024;
		
		@Config.Comment("Superium Infusion Durability")
		@Config.LangKey("matc.config.infusiondurabilities.superiumDurability")
		@Config.RequiresMcRestart
		@Config.RangeInt(min = 1, max = 2147483647)
		public int superiumDurability = 2048;
		
		@Config.Comment("Supremium Infusion Durability")
		@Config.LangKey("matc.config.infusiondurabilities.supremiumDurability")
		@Config.RequiresMcRestart
		@Config.RangeInt(min = 1, max = 2147483647)
		public int supremiumDurability = 4096;
		
		@Config.Comment("Infusion Crystal Durabilities")
		@Config.LangKey("matc.config.infusiondurabilities.enabled")
		@Config.RequiresMcRestart
		public boolean enableInfusionDurability = true;
	}
	@Mod.EventBusSubscriber(modid = Main.MOD_ID)
	private static class EventHandler {
		
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(Main.MOD_ID)) {
				ConfigManager.sync(Main.MOD_ID, Config.Type.INSTANCE);
			}
		}
	}
	
}
