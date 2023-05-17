package com.lawal.transit.middleware.abstracts;
import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.enums.Direction;
import com.lawal.transit.middleware.enums.RoadLane;

public abstract class AvenueStation extends Station {

    public AvenueStation (int id, String name, int blockId, Avenue avenue, Direction blockSide) {
        super(id, name, blockId, avenue, blockSide);
    }
} // end class AvenueStation