package com.lawal.transit.road;


import com.lawal.transit.block.Blocks;
import com.lawal.transit.global.Direction;
import com.lawal.transit.road.contract.Road;
import com.lawal.transit.station.Stations;
import lombok.Getter;

@Getter
public final class Curb {

    private final int id;

    private final Road road;
    private final Direction orientation;
    private Direction trafficDirection;
    private final Blocks blocks;
    private final Stations stations;

    public Curb (int id, Road road, Direction orientation) {
        this.id = id;
        this.road = road;
        this.orientation = orientation;
        this.blocks = new Blocks();
        this.stations = new Stations();
        setTrafficDirection();
    }

    @Override
    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof Curb curb) {
            return id == curb.getId() && orientation == curb.getOrientation();
        }
        return false;
    }

    public Curb  getOppositeCurb () {
        return road.getCurbByOrientation(orientation.oppositeDirection());
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + "[id:" + id +  " orientation:" + orientation.print()
            +  " blocks:" + blocks.size() + " stations:" + stations.size() + "] " + road.toString();
    }

    private void setTrafficDirection () {
        switch (orientation) {
            case NORTH -> {
                this.trafficDirection = Direction.WEST;
            }
            case SOUTH -> {
                this.trafficDirection = Direction.EAST;
            }
            case EAST -> {
                this.trafficDirection = Direction.NORTH;
            }
            case WEST -> {
                this.trafficDirection = Direction.SOUTH;
            }
        }
    }
}