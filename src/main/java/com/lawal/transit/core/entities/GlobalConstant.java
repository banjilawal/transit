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
} // end class GlobalConstant
