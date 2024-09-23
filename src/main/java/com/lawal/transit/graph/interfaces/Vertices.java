package com.lawal.transit.graph.interfaces;

import com.lawal.transit.addressing.Addressable;

import java.util.Iterator;
import java.util.List;

public interface Vertices {

    List<Vertex> toList ();
    void add (Vertex vertex) throws Exception;
    void remove (Vertex vertex) throws Exception;
    Vertex find (int id);
    Vertex find (Addressable key);
    Iterator<Vertex> iterator ();
}