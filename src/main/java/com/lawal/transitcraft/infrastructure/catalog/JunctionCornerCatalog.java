package com.lawal.transitcraft.infrastructure.catalog;


import com.lawal.transitcraft.infrastructure.block.Block;
import com.lawal.transitcraft.common.Direction;
import com.lawal.transitcraft.infrastructure.junction.Junction;
import com.lawal.transitcraft.infrastructure.junction.JunctionCorner;
import com.lawal.transitcraft.infrastructure.avenue.Avenue;
import com.lawal.transitcraft.infrastructure.station.Station;
import com.lawal.transitcraft.infrastructure.street.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
public enum JunctionCornerCatalog {
    INSTANCE;

    private final List<JunctionCorner> catalog;

    JunctionCornerCatalog() {
        catalog = new ArrayList<>();
    }

//    public List<JunctionCorner> getCatalog() { return List.copyOf(catalog); }

    public int size() { return catalog.size(); }

    public Iterator<JunctionCorner> iterator() { return catalog.iterator(); }

    public void addCorner (JunctionCorner corner) {
        if (corner == null) return;
        if (catalog.contains(corner)) {
            System.out.println("JunctionCorner " + corner.getId() + " already exists catalog size:" + catalog.size() );
        }
        catalog.add(corner);
    }

    public JunctionCorner findById(Long id) {
        if (id == null) return null;

        for (JunctionCorner corner : catalog) {
            if (corner.getId().equals(id)) return corner;
        }
        return null;
    }

    public List<JunctionCorner> filterByJunction (Junction junction) {
        if (junction == null) return null;

        List<JunctionCorner> matches = new ArrayList<>();
        for (JunctionCorner corner : catalog) {
            if (corner.getJunction().equals(junction) && !matches.contains(corner)) matches.add(corner);
        }
        return matches;
    }

    public List<JunctionCorner> filterByAvenue (Avenue avenue) {
        if (avenue == null) return null;

        List<JunctionCorner> matches = new ArrayList<>();
        for (JunctionCorner corner : catalog) {
            if (corner.getJunction().getAvenue().equals(avenue) && !matches.contains(corner)) matches.add(corner);
        }
        return matches;
    }

    public List<JunctionCorner> filterByStreet (Street street) {
        if (street == null) return null;

        List<JunctionCorner> matches = new ArrayList<>();
        for (JunctionCorner corner : catalog) {
            if (corner.getJunction().getStreet().equals(street) && !matches.contains(corner)) matches.add(corner);
        }
        return matches;
    }

    public List<JunctionCorner> filterByBlock(Block block) {
        if (block == null) return null;

        List<JunctionCorner> matches = new ArrayList<>();
        for (JunctionCorner corner : catalog) {
            if (corner.getAvenueLeg().equals(block) || corner.getStreetLeg().equals(block) && !matches.contains(corner))
                matches.add(corner);
        }
        return matches;
    }

    public List<JunctionCorner> filterByOrientation(Direction orientation) {
        if (orientation == null) return null;

        List<JunctionCorner> matches = new ArrayList<>();
        for (JunctionCorner corner : catalog) {
            if (corner.getOrientation() == orientation && !matches.contains(corner)) matches.add(corner);
        }
        return matches;
    }

    public List<JunctionCorner> filterByStation(Station station) {
        if (station == null) return null;

        List<JunctionCorner> matches = new ArrayList<>();
        for (JunctionCorner corner : catalog) {
            if (corner.getLegByStation(station) != null && !matches.contains(corner)) matches.add(corner);
        }
        return matches;
    }

    public JunctionCorner getFirst() {
        return catalog.get(0);
    }

    public JunctionCorner getLast() {
        return catalog.get(catalog.size() - 1);
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (JunctionCorner corner : catalog) {
            stringBuilder.append(corner.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}