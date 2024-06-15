package com.lawal.transit.sections.interfaces;

import com.lawal.transit.*;
import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.locations.interfaces.*;
import com.lawal.transit.road.interfaces.*;

import java.util.*;

public class Borders implements BorderCollection {

    public static final String ADDITION_ERROR = "The border already exists and cannot be added again.";
    public static final String REMOVAL_ERROR = "The border does not exist in the list so it cannot be removed";
    private final ArrayList<Borderable> borders;

    public Borders () {
        this.borders = new ArrayList<>();
    }

    @Override
    public int numberOfBorders () {
        return borders.size();
    }

    @Override
    public Iterator<Borderable> iterator () {
        return borders.iterator();
    }

    @Override
    public Borderable seacrh (RoadLabeler roadLabeler) {
        for (Borderable borderable : borders) {
            if (borderable.getRoadLabel().equals(roadLabeler))
                return borderable;
        }
        return null;
    }

    @Override
    public Borderable search (Orientation orientation) {
        for (Borderable borderable : borders) {
            if (borderable.getOrientation().equals(orientation))
                return borderable;
        }
        return null;
    }

    @Override
    public void add (Borderable borderable) throws Exception {
        if (borders.contains(borderable))
            throw new Exception(ADDITION_ERROR);
        borders.add(borders.size(), borderable);;
    }

    @Override
    public void remove (Borderable borderable) throws Exception {
        int index = borders.indexOf(borderable);
        if (index < 0)
            throw new Exception(REMOVAL_ERROR);
        borders.remove(index);
    }

    @Override
    public Borderable find (Orientation orientation) {
        for (Borderable borderable : borders)
            if (borderable.getOrientation().equals(orientation))
                return borderable;
        return null;
    }
}
