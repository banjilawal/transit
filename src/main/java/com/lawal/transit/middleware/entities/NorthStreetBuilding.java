package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.StreetBuilding;
import com.lawal.transit.middleware.enums.Direction;

public class NorthStreetBuilding extends StreetBuilding {

    public NorthStreetBuilding (int id, String name, int blockId, Street street) {
        super(id, name, blockId, street, Direction.NORTH);
    }
} // end class NorthStreetBuiilding
/*
import com.lawal.transit.middleware.abstracts.StreetBuilding;
import com.lawal.transit.middleware.enums.Direction;

public class NorthStreetBuilding extends StreetBuilding {
    public static Direction BUILDING_ORIENTATION = Direction.NORTH;

    public NorthStreetBuilding (int id, String name, int blockId, Street blockStreet) {
        super(id, name, blockId, blockStreet);
    }

    public Street getStreet () {
        return (Street) getBlockRoad();
    }

    public void setStreet (Street street) {
        setBlockRoad(street);
    }

    @Override
    public String toString () {
        return super.toString() + " " + BUILDING_ORIENTATION.abbreviation();
    } // close toString

    @Override
    public String fullString () {
        return toString();
    } // close addressString
} // end class AvenueBuilding

 */