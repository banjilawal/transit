package com.lawal.transit.graph;

import com.lawal.transit.addressing.*;
import com.lawal.transit.graph.interfaces.Edgeables;

public interface OldStationable {
    public FormattedAddress getAddress ();
    public Edgeables getIncomingEdges ();
    public Edgeables getOutgoingEdges ();
}