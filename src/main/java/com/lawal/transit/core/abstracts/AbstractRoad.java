package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.concretes.*;
import com.lawal.transit.core.concretes.ConcreteAvenue;
import com.lawal.transit.Orientation;

public abstract class AbstractRoad extends FixedPath {
    private Orientation orientation;

    public AbstractRoad (int id, String name, Orientation orientation) {
        super(id, name);
        this.orientation = orientation;
    }


    public Orientation getDirection () {
        return orientation;
    }


    public Orientation getOppositeDirection () {
        return orientation.oppositeDirection();
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof AbstractRoad abstractRoad)
            return super.equals(abstractRoad) && orientation.equals(abstractRoad.getDirection());
        return false;
    } // close equals


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString () {
        StringBuilder builder = new StringBuilder();
        if (this instanceof ConcreteAvenue concreteAvenue) {
            builder.append(concreteAvenue.getName()).append(" ").append(concreteAvenue.getClass().getSimpleName().substring(0, 3));
        }
        else {
            ConcreteStreet concreteStreet = (ConcreteStreet) this;
            builder.append(concreteStreet.getName()).append(" ").append(concreteStreet.getClass().getSimpleName().substring(0, 2));
        }
        return builder.toString();
    } // close toString
} // end class TwoWayRoad
