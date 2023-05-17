package com.lawal.transit.middleware.abstracts;

import com.lawal.transit.middleware.entities.Street;
import com.lawal.transit.middleware.enums.Direction;
import com.lawal.transit.middleware.enums.RoadLane;

public abstract class StreetStation extends Station {

    public StreetStation (int id, String name, int blockId, Street street, Direction blockSide) {
        super(id, name, blockId, street, blockSide);
    }
} // end class StreetStation