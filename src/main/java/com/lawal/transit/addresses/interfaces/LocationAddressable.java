package com.lawal.transit.addresses.interfaces;

import com.lawal.transit.*;

public interface LocationAddressable {
    public int getId ();
    public String getName ();
    public Orientation getOrientation ();
    public Addressable getBlockAddress ();
    public RoadLabeler getRoadLabel ();
}
