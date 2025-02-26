package com.lawal.transit.global;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public final class Constant {

    public static ArrayList<String> AVENUE_NAMES = new ArrayList<>(Arrays.asList(
        "Alpha",
        "Bravo",
        "Charlie",
//        "Delta",
//        "Echo",
//        "Foxtrot",
//        "Golf",
//        "Hotel",
//        "Igloo",
//        "Juliet",
//        "Kilo",
//        "Lima",
//        "Mike",
//        "November",
//        "Oscar",
//        "Papa",
//        "Quebec",
//        "Rome",
//        "Sierra",
//        "Tango",
//        "Uniform",
//        "Victor",
//        "Whiskey",
//        "Xray",
//        "Yankee",
        "Zeta")
    );

    public static String[] EXPRESS_BUS_ROUTE_NAMES = { "Downtown", "Midtown", "Uptown", "Sundowner", "Nooner",
            "Zocalo", "EarlyBird"
    };

    public static String[] REGULAR_BUS_ROUTE_NAMES = {
        "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet", "Gold", "Olive",
        "Juno", "Silver", "Pearl", "Oak", "Fig", "Pine", "Elm", "Cedar", "Venus", "Pluto",
        "Neptune", "Cobalt", "Hemlock", "Saturn", "Mercury", "Mars", "Platinum", "Amber",
        "Teak", "Iroko", "Ebony", "Mahogany", "Fir", "Cypress", "A", "B", "C", "D", "E",
        "F", "G", "H", "J", "k", "L", "M", "N", "Q", "R", "S", "T", "U", "V", "W", "X",
        "Y", "Z", "Alpha", "Beta", "Delta", "Epsilon", "Gamma", "Omega", "Sigma", "Theta",
        "Lambda", "Zeta", "Kappa", "Tau", "Micron", "11", "22", "33", "44", "55", "66",
        "77", "88", "99", "3", "4", "5", "6", "7", "9", "10", "12", "13", "14", "15", "16",
        "17", "18", "19", "Zaria", "Kano", "Yola", "Ogbomosho", "Manzikert"
    };

    public static String PLACE_NAME_PREFIX = "";
    public static int DOOR_OPENING_SECONDS = 5;
    public static int DOOR_OPEN_SECONDS = 100;

    public static int DOOR_CLOSED_SECONDS = 10;
    public static int DOOR_CLOSING_SECONDS = 5;
    public static int DECELERATION_SECONDS = 10;
    public static int ACCELERATION_SECONDS = 10;

    public static int INITIAL_ODD_ADDRESS_NUMBER = 1;
    public static int INITIAL_EVEN_ADDRESS_NUMBER = 0;

    public static final int STATION_DENSITY_PERCENTAGE_FLOOR = 25;
    public static final int STATION_DENSITY_PERCENTAGE_CEILING = 45;
    public static final int PLACES_PER_BLOCK = 4;
    public static final int MULTIPLICATION_FACTOR = 1000;
    public static final int NAME_INFIX_INTERVAL = 2;


    public static int REGULAR_SCHEDULE_MINIMUM_STOPS = 25;
    public static int REGULAR_SCHEDULE_MAXIMUM_STOPS = 45;
    public static int EXPRESS_SCHEDULE_MINIMUM_STOPS = 10;
    public static int EXPRESS_SCHEDULE_MAXIMUM_STOPS = 15;

    public static int REGULAR_INTERARRIVAL_FLOOR = 30;
    public static int REGULAR_INTERARRIVAL_CEILING = 45;
    public static int EXPRESS_INTERARRIVAL_FLOOR = 15;
    public static int EXPRESS_MAXIMUM_INTERARRIVAL_TIME = 30;

    public static int REGULAR_SCHEDULE_MINIMUM_SPEED = 10;
    public static int REGULAR_SCHEDULE_MAXIMUM_SPEED = 20;
    public static int EXPRESS_SCHEDULE_MINIMUM_SPEED = 35;
    public static int EXPRESS_SCHEDULE_MAXIMUM_SPEED = 15;

    public static final int STANDARD_BUS_CAPACITY = 50;
    public static final int LONG_BUS_CAPACITY = 70;

    public static LocalTime TRANSIT_START_TIME = LocalTime.of(6,0);
    public static LocalTime TRANSIT_END_TIME = LocalTime.of(2,30);

} // end class GlobalConstant