package com.lawal.transit.catalog;


import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.junction.Junctions;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.JunctionCorner;
import com.lawal.transit.road.model.Road;
import com.lawal.transit.station.model.Station;
import com.lawal.transit.street.model.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;


@Getter
public enum JunctionCatalog {
    INSTANCE;

    private final List<Junction> catalog;

    JunctionCatalog () {
        catalog = new ArrayList<>();
    }

    public List<Junction> getCatalog() { return List.copyOf(catalog); }

    public int size() { return catalog.size(); }

    public void addJunction(Junction junction) {
        if (junction == null) return;
        if (catalog.contains(junction)) return;
        catalog.add(junction);
    }

    public Junction findById(Long id) {
        if (id == null) return null;

        for (Junction junction : catalog) {
            if (junction.getId().equals(id)) return junction;
        }
        return null;
    }

    public List<Junction> filterByAvenue(Avenue avenue) {
        if (avenue == null) return null;

        List<Junction> matches = new ArrayList<>();
        for (Junction junction : catalog) {
            if (junction.getAvenue().equals(avenue) && !matches.contains(junction)) matches.add(junction);
        }
        return matches;
    }

    public List<Junction> filterByStreet(Street street) {
        if (street == null) return null;

        List<Junction> matches = new ArrayList<>();
        for (Junction junction : catalog) {
            if (junction.getStreet().equals(street) && !matches.contains(junction)) matches.add(junction);
        }
        return matches;
    }

    public List<Junction> filterByBlock(Block block) {
        List<Junction> matches = new ArrayList<>();
        if (block == null) return matches;

        for (Junction junction : catalog) {
            for (JunctionCorner corner : junction.getCorners()) {
                if (corner.getAvenueLeg().equals(block) || corner.getStreetLeg().equals(block)) matches.add(junction);
            }
        }
        return matches;
    }

    public List<Junction> filterByRoad(Road road) {
        List<Junction> matches = new ArrayList<>();
        if (road == null) return matches;

        for (Junction junction : catalog) {
            if (!junction.filterCornersByRoad(road).isEmpty()) matches.add(junction);
        }
        return matches;
    }

    public List<Junction> filterByStation(Station station) {
        if (station == null) return null;

        List<Junction> matches = new ArrayList<>();
        for (Junction junction : catalog) {
            if (junction.getCornerByStation(station) != null && !matches.contains(junction)) matches.add(junction);
        }
        return matches;
    }

    public Junction getFirst() {
        return catalog.get(0);
    }
}