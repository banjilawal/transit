package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.Road;
import com.lawal.transit.core.enums.Direction;

public class Avenue extends Road {

    public Avenue(int id, String name) {
        super(id, name, Direction.EAST);
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Avenue avenue) {
            return super.equals(avenue);
        }
        return false;
    } // close equals

    @Override
    public String toString () {
        return getClass().getSimpleName() + ":" + getId() + " name:" + getName();
    }
} // end class Avenue
