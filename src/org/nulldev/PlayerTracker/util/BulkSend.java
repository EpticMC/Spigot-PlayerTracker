package org.nulldev.PlayerTracker.util;

////////////////////////////////
//----------------------------//
// Copyright (c) 2017 NulLDev //
//----------------------------//
////////////////////////////////

import org.nulldev.PlayerTracker.Config;
import org.nulldev.PlayerTracker.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

@SuppressWarnings("unused")
public class BulkSend {
    public static void send(Player player, String msg, Main plugin) {
        String[] s;
        if (Config.isPrefixEnabled.booleanValue()) {
            String prefix = Config.msgPrefix;
            msg = String.valueOf(prefix) + msg;
        }
        String msg2 = ChatColor.translateAlternateColorCodes((char)'&', (String)msg);
        String[] arrstring = s = msg2.split("\\n");
        int n = arrstring.length;
        int n2 = 0;
        while (n2 < n) {
            String m = arrstring[n2];
            player.sendMessage(m);
            ++n2;
        }
    }

    public static void sendWithPlayer(Player player, String msg, String s, Main plugin) {
        String newmsg = msg.replace("%player%", s);
        BulkSend.send(player, newmsg, plugin);
    }

    public static void sendWithPlayerAndCommand(Player player, String msg, String p, String c, Main plugin) {
        String newmsg = msg.replace("%player%", p);
        newmsg = newmsg.replace("%command%", c);
        BulkSend.send(player, newmsg, plugin);
    }

    public static void sendWithoutPrefix(Player player, String msg, Main plugin) {
		String[] s;
        String msg2 = ChatColor.translateAlternateColorCodes((char)'&', (String)msg);
        String[] arrstring = s = msg2.split("\\n");
        int n = arrstring.length;
        int n2 = 0;
        while (n2 < n) {
            String m = arrstring[n2];
            player.sendMessage(m);
            ++n2;
        }
    }
}
