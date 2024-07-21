package com.lawal.transit.fx;

import com.lawal.transit.Coordinate;

import java.util.*;

public final class RectangleDimension {
    private final Coordinate coordinate;
    private final double width;
    private final double height;

    public RectangleDimension (Coordinate coordinate, double width, double height) {
        this.coordinate = coordinate;
        this.width = width;
        this.height = height;
    }

    public Coordinate getCoordinate () {
        return coordinate;
    }

    public  double getWidth () {
        return width;
    }

    public double getHeight () {
        return height;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof RectangleDimension rectangleDimension)
            return coordinate.equals(rectangleDimension.getCoordinate())
                && width - rectangleDimension.getWidth() == 0
                && height - rectangleDimension.getHeight() == 0;
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(coordinate, width, height);
    }

    @Override
    public String toString () {
        return coordinate.toString() + " width:" + width + " height:" + height;
    }
}
