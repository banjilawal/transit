package com.lawal.transit.middleware.interfaces;

import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.entities.Street;
import com.lawal.transit.middleware.populator.*;

public interface NameAssigner {
    String assignName(BlockPopulator blockPopulator, Street northStreet, Avenue eastAvenue);
    String assignName (BuildingPopulator buildingPopulator, int buildingNumber);
//    String assignName (TransitRoutePopulator transitRoutePopulator);
//    String assignName(StationPopulator stationPopulator, int stationNumber);
    String assignName (RoadPopulator roadPopulator, Road road, int roadId);
} // end interface NameAssigner
