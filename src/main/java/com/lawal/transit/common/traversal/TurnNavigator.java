package com.lawal.transit.common.traversal;

import com.lawal.transit.infrastructure.block.Block;
import com.lawal.transit.common.Direction;

import com.lawal.transit.common.TurnCategory;
import com.lawal.transit.infrastructure.junction.Junction;

import com.lawal.transit.infrastructure.junction.JunctionCorner;

public class TurnNavigator {

    public static Block destinationFromAvenue(Junction junction, Direction cornerDirection, TurnCategory turnCategory) {
        if (junction == null || cornerDirection == null || turnCategory == null) {
            System.out.println("junction and cornerDirection and turnCategory are null");
            return null;
        }
        Block currentAvenueBlock = junction.getCornersAsMap().get(Direction.NORTHEAST).getAvenueLeg();
        if (currentAvenueBlock == null) {
            System.out.println("TurnNavigator.destinationFromAvenue().currentAvenueBlock is null");
            return null;
        }
        System.out.println("TurnNavigator.destinationFromAvenue().currentAvenueBlock is " + currentAvenueBlock.toString());
        JunctionCorner sourceCorner = junction.getCornerByOrientation(cornerDirection);
        if (sourceCorner == null) {
            System.out.println("TurnNavigator.destinationFromAvenue().sourceCorner is null");
            return null;
        }
        Block sourceBlock = sourceCorner.getAvenueLeg();
        if (sourceBlock == null) {
            System.out.println("TurnNavigator.destinationFromAvenue().sourceBlock is null");
            return null;
        }

        Direction sourceBlockOrientation = sourceBlock.getCurb().getOrientation();
        if (sourceBlockOrientation == null) {
            System.out.println("TurnNavigator:sourceOrientation.sourceOrientation:\" is null");
            return null;
        }
//  //      System.out.println("TurnNavigator.destinationFromAvenue().sourceOrientation:" + sourceBlockOrientation.toString());

        Block destinationBlock = null;
        JunctionCorner destinationCorner = null;
        switch(turnCategory) {
            case LEFT_TURN:
                destinationCorner = junction.getCornerByOrientation(sourceCorner.getOrientation().leftTurnFrom());
                System.out.println("TurnNavigator.destinationFromAvenue().LEFT_TURN_destinationCorner:" + destinationCorner.getOrientation());
                destinationBlock = destinationCorner.getStreetLeg();
                return destinationBlock;
            case RIGHT_TURN:
                destinationCorner = junction.getCornerByOrientation(sourceCorner.getOrientation().rightTurnFrom());
                System.out.println("TurnNavigator.destinationFromAvenue().RIGHT_TURN_destinationCorner:" + destinationCorner.getOrientation());
                destinationBlock = destinationCorner.getStreetLeg();
                return destinationBlock;
            case REVERSE:
                destinationCorner = junction.getCornerByOrientation(sourceCorner.getOrientation().reverseTo());
                System.out.println("TurnNavigator.destinationFromAvenue().REVERSE_destinationCorner:" + destinationCorner.getOrientation());
                destinationBlock = destinationCorner.getAvenueLeg();
                return destinationBlock;
            case NO_TURN:
                destinationCorner = junction.getCornerByOrientation(sourceCorner.getOrientation().forwardTo());
                System.out.println("TurnNavigator.destinationFromAvenue().NO_TURN_destinationCorner:" + destinationCorner.getOrientation());
                destinationBlock = destinationCorner.getAvenueLeg();
                if (destinationBlock == null) {
                    System.out.println("TurnNavigator.destinationFromAvenue().NO_TURN_destinationBlock is No more blocks forward");
                    return sourceBlock;
                }
                return destinationBlock;
            default:
                System.out.println("TurnNavigator.destinationFromAvenue(): invalid turnCategory:" + turnCategory.toString());
        }
        return destinationBlock;
    }

    public static Block destinationFromStreet(Junction junction, Direction cornerOrientation, TurnCategory turnCategory) {
        if (junction == null || cornerOrientation == null || turnCategory == null) {
            System.out.println("junction and cornerDirection and turnCategory are null");
            return null;
        }

        JunctionCorner sourceCorner = junction.getCornerByOrientation(cornerOrientation);
        if (sourceCorner == null) {
            System.out.println("TurnNavigator.destinationFromStreet().sourceCorner is null");
            return null;
        }
        Block sourceBlock = sourceCorner.getStreetLeg();
        if (sourceBlock == null) {
            System.out.println("TurnNavigator.destinationFromStreet().sourceBlock is null");
            return null;
        }
        Direction sourceBlockOrientation = sourceBlock.getCurb().getOrientation();
        if (sourceBlockOrientation == null) {
            System.out.println("TurnNavigator:sourceOrientation.sourceOrientation:\" is null");
            return null;
        }
        System.out.println("TurnNavigator.destinationFromStreet().sourceOrientation:" + sourceBlockOrientation.toString());

        Block destinationBlock = null;
        JunctionCorner destinationCorner = null;

        switch(turnCategory) {
            case LEFT_TURN:
                destinationCorner = junction.getCornerByOrientation(sourceCorner.getOrientation().leftTurnFrom());
                destinationBlock = destinationCorner.getAvenueLeg();
                return destinationBlock;
            case RIGHT_TURN:
                destinationCorner = junction.getCornerByOrientation(sourceCorner.getOrientation().rightTurnFrom());
                destinationBlock = destinationCorner.getAvenueLeg();
                return destinationBlock;
            case REVERSE:
                destinationCorner = junction.getCornerByOrientation(sourceCorner.getOrientation().reverseTo());
                destinationBlock = destinationCorner.getStreetLeg();
            case NO_TURN:
                destinationCorner = junction.getCornerByOrientation(sourceCorner.getOrientation().forwardTo());
                destinationBlock = destinationCorner.getStreetLeg();
                if (destinationBlock == null) {
                    System.out.println("TurnNavigator.destinationFromAvenue().NO_TURN_destinationBlock is No more blocks forward");
                    return sourceBlock;
                }
                return destinationBlock;
            default:
                System.out.println("TurnNavigator.destinationFromStreet(): invalid turnCategory:" + turnCategory.toString());
        }
        return destinationBlock;
//
//        Street junctionStreet = junction.getStreet();
//        Direction currentCurbOrientation = currentStreetBlock.getCurb().getOrientation();
//
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
//        return null;
    }
}