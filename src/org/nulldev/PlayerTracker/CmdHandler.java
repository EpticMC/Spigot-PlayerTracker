package org.nulldev.PlayerTracker;

////////////////////////////////
//----------------------------//
// Copyright (c) 2017 NullDev //
//----------------------------//
////////////////////////////////

import org.nulldev.PlayerTracker.Tracker;
import org.nulldev.PlayerTracker.Config;
import org.nulldev.PlayerTracker.Main;
import org.nulldev.PlayerTracker.util.PlayerFetch;
import org.nulldev.PlayerTracker.util.BulkSend;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@SuppressWarnings("deprecation")
public class CmdHandler implements CommandExecutor {
    private Main plugin;

    public CmdHandler(Main plugin) { this.plugin = plugin; }

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can't be executed from the console");
            return false;
        }
        Player psender = (Player)sender;
        if (args.length > 0) {
            if (sender.hasPermission("playertracker.track") || sender.isOp()) {
				OfflinePlayer oplayer = Bukkit.getOfflinePlayer((String)args[0]);
                if (oplayer == null) {
                    BulkSend.send(psender, Config.msgPlayerNotExist, this.plugin);
                    return true;
                }
                for (Tracker w : this.plugin.trackers) {
                    if (psender.getUniqueId() != PlayerFetch.uuid(w.getTracker()) || oplayer.getUniqueId() != PlayerFetch.uuid(w.getTarget())) continue;
                    this.plugin.trackers.remove(w);
                    BulkSend.sendWithPlayer(psender, Config.msgDisableTracker, oplayer.getName(), this.plugin);
                    return true;
                }
                Player player = Bukkit.getPlayer((String)args[0]);
                if (player == null) {
                    BulkSend.send(psender, Config.msgPlayerNotOnline, this.plugin);
                    return true;
                }
                this.plugin.trackers.add(new Tracker(psender.getUniqueId(), player.getUniqueId()));
                BulkSend.sendWithPlayer(psender, Config.msgEnableTracker, player.getDisplayName(), this.plugin);
                return true;
            }
            else this.permissionError(psender);
            return true;
        }
        else {
        	String msg = " \n&4-- &6PlayerTracker &4--\n \n";
        	if (psender.hasPermission("playertracker.track") || psender.isOp()){
        		msg = String.valueOf(msg) + Config.msgEnterPlayersName;
                msg = String.valueOf(msg) + "# &c/tc <player> &b- &aTrack a players commands./n";
        	    msg = String.valueOf(msg) + "&4----------------------";
		        BulkSend.sendWithoutPrefix(psender, msg, this.plugin);
        	}
        	else this.permissionError(psender);
        	return true;
        }
    }

    public void permissionError(Player player) { player.sendMessage((Object)ChatColor.RED + "You do not have permission to use this command."); }
}
