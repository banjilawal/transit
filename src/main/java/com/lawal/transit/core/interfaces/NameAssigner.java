package com.lawal.transit.core.interfaces;

import com.lawal.transit.core.abstracts.AbstractRoad;
import com.lawal.transit.core.concretes.Intersection;
import com.lawal.transit.test.populator.*;

public interface NameAssigner {
    String assignName(BlockPopulator blockPopulator, Intersection northWestCorner);
    String assignName (BuildingPopulator buildingPopulator, int buildingNumber);
//    String assignName (TransitRoutePopulator transitRoutePopulator);
    String assignName(StationPopulator stationPopulator, int previousStationNumber);
    String assignName (RoadPopulator roadPopulator, AbstractRoad abstractRoad, int roadId);
    String assignName (RegularBusRoutePopulator busRoutePopulator);
    String assignName (ExpressBusRoutePopulator busRoutePopulator);
} // end interface NameAssigner
