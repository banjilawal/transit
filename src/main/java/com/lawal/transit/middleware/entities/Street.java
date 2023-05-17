package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.abstracts.SimplexPath;
import com.lawal.transit.middleware.enums.Direction;
import com.lawal.transit.middleware.enums.RoadCategory;
import com.lawal.transit.middleware.enums.RoadDirection;

public class Street extends Road {

    public Street (int id, String name) {
        super(id, name, new SimplexPath(Direction.EAST));
    }

    public SimplexPath getEastLane () {
        return getLane();
    }

    public SimplexPath getWestLane () {
        return getOppositeLane();
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Street) {
            Street street = (Street) object;
            if (super.equals(street)) {
                return true;
            }
        }
        return false;
    } // close equals

} // end class Street
