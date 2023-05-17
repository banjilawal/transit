package com.lawal.transit.middleware.abstracts;

import com.lawal.transit.middleware.enums.Direction;

public abstract class Building extends Location {

    public Building (int id, String name, int blockId, Road blockRoad, Direction blockSide) {
        super(id, name, blockId, blockRoad, blockSide);
    }
} // end class Building