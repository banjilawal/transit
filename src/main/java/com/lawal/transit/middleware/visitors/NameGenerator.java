package com.lawal.transit.middleware.visitors;

import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.entities.Street;
import com.lawal.transit.middleware.interfaces.NameAssigner;
import com.lawal.transit.middleware.populator.*;
import com.lawal.transit.middleware.singletons.RegularBusRoutes;
//import com.lawal.transit.middleware.populator.BuildingPopulator;
//import com.lawal.transit.middleware.populator.IntersectionPopulator;


public enum NameGenerator implements NameAssigner {
    INSTANCE;
    public static String[] AVENUE_NAMES = {
            "Alpha",
            "Bravo", "Charlie",
            "Delta", "Echo",
//            "Foxtrot", "Golf", "Hotel", "Igloo",
//            "Juliet", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Rome",
//            "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "Xray", "Yankee",
            "Zeta"
    };

    public String[] EXPRESS_BUS_ROUTE_NAMES = { "Downtown", "Midtown", "Uptown" };

    private String[] REGULAR_BUS_ROUTE_NAMES = {
            "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet", "Gold", "Olive",
            "Juno", "Silver", "Pearl", "Oak", "Fig", "Pine", "Elm", "Cedar", "Venus", "Pluto",
            "Neptune", "Cobalt", "Hemlock", "Saturn", "Mercury", "Mars", "Platinum", "Amber",
            "Teak", "Iroko", "Ebony", "Mahogany", "Fir", "Cypress", "A", "B", "C", "D", "E",
            "F", "G", "H", "J", "k", "L", "M", "N", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z", "Alpha", "Beta", "Delta", "Epsilon", "Gamma", "Omega", "Sigma", "Theta",
            "Lambda", "Zeta", "Kappa", "Tau", "Micron", "11", "22", "33", "44", "55", "66",
            "77", "88", "99", "3", "4", "5", "6", "7", "9", "10", "12", "13", "14", "15", "16",
            "17", "18", "19"
    };
    private static int START_BORDER_ARRAY_INDEX = 0;
    private static int END_BORDER_ID_ARRAY_INDEX = AVENUE_NAMES.length;
    private static final int CAPITAL_A_ASCII_VALUE = 65;

//    @Override
//    public String assignName (IntersectionPopulator intersectionPopulator, Street street, Avenue avenue) {
//        return street.getName() + avenue.getName().charAt(0);
//    } //close

    @Override
    public String assignName (BlockPopulator blockPopulator, Street northStreet, Avenue westAvenue) {
//        int northStreetId = transformRoadId(northStreet);
//        System.out.println(northStreetId + "," + northStreet.getId());
//        int westAvenueId = avenueId(westAvenue);
//        String number = Integer.toString(westAvenueId);
        String letter = Character.toString(((char) (CAPITAL_A_ASCII_VALUE + getBlockNameComponent(northStreet))));
        String number = Integer.toString(getBlockNameComponent(westAvenue) + 1);
        return letter + "-" + number;
    } // close

    @Override
    public String assignName (RoadPopulator roadPopulator, Road road, int roadId) {
        String name = "";
        if (road instanceof Avenue) {
            return AVENUE_NAMES[(roadId - 1)];
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

//    @Override
//    public String assignName (TransitRoutePopulator transitRoutePopulator) {
//        return getRegularBusRouteName();
//    } // close

//    @Override
//    public String assignName (StationPopulator stationPopulator, int stationNumber) {
//        return "MT-" + Integer.toString(stationNumber);
//    } // close

    private int getBlockNameComponent (Road road) {
        int id = road.getId();
//        System.out.println("\t----->>NAME_GENERATOR_STREET_ID__ENTRY_VALUE:" + id);
        switch (id) {
            case 100:
                id = START_BORDER_ARRAY_INDEX;
                break;
            case 200:
                id = END_BORDER_ID_ARRAY_INDEX;
                break;
        }
        return id;
    } // close transformRoadId

    /*
    private int streetId (Street street) {
        int id = street.getId();
//        System.out.println("\t----->>NAME_GENERATOR_STREET_ID__ENTRY_VALUE:" + id);
        switch (id) {
            case 100:
                id = START_BORDER_ARRAY_INDEX;
                break;
            case 200:
                id = END_BORDER_ID_ARRAY_INDEX;
                break;
        }
        return id;
    } // close streetId

    private int avenueId (Avenue avenue) {
        int id = avenue.getId();
        switch (id) {
            case 100:
                id = START_BORDER_ARRAY_INDEX;
                break;
            case 200:
                id = END_BORDER_ID_ARRAY_INDEX;
                break;
        }
        return id;
    } // close avenueId
     */

    public int expressRouteCount () {
        return EXPRESS_BUS_ROUTE_NAMES.length;
    }

    private String randomStringArrayEntryName (String[] stringArray) {
        int index = (int) (Math.random() * (stringArray.length - 1));
        return stringArray[index];
    } // close randomStringArrayEntryName

    private String getRegularBusRouteName () {
        String name = randomStringArrayEntryName(REGULAR_BUS_ROUTE_NAMES);
        while (RegularBusRoutes.INSTANCE.getBag().search(name) != null) {
            name = randomStringArrayEntryName(REGULAR_BUS_ROUTE_NAMES);
        }
        return  (name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase());
    } // close getRegularBusRouteName
} // end class SerialNumberGenerator
