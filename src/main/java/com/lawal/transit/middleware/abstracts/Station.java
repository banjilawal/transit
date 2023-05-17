package com.lawal.transit.middleware.abstracts;

import com.lawal.transit.middleware.enums.Direction;
import com.lawal.transit.middleware.enums.RoadLane;
import com.lawal.transit.middleware.interfaces.BlockLocatable;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Station extends NamedEntity implements BlockLocatable {
    private ArrayList<String> busRouteNames;
    private Direction blockSide;
    private Road blockRoad;
    private int blockId;

    public Station (int id, String name, int blockId, Road blockRoad, Direction blockSide) {
        super(id, name);
        this.blockId = blockId;
        this.blockRoad = blockRoad;
        this.blockSide = blockSide;
        this.busRouteNames = new ArrayList<>();
    } // close constructor

    @Override
    public Direction getBlockSide () {
        return blockSide;
    }

    @Override
    public Road getBlockRoad () {
        return blockRoad;
    }

    @Override
    public int getBlockId () {
        return blockId;
    }

    public ArrayList<String> getBusRouteNames () {
        return busRouteNames;
    }

    @Override
    public void setBlockSide (Direction blockSide) {
        this.blockSide = blockSide;
    }

    @Override
    public void setBlockId (int blockId) {
        this.blockId = blockId;
    }

    @Override
    public void setBlockRoad (Road blockRoad) {
        this.blockRoad = blockRoad;
    }

    public void setBusRouteNames (ArrayList<String> busRouteNames) {
        this.busRouteNames = busRouteNames;
    }

    public boolean addBusRouteName (String busRouteName) {
        if (!busRouteNames.contains(busRouteName)) {
            return busRouteNames.add(busRouteName);
        }
        return false;
    } // close addStop

    public void addBusRouteNames (ArrayList<String> busRouteNames) {
        for (String name : busRouteNames) {
            boolean outcome = addBusRouteName(name);
        }
    } // close addStops

    @Override
    public boolean equals (Object object) {
        if (object instanceof Station) {
            Station station = (Station) object;
            if (super.equals(station) && blockId == station.getBlockId()) {
                if (blockRoad.equals(station.getBlockRoad())) {
                    if (blockSide.compareTo(station.getBlockSide()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), blockId, blockRoad, blockSide);
    } // closeHashcode

    public String toString () {
        String string = super.toString()
                + " " + blockRoad.getName()
                + " " + blockRoad.getRoadCategory().abbreviation()
                + " " + blockSide.abbreviation()
                + " blockId:" + blockId
                + "\n" + printBusRoutes();
        return string;
    } // close toString

    public String printBusRoutes () {
        String string = "[BusRoutes:";
        for (String busRouteName : busRouteNames) {
            string += busRouteName + " ";
        }
        return (string.trim() + "]");
    } // close printBusRoutes
} // end class Station