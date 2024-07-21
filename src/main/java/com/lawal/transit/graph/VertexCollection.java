package com.lawal.transit.graph;

import com.lawal.transit.globals.*;

import java.util.*;

public interface VertexCollection {

    public int getOrder ();
    public Iterator<Vertex> iterator ();
    public void add (Vertex vertex) throws Exception;
    public void remove (Vertex vertex) throws Exception;
    public Vertex search (FormattedAddress address);
}
