//package com.lawal.transit.junction;
//
//import com.lawal.transit.global.Direction;
//import com.lawal.transit.road.Avenue;
//import com.lawal.transit.road.Street;
//import com.lawal.transit.road.interfaces.Curbsideable;
//import lombok.*;
//
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//public class JunctionCorner {
//    private final long id;
//    private final Direction orientation;
//    private final Avenue avenue;
//    private final Street street;
//
//    public Curbsideable getAvenueCurbside () {
//        if (orientation == Direction.NORTHEAST || orientation == Direction.NORTHWEST) {
//            return avenue.getCurb(Avenue.RIGHTWARD_TRAFFIC_DIRECTION);
//        }
//        else if (orientation == Direction.SOUTHEAST || orientation == Direction.SOUTHWEST) {
//            return avenue.getCurb(Avenue.LEFTWARD_TRAFFIC_DIRECTION);
//        } else {
//            return null;
//        }
//    }
//
//    public Curbsideable getStreetCurbside () {
//        if (orientation == Direction.NORTHEAST || orientation == Direction.NORTHWEST) {
//            return street.getCurb(Street.RIGHTWARD_TRAFFIC_DIRECTION);
//        }
//        else if (orientation == Direction.SOUTHEAST || orientation == Direction.SOUTHWEST) {
//            return street.getCurb(Avenue.LEFTWARD_TRAFFIC_DIRECTION);
//        } else {
//            return null;
//        }
//    }
//
//
//
//
//
//
//}