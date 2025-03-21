package com.lawal.transit.infrastructure.catalog;

import com.lawal.transit.infrastructure.avenue.Avenue;

import com.lawal.transit.infrastructure.block.BlockEdge;
import com.lawal.transit.infrastructure.station.Station;
import com.lawal.transit.infrastructure.street.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum BlockEdgeCatalog {
    INSTANCE;

    private final List<BlockEdge> catalog;

    BlockEdgeCatalog () { catalog = new ArrayList<>(); }


    public void addEdge(BlockEdge blockEdge) {
        if (blockEdge == null) {
            System.out.println("BlockEdgeCatalog.addEdge(): null blockEdge");
            return;
        }
        if (catalog.contains(blockEdge)) {
            System.out.println("BlockEdgeCatalog.addEdge(): already contains " + blockEdge.getId() + " catalog size:" + catalog.size());
            return;
        }
//        System.out.println("BlockEdgeCatalog.add():" + blockEdge);
        catalog.add(blockEdge);
    }

    public BlockEdge findById(Long id) {
        if (id == null) return null;

        for (BlockEdge blockEdge : catalog) {
            if (blockEdge.getId().equals(id)) return blockEdge;
        }
        return null;
    }

    public List<BlockEdge> filterByAvenue(Avenue avenue) {
        List<BlockEdge> matches = new ArrayList<>();
        if (avenue == null) return matches;

        for (BlockEdge blockEdge : catalog) {
            if (blockEdge.containsAvenue(avenue)) {
//                System.out.println("BlockEdgeCatalog.filterByAvenue():" + blockEdge.getId());
                matches.add(blockEdge);
            }
            else {
                System.out.println("BlockEdgeCatalog.filterByAvenue() failure:" + blockEdge.getId());
            }
        }
        System.out.println("BlockEdgeCatalog.filterByAvenue() filtered:" + catalog.size());
        return matches;
    }

    public List<BlockEdge> filterByStreet(Street street) {
        List<BlockEdge> matches = new ArrayList<>();
        if (street == null) return matches;

        for (BlockEdge blockEdge : catalog) {
            Street headStreet = blockEdge.getHead().getCurb().getStreet();
            Street tailStreet = blockEdge.getTail().getCurb().getStreet();

            if ((headStreet != null && headStreet.equals(street) || (tailStreet != null && tailStreet.equals(street))
                && !matches.contains(blockEdge)))
                matches.add(blockEdge);
        }
        return matches;
    }

    public List<BlockEdge> filterByStation(Station station) {
        List<BlockEdge> matches = new ArrayList<>();
        if (station == null) return matches;

        for (BlockEdge blockEdge : catalog) {
            Station tailStation = blockEdge.getTail().getStation();
            Station headStation = blockEdge.getHead().getStation();
            if ((tailStation != null && tailStation.equals(station) || (headStation != null && headStation.equals(station))
                && !matches.contains(blockEdge)))
                matches.add(blockEdge);
        }
        return matches;
    }
}