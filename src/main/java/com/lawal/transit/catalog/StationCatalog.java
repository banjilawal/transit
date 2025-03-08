package com.lawal.transit.catalog;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.global.Direction;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.station.Stations;
import com.lawal.transit.station.model.Station;
import com.lawal.transit.street.model.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum StationCatalog {
    INSTANCE;

    private final List<Station> catalog;

    StationCatalog () {
        catalog = new ArrayList<>();
    }

    public Station findById(Long id) {
        if (id == null) return null;

        for (Station station : catalog) {
            if (station.getId().equals(id)) return station;
        }
        return null;
    }

    public List<Station> filterByAvenue(Avenue avenue) {
        if (avenue == null) return null;

        List<Station> matches = new ArrayList<>();
        for (Station station : catalog) {
            Avenue stationAvenue = station.getBlock().getCurb().getAvenue();
            if (stationAvenue != null && stationAvenue.equals(avenue) && !matches.contains(station)) matches.add(station);
        }
        return matches;
    }

    public List<Station> filterByStreets(Street street) {
        if (street == null) return null;

        List<Station> matches = new ArrayList<>();
        for (Station station : catalog) {
            Street stationStreet = station.getBlock().getCurb().getStreet();
            if (stationStreet != null && stationStreet.equals(street) && !matches.contains(station)) matches.add(station);
        }
        return matches;
    }

    public List<Station> filterByOrientation(Direction orientation) {
        if (orientation == null) return null;

        List<Station> matches = new ArrayList<>();
        for (Station station : catalog) {
            if (station.getBlock().getCurb().getOrientation().equals(orientation) && !matches.contains(station))
                matches.add(station);
        }
        return matches;
    }

    public List<Station> filterByJunction(Junction junction) {
        if (junction == null) return null;

        List<Station> matches = new ArrayList<>();
        for (Station station : catalog) {
            if (junction.getCornerByStation(station) != null && !matches.contains(station)) matches.add(station);
        }
        return matches;
    }

    public List<Station> filterByRoad(Road road) {
        List<Station> matches = new ArrayList<>();
        if (road == null) return matches;

        for (Station station : catalog) {
            Road stationRoad = station.getBlock().getCurb().getRoad();
            if (stationRoad != null && stationRoad.equals(road) && !matches.contains(station)) matches.add(station);
        }
        return matches;
    }
}