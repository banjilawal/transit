package com.lawal.transit.globals;

import com.lawal.transit.*;
import com.lawal.transit.road.interfaces.*;

public interface FormattedAddress {
    public int getId ();
    public String getName ();
    public Orientation getOrientation ();
    public RoadIdentifiable getRoadIdentity ();
}
