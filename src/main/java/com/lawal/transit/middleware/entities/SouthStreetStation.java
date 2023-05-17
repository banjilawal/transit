package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.Station;
import com.lawal.transit.middleware.abstracts.StreetStation;
import com.lawal.transit.middleware.enums.Direction;

public class SouthStreetStation extends StreetStation {

    public SouthStreetStation (int id, String name, int blockId, Street street) {
        super(id, name, blockId, street, Direction.SOUTH);
    }
} // end class SouthStreetStation