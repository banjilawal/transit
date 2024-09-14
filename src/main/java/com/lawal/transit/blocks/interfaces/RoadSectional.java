package com.lawal.transit.blocks.interfaces;

import com.lawal.transit.globals.*;
import com.lawal.transit.places.interfaces.*;
import com.lawal.transit.stations.Station;
import com.lawal.transit.stations.Stations;

public interface RoadSectional {

    RoadSectionTag tag ();
    Placeables places ();
    Station getStation (Stations stations);
}

//package com.lawal.transit.roads.interfaces;
//
//import com.lawal.transit.blocks.interfaces.*;
//    import com.lawal.transit.globals.*;
//    import com.lawal.transit.stations.interfaces.*;
//
//public interface RoadSectional {
//
//    Stationables stations ();
//    RoadSectionals blocks ();
//    Direction trafficDirection ();
//}