package com.lawal.transit.transport.interfaces;

import com.lawal.transit.search.*;
import com.lawal.transit.traveler.*;

import java.util.*;

public interface Embarkations {

    public int size ();
    public Iterator<Embarkation> iterator ();
    public void add (Journey traveler, Vehicle vehicle);
    public void remove (Journey travler, Vehicle vehicle, FormattedAddress disembarkationPoint);
}
