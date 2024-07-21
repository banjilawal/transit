package com.lawal.transit.road;

import com.lawal.transit.*;
import com.lawal.transit.buildings.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.graph.*;
import com.lawal.transit.stations.*;

public final class RoadsideTrafficLane implements BorderLane {  //extends Rectangle implements Lane {

    private final int id;
    private final VertexCollection stations;
    private final Orientation trafficDirection;
    private final AddressableCollection buildings;


    public RoadsideTrafficLane (Orientation trafficDirection) {
        this.trafficDirection = trafficDirection;
        this.buildings = new Buildings();
        this.stations = new Stations();
        this.id = 0;
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
    public VertexCollection getStations () {
        return stations;
    }

    @Override
    public AddressableCollection getBuildings () {
        return buildings;
    }
}
