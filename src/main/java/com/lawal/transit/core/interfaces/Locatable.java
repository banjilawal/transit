package com.lawal.transit.core.interfaces;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.abstracts.SimplexPath;
import com.lawal.transit.core.enums.Direction;

public interface Locatable {
    void setRoad (Direction curbSide);
    Road getRoad ();
   // SimplexPath getRoadLane ();
} // end interface
