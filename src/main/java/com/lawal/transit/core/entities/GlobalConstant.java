package com.lawal.transit.core.entities;

import java.time.LocalTime;

public class GlobalConstant {
    public static final String WEST_BORDER_NAME = "WestBorder";
    public static final String EAST_BORDER_NAME = "EastBorder";
    public static final String NORTH_BORDER_NAME = "NorthBorder";
    public static final String SOUTH_BORDER_NAME = "SouthBorder";
    public static final int NORTH_STATION_STARTING_NUMBER = 1000;
    public static final int EAST_STATION_STARTING_NUMBER = 2000;
    public static final int SOUTH_STATION_STARTING_NUMBER = 3000;
    public static final int WEST_STATION_STARTING_NUMBER = 4000;
    public static final int BUILDINGS_PER_BLOCK_BORDER = 1;
    public static final int MULTIPLICATION_FACTOR = 1000;
    public static final int ADDRESS_INTERVAL = 2;
    public static final int MINIMUM_ENTITY_ID = 1;
    public static final int START_BORDER_ID = 100;
    public static final int END_BORDER_ID = 200;

    public static int REGULAR_MINIMUM_INTERARRIVAL_TIME = 10;
    public static int REGULAR_MAXIMUM_INTERARRIVAL_TIME = 30;
    public static int EXPRESS_MINIMUM_INTERARRIVAL_TIME = 8;
    public static int EXPRESS_MAXIMUM_INTERARRIVAL_TIME = 15;

    public static LocalTime TRANSIT_START_TIME = LocalTime.of(6,0);
    public static LocalTime TRANSIT_END_TIME = LocalTime.of(2,30);

    public static String[] AVENUE_NAMES = {
            "Alpha",
            "Bravo", "Charlie",
            "Delta", "Echo",
//            "Foxtrot", "Golf", "Hotel", "Igloo",
//            "Juliet", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Rome",
//            "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "Xray", "Yankee",
            "Zeta"
    };

    public static String[] EXPRESS_BUS_ROUTE_NAMES = { "Downtown", "Midtown", "Uptown" };

    public static String[] REGULAR_BUS_ROUTE_NAMES = {
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
} // end class GlobalConstant
