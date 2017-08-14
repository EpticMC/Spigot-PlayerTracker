package org.nulldev.PlayerTracker;

////////////////////////////////
//----------------------------//
//copyright (c) 2017 NulLDev //
//----------------------------//
////////////////////////////////

import org.nulldev.PlayerTracker.Main;

public class Config {
    public static String msgOnCommand;
    public static String msgEnableTracker;
    public static String msgDisableTracker;
    public static String msgPlayerNotExist;
    public static String msgPlayerNotOnline;
    public static String msgEnterPlayersName;
    public static String msgPrefix;
    public static Boolean isPrefixEnabled;
    public static String[] commandsToIgnore;

    static { isPrefixEnabled = true; }

    public static void loadConfig(Main plugin) {
        msgOnCommand = plugin.getConfig().getString("on_command");
        msgEnableTracker = plugin.getConfig().getString("enable_tracker");
        msgDisableTracker = plugin.getConfig().getString("disable_tracker");
        msgPlayerNotExist = plugin.getConfig().getString("player_not_existant");
        msgPlayerNotOnline = plugin.getConfig().getString("player_offline");
        msgEnterPlayersName = plugin.getConfig().getString("specify_name");
        msgPrefix = plugin.getConfig().getString("prefix");
        isPrefixEnabled = plugin.getConfig().getBoolean("enable_prefix");
        String preCommandsToIgnore = plugin.getConfig().getString("ignore_commands");
        commandsToIgnore = preCommandsToIgnore.split(",");
    }
}