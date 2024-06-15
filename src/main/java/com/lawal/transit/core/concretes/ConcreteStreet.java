package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.AbstractRoad;
import com.lawal.transit.Orientation;

public class ConcreteStreet extends AbstractRoad {

    public ConcreteStreet (int id, String name) {
        super(id, name, Orientation.NORTH);
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof ConcreteStreet concreteStreet) {
            return super.equals(concreteStreet);
        }
        return false;
    }


    @Override
    public String toString () {
        return getClass().getSimpleName() + ":" + getId() + " name:" + getName();
    }
} // end class ConcreteStreet
