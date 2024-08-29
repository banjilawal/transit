package com.lawal.transit.traveler;

import com.lawal.transit.globals.*;
import com.lawal.transit.search.*;

public interface Traveling {

    public int getTravelerId ();
    public FormattedAddress getSource ();
    public FormattedAddress getDestination ();
    public Positionable getCurrentLocation ();
    public void setCurrentLocation (Positionable location);
}
