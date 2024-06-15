package com.lawal.transit.sections.interfaces;

import com.lawal.transit.*;
import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.road.interfaces.*;

public interface Borderable {

    public Orientation getOrientation ();
    public RoadLabeler getRoadLabel ();
}
