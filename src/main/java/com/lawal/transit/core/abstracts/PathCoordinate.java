package com.lawal.transit.core.abstracts;

import static java.util.Objects.hash;

public abstract class PathCoordinate {
    private FixedPath xPath;
    private FixedPath yPath;


    public PathCoordinate (FixedPath xPath, FixedPath yPath) {
        this.xPath = xPath;
        this.yPath = yPath;
    }

    public FixedPath getXPath( ) {
        return xPath;
    }

    public FixedPath getYPath () {
        return yPath;
    }


    public void setXPath (FixedPath xPath) {
        this.xPath = xPath;
    }

    public void setYPath (FixedPath yPath) {
        this.yPath = yPath;
    }



    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof PathCoordinate coordinate) {
            return xPath.equals(coordinate.getXPath()) && yPath.equals(coordinate.getYPath());
        }
        return false;
    } // close equals

    @Override
    public int hashCode() {
        return hash(super.hashCode(), xPath, yPath);
    }

    @Override
    public String toString () {
        return this.getClass().getSimpleName() + " xPath:" + xPath.getName() + ", yPath:" + yPath.getName();
    }
} // end class PathCoordinate