package com.lawal.transit.addresses;

import com.lawal.transit.addresses.interfaces.*;

import java.util.*;

public class RoadName implements RoadNameable {

    private String value;
    private String suffix;

    public RoadName (String value, String suffix) {
        this.value = value;
        this.suffix = suffix;
    }

    @Override
    public String getValue () {
        return value;
    }

    @Override
    public String getSuffix () {
        return suffix;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof RoadNameable roadNameable)
            return value.equalsIgnoreCase(roadNameable.getValue())
                && suffix.equalsIgnoreCase(roadNameable.getSuffix());
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(value, suffix);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + " value:" + value + " suffix:" + suffix;
    }
}
