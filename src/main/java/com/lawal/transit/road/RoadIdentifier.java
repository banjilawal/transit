package com.lawal.transit.road;

import com.lawal.transit.road.interfaces.*;

public final class RoadIdentifier implements RoadIdentifiable {

    private final RoadCategory category;
    private final String name;
    private final int id;



    public RoadIdentifier (RoadCategory category,  String name, int id) {
        this.category = category;
        this.name = name;
        this.id = id;

    }

    @Override
    public RoadCategory getCategory () {
        return category;
    }

    @Override
    public String getName () {
        return name;
    }

    @Override
    public int getId () {
        return id;
    }



    @Override
    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof RoadIdentifiable identity) {
            return category == identity.getCategory() && id == identity.getId()
                && name.equalsIgnoreCase(identity.getName());
        }
        return false;
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + " id:" + id + "  "  + name + " " + category.toString();
    }
}
