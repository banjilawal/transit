package com.lawal.transit.graph.interfaces;

import com.lawal.transit.addresses.interfaces.*;

import java.util.*;

public interface EdgeCollection<Vertex> {

    public int getDegree ();
    public Iterator<Edgeable<Vertex>> iterator ();
    public Edgeable<Vertex> search (RoadLabeler roadLabeler);
    public void add (Edgeable<Vertex> edgeable) throws Exception;
    public void remove (Edgeable<Vertex> edgeable) throws Exception;
}
