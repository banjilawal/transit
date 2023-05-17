package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.Station;
import com.lawal.transit.middleware.abstracts.StreetStation;
import com.lawal.transit.middleware.enums.Direction;

public class NorthStreetStation extends StreetStation {

    public NorthStreetStation (int id, String name, int blockId, Street street) {
        super(id, name, blockId, street, Direction.NORTH);
    }
} // end class NorthStreetStation