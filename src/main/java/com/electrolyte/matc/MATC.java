package com.electrolyte.matc;

import com.electrolyte.matc.config.MATCModConfig;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("matc")
public class MATC {

    public static final String MOD_ID = "matc";
    public static final Logger logger = LogManager.getFormatterLogger(MATC.MOD_ID);

    public MATC() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MATCModConfig.SERVER_CONFIG);

        ModRegistry.init();

    }

    public static final ItemGroup ITEM_GROUP = new ItemGroup("matc") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModRegistry.SUPREMIUMCRYSTAL.get());
        }
    };
}
