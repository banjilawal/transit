package com.lawal.transit.road.interfaces;

import com.lawal.transit.*;
import com.lawal.transit.addresses.*;
import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.locations.*;
import com.lawal.transit.locations.interfaces.*;

public interface Lane {

    public int getId ();

    public Orientation getTrafficDirection ();

    public AddressCollection<LocationAddressable> getAddresses ();
    public Stations getStations ();
}
