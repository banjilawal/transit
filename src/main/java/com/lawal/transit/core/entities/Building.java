package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.Location;
import com.lawal.transit.core.enums.Direction;

public class Building extends Location {

    public Building (int id, String name, Block block, Direction orientation) {
        super(id, name, block, orientation);
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Building building) return super.equals(building);
        return false;
    } // close equals
} // end class Building