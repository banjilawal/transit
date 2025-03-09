package com.lawal.transit.catalog;


import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.curb.model.Curb;
import com.lawal.transit.global.Direction;
import com.lawal.transit.street.model.Street;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum CurbCatalog {
    INSTANCE;

    private final List<Curb> catalog;

    CurbCatalog () {
        catalog = new ArrayList<>();
    }

//    public List<Curb> getCatalog() {
//        return List.copyOf(catalog);
//    }

    public void addCurb(Curb curb) {
        if (curb == null) return;
        if (catalog.contains(curb)) return;
        catalog.add(curb);
    }


    public Curb findById(Long id) {
        if (id == null) return null;

        for (Curb curb : catalog) {
            if (curb.getId().equals(id)) {
                return curb;
            }
        }
        return null;
    }

    public List<Curb> filterByAvenue(Avenue avenue) {
        if (avenue == null) return null;

        List<Curb> matches = new ArrayList<>();
        for (Curb curb : catalog) {
            if (curb.getAvenue() != null && curb.getAvenue().equals(avenue) && !matches.contains(curb)) {
                matches.add(curb);
            }
        }
        return matches;
    }

    public List<Curb> filterByStreet(Street street) {
        if (street == null) return null;

        List<Curb> matches = new ArrayList<>();
        for (Curb curb : catalog) {
            if (curb.getStreet() != null && curb.getStreet().equals(street) && !matches.contains(curb)) {
                matches.add(curb);
            }
        }
        return matches;
    }

    public List<Curb> filterByOrientation(Direction orientation) {
        if (orientation == null) return null;

        List<Curb> matches = new ArrayList<>();
        for (Curb curb : catalog) {
            if (curb.getOrientation().equals(orientation) && !matches.contains(curb)) matches.add(curb);
        }
        return matches;
    }
}