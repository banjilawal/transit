package com.lawal.transit.globals;

import com.lawal.transit.graph.interfaces.Vertex;
import com.lawal.transit.places.interfaces.*;

public interface Visitor {

    void visit (Placeable placeable);
    void visit (Vertex vertex);
}