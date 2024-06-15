package com.lawal.transit.core.abstracts;

import com.lawal.transit.Orientation;

import java.util.Objects;

public abstract class Traversal {
    private FixedPath path;
    private Orientation orientation;

    public Traversal(FixedPath path, Orientation orientation) {
        this.path = path;
        this.orientation = orientation;
    }

    public FixedPath getPath () {
        return path;
    }

    public Orientation getDirection () {
        return orientation;
    }

    public void setPath (FixedPath path) {
        this.path = path;
    }

    public void setDirection (Orientation orientation) {
        this.orientation = orientation;
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Traversal traversal)
            return path.equals(traversal.getPath()) && orientation.equals(traversal.getDirection());
       return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(path, orientation);
    }
} // end class Traverse
