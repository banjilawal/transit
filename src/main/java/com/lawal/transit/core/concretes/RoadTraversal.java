package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.abstracts.Traversal;
import com.lawal.transit.core.enums.Direction;

public class RoadTraversal extends Traversal {
    public RoadTraversal (Road road, Direction direction) {
        super(road, direction);
    }
} // end class Roadtraversal
