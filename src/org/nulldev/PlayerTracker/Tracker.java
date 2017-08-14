package org.nulldev.PlayerTracker;

////////////////////////////////
//----------------------------//
// Copyright (c) 2017 NullDev //
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
    public UUID getTarget()  { return this.target; }
}
