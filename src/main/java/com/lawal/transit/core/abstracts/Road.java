package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.concretes.Avenue;
import com.lawal.transit.core.concretes.Street;
import com.lawal.transit.core.enums.Direction;

public abstract class Road extends FixedPath {
    private Direction direction;

    public Road(int id, String name, Direction direction) {
        super(id, name);
        this.direction = direction;
    }


    public Direction getDirection () {
        return direction;
    }


    public Direction getOppositeDirection () {
        return direction.oppositeDirection();
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Road road)
            return super.equals(road) && direction.equals(road.getDirection());
        return false;
    } // close equals


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString () {
        StringBuilder builder = new StringBuilder();
        if (this instanceof Avenue avenue) {
            builder.append(avenue.getName()).append(" ").append(avenue.getClass().getSimpleName().substring(0, 3));
        }
        else {
            Street street = (Street) this;
            builder.append(street.getName()).append(" ").append(street.getClass().getSimpleName().substring(0, 2));
        }
        return builder.toString();
    } // close toString
} // end class Road
