package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.enums.Direction;

public class Street extends Road {

    public Street (int id, String name) {
        super(id, name,Direction.NORTH);
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Street street) {
            return super.equals(street);
        }
        return false;
    }


    @Override
    public String toString () {
        return getClass().getSimpleName() + ":" + getId() + " name:" + getName();
    }
} // end class Street
