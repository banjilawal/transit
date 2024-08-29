package com.lawal.transit.traveler;

import com.lawal.transit.globals.*;
import com.lawal.transit.search.*;

public interface Journey {

    public Positionable getLocation ();
    public FormattedAddress getDestination ();
    public void setLocation (Positionable positionable);
    public void receiveRoute (RoutingAnswer response);
    public void requestRoute (Dispatching dispatcher);
}
