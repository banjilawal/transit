package com.lawal.transit.road;

import com.lawal.transit.*;
import com.lawal.transit.buildings.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.graph.*;
import com.lawal.transit.graph.interfaces.*;
import com.lawal.transit.road.interfaces.*;

public final class TrafficLane implements Lane {  //extends Rectangle implements Lane {

    public static final String ILLEGAL_STATION_ADDITION_ATTEMPT = "Stations can only be added to the zeroth lane";
    public static final String ILLEGAL_BUILDING_ADDITION_ATTEMPT = "Buildings can only be added to the zeroth lane";
    private final Orientation trafficDirection;
    private final AddressableCollection buildings;
    private final VertexCollection stations;
    private final int id;

    public TrafficLane (Orientation trafficDirection, int id) {
        this.trafficDirection = trafficDirection;
        this.buildings = new Buildings();
        this.stations = new Vertices();
        this.id = id;
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
    public AddressableCollection getBuildings () {
        return buildings;
    }

    @Override
    public VertexCollection getStations () {
        return stations;
    }

    @Override
    public void addStation (Vertex station) throws Exception {
        if (id != 0)
            throw new Exception(ILLEGAL_STATION_ADDITION_ATTEMPT);
        this.stations.add(station);
    }

    @Override
    public void addBuilding (Addressable building) throws Exception {
        if (id != 0)
            throw new Exception(ILLEGAL_BUILDING_ADDITION_ATTEMPT);
        this.buildings.add(building);
    }
}
