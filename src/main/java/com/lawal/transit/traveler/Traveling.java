package com.lawal.transit.traveler;

import com.lawal.transit.global.*;

public interface Traveling {

    public int getTravelerId ();
    public Address getSource ();
    public Address getDestination ();
    public Trackable getCurrentLocation ();
    public void setCurrentLocation (Trackable location);
}