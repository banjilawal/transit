package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.enums.Direction;

import java.util.Objects;

public abstract class Traversal {
    private FixedPath path;
    private Direction direction;

    public Traversal(FixedPath path, Direction direction) {
        this.path = path;
        this.direction = direction;
    }

    public FixedPath getPath () {
        return path;
    }

    public Direction getDirection () {
        return direction;
    }

    public void setPath (FixedPath path) {
        this.path = path;
    }

    public void setDirection (Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Traversal traversal)
            return path.equals(traversal.getPath()) && direction.equals(traversal.getDirection());
       return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(path, direction);
    }
} // end class Traverse
