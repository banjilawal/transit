package com.lawal.transit.catalog;


import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.route.model.TransitRoute;
import com.lawal.transit.route.model.TransitStop;
import com.lawal.transit.station.model.Station;
import com.lawal.transit.street.model.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum StopCatalog {
    INSTANCE;

    private final List<TransitStop> catalog;

    StopCatalog () {
        catalog = new ArrayList<>();
    }

    public TransitStop findById(Long id) {
        if (id == null) return null;

        for (TransitStop transitStop : catalog) {
            if (transitStop.getId().equals(id)) {
                return transitStop;
            }
        }
        return null;
    }

    public List<TransitStop> filterByRoute(TransitRoute route) {
        List<TransitStop> matches = new ArrayList<>();

        if (route == null) return matches;
        for (TransitStop transitStop : catalog) {
            if (transitStop.getRoute().equals(route) && !matches.contains(transitStop)) matches.add(transitStop);
        }
        return matches;
    }

    public List<TransitStop> filterByStation(Station station) {
        List<TransitStop> matches = new ArrayList<>();

        if (station == null) return matches;
        for (TransitStop transitStop : catalog) {
            if (transitStop.getStation().equals(station) && !matches.contains(transitStop)) matches.add(transitStop);
        }
        return matches;
    }

    public List<TransitStop> filterByAvenue(Avenue avenue) {
        List<TransitStop> matches = new ArrayList<>();

        if (avenue == null) return matches;
        for (TransitStop transitStop : catalog) {
            Avenue stationAvenue = transitStop.getStation().getBlock().getAvenue();

            if (stationAvenue != null && stationAvenue.equals(avenue) && !matches.contains(transitStop))
                matches.add(transitStop);
        }
        return matches;
    }

    public List<TransitStop> filterByStreet(Street street) {
        List<TransitStop> matches = new ArrayList<>();

        if (street == null) return matches;
        for (TransitStop transitStop : catalog) {
            Street stationStreet = transitStop.getStation().getBlock().getStreet();

            if (stationStreet != null && stationStreet.equals(street) && !matches.contains(transitStop))
                matches.add(transitStop);
        }
        return matches;
    }
}