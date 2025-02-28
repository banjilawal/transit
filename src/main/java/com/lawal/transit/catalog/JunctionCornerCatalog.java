package com.lawal.transit.catalog;


import com.lawal.transit.block.model.Block;
import com.lawal.transit.global.Direction;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.junction.model.JunctionCorner;
import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.street.model.Street;
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

    public List<JunctionCorner> getCorners() { return catalog; }

    public int size() { return catalog.size(); }

    public Iterator<JunctionCorner> iterator() { return catalog.iterator(); }

    public void addJunctionCorner(JunctionCorner corner) {
        catalog.add(corner);
    }

    public JunctionCorner findById(int id) {
        for (JunctionCorner corner : catalog) {
            if (corner.getId() == id) return corner;
        }
        return null;
    }

    public List<JunctionCorner> filterByJunction (Junction junction) {
        List<JunctionCorner> matches = new ArrayList<>();
        for (JunctionCorner corner : catalog) {
            if (corner.getJunction().equals(junction) && !matches.contains(corner)) matches.add(corner);
        }
        return matches;
    }

    public List<JunctionCorner> filterByAvenue (Avenue avenue) {
        List<JunctionCorner> matches = new ArrayList<>();
        for (JunctionCorner corner : catalog) {
            if (corner.getJunction().getAvenue().equals(avenue) && !matches.contains(corner)) matches.add(corner);
        }
        return matches;
    }

    public List<JunctionCorner> filterByStreet (Street street) {
        List<JunctionCorner> matches = new ArrayList<>();
        for (JunctionCorner corner : catalog) {
            if (corner.getJunction().getStreet().equals(street) && !matches.contains(corner)) matches.add(corner);
        }
        return matches;
    }

    public List<JunctionCorner> filterByBlock(Block block) {
        List<JunctionCorner> matches = new ArrayList<>();
        for (JunctionCorner corner : catalog) {
            if (corner.getAvenueLeg().equals(block) || corner.getStreetLeg().equals(block) && !matches.contains(corner))
                matches.add(corner);
        }
        return matches;
    }

    public List<JunctionCorner> filterByOrientation(Direction orientation) {
        List<JunctionCorner> matches = new ArrayList<>();
        for (JunctionCorner corner : catalog) {
            if (corner.getCornerOrientation() == orientation && !matches.contains(corner)) matches.add(corner);
        }
        return matches;
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