package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.*;
import com.lawal.transit.core.abstracts.AbstractRoad;
import com.lawal.transit.Orientation;

public class RoadTraversal extends Traversal {
    public RoadTraversal (AbstractRoad abstractRoad, Orientation orientation) {
        super(abstractRoad, orientation);
    }
} // end class Roadtraversal
