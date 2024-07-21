package com.lawal.transit.globals;

import com.lawal.transit.*;

import com.lawal.transit.road.*;

import java.util.*;

public class Address implements FormattedAddress {

    private final int id;
    private final String name;
    private final Orientation orientation;
    private final RoadIdentifiable roadIdentity;

    public Address (
        int id,
        String name,
        Road road,
        RoadLateral roadLateral
    ) {
        this.id = id;
        this.name = name;
        this.roadIdentity = road.getIdentifier();
        this.orientation = getOrientation(road, roadLateral);
    }

    @Override
    public int getId () {
        return id;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public Orientation getOrientation () {
        return orientation;
    }

    @Override
    public RoadIdentifiable getRoadIdentity () {
        return roadIdentity;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof FormattedAddress locationAddressable) {
            return id == locationAddressable.getId()
                && name.equalsIgnoreCase(locationAddressable.getName())
                && orientation.equals(locationAddressable.getOrientation())
                && roadIdentity.equals(locationAddressable.getRoadIdentity());
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, name, orientation, roadIdentity);
    }

    @Override
    public String toString () {
        return name + " " + roadIdentity.getName() + " " + roadIdentity.getCategory().abbreviation()
            + " " + orientation.abbreviation();
    }

    private Orientation getOrientation (Road road, RoadLateral roadLateral) {
        if (roadLateral == RoadLateral.RIGHT)
            return road.getRightLanes().getTrafficDirection();
        else
            return road.getLeftLanes().getTrafficDirection();
    }
}
