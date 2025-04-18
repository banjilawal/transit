package com.lawal.transit.infrastructure.catalog;


import com.lawal.transit.infrastructure.avenue.Avenue;
import com.lawal.transit.infrastructure.bus.BusRoute;
import com.lawal.transit.infrastructure.bus.Departure;
import com.lawal.transit.infrastructure.station.Station;
import com.lawal.transit.infrastructure.street.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum DepartureCatalog {
    INSTANCE;

    private final List<Departure> catalog;

    DepartureCatalog () {
        catalog = new ArrayList<>();
    }

    public List<Departure> getCatalog() {
        return List.copyOf(catalog);
    }

    public void addDeparture(Departure departure) {
        if (departure == null) return;
        if (catalog.contains(departure)) return;
        catalog.add(departure);
    }

    public Departure findById(Long id) {
        if (id == null) return null;

        for (Departure departure : catalog) {
            if (departure.getId().equals(id)) {
                return departure;
            }
        }
        return null;
    }

    public List<Departure> filterByRoute(BusRoute busRoute) {
        List<Departure> matches = new ArrayList<>();

        if (busRoute == null) return matches;
        for (Departure departure : catalog) {
            if (departure.getBusRoute().equals(busRoute) && !matches.contains(departure)) matches.add(departure);
        }
        return matches;
    }

    public List<Departure> filterByStation(Station station) {
        List<Departure> matches = new ArrayList<>();

        if (station == null) return matches;
        for (Departure departure : catalog) {
            if (departure.getStation().equals(station) && !matches.contains(departure)) matches.add(departure);
        }
        return matches;
    }

    public List<Departure> filterByAvenue(Avenue avenue) {
        List<Departure> matches = new ArrayList<>();

        if (avenue == null) return matches;
        for (Departure departure : catalog) {
            Avenue stationAvenue = departure.getStation().getBlock().getAvenue();

            if (stationAvenue != null && stationAvenue.equals(avenue) && !matches.contains(departure))
                matches.add(departure);
        }
        return matches;
    }

    public List<Departure> filterByStreet(Street street) {
        List<Departure> matches = new ArrayList<>();

        if (street == null) return matches;
        for (Departure departure : catalog) {
            Street stationStreet = departure.getStation().getBlock().getStreet();

            if (stationStreet != null && stationStreet.equals(street) && !matches.contains(departure))
                matches.add(departure);
        }
        return matches;
    }
}