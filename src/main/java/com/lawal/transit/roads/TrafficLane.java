package com.lawal.transit.roads;

import com.lawal.transit.globals.*;
import com.lawal.transit.roads.interfaces.*;

public record TrafficLane(int id, Direction trafficDirection) implements Lane {  //extends Rectangle implements Lane {

//    @Override
//    public boolean equals (Object object) {
//        if (this == object) return true;
//        if (object == null) return false;
//        if (object instanceof Lane lane)
//            return id == lane.id() && trafficDirection.equals(lane.trafficDirection());
//        return false;
//    }

    @Override
    public String toString () {
        return "Lane:" + id + trafficDirection.abbreviation();
    }
}