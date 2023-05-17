package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.abstracts.*;
import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.entities.Street;

import java.util.Iterator;

public enum Buildings {
    INSTANCE;
    AvenueBuildings avenueBuildings = AvenueBuildings.INSTANCE;
    StreetBuildings streetBuildings = StreetBuildings.INSTANCE;

    public Building search (String buildingName, String roadName) {
        Road road = Roads.INSTANCE.search(roadName);
        if (road instanceof Avenue) {
            return searchAvenues(buildingName, ((Avenue) road));
        }
        return searchStreets(buildingName, ((Street) road));
    } // close search

    public String toString () {
        return "\t\t\tBuildings\n\t\t--------------\n" + avenueBuildings.toString() + "\n" + streetBuildings.toString();
    }
    public String fullString () {
        return toString();
    }

    private Building searchAvenues (String buildingName, Avenue targetAvenue) {
        for (Iterator<AvenueBuilding> iterator = avenueBuildings.iterator(); iterator.hasNext();) {
            AvenueBuilding avenueBuilding = (AvenueBuilding) iterator.next();
            Avenue avenue = (Avenue) avenueBuilding.getBlockRoad();
            if (avenue.equals(targetAvenue) && avenueBuilding.getName().equalsIgnoreCase(buildingName)) {
                return avenueBuilding;
            }
        }
        return null;
    } // close searchAvenues

    private Building searchStreets (String buildingName, Street targetStreet) {
        for (Iterator<StreetBuilding> iterator = streetBuildings.iterator(); iterator.hasNext();) {
            StreetBuilding streetBuilding = (StreetBuilding) iterator.next();
            Street street = (Street) streetBuilding.getBlockRoad();
            if (street.equals(targetStreet) && streetBuilding.getName().equalsIgnoreCase(buildingName)) {
                return streetBuilding;
            }
        }
        return null;
    } // close searchAvenues
} // end class Buildings