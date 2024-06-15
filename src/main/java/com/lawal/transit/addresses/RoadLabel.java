package com.lawal.transit.addresses;

import com.lawal.transit.addresses.interfaces.*;

import java.util.*;

public class RoadLabel implements RoadLabeler {

    private final int id;
    private final RoadNameable roadNameable;

    public RoadLabel (int id, RoadNameable roadNameable) {
        this.id = id;
        this.roadNameable = roadNameable;
    }

    @Override
    public int getId () {
        return id;
    }

    @Override
    public RoadNameable getName () {
        return roadNameable;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof RoadLabeler roadLabeler)
            return id == roadLabeler.getId() && roadNameable.equals(roadLabeler.getName());
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, roadNameable);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + " id:" + id + " name:" + roadNameable.toString();
    }
}
