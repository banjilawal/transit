package com.lawal.transit.middleware.interfaces;

import com.lawal.transit.middleware.populator.*;

public interface NumberAssigner {
//  int assignNumber (IntersectionPopulator intersectionPopulator);
//    int assignNumber (TransitRoutePopulator transitRoutePopulator);
    int assignNumber (BuildingPopulator buildingPopulator);
//    int assignNumber (StationPopulator stationPopulator);
    int assignNumber (BlockPopulator blockPopulator);
    int assignNumber (RoadPopulator roadPopulator);
} // end interface NumberAssigner
