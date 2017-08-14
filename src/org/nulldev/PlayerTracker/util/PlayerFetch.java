package org.nulldev.PlayerTracker.util;

////////////////////////////////
//----------------------------//
// Copyright (c) 2017 NullDev //
//----------------------------//
////////////////////////////////

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class PlayerFetch {
    public static UUID uuid(UUID brokenUUID) { return Bukkit.getOfflinePlayer((UUID)brokenUUID).getUniqueId(); }
    public static OfflinePlayer offline(UUID playerUUID) { return Bukkit.getOfflinePlayer((UUID)playerUUID); }
    public static Player player(UUID playerUUID) { return Bukkit.getPlayer((UUID)playerUUID); }
}
