package com.lawal.transit.road;

import com.lawal.transit.buildings.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.graph.*;
import com.lawal.transit.stations.*;

public class Sidewalk implements RoadSide {

    private final VertexCollection stations;
    private final AddressableCollection buildings;

    public Sidewalk () {
        this.stations = new Stations();
        this.buildings = new Buildings();
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
