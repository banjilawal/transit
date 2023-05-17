package com.lawal.transit.middleware.drivers;

import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.entities.Street;
import com.lawal.transit.middleware.exception.IdentifiableEntityException;
import com.lawal.transit.middleware.singletons.Roads;

public class RoadDriver {
/*
    private static  String[] avenueNames = {
            "Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot",
            "Golf", "Hotel", "Igloo", "Juliet", "Kilo", "Lima",
            "Mike", "November", "Oscar", "Papa", "Quebec", "Rome",
            "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "Xray",
            "Yankee","Zeta"
    };
    public static void main (String[] args) {
        Roads roads = Roads.INSTANCE;

        for (String avenueName : avenueNames) {
            Avenue avenue = null;
            Street street = null;

            int avenueId = roads.nextSerialNumber();
            int streetId = avenueId + avenueNames.length;
            String streetName = Integer.toString(avenueId);

            try {
                avenue = new Avenue(avenueId, avenueName);
            } catch (IdentifiableEntityException e) {
                //String errorMessage = avenue.generateErrorMessage("RoadDriver.main", "", 28, IdentifiableEntityException.PREFIX);
                throw new RuntimeException(e);
            }
            //roads.getBag().add(avenue);

            try {
                street = new Street(streetId, streetName);
            } catch (IdentifiableEntityException e) {
                throw new RuntimeException(e);
            }
            roads.getBag().add(street);
        } // close for
        System.out.println(roads.toString());
    }

 */
} // end class RoadDriver
