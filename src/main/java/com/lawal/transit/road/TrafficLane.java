package com.lawal.transit.road;

import com.lawal.transit.*;
import com.lawal.transit.buildings.*;
import com.lawal.transit.globals.*;
import com.lawal.transit.graph.*;

import java.util.*;

public final class TrafficLane implements Lane {  //extends Rectangle implements Lane {

    private final int id;
    private final Orientation trafficDirection;

    public TrafficLane (int id, Orientation trafficDirection) {
        this.id = id;
        this.trafficDirection = trafficDirection;
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
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Lane lane)
            return id == lane.getId() && trafficDirection.equals(lane.getTrafficDirection());
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, trafficDirection);
    }
}
