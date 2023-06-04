package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.abstracts.SimplexPath;
import com.lawal.transit.core.enums.Direction;

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
