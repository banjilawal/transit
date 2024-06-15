package com.lawal.transit.addresses;

import com.lawal.transit.*;
import com.lawal.transit.addresses.interfaces.*;
import com.lawal.transit.addresses.interfaces.Addressable;

import java.util.*;

public class LocationAddress  implements LocationAddressable {

    private final int id;
    private final String name;
    private final Orientation orientation;
    private final Addressable blockAddressable;
    private final RoadLabeler roadLabeler;

    public LocationAddress (
        int id,
        String name,
        Addressable blockAddressable,
        RoadLabeler roadLabeler,
        Orientation orientation
    ) {
        this.id = id;
        this.name = name;
        this.orientation = orientation;
        this.blockAddressable = blockAddressable;
        this.roadLabeler = roadLabeler;
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
    public Addressable getBlockAddress () {
        return blockAddressable;
    }

    @Override
    public RoadLabeler getRoadLabel () {
        return roadLabeler;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof LocationAddressable locationAddressable) {
            return id == locationAddressable.getId()
                && name.equalsIgnoreCase(locationAddressable.getName())
                && orientation.equals(locationAddressable.getOrientation())
                && blockAddressable.equals(locationAddressable.getBlockAddress())
                && roadLabeler.equals(locationAddressable.getRoadLabel());
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, name, orientation, blockAddressable, roadLabeler);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + " id:" + id + " name:" + getName()
            + " blockAddressable:" + blockAddressable.toString()
            + " road:" + roadLabeler.toString() + " " + orientation.print();
    }
}
