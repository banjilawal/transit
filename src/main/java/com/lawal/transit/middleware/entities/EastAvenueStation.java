package com.lawal.transit.middleware.entities;
import com.lawal.transit.middleware.abstracts.AvenueStation;
import com.lawal.transit.middleware.abstracts.Station;
import com.lawal.transit.middleware.enums.Direction;

public class EastAvenueStation extends AvenueStation {

    public EastAvenueStation (int id, String name, int blockId, Avenue avenue) {
        super(id, name, blockId, avenue, Direction.EAST);
    }
} // end class EastAvenueStation