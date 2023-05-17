package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.abstracts.SimplexPath;
import com.lawal.transit.middleware.enums.Direction;
import com.lawal.transit.middleware.enums.RoadCategory;
import com.lawal.transit.middleware.enums.RoadDirection;

public class Avenue extends Road {
    public Avenue(int id, String name) {
        this(id, name, (new SimplexPath(Direction.NORTH)), (new SimplexPath(Direction.NORTH.oppositeDirection())), RoadDirection.NORTH_SOUTH, RoadCategory.AVENUE);
    }

    public Avenue(int id, String name, SimplexPath forwardPath, SimplexPath reversePath, RoadDirection roadDirection, RoadCategory roadCategory) {
        super(id, name, forwardPath, reversePath, roadDirection, roadCategory);
    }

    public SimplexPath getNorthLane () {
        return getForwardPath();
    }

    public SimplexPath getSouthLane () {
        return getReversePath();
    }
} // end class Avenue
