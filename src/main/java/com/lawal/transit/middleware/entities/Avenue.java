package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.abstracts.SimplexPath;
import com.lawal.transit.middleware.enums.Direction;
import com.lawal.transit.middleware.enums.RoadCategory;
import com.lawal.transit.middleware.enums.RoadDirection;

public class Avenue extends Road {

    public Avenue(int id, String name) {
        super(id, name, new SimplexPath(Direction.NORTH));
    }

    public SimplexPath getNorthLane () {
        return getLane();
    }

    public SimplexPath getSouthLane () {
        return getOppositeLane();
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Avenue) {
            Avenue avenue = (Avenue) object;
            if (super.equals(avenue)) {
                return true;
            }
        }
        return false;
    } // close equals
} // end class Avenue
