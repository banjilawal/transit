package com.lawal.transit.core.interfaces;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.entities.Avenue;
import com.lawal.transit.core.entities.Street;
import com.lawal.transit.core.populator.*;

public interface NameAssigner {
    String assignName(BlockPopulator blockPopulator, Street northStreet, Avenue eastAvenue);
    String assignName (BuildingPopulator buildingPopulator, int buildingNumber);
//    String assignName (TransitRoutePopulator transitRoutePopulator);
    String assignName(StationPopulator stationPopulator, int previousStationNumber);
    String assignName (RoadPopulator roadPopulator, Road road, int roadId);
    String assignName (RegularBusRoutePopulator busRoutePopulator);
    String assignName (ExpressBusRoutePopulator busRoutePopulator);
} // end interface NameAssigner
