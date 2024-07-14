package com.lawal.transit.road.interfaces;

import java.util.*;

public interface RoadCollection {

    public int numberOfRoads ();
    public Iterator<Road> iterator();
    public void add (Road road) throws Exception;
    public Road search (RoadIdentifiable identifier);
    public void remove (RoadIdentifiable identifier) throws Exception;

}
