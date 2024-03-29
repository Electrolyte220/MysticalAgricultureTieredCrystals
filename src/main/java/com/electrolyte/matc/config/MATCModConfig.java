package com.electrolyte.matc.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class MATCModConfig {

    public static ForgeConfigSpec CLIENT_CONFIG;
    public static ForgeConfigSpec SERVER_CONFIG;

    public static ForgeConfigSpec.BooleanValue USES_TOOLTIP;
    public static ForgeConfigSpec.BooleanValue UPGRADE_TOOLTIP;

    public static ForgeConfigSpec.IntValue INFERIUM_DURABILITY;
    public static ForgeConfigSpec.BooleanValue INFERIUM_DURABILITY_ENABLED;
    public static ForgeConfigSpec.IntValue PRUDENTIUM_DURABILITY;
    public static ForgeConfigSpec.BooleanValue PRUDENTIUM_DURABILITY_ENABLED;
    public static ForgeConfigSpec.IntValue TERTIUM_DURABILITY;
    public static ForgeConfigSpec.BooleanValue TERTIUM_DURABILITY_ENABLED;
    public static ForgeConfigSpec.IntValue IMPERIUM_DURABILITY;
    public static ForgeConfigSpec.BooleanValue IMPERIUM_DURABILITY_ENABLED;
    public static ForgeConfigSpec.IntValue SUPREMIUM_DURABILITY;
    public static ForgeConfigSpec.BooleanValue SUPREMIUM_DURABILITY_ENABLED;

    static {
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        CLIENT_BUILDER.comment("Whether or not crystals should display 'Uses Left' tooltips").push("Uses Left Tooltips");
        USES_TOOLTIP = CLIENT_BUILDER
                .comment("Should crystals display 'Uses Left' on their tooltips?")
                .translation("config.matc.uses_tooltip")
                .define("usesTooltip", true);
        CLIENT_BUILDER.pop();

        CLIENT_BUILDER.comment("Whether or not crystals should display their upgrade tooltips").push("Upgrade Tooltips");
        UPGRADE_TOOLTIP = CLIENT_BUILDER
                .comment("Should crystals display upgrade tooltips?")
                .translation("config.matc.upgrade_tooltip")
                .define("upgradeTooltip", true);
        CLIENT_BUILDER.pop();

        CLIENT_CONFIG = CLIENT_BUILDER.build();


        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();

        SERVER_BUILDER.comment("Number of uses for each crystal").push("Uses");
        INFERIUM_DURABILITY = SERVER_BUILDER
                .comment("Durability for the Inferium Crystal")
                .translation("config.matc.inferium_durability")
                .defineInRange("inferiumDurability", 256, 1, Integer.MAX_VALUE);
        PRUDENTIUM_DURABILITY = SERVER_BUILDER
                .comment("Durability for the Prudentium Crystal")
                .translation("config.matc.prudentium_durability")
                .defineInRange("prudentiumDurability", 512, 1, Integer.MAX_VALUE);
        TERTIUM_DURABILITY = SERVER_BUILDER
                .comment("Durability for the Tertium Crystal")
                .translation("config.matc.tertium_durability")
                .defineInRange("tertiumDurability", 1024, 1, Integer.MAX_VALUE);
        IMPERIUM_DURABILITY = SERVER_BUILDER
                .comment("Durability for the Imperium Crystal")
                .translation("config.matc.imperium_durability")
                .defineInRange("imperiumDurability", 2048, 1, Integer.MAX_VALUE);
        SUPREMIUM_DURABILITY = SERVER_BUILDER
                .comment("Durability for the Supremium Crystal")
                .translation("config.matc.supremium_durability")
                .defineInRange("supremiumDurability", 4096, 1, Integer.MAX_VALUE);
        SERVER_BUILDER.pop();

        SERVER_BUILDER.comment("Whether or not crystals should have durability.").push("Enable / Disable Durability");
        INFERIUM_DURABILITY_ENABLED = SERVER_BUILDER
                .comment("Should the Inferium Crystal Have Durability?")
                .translation("config.matc.inferium_durability_enabled")
                .define("inferiumDurabilityEnabled", true);
        PRUDENTIUM_DURABILITY_ENABLED = SERVER_BUILDER
                .comment("Should the Prudentium Crystal Have Durability?")
                .translation("config.matc.prudentium_durability_enabled")
                .define("prudentiumDurabilityEnabled", true);
        TERTIUM_DURABILITY_ENABLED = SERVER_BUILDER
                .comment("Should the Tertium Crystal Have Durability?")
                .translation("config.matc.tertium_durability_enabled")
                .define("tertiumDurabilityEnabled", true);
        IMPERIUM_DURABILITY_ENABLED = SERVER_BUILDER
                .comment("Should the Imperium Crystal Have Durability?")
                .translation("config.matc.imperium_durability_enabled")
                .define("imperiumDurabilityEnabled", true);
        SUPREMIUM_DURABILITY_ENABLED = SERVER_BUILDER
                .comment("Should the Supremium Crystal Have Durability?")
                .translation("config.matc.supremium_durability_enabled")
                .define("supremiumDurabilityEnabled", true);
        SERVER_BUILDER.pop();

        SERVER_CONFIG = SERVER_BUILDER.build();
    }
}
