package com.lawal.transit.graph.interfaces;

import com.lawal.transit.addresses.*;
import com.lawal.transit.addresses.interfaces.*;

public interface DirectedVertex<Addressable> extends Vertex<Addressable> {

    public EdgeCollection<DirectedVertex<Addressable>> getIncomingEdges ();
    public EdgeCollection<DirectedVertex<Addressable>> getOutgoingEdges ();

}
