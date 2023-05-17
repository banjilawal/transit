package com.lawal.transit.middleware.abstracts;

import java.util.Objects;

public abstract class DuplexPath extends NamedEntity {
    private SimplexPath forwardPath;
    private SimplexPath reversePath;

    public DuplexPath(int id, String name, SimplexPath forwardPath, SimplexPath reversePath) {
        super(id, name);
        this.forwardPath = forwardPath;
        this.reversePath = reversePath;
    }

    public SimplexPath getForwardPath () {
        return forwardPath;
    }

    public SimplexPath getReversePath () {
        return reversePath;
    }

    public void setForwardPath (SimplexPath forward) {
        this.forwardPath = forward;
    }

    public void setReversePath (SimplexPath reverse) {
        this.reversePath = reverse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), forwardPath, reversePath);
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof DuplexPath) {
            DuplexPath duplexPath = (DuplexPath) object;
            if (super.equals(duplexPath)) {
                if (forwardPath.equals(duplexPath.getForwardPath()) && reversePath.equals(duplexPath.getReversePath())) {
                    return true;
                }
            }
        }
        return false;
    } // close equals
} // close SimplexPath
