package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.AvenueBuilding;
import com.lawal.transit.middleware.enums.Direction;

public class EastAvenueBuilding extends AvenueBuilding {

    public EastAvenueBuilding (int id, String name, int blockId, Avenue avenue) {
        super(id, name, blockId, avenue, Direction.EAST);
    }
} // end EastAvenueBuilding
/*
import com.lawal.transit.middleware.abstracts.AvenueBuilding;
import com.lawal.transit.middleware.enums.Direction;

public class EastAvenueBuilding extends AvenueBuilding {
    public static Direction BUILDING_ORIENTATION = Direction.EAST;
    public EastAvenueBuilding (int id, String name, int blockId, Avenue blockAvenue) {
        super(id, name, blockId, blockAvenue);
    }

    public Avenue getAvenue () {
        return (Avenue) getBlockRoad();
    }

    public void setAvenue (Avenue avenue) {
        setBlockRoad(avenue);
    }

    @Override
    public String toString () {
        return super.toString() + " " + BUILDING_ORIENTATION.abbreviation();
    }

    @Override
    public String fullString () {
        return toString();
    }
} // end class AvenueBuilding

 */