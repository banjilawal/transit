package com.lawal.transit.middleware.singletons;

import com.lawal.transit.middleware.abstracts.AvenueStation;
import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.abstracts.Station;
import com.lawal.transit.middleware.abstracts.StreetStation;
import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.entities.Street;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public enum Stations {
    INSTANCE;
    AvenueStations avenueStations = AvenueStations.INSTANCE;
    StreetStations streetStations = StreetStations.INSTANCE;

    public Station search (String stationName) {
        Station station = (Station) avenueStations.getBag().search(stationName);
        if (station == null) {
            station = (Station) streetStations.getBag().search(stationName);
        }
        return station;
    } // close search

    public boolean add (Station station) {
        if (station instanceof AvenueStation) {
            AvenueStation avenueStation = (AvenueStation) station;
            return avenueStations.add(avenueStation);
        }
        StreetStation streetStation = (StreetStation) station;
        return streetStations.add(streetStation);
    } // close add

    public boolean remove (Station station) {
        if (station instanceof AvenueStation) {
            AvenueStation avenueStation = (AvenueStation) station;
            return avenueStations.remove(avenueStation);
        }
        StreetStation streetStation = (StreetStation) station;
        return streetStations.remove(streetStation);
    } // close remove

    public boolean remove (String stationName) {
        return remove(search(stationName));
    } // close remove

    public ArrayList<String> filter (Road road) {
        ArrayList<String> stationNames = new ArrayList<>();
        if (road instanceof Avenue) {
            Avenue avenue= (Avenue) road;
            for (Iterator<AvenueStation> iterator = avenueStations.iterator(); iterator.hasNext();) {
                AvenueStation avenueStation = (AvenueStation) iterator.next();
                if (avenueStation.getBlockRoad().equals(avenue)) {
                    stationNames.add(avenueStation.getName());
                }
            }
            return stationNames;
        }
        Street street = (Street) road;
        for (Iterator<StreetStation> iterator = streetStations.iterator(); iterator.hasNext();) {
            StreetStation streetStation = (StreetStation) iterator.next();
            if (streetStation.getBlockRoad().equals(street)) {
                stationNames.add(streetStation.getName());
            }
        }
        return stationNames;
    } // close filter

    public String toString () {
        return "\t\t\tStations\n\t\t--------------\n" + avenueStations.toString() + "\n" + streetStations.toString();
    }
    public String fullString () {
        return toString();
    }
} // end class Stations