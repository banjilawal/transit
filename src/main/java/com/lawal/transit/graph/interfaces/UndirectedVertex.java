package com.lawal.transit.graph.interfaces;

import com.lawal.transit.addresses.*;
import com.lawal.transit.addresses.interfaces.*;

public interface UndirectedVertex<Addressable> extends Vertex<Addressable> {

    public EdgeCollection<UndirectedVertex<Addressable>> getEdges ();
}
