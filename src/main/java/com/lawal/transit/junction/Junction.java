package com.lawal.transit.junction;

import com.lawal.transit.block.Block;
import com.lawal.transit.global.Direction;
import com.lawal.transit.road.*;
import com.lawal.transit.road.contract.Road;

import java.util.Objects;


public record Junction(int id, Avenue avenue, Street street) {

    @Override
    public boolean equals(Object object) {
        if (object == this) return true;
        if (object == null) return false;
        if (object instanceof Junction junction) {
            return id == junction.id();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[id:" + id + " " + avenue.label().name() + " and " + street.label().name() + "]";
    }
//
//    public Block getNorthEastAveLeg() {
//        return new JunctionCorner(Direction.NORTHEAST, avenue, street).getAvenueLeg();
//    }
//
//    public Block getNorthEastStreetLeg() {
//        return new JunctionCorner(Direction.NORTHEAST, avenue, street).getStreetLeg();
//    }
//
//    public Block getNorthWestAveLeg() {
//        return new JunctionCorner(Direction.NORTHWEST, avenue, street).getAvenueLeg();
//    }
//
//    public Block getNorthWestStreetLeg() {
//        return new JunctionCorner(Direction.NORTHWEST, avenue, street).getStreetLeg();
//    }
//
//    public Block getSouthEastAveLeg() {
//        return new JunctionCorner(Direction.SOUTHEAST, avenue, street).getAvenueLeg();
//    }
//
//    public Block getSouthEastStreetLeg() {
//        return new JunctionCorner(Direction.SOUTHEAST, avenue, street).getStreetLeg();
//    }
//
//    public Block getSouthWestAveLeg() {
//        return new JunctionCorner(Direction.SOUTHWEST, avenue, street).getAvenueLeg();
//    }
//
//    public Block getSouthWestStreetLeg() {
//        return new JunctionCorner(Direction.SOUTHWEST, avenue, street).getStreetLeg();
//    }
    
//    public Direction getOrientation(Block junctionLeg) {
//
//
//    }
//
//    private Road getOppositeRoad(Road road) {
//        if (road instanceof Avenue) return street;
//        else return avenue;
//    }
}