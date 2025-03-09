package com.lawal.transit.catalog;

import com.lawal.transit.avenue.model.Avenue;

import com.lawal.transit.block.model.BlockEdge;
import com.lawal.transit.station.model.Station;
import com.lawal.transit.street.model.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum BLockEdgeCatalog {
    INSTANCE;

    private final List<BlockEdge> catalog;

    BLockEdgeCatalog () { catalog = new ArrayList<>(); }


    public void addEdge(BlockEdge blockEdge) {
        if (blockEdge == null) {
            System.out.println("BlockEdgeCatalog.addEdge(): null blockEdge");
            return;
        }
        if (catalog.contains(blockEdge)) return;
        System.out.println("BlockEdgeCatalog.add():" + blockEdge);
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
            Avenue headAvenue = blockEdge.getHead().getCurb().getAvenue();
            Avenue tailAvenue = blockEdge.getTail().getCurb().getAvenue();

            if ((headAvenue != null && headAvenue.equals(avenue) || (tailAvenue != null && tailAvenue.equals(avenue))
                && !matches.contains(blockEdge)))
                matches.add(blockEdge);
        }
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