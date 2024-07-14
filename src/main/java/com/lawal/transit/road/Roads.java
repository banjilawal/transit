package com.lawal.transit.road;

import com.lawal.transit.road.interfaces.*;

import java.util.*;

public final class Roads implements RoadCollection {

    public static final String NONEXISTENT_ROAD_REMOVAL_FAILURE = "The nonexistent road cannot be removed";

    private final List<Road> roads;

    public Roads () {
        roads = new ArrayList<>();
    }

    @Override
    public int numberOfRoads () {
        return roads.size();
    }

    @Override
    public Iterator<Road> iterator () {
        return roads.iterator();
    }

    @Override
    public void add (Road road) throws Exception {
        if (roads.contains(road))
            throw new Exception();
        roads.add(roads.size(), road);
    }

    @Override
    public Road search (RoadIdentifiable identifier) {
        for (Road road : roads) {
            if (road.getIdentifier().equals(identifier))
                return road;
        }
        return null;
    }

    @Override
    public void remove (RoadIdentifiable identifier) throws Exception {
        Road road = search(identifier);
        if (road == null)
            throw new Exception(NONEXISTENT_ROAD_REMOVAL_FAILURE);
        int index = roads.indexOf(road);
        roads.remove(index);
    }
}
