package com.lawal.transit.middleware.populator;

import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.entities.Street;
import com.lawal.transit.middleware.singletons.Avenues;
import com.lawal.transit.middleware.singletons.Streets;
import com.lawal.transit.middleware.visitors.NameGenerator;
import com.lawal.transit.middleware.visitors.SerialNumberGenerator;

public enum RoadPopulator implements Populator {
    INSTANCE;
    private String avenueName;
    private String streetName;
    private int id;

    public static String WEST_BORDER_NAME = "WestBorder";
    public static String EAST_BORDER_NAME = "EastBorder";
    public static String NORTH_BORDER_NAME = "NorthBorder";
    public static String SOUTH_BORDER_NAME = "SouthBorder";
    public int START_BORDER_ID = 100;
    public int END_BORDER_ID = 200;

    public void populate () {
        Avenues avenues = Avenues.INSTANCE;
        Streets streets = Streets.INSTANCE;
        int totalNames = NameGenerator.INSTANCE.AVENUE_NAMES.length;

//        avenues.add(new Avenue(100, "WestBorder"));
//        streets.add(new Street(100, "NorthBorder"));
        addBorderRoads(START_BORDER_ID);
        for (int index = 0; index < totalNames; index++) {
            id = SerialNumberGenerator.INSTANCE.assignNumber(this);
            avenueName = NameGenerator.INSTANCE.AVENUE_NAMES[index];
            streetName = Integer.toString(index + 1);
            avenues.add(new Avenue(id, avenueName));
            streets.add(new Street(id, streetName));
        }
        addBorderRoads(END_BORDER_ID);
//        avenues.add(new Avenue(200, "EastBorder"));
//        streets.add(new Street(200, "SouthBorder"));
//          System.out.println(avenues.fullString());
    } // close populate

    private void addBorderRoads (int borderID) {
        switch (borderID) {
            case 100:
                Avenues.INSTANCE.add(new Avenue(START_BORDER_ID, EAST_BORDER_NAME));
                Streets.INSTANCE.add(new Street(START_BORDER_ID, NORTH_BORDER_NAME));
                break;
            case 200:
                Avenues.INSTANCE.add(new Avenue(END_BORDER_ID, WEST_BORDER_NAME));
                Streets.INSTANCE.add(new Street(END_BORDER_ID, SOUTH_BORDER_NAME));
                break;
        }
    } // close addBorderRoads
} // end class RoadPopulator