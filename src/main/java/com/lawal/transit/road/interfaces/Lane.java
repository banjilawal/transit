package com.lawal.transit.road.interfaces;

import com.lawal.transit.*;

import com.lawal.transit.globals.*;
import com.lawal.transit.graph.interfaces.*;

public interface Lane {

    public int getId ();
    public Orientation getTrafficDirection ();
    public AddressableCollection getBuildings ();
    public VertexCollection getStations ();
    public void addBuilding (Addressable building) throws Exception;
    public void addStation (Vertex station) throws Exception;
}
