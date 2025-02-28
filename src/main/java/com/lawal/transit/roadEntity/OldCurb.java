package com.lawal.transit.roadEntity;


import com.lawal.transit.block.Blocks;
import com.lawal.transit.global.Direction;
import com.lawal.transit.roadEntity.contract.RoadEntity;
import com.lawal.transit.station.Stations;
import lombok.Getter;

@Getter
public final class OldCurb {

    private final int id;

    private final RoadEntity roadEntity;
    private final Direction orientation;
    private Direction trafficDirection;
    private final Blocks blocks;
    private final Stations stations;

    public OldCurb (int id, RoadEntity roadEntity, Direction orientation) {
        this.id = id;
        this.roadEntity = roadEntity;
        this.orientation = orientation;
        this.blocks = new Blocks();
        this.stations = new Stations();
        setTrafficDirection();
    }

    @Override
    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof OldCurb oldCurb) {
            return id == oldCurb.getId() && orientation == oldCurb.getOrientation();
        }
        return false;
    }

    public OldCurb getOppositeCurb () {
        return roadEntity.getCurbByOrientation(orientation.oppositeDirection());
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + "[id:" + id +  " orientation:" + orientation.print()
            +  " blocks:" + blocks.size() + " stations:" + stations.size() + "] " + roadEntity.toString();
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