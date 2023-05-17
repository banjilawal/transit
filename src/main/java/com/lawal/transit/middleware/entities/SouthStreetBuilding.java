package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.StreetBuilding;
import com.lawal.transit.middleware.enums.Direction;

public class SouthStreetBuilding extends StreetBuilding {

    public SouthStreetBuilding (int id, String name, int blockId, Street street) {
        super(id, name, blockId, street, Direction.SOUTH);
    }
} // end class SouthStreetBuilding
/*
import com.lawal.transit.middleware.abstracts.StreetBuilding;
import com.lawal.transit.middleware.enums.Direction;

public class SouthStreetBuilding extends StreetBuilding {
    public static Direction BUILDING_ORIENTATION = Direction.SOUTH;
    public SouthStreetBuilding (int id, String name, int blockId, Street blockStreet) {
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