package com.lawal.transit.core.visitors;

import com.lawal.transit.core.interfaces.NumberAssigner;
//import com.lawal.transit.middleware.populator.BlockPopulator;
//import com.lawal.transit.middleware.populator.BuildingPopulator;
//import com.lawal.transit.middleware.populator.IntersectionPopulator;
import com.lawal.transit.core.populator.*;

public enum SerialNumberGenerator implements NumberAssigner {
    INSTANCE;
    private int regularBusRouteSerialNumber = 1;
    private int expressBusRouteSerialNumber = 1;
    private int intersectionSerialNumber = 1;
    private int buildingSerialNumber = 1;
    private int stationSerialNumber = 1;
    private int blockSerialNumber = 1;
    private int roadSerialNumber = 1;

    @Override
    public int assignNumber(IntersectionPopulator intersectionPopulator) {
        return intersectionSerialNumber++;
    }

    @Override
    public int assignNumber(RegularBusRoutePopulator busRoutePopulator) {
        return regularBusRouteSerialNumber++;
    }

    @Override
    public int assignNumber(ExpressBusRoutePopulator busRoutePopulator) {
        return expressBusRouteSerialNumber++;
    }

    @Override
    public int assignNumber(BuildingPopulator buildingPopulator) {
        return buildingSerialNumber++;
    }

    @Override
    public int assignNumber(StationPopulator stationPopulator) {
        return stationSerialNumber++;
    }

    @Override
    public int assignNumber(BlockPopulator blockPopulator) {
        return blockSerialNumber++;
    }

    @Override
    public int assignNumber(RoadPopulator roadPopulator) {
        return roadSerialNumber++;
    }
} // end class SerialNumberGenerator



