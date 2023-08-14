package com.lawal.transit.core.abstracts;

import com.lawal.transit.core.enums.Direction;

import java.util.Objects;

public abstract class Traverse {
    Path path;
    Direction direction;

    public Traverse (Path path, Direction direction) {
        this.path = path;
        this.direction = direction;
    }

    public Path getPath () {
        return path;
    }

    public Direction getDirection () {
        return direction;
    }

    public void setPath (Path path) {
        this.path = path;
    }

    public void setDirection (Direction direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (!(object instanceof Traverse traverse)) return false;
        return Objects.equals(path, traverse.path) && direction == traverse.direction;
    }

    @Override
    public int hashCode () {
        return Objects.hash(path, direction);
    }
} // end class Traverse
