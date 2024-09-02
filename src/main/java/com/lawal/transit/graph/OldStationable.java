package com.lawal.transit.graph;

import com.lawal.transit.edges.interfaces.*;
import com.lawal.transit.search.*;

public interface OldStationable {
    public FormattedAddress getAddress ();
    public Edgeables getIncomingEdges ();
    public Edgeables getOutgoingEdges ();
}