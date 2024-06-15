package com.lawal.transit.graph.interfaces;

import com.lawal.transit.addresses.interfaces.*;

import java.util.*;
import java.util.concurrent.*;

public interface VertexCollection<Vertex> extends GenericCollection<Vertex> {

    public int getOrder ();
    public Iterator<Vertex> iterator ();
    public Vertex search (Addressable addressable);
    public void add (Vertex vertex) throws Exception;
    public void remove (Vertex vertex) throws Exception;
}
