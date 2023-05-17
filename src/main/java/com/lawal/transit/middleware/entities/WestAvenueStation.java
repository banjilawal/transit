package com.lawal.transit.middleware.entities;
import com.lawal.transit.middleware.abstracts.AvenueStation;
import com.lawal.transit.middleware.abstracts.Station;
import com.lawal.transit.middleware.enums.Direction;

public class WestAvenueStation extends AvenueStation {

    public WestAvenueStation (int id, String name, int blockId, Avenue avenue) {
        super(id, name, blockId, avenue, Direction.WEST);
    }
} // end class WestAvenueStation