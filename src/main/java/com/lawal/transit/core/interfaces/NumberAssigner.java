package com.lawal.transit.core.interfaces;

import com.lawal.transit.core.populator.*;

public interface NumberAssigner {
//  int assignNumber (IntersectionPopulator intersectionPopulator);
    int assignNumber (BuildingPopulator buildingPopulator);
//    int assignNumber (StationPopulator stationPopulator);
    int assignNumber (BlockPopulator blockPopulator);
    int assignNumber (RoadPopulator roadPopulator);
    int assignNumber (RegularBusRoutePopulator busRoutePopulator);
    int assignNumber (ExpressBusRoutePopulator busRoutePopulator);
} // end interface NumberAssigner
