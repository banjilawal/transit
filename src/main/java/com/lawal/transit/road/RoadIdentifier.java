package com.lawal.transit.road;

import java.util.*;

public final class RoadIdentifier implements RoadIdentifiable {

    private final int id;
    private final String name;
    private final RoadCategory category;

    public RoadIdentifier (int id, String name, RoadCategory category) {
        this.id = id;
        this.name = name;
        this.category = category;
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
    public RoadCategory getCategory () {
        return category;
    }

    @Override
    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof RoadIdentifier identifier)
            return id == identifier.getId()
                && name.equalsIgnoreCase(identifier.getName())
                && category.equals(identifier.getCategory());
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(id, name, category);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + " id:" + id + "  "  + name + " " + category.toString();
    }
}
