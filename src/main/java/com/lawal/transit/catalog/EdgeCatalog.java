package com.lawal.transit.catalog;

import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.edge.model.Edge;
import com.lawal.transit.station.model.Station;
import com.lawal.transit.street.model.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum EdgeCatalog {
    INSTANCE;

    private final List<Edge> catalog;

    EdgeCatalog () { catalog = new ArrayList<>(); }

//    public List<Edge> getCatalog() {
//        return List.copyOf(catalog);
//    }

    public void addEdge(Edge edge) {
        if (edge == null) {
            System.out.println("EdgeCatalog.addEdge(): null edge");
            return;
        }
        if (catalog.contains(edge)) return;
        System.out.println("EdgeCatalog.add():" + edge);
        catalog.add(edge);
    }

    public Edge findById(Long id) {
        if (id == null) return null;

        for (Edge edge : catalog) {
            if (edge.getId().equals(id)) return edge;
        }
        return null;
    }

    public List<Edge> filterByAvenue(Avenue avenue) {
        List<Edge> matches = new ArrayList<>();
        if (avenue == null) return matches;

        for (Edge edge : catalog) {
            Avenue headAvenue = edge.getHeadStation().getBlock().getAvenue();
            Avenue tailAvenue = edge.getTailStation().getBlock().getAvenue();

            if ((headAvenue != null && headAvenue.equals(avenue) || (tailAvenue != null && tailAvenue.equals(avenue))
                && !matches.contains(edge)))
                matches.add(edge);
        }
        return matches;
    }

    public List<Edge> filterByStreet(Street street) {
        List<Edge> matches = new ArrayList<>();
        if (street == null) return matches;

        for (Edge edge : catalog) {
            Street headStreet = edge.getHeadStation().getBlock().getStreet();
            Street tailStreet = edge.getTailStation().getBlock().getStreet();

            if ((headStreet != null && headStreet.equals(street) || (tailStreet != null && tailStreet.equals(street))
                && !matches.contains(edge)))
                matches.add(edge);
        }
        return matches;
    }

    public List<Edge> filterByStation(Station station) {
        List<Edge> matches = new ArrayList<>();
        if (station == null) return matches;

        for (Edge edge : catalog) {
            if (edge.getTailStation().equals(station) || edge.getHeadStation().equals(station) && !matches.contains(edge))
                matches.add(edge);
        }
        return matches;
    }
}