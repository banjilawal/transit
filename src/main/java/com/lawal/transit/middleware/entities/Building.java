package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.Location;
import com.lawal.transit.middleware.enums.Direction;

public class Building extends Location {

    public Building (int id, String name, Block block, Direction curbSide) {
        super(id, name, block, curbSide);
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Building) {
            Building building = (Building) object;
            if (super.equals(building)) {
                return true;
            }
        }
        return false;
    } // close equals
} // end class Building