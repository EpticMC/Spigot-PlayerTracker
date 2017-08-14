package org.nulldev.PlayerTracker;

////////////////////////////////
//----------------------------//
//copyright (c) 2017 NulLDev //
//----------------------------//
////////////////////////////////

import java.util.UUID;

public class Tracker {
    private UUID trackers;
    private UUID target;

    public Tracker(UUID watcher, UUID target) {
        this.trackers = watcher;
        this.target = target;
    }

    public UUID getTracker() { return this.trackers; }
    public UUID getTraget() { return this.target; }
}