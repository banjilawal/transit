package com.lawal.transit.buildings;

import com.lawal.transit.globals.*;
import javafx.collections.*;

import java.util.*;

public class Buildings implements AddressableCollection {
    public static final String ADDITION_ERROR = "The item is already in the list. It cannot be added again";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";
    private final List<Addressable> buildings;

    public Buildings () {
        this.buildings = new ArrayList<>();
    }

    @Override
    public int size () {
        return buildings.size();
    }

    @Override
    public Iterator<Addressable> iterator () {
        return buildings.iterator();
    }

    @Override
    public void add (Addressable addressable) throws Exception {
        for (Addressable building : buildings) {
            if (building.getAddress().equals(addressable.getAddress()))
                throw new Exception(ADDITION_ERROR);
        }
        buildings.add(buildings.size(), addressable);
    }

    @Override
    public void remove (Addressable addressable) throws Exception {
        int index = buildings.indexOf(addressable);
        if (index < 0) {
            throw new Exception(REMOVAL_ERROR);
        }
        buildings.remove(index);
    }

    @Override
    public Addressable search (FormattedAddress address) {
        for (Addressable location : buildings) {
            if (location.getAddress().equals(address))
                return location;
        }
        return null;
    }
}
