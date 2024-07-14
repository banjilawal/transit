package com.lawal.transit.graph.interfaces;

import com.lawal.transit.road.interfaces.*;

import java.util.*;

public interface EdgeCollection {

    public int getDegree ();
    public Iterator<Edgeable> iterator ();
    public Edgeable search (RoadIdentifiable roadIdentifier);
    public void add (Edgeable edgeable) throws Exception;
    public void remove (Edgeable edgeable) throws Exception;
}
