package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.entities.Avenue;
import com.lawal.transit.core.entities.Street;
import com.lawal.transit.core.enums.Direction;

import java.util.Objects;

public abstract class Road extends FixedPath {
    private Direction direction;

    public Road(int id, String name, Direction direction) {
        super(id, name);
        this.direction = direction;
    }

    public Direction getDirection () { return direction; }
    public Direction getOppositeDirection () { return direction.oppositeDirection(); }

    @Override
    public boolean equals(Object object) {
        if (object instanceof  Road) {
            Road road = (Road) object;
            if (super.equals(road)) {
                return true;
            }
        }
        return false;
    } // close equals

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    } // close hashCode

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
