package com.lawal.transit.road;

import com.lawal.transit.*;
import com.lawal.transit.addresses.*;
import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.locations.*;
import com.lawal.transit.road.interfaces.*;

public class  TrafficLane implements Lane {
    public static final String ADDITION_ERROR = "The item is already in the list. It cannot be added again";
    public static final String REMOVAL_ERROR = "The item does not exist in the list so it cannot be removed";
    private final int id;
    private final Orientation trafficDirection;
    private final AddressCollection<LocationAddressable> addresses;
    private final Stations stations;

    public TrafficLane (
        int id,
        Orientation trafficDirection,
        AddressCollection<LocationAddressable> addresses,
        Stations stations
    ) {
        this.id = id;
        this.trafficDirection = trafficDirection;
        this.addresses = addresses;
        this.stations = stations;
    }

    @Override
    public int getId () {
        return id;
    }

    @Override
    public Orientation getTrafficDirection () {
        return trafficDirection;
    }

    @Override
    public AddressCollection<LocationAddressable> getAddresses () {
        return addresses;
    }

    @Override
    public Stations getStations () {
        return stations;
    }

}
