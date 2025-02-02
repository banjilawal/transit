package com.lawal.transit.junction;

import com.lawal.transit.block.Block;
import com.lawal.transit.global.Direction;
import com.lawal.transit.road.*;

import java.util.Objects;


public record Junction(int id, Avenue avenue, Street street) {

    @Override
    public boolean equals (Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof Junction junction) {
            return id == junction.id();
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hashCode(id);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + " id:" + id + " " + avenue.label().name() + " and " + street.label().name();
    }

    public Block getNorthEastAveLeg () {
        return new JunctionCorner(Direction.NORTHEAST, avenue, street).getAvenueLeg();
    }

    public Block getNorthEastStreetLeg () {
        return new JunctionCorner(Direction.NORTHEAST, avenue, street).getStreetLeg();
    }
}