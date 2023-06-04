package com.lawal.transit.core.abstracts;

import java.util.Objects;

public abstract class DuplexPath extends NamedEntity {
    private SimplexPath path;
    private SimplexPath reversePath;

    public DuplexPath(int id, String name, SimplexPath path) {
        super(id, name);
        this.path = path;
        this.reversePath = path.oppositePath();
    } //

    public SimplexPath getPath () {
        return path;
    }

    public SimplexPath getReversePath () {
        return reversePath;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), path, reversePath);
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof DuplexPath) {
            DuplexPath duplexPath = (DuplexPath) object;
            if (super.equals(duplexPath)) {
                if (path.equals(duplexPath.getPath()) && reversePath.equals(duplexPath.getReversePath())) {
                    return true;
                }
            }
        }
        return false;
    } // close equals
} // close SimplexPath
