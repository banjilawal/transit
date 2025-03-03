//package com.lawal.transit;
//
//import com.lawal.transit.avenue.model.Avenue;
//import com.lawal.transit.block.model.Block;
//import com.lawal.transit.global.Direction;
//import com.lawal.transit.global.TurnCategory;
//import com.lawal.transit.junction.model.Junction;
//import com.lawal.transit.street.model.Street;
//
//import java.util.concurrent.atomic.AtomicLong;
//
//public class EdgePopulatorCopy {
//
//    private static AtomicLong edgeId = new AtomicLong(0);
//
//
//    public static Block getDestinationBlockFromAvenue(Junction junction, Block currentAvenueBlock, TurnCategory turnCategory) {
//
//        Avenue junctionAvenue = junction.getAvenue();
//        Direction currentCurbOrientation = currentAvenueBlock.getCurb().getOrientation();
//
//        if (currentCurbOrientation == Direction.NORTH) {
//            if (turnCategory == TurnCategory.LEFT_TURN) {
//                return junction.getCornerByOrientation(Direction.NORTH.leftTurnFrom()).getStreetLeg();
//            } else if (turnCategory == TurnCategory.RIGHT_TURN) {
//                return junction.getCornerByOrientation(Direction.NORTH.rightTurnFrom()).getStreetLeg();
//            } else if (turnCategory == TurnCategory.REVERSE) {
//                return junction.getCornerByOrientation(Direction.NORTH.reverseTurnCurbDirection()).getAvenueLeg();
//            } else if (turnCategory == TurnCategory.NO_TURN) {
//                return junction.getCornerByOrientation(Direction.NORTHEAST).getAvenueLeg();
//            } else return null;
//        }
//
////        if (junctionAvenue.getTrafficDirectionByCurbOrientation(Avenue.LEFT_CURB_ORIENTATION) == Direction.EAST) {
////            if (turnCategory == TurnCategory.LEFT_TURN) {
////                return junction.getCornerByOrientation(Direction.NORTHEAST).getStreetLeg();
////            } else if (turnCategory == TurnCategory.RIGHT_TURN) {
////                return junction.getCornerByOrientation(Direction.SOUTHWEST).getStreetLeg();
////            } else if (turnCategory == TurnCategory.REVERSE) {
////                return junction.getCornerByOrientation(Direction.NORTHWEST).getAvenueLeg();
////            } else if (turnCategory == TurnCategory.NO_TURN) {
////                return junction.getCornerByOrientation(Direction.SOUTHEAST).getAvenueLeg();
////            } else return null;
////        }
//
//        if (currentCurbOrientation == Direction.SOUTH) {
//            if (turnCategory == TurnCategory.LEFT_TURN) {
//                return junction.getCornerByOrientation(Direction.SOUTH.leftTurnFrom()).getStreetLeg();
//            }
//            else if (turnCategory == TurnCategory.RIGHT_TURN) {
//                return junction.getCornerByOrientation(Direction.SOUTH.rightTurnFrom()).getStreetLeg();
//            }
//            else if (turnCategory == TurnCategory.REVERSE) {
//                return junction.getCornerByOrientation(Direction.SOUTH.reverseTurnCurbDirection()).getAvenueLeg();
//            }
//            else if (turnCategory == TurnCategory.NO_TURN) {
//                return junction.getCornerByOrientation(Direction.SOUTHWEST).getAvenueLeg();
//            } else return null;
//        }
//
////        if (junctionAvenue.getTrafficDirectionByCurbOrientation(Avenue.RIGHT_CURB_ORIENTATION) == Direction.WEST) {
////            if (turnCategory == TurnCategory.LEFT_TURN) {
////                return junction.getCornerByOrientation(Direction.SOUTHWEST).getStreetLeg();
////            }
////            else if (turnCategory == TurnCategory.RIGHT_TURN) {
////                return junction.getCornerByOrientation(Direction.NORTHWEST).getStreetLeg();
////            }
////            else if (turnCategory == TurnCategory.REVERSE) {
////                return junction.getCornerByOrientation(Direction.SOUTHEAST).getAvenueLeg();
////            }
////            else if (turnCategory == TurnCategory.NO_TURN) {
////                return junction.getCornerByOrientation(Direction.NORTHWEST).getAvenueLeg();
////            } else return null;
////        }
//        return null;
//    }
//
//    public static Block getDestinationBlockFromStreet(Junction junction, Block currentStreetBlock, TurnCategory turnCategory) {
//
//            Street junctionStreet = junction.getStreet();
//            Direction currentCurbOrientation = currentStreetBlock.getCurb().getOrientation();
////            if (currentCurb == null) return null;
///* Street orientations
//        public static final Direction RIGHTWARD_TRAFFIC_DIRECTION = Direction.NORTH;
//        public static final Direction LEFTWARD_TRAFFIC_DIRECTION = Direction.SOUTH;
//
//        public static final Direction LEFT_CURB_ORIENTATION = Direction.WEST;
//        public static final Direction RIGHT_CURB_ORIENTATION = Direction.EAST;
//
//           public Direction getTrafficDirectionFromByCurbOrientation(Direction curbOrientation) {
//        if (curbOrientation == LEFT_CURB_ORIENTATION) return LEFTWARD_TRAFFIC_DIRECTION;
//        else if (curbOrientation == RIGHT_CURB_ORIENTATION) return RIGHTWARD_TRAFFIC_DIRECTION;
//        else return null;
//    }
//*/
//        if (currentCurbOrientation == Direction.WEST) {
//            if (turnCategory == TurnCategory.LEFT_TURN) {
//                return junction.getCornerByOrientation(Direction.WEST.leftTurnFrom()).getAvenueLeg();
//            } else if (turnCategory == TurnCategory.RIGHT_TURN) {
//                return junction.getCornerByOrientation(Direction.WEST.rightTurnFrom()).getAvenueLeg();
//            } else if (turnCategory == TurnCategory.REVERSE) {
//                return junction.getCornerByOrientation(Direction.WEST.reverseTurnCurbDirection()).getStreetLeg();
//            } else if (turnCategory == TurnCategory.NO_TURN) {
//                return junction.getCornerByOrientation(Direction.NORTHWEST).getStreetLeg();
//            } else return null;
//        }
//
//        if (currentCurbOrientation == Direction.EAST) {
//            if (turnCategory == TurnCategory.LEFT_TURN) {
//                return junction.getCornerByOrientation(Direction.EAST.leftTurnFrom()).getAvenueLeg();
//            } else if (turnCategory == TurnCategory.RIGHT_TURN) {
//                return junction.getCornerByOrientation(Direction.EAST.rightTurnFrom()).getAvenueLeg();
//            } else if (turnCategory == TurnCategory.REVERSE) {
//                return junction.getCornerByOrientation(Direction.EAST.reverseTurnCurbDirection()).getStreetLeg();
//            } else if (turnCategory == TurnCategory.NO_TURN) {
//                return junction.getCornerByOrientation(Direction.SOUTHEAST).getStreetLeg();
//            } else return null;
//        }
//
////
////            if (junctionStreet.getTrafficDirectionFromByCurbOrientation(Street.LEFT_CURB_ORIENTATION) == Direction.SOUTH) {
////                if (turnCategory == TurnCategory.LEFT_TURN) {
////                    return junction.getCornerByOrientation(Direction.SOUTHEAST).getAvenueLeg();
////                } else if (turnCategory == TurnCategory.RIGHT_TURN) {
////                    return junction.getCornerByOrientation(Direction.NORTHWEST).getAvenueLeg();
////                } else if (turnCategory == TurnCategory.REVERSE) {
////                    return junction.getCornerByOrientation(Direction.NORTHEAST).getStreetLeg();
////                } else if (turnCategory == TurnCategory.NO_TURN) {
////                    return junction.getCornerByOrientation(Direction.SOUTHWEST).getStreetLeg();
////                } else return null;
////            }
////
////            if (junctionStreet.getTrafficDirectionFromByCurbOrientation(Street.RIGHT_CURB_ORIENTATION) == Direction.NORTH) {
////                if (turnCategory == TurnCategory.LEFT_TURN) {
////                    return junction.getCornerByOrientation(Direction.NORTHWEST).getAvenueLeg();
////                }
////                else if (turnCategory == TurnCategory.RIGHT_TURN) {
////                    return junction.getCornerByOrientation(Direction.SOUTHEAST).getAvenueLeg();
////                }
////                else if (turnCategory == TurnCategory.REVERSE) {
////                    return junction.getCornerByOrientation(Direction.SOUTHWEST).getStreetLeg();
////                }
////                else if (turnCategory == TurnCategory.NO_TURN) {
////                    return junction.getCornerByOrientation(Direction.NORTHEAST).getStreetLeg();
////                } else return null;
////            }
//            return null;
//        }
//}