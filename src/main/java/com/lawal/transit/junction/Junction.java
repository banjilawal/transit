//package com.lawal.transit.junction;
//
//import com.lawal.transit.block.interfaces.*;
//import com.lawal.transit.global.Direction;
//import com.lawal.transit.road.*;
//
//import java.util.HashMap;
//
//public class Junction implements JUnctionEntity {
//    int id,
//    Avenue avenue,
//    Street street,
//    HashMap<Direction, RoadSegment> branches;
//
//    public Junction (int id, Avenue avenue, Street street street) {
//        this.id = id;
//        this.avenue = avenue;
//        this.street = street;
//
//        branches = new HashMap<>();
//
//        if (street.label().id() == avenue.label().id()) {
//            branches.put(Direction.EAST, avenue.rightCurb().blocks().findBlock(street.label().id() + 1));
//            branches.put(Direction.WEST, avenue.leftCurb().blocks().findBlock(street.label().id() + 1));
//            branches.put(Direction.SOUTH, street.rightCurb().blocks().findBlock(avenue.label().id() + 1));
//            branches.put(Direction.NORTH, street.leftCurb().blocks().findBlock(avenue.label().id() + 1));
//        }
//        branches.put(Direction.NORTH, stre);
//    }
//
//
//    RoadSegment northBranch,
//    RoadSegment eastBranch,
//    RoadSegment southBranch,
//    RoadSegment westBranch,
//    RoadSegment turnNorthEastBranch,
//    RoadSegment turnSouthEastBranch,
//    RoadSegment turnSouthWestBranch,
//    RoadSegment turnNorthWestBranch
//) implements JunctionEntity {
//
//    @Override
//    public String toString() {
//        return getClass().getSimpleName() + " id:" + id + " " + avenue.label().name() + " and " + street.label().name();
//    }
//
//    public RoadSegment findBlock (RoadSegment roadSegment) {
//        if (roadSegment.equals(northBranch)) return northBranch;
//    }
//
//    public Builder builder () {
//        return new Builder();
//    }
//
//    public static class Builder {
//
//        private int id;
//        private Avenue avenue;
//        private Street street;
//
//        public Builder () {}
//
//        public Builder id (int id) {
//            this.id = id;
//            return this;
//        }
//
//        public Builder avenue (Avenue avenue) {
//            this.avenue = avenue;
//            return this;
//        }
//
//        public Builder street (Street street) {
//            this.street = street;
//            return this;
//        }
//
//        public Junction build () {
//            RoadSegment northBranch = street.leftCurb().blocks().findBlock(avenue.label().id());
//            RoadSegment southBranch = street.rightCurb().blocks().findBlock(avenue.label().id());
//            RoadSegment westBranch = avenue.leftCurb().blocks().findBlock(street.label().id());
//            RoadSegment eastBranch = avenue.rightCurb().blocks().findBlock(street.label().id());
//            RoadSegment turnNorthEastBranch = avenue.rightCurb().blocks().findBlock(street.label().id() + 1);
//            RoadSegment turnNorthWestBranch = avenue.leftCurb().blocks().findBlock(street.label().id() + 1);
//            RoadSegment turnSouthWestBranch = street.leftCurb().blocks().findBlock(avenue.label().id() + 1);
//            RoadSegment turnSouthEastBranch = avenue.leftCurb().blocks().findBlock(street.label().id());
//
//            return new Junction(
//                id,
//                avenue,
//                street,
//                northBranch,
//                eastBranch,
//                southBranch,
//                westBranch,
//                turnNorthEastBranch,
//                turnSouthEastBranch,
//                turnSouthWestBranch,
//                turnNorthWestBranch
//            );
//        }
//    }
//}