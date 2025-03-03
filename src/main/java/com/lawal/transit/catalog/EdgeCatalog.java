package com.lawal.transit.catalog;

import com.lawal.transit.edge.model.Edge;
import com.lawal.transit.station.model.Station;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum EdgeCatalog {
    INSTANCE;

    private final List<Edge> catalog;

    EdgeCatalog () { catalog = new ArrayList<>(); }

    public Edge findById(Long id) {
        if (id == null) return null;

        for (Edge edge : catalog) {
            if (edge.getId().equals(id)) return edge;
        }
        return null;
    }

    public List<Edge> filterByStation(Station station) {
        if (station == null) return null;

        List<Edge> matches = new ArrayList<>();
        for (Edge edge : catalog) {
            if (edge.getTailStation().equals(station) || edge.getHeadStation().equals(station) && !matches.contains(edge))
                matches.add(edge);
        }
        return matches;
    }
}