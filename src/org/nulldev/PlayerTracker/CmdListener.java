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
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CmdListener implements Listener {
    private Main plugin;

    public CmdListener(Main plugin) { this.plugin = plugin; }

    @EventHandler
    public void playerCommandPreprocess(PlayerCommandPreprocessEvent e) {
        int n;
        String s;
        String[] args;
        String[] arrstring;
        int n2;
        if (this.plugin.trackers.size() > 0) {
            for (Tracker w : this.plugin.trackers) {
                if (PlayerFetch.uuid(w.getTraget()) != e.getPlayer().getUniqueId() || !PlayerFetch.offline(w.getTracker()).isOnline()) continue;
                if (Config.commandsToIgnore.length > 0) {
                    args = e.getMessage().replace("/", "").split(" ");
                    arrstring = Config.commandsToIgnore;
                    n = arrstring.length;
                    n2 = 0;
                    while (n2 < n) {
                        s = arrstring[n2];
                        if (args[0].equalsIgnoreCase(s.trim())) break;
                        ++n2;
                    }
                }
                BulkSend.sendWithPlayerAndCommand(PlayerFetch.player(w.getTracker()), Config.msgOnCommand, e.getPlayer().getDisplayName(), e.getMessage(), this.plugin);
            }
        }
    }
}
