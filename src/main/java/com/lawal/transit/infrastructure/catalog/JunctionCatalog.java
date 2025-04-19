package com.lawal.transit.infrastructure.catalog;


import com.lawal.transit.infrastructure.avenue.Avenue;
import com.lawal.transit.infrastructure.block.Block;
import com.lawal.transit.infrastructure.junction.Junction;
import com.lawal.transit.infrastructure.junction.JunctionCorner;
import com.lawal.transit.infrastructure.road.Road;
import com.lawal.transit.infrastructure.station.Station;
import com.lawal.transit.infrastructure.street.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
        if (catalog.contains(junction)) {
            System.out.println("Junction already exists: " + junction.getId() + " catalog size: " + catalog.size());
            return;
        }
        catalog.add(junction);
    }

    public Junction findById(Long id) {
        if (id == null) return null;

        for (Junction junction : catalog) {
            if (junction.getId().equals(id)) return junction;
        }
        return null;
    }

    public Set<Junction> filterByAvenue(Avenue avenue) {
        Set<Junction> matches = new HashSet<>();
        if (avenue == null) return matches;

        for (Junction junction : catalog) {
            if (junction.getAvenue().equals(avenue)) matches.add(junction);
        }
        return matches;
    }

    public Set<Junction> filterByStreet(Street street) {
        Set<Junction> matches = new HashSet<>();
        if (street == null) return matches;

        for (Junction junction : catalog) {
            if (junction.getStreet().equals(street)) matches.add(junction);
        }
        return matches;
    }

    public Set<Junction> filterByBlock(Block block) {
        Set<Junction> matches = new HashSet<>();
        if (block == null) return matches;

        for (Junction junction : catalog) {
            for (JunctionCorner corner : junction.getCorners()) {
                if (corner.containsBlock(block)) matches.add(junction);
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