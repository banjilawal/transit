package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.enums.Direction;

import java.util.Objects;

public class SimplexPath extends Entity {
    private Direction direction;

    public SimplexPath(Direction direction) {
        super();
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public SimplexPath oppositePath () {
        return new SimplexPath(direction.oppositeDirection());
    } // close oppositePath

    @Override
    public boolean equals(Object object) {
        if (object instanceof SimplexPath) {
            SimplexPath simplexPath = (SimplexPath) object;

            if (super.equals(simplexPath)) {
                return (direction.compareTo(simplexPath.getDirection()) == 0);
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction);
    }

    @Override
    public String toString () { return direction.print(); }
} // close SimplexPath
