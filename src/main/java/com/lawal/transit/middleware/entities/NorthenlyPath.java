package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.NamedEntity;
import com.lawal.transit.middleware.enums.Direction;

import java.util.Objects;

public abstract class NorthenlyPath extends NamedEntity {
    private Direction direction;

    public NorthenlyPath(int id, String name, Direction direction) {
        super(id, name);
        this.direction = direction;
    }

    public Direction getDirection () {
        return direction;
    }

    public void setDirection (Direction direction) {
        this.direction = direction;
    }

    /*
    public void setReverseTravelDirection (Direction reverseTravelDirection) {
        this.reverseTravelDirection = reverseTravelDirection;
        this.travelDirection = this.reverseTravelDirection.oppositeDirection();
    }
     */
    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), direction);
    } // close hashCode

    @Override
    public boolean equals (Object object) {
        if (object instanceof NorthenlyPath) {
            NorthenlyPath simplexPath = (NorthenlyPath) object;
            if (super.equals(simplexPath)) {
                if (direction.compareTo(simplexPath.getDirection()) == 0) {
                    return true;
                }
            }
        }
        return false;
    } // close equals
} // close SimplexPath
