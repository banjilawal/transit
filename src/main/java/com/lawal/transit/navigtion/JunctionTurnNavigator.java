package com.lawal.transit.navigtion;

import com.lawal.transit.block.model.Block;
import com.lawal.transit.global.Direction;

import com.lawal.transit.global.TurnCategory;
import com.lawal.transit.junction.model.Junction;
import com.lawal.transit.avenue.model.Avenue;

import com.lawal.transit.street.model.Street;

import java.util.concurrent.atomic.AtomicLong;

public class JunctionTurnNavigator {

    public static Block getDestinationBlockFromAvenue (Junction junction, Block currentAvenueBlock, TurnCategory turnCategory) {
        Avenue junctionAvenue = junction.getAvenue();
        Direction currentCurbOrientation = currentAvenueBlock.getCurb().getOrientation();

        if (currentCurbOrientation == Direction.NORTH) {
            if (turnCategory == TurnCategory.LEFT_TURN) {
                return junction.getCornerByOrientation(Direction.NORTH.leftTurnFrom()).getStreetLeg();
            } else if (turnCategory == TurnCategory.RIGHT_TURN) {
                return junction.getCornerByOrientation(Direction.NORTH.rightTurnFrom()).getStreetLeg();
            } else if (turnCategory == TurnCategory.REVERSE) {
                return junction.getCornerByOrientation(Direction.NORTH.reverseTurnCurbDirection()).getAvenueLeg();
            } else if (turnCategory == TurnCategory.NO_TURN) {
                return junction.getCornerByOrientation(Direction.NORTHEAST).getAvenueLeg();
            } else return null;
        }

        if (currentCurbOrientation == Direction.SOUTH) {
            if (turnCategory == TurnCategory.LEFT_TURN) {
                return junction.getCornerByOrientation(Direction.SOUTH.leftTurnFrom()).getStreetLeg();
            } else if (turnCategory == TurnCategory.RIGHT_TURN) {
                return junction.getCornerByOrientation(Direction.SOUTH.rightTurnFrom()).getStreetLeg();
            } else if (turnCategory == TurnCategory.REVERSE) {
                return junction.getCornerByOrientation(Direction.SOUTH.reverseTurnCurbDirection()).getAvenueLeg();
            } else if (turnCategory == TurnCategory.NO_TURN) {
                return junction.getCornerByOrientation(Direction.SOUTHWEST).getAvenueLeg();
            } else return null;
        }
        return null;
    }

    public static Block getDestinationBlockFromStreet (Junction junction, Block currentStreetBlock, TurnCategory turnCategory) {

        Street junctionStreet = junction.getStreet();
        Direction currentCurbOrientation = currentStreetBlock.getCurb().getOrientation();

        if (currentCurbOrientation == Direction.WEST) {
            if (turnCategory == TurnCategory.LEFT_TURN) {
                return junction.getCornerByOrientation(Direction.WEST.leftTurnFrom()).getAvenueLeg();
            } else if (turnCategory == TurnCategory.RIGHT_TURN) {
                return junction.getCornerByOrientation(Direction.WEST.rightTurnFrom()).getAvenueLeg();
            } else if (turnCategory == TurnCategory.REVERSE) {
                return junction.getCornerByOrientation(Direction.WEST.reverseTurnCurbDirection()).getStreetLeg();
            } else if (turnCategory == TurnCategory.NO_TURN) {
                return junction.getCornerByOrientation(Direction.NORTHWEST).getStreetLeg();
            } else return null;
        }

        if (currentCurbOrientation == Direction.EAST) {
            if (turnCategory == TurnCategory.LEFT_TURN) {
                return junction.getCornerByOrientation(Direction.EAST.leftTurnFrom()).getAvenueLeg();
            } else if (turnCategory == TurnCategory.RIGHT_TURN) {
                return junction.getCornerByOrientation(Direction.EAST.rightTurnFrom()).getAvenueLeg();
            } else if (turnCategory == TurnCategory.REVERSE) {
                return junction.getCornerByOrientation(Direction.EAST.reverseTurnCurbDirection()).getStreetLeg();
            } else if (turnCategory == TurnCategory.NO_TURN) {
                return junction.getCornerByOrientation(Direction.SOUTHEAST).getStreetLeg();
            } else return null;
        }
        return null;
    }
}