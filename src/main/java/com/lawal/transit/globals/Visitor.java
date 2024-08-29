package com.lawal.transit.globals;

import com.lawal.transit.places.interfaces.*;
import com.lawal.transit.stations.interfaces.*;

public interface Visitor {

    void visit (Placeable placeable);
    void visit (Stationable stationable);
}
