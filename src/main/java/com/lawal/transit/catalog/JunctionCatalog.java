package com.lawal.transit.catalog;


import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.junction.Junctions;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.JunctionCorner;
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
        if (block == null) return null;

        List<Junction> matches = new ArrayList<>();
        for (Junction junction : catalog) {
            if (junction.getCornerByBlock(block) != null && !matches.contains(junction)) matches.add(junction);
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
}