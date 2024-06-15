package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.AbstractRoad;
import com.lawal.transit.Orientation;

public class ConcreteAvenue extends AbstractRoad {

    public ConcreteAvenue (int id, String name) {
        super(id, name, Orientation.EAST);
    }


    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof ConcreteAvenue concreteAvenue) {
            return super.equals(concreteAvenue);
        }
        return false;
    } // close equals

    @Override
    public String toString () {
        return getClass().getSimpleName() + ":" + getId() + " name:" + getName();
    }
} // end class ConcreteAvenue
