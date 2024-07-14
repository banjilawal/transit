package com.lawal.transit;

import java.util.*;

public class LineCoordinates {

    private final Coordinate start;
    private final Coordinate end;

    private LineCoordinates (Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;
    }

    private Coordinate getStart () {
        return start;
    }

    private Coordinate getEnd () {
        return end;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        LineCoordinates that = (LineCoordinates) object;
        return Objects.equals(start, that.start) && Objects.equals(end, that.end);
    }

    @Override
    public int hashCode () {
        return Objects.hash(start, end);
    }

    @Override
    public String toString () {
        return "LineCoordinates{" +
            "start=" + start +
            ", end=" + end +
            '}';
    }
}
