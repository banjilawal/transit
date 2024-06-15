package com.lawal.transit.sections;

import com.lawal.transit.*;
import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.road.interfaces.*;
import com.lawal.transit.sections.interfaces.*;

import java.util.*;

public class Border implements Borderable {

    private Orientation orientation;
    private RoadLabeler roadLabeler;

    public Border (Orientation orientation, RoadLabeler roadLabeler) {
        this.orientation = orientation;
        this.roadLabeler = roadLabeler;
    }
    @Override
    public Orientation getOrientation () {
        return orientation;
    }

    @Override
    public RoadLabeler getRoadLabel () {
        return roadLabeler;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof  Borderable borderable)
            return orientation.equals(borderable.getOrientation()) && roadLabeler.equals(borderable.getRoadLabel());
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(orientation, roadLabeler);
    }

    @Override
    public String toString () {
        return orientation.print() + "ern " + getClass().getSimpleName()
            + ": " + roadLabeler.toString();
    }
}
