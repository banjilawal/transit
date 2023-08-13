package com.lawal.transit.core.visitors;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.entities.*;
import com.lawal.transit.core.interfaces.NameAssigner;
import com.lawal.transit.core.populator.*;
import com.lawal.transit.core.singletons.ExpressBusRoutes;
import com.lawal.transit.core.singletons.RegularBusRoutes;
//import com.lawal.transit.middleware.populator.BuildingPopulator;
//import com.lawal.transit.middleware.populator.IntersectionPopulator;


public enum NameGenerator implements NameAssigner {
    INSTANCE;

    @Override
    public String assignName(IntersectionPopulator intersectionPopulator, int xCoordinateIndex, int yCoordinateIndex) {
        return "(" + xCoordinateIndex + "," + yCoordinateIndex + ")";
    }

    @Override
    public String assignName (BlockPopulator blockPopulator, Intersection northWestCorner) {
        int asciiValue = GlobalConstant.CAPITAL_A_ASCII_VALUE + northWestCorner.getYCoordinateIndex();
        String letter = "" + (char) asciiValue;
        int number = northWestCorner.getXCoordinateIndex() + 1;
        return letter + "-" + number;
    } // close

    @Override
    public String assignName (RoadPopulator roadPopulator, Road road, int roadId) {
        if (road instanceof Avenue) {
            return GlobalConstant.AVENUE_NAMES[(roadId - 1)];
        }
        else if (road instanceof Street) {
            return Integer.toString(roadId);
        } else {
            return "Cannot assign road name";
        }
    } // close

    @Override
    public String assignName(BuildingPopulator buildingPopulator, int buildingNumber) {
        return Integer.toString(buildingNumber);
    } //close

    @Override
    public String assignName (StationPopulator stationPopulator, int previousStationNumber) {
        return "MT-" + (previousStationNumber + 1);
    } // close

    @Override
    public String assignName (RegularBusRoutePopulator busRoutePopulator) {
        String name = randomArrayEntry(GlobalConstant.REGULAR_BUS_ROUTE_NAMES);
        while (RegularBusRoutes.INSTANCE.getRoutNames().contains(name)) {
            name = randomArrayEntry(GlobalConstant.REGULAR_BUS_ROUTE_NAMES);
        }
        return name;
    } // close

    @Override
    public String assignName(ExpressBusRoutePopulator busRoutePopulator) {
        String name = randomArrayEntry(GlobalConstant.EXPRESS_BUS_ROUTE_NAMES);
        while (ExpressBusRoutes.INSTANCE.getRoutNames().contains(name)) {
            name = randomArrayEntry(GlobalConstant.EXPRESS_BUS_ROUTE_NAMES);
        }
        return name;
    } // close


//
//    public int expressRouteCount () {
//        return GlobalConstant.EXPRESS_BUS_ROUTE_NAMES.length;
//    }
//

    private String randomArrayEntry (String[] stringArray) {
        int index = (int) (Math.random() * (stringArray.length - 1));
        return stringArray[index];
    } // close randomStringArrayEntryName
} // end class SerialNumberGenerator
