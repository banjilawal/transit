package com.lawal.transit;

import java.util.*;

public class Coordinate {

    private double x;
    private double y;

    public Coordinate (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX () {
        return x;
    }

    public double getY () {
        return y;
    }

    public void setX (double x) {
        this.x = x;
    }

    public void setY (double y) {
        this.y = y;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Coordinate that = (Coordinate) object;
        return Double.compare(x, that.x) == 0 && Double.compare(y, that.y) == 0;
    }

    @Override
    public int hashCode () {
        return Objects.hash(x, y);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + ":(" + x + ", " + y + ")";
    }
}
