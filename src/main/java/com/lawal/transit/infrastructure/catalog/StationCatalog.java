package com.lawal.transit.infrastructure.catalog;

import com.lawal.transit.infrastructure.avenue.Avenue;
import com.lawal.transit.infrastructure.curb.Curb;
import com.lawal.transit.common.Direction;
import com.lawal.transit.infrastructure.junction.Junction;
import com.lawal.transit.infrastructure.road.Road;
import com.lawal.transit.infrastructure.station.Station;
import com.lawal.transit.infrastructure.street.Street;
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

    public int size() {
        return catalog.size();
    }

    public void addStation(Station station) {
        if (station == null) return;
        if (catalog.contains(station)) return;
        catalog.add(station);
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

    public List<Station> filterByCurb(Curb curb) {
        List<Station> matches = new ArrayList<>();
        if (curb == null) return matches;

        for (Station station : catalog) {
            Curb stationCurb = station.getBlock().getCurb();
            if (stationCurb != null && stationCurb.equals(curb) && !matches.contains(station)) matches.add(station);
        }

        return matches;
    }

    public List<Station> filterByRoad(Road road) {
        List<Station> matches = new ArrayList<>();
        if (road == null) return matches;

        for (Station station : catalog) {
            Road stationRoad = station.getBlock().getCurb().getRoad();
            if (stationRoad != null && stationRoad.equals(road) && !matches.contains(station)) {
//                System.out.println("BINGO!! StationCatalog.(filterByRoad():" + road + "match" + "stationRoad:" + stationRoad);
                matches.add(station);
//                System.out.println("matches.size()=" + matches.size());
            }
        }
        return matches;
    }
}