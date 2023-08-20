package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.enums.Direction;

public class Avenue extends Road {

    public Avenue(int id, String name) {
        super(id, name, Direction.EAST);
    }

    public Avenue copy () {
        return new Avenue(getId(), getName());
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Avenue) {
            Avenue avenue = (Avenue) object;
            if (super.equals(avenue)) {
                return true;
            }
        }
        return false;
    } // close equals
} // end class Avenue
