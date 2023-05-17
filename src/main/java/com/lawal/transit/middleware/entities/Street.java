package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.abstracts.SimplexPath;
import com.lawal.transit.middleware.enums.Direction;
import com.lawal.transit.middleware.enums.RoadCategory;
import com.lawal.transit.middleware.enums.RoadDirection;

public class Street extends Road {
    public Street (int id, String name) {
        this(id, name, (new SimplexPath(Direction.EAST)), (new SimplexPath(Direction.EAST.oppositeDirection())), RoadDirection.EAST_WEST, RoadCategory.STREET);
    }

    public Street (int id, String name, SimplexPath forwardPath, SimplexPath reversePath, RoadDirection roadDirection, RoadCategory roadCategory) {
        super(id, name, forwardPath, reversePath, roadDirection, roadCategory);
    }

    public SimplexPath getEastLane () {
        return getForwardPath();
    }

    public SimplexPath getWestLane () {
        return getReversePath();
    }
} // end class Street
