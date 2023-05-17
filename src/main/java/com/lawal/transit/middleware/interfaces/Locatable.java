package com.lawal.transit.middleware.interfaces;

import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.abstracts.SimplexPath;
import com.lawal.transit.middleware.enums.Direction;

public interface Locatable {
    void setRoad (Direction curbSide);
    Road getRoad ();
    SimplexPath getRoadLane ();
} // end interface
