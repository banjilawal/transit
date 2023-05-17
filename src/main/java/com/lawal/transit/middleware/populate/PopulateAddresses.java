package com.lawal.transit.middleware.populate;
/*
import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.enums.RoadCategory;
import com.lawal.transit.middleware.singletons.Addresses;
import com.lawal.transit.middleware.singletons.Arteries;
import com.lawal.transit.middleware.entities.Address;
import com.lawal.transit.middleware.enums.Direction;

import java.util.Iterator;

public class PopulateAddresses extends Populate {
    private static int baseAddressNumber = 1000;
    private static int addressesPerBlockSide = 4;

    private static int blocksPerRoadSide;
    private static int addressesPerRoadSide;


    public static void populateAddresses () {
        PopulateSingletons.populate();
        blocksPerRoadSide = Arteries.getInstance().size() / 2;
        addressesPerRoadSide =  addressesPerBlockSide * blocksPerRoadSide;
        System.out.println("addresses per roadside:" + addressesPerRoadSide);
        for (Iterator<Road> iterator = Arteries.getInstance().iterator(); iterator.hasNext();) {
            Road artery = (Road) iterator.next();
            insertAddresses(artery);
        }
    } // close populate

    private static void insertAddresses (Road artery) {
        int id = 0;
        String name = "";
        int rightStartNumber = baseAddressNumber;
        int leftStartNumber = baseAddressNumber + 1;

        Direction leftAddressOrientation = Direction.WEST;
        Direction rightAddressOrientation  = Direction.EAST;
        if (artery.getCategory() == RoadCategory.AVENUE) {
            leftAddressOrientation = Direction.NORTH;
            rightAddressOrientation = Direction.SOUTH;
        }

        for (int index = 0; index < addressesPerRoadSide; index +=2) {
            id = Addresses.nextSerialNumber();
            name = Integer.toString(leftStartNumber + index);
            Addresses.getInstance().add(new Address(id, name, artery, leftAddressOrientation));

            id = Addresses.nextSerialNumber();
            name = Integer.toString(rightStartNumber + index);
            Addresses.getInstance().add(new Address(id, name, artery, rightAddressOrientation));
        }
    } // close insertAddresses
} // end class PopulateAddresses

 */
