package com.lawal.transit.road;

import com.lawal.transit.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.graph.*;

public interface BorderLane extends Lane {

    public VertexCollection getStations ();
    public AddressableCollection getBuildings ();
}
