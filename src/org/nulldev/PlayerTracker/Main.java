package org.nulldev.PlayerTracker;

////////////////////////////////
//----------------------------//
// Copyright (c) 2017 NullDev //
//----------------------------//
////////////////////////////////

import org.nulldev.PlayerTracker.Tracker;
import org.nulldev.PlayerTracker.CmdHandler;
import org.nulldev.PlayerTracker.CmdListener;
import org.nulldev.PlayerTracker.Config;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public List<Tracker> trackers = new ArrayList<Tracker>();

    public void onEnable() {
        this.registerEvents();
        this.registerCommands();
        this.registerConfig();
        Config.loadConfig(this);
        PluginDescriptionFile pdfFile = this.getDescription();
        Logger logger = this.getLogger();
        logger.info(String.valueOf(pdfFile.getName()) + " has been enabled! Version: " + pdfFile.getVersion() + " ^.^");
    }

    public void onDisable() {
        PluginDescriptionFile pdfFile = this.getDescription();
        Logger logger = this.getLogger();
        logger.info(String.valueOf(pdfFile.getName()) + " has been disabled! Version: " + pdfFile.getVersion() + " ^.^");
    }

    public void registerEvents() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents((Listener)new CmdListener(this), (org.bukkit.plugin.Plugin)this);
    }

    public void registerCommands() { 
    	this.getCommand("track").setExecutor((CommandExecutor)new CmdHandler(this));
    	this.getCommand("tc").setExecutor((CommandExecutor)new CmdHandler(this));
    }

    public void registerConfig() {
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();
    }
}
