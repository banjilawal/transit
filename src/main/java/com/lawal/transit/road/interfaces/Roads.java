package com.lawal.transit.road.interfaces;

import java.util.*;

public interface Roads {

    public int size ();
    public Iterator<Road> iterator();
    public void add (Road road) throws Exception;
    public Road search (int roadId);
    public Road search (String roadName);
    public void remove (int roadId) throws Exception;
}