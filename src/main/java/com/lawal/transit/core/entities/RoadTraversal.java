package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.abstracts.Traverse;
import com.lawal.transit.core.enums.Direction;

public class RoadTraversal extends Traverse {
    public RoadTraversal (Road road, Direction direction) {
        super(road, direction);
    }
} // end class Roadtraversal
