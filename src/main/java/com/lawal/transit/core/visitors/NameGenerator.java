package com.lawal.transit.core.visitors;

import com.lawal.transit.core.abstracts.AbstractRoad;
import com.lawal.transit.core.concretes.*;
import com.lawal.transit.core.global.Constant;
import com.lawal.transit.core.interfaces.NameAssigner;
import com.lawal.transit.test.populator.*;
import com.lawal.transit.core.singletons.ExpressBusRoutes;
import com.lawal.transit.core.singletons.RegularBusRoutes;
//import com.lawal.transit.middleware.populator.BuildingPopulator;


public enum NameGenerator implements NameAssigner {
    INSTANCE;


    @Override
    public String assignName (BlockPopulator blockPopulator, Intersection northWestCorner) {
        int asciiValue = Constant.CAPITAL_A_ASCII_VALUE + northWestCorner.getId();
        String letter = "" + (char) asciiValue;
        int number = northWestCorner.getId() + 1;
        return letter + "-" + number;
    } // close

    @Override
    public String assignName (RoadPopulator roadPopulator, AbstractRoad abstractRoad, int roadId) {
        if (abstractRoad instanceof ConcreteAvenue) {
            return Constant.AVENUE_NAMES[(roadId - 1)];
        }
        else if (abstractRoad instanceof ConcreteStreet) {
            return Integer.toString(roadId);
        } else {
            return "Cannot assign abstractRoad name";
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
        String name = randomArrayEntry(Constant.REGULAR_BUS_ROUTE_NAMES);
        while (RegularBusRoutes.INSTANCE.search(name) != null) {
            name = randomArrayEntry(Constant.REGULAR_BUS_ROUTE_NAMES);
        }
        return name;
    } // close

    @Override
    public String assignName(ExpressBusRoutePopulator busRoutePopulator) {
        String name = randomArrayEntry(Constant.EXPRESS_BUS_ROUTE_NAMES);
        while (ExpressBusRoutes.INSTANCE.search(name) != null) {
            name = randomArrayEntry(Constant.EXPRESS_BUS_ROUTE_NAMES);
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
} // end class NameGenerator