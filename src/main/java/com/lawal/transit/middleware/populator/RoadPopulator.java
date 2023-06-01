package com.lawal.transit.middleware.populator;

import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.entities.GlobalConstant;
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

//    public static String WEST_BORDER_NAME = "WestBorder";
//    public static String EAST_BORDER_NAME = "EastBorder";
//    public static String NORTH_BORDER_NAME = "NorthBorder";
//    public static String SOUTH_BORDER_NAME = "SouthBorder";
//    public int START_BORDER_ID = 100;
//    public int END_BORDER_ID = 200;

    public void populate () {
        int totalNames = NameGenerator.INSTANCE.AVENUE_NAMES.length;
        addBorderRoads(GlobalConstant.START_BORDER_ID);
        for (int index = 0; index < totalNames; index++) {
            id = SerialNumberGenerator.INSTANCE.assignNumber(this);
            avenueName = NameGenerator.INSTANCE.AVENUE_NAMES[index];
            streetName = Integer.toString(index + 1);
            Avenues.INSTANCE.getBag().add(new Avenue(id, avenueName));
            Streets.INSTANCE.getBag().add(new Street(id, streetName));
        }
        addBorderRoads(GlobalConstant.END_BORDER_ID);
    } // close populate

    private void addBorderRoads (int borderID) {
        switch (borderID) {
            case 100:
                Avenues.INSTANCE.getBag().add(new Avenue(GlobalConstant.START_BORDER_ID, GlobalConstant.EAST_BORDER_NAME));
                Streets.INSTANCE.getBag().add(new Street(GlobalConstant.START_BORDER_ID, GlobalConstant.NORTH_BORDER_NAME));
                break;
            case 200:
                Avenues.INSTANCE.getBag().add(new Avenue(GlobalConstant.END_BORDER_ID, GlobalConstant.WEST_BORDER_NAME));
                Streets.INSTANCE.getBag().add(new Street(GlobalConstant.END_BORDER_ID, GlobalConstant.SOUTH_BORDER_NAME));
                break;
        }
    } // close addBorderRoads
} // end class RoadPopulator