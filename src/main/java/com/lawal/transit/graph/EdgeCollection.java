package com.lawal.transit.graph;

import com.lawal.transit.road.*;

import java.util.*;

public interface EdgeCollection {

    public int getDegree ();
    public Iterator<Edgeable> iterator ();
    public Edgeable search (RoadIdentifiable roadIdentifier);
    public void add (Edgeable edgeable) throws Exception;
    public void remove (Edgeable edgeable) throws Exception;
}
