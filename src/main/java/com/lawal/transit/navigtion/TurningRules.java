package com.lawal.transit.navigtion;

import com.lawal.transit.global.Direction;
import com.lawal.transit.avenue.model.Avenue;
import com.lawal.transit.street.model.Street;

public class TurningRules {

    private TurningRules () {}

    public Direction  leftFromAvenue (Direction currentDirection) {
        if (currentDirection == Avenue.RIGHTWARD_TRAFFIC_DIRECTION)
            return Street.LEFTWARD_TRAFFIC_DIRECTION;
        else if (currentDirection == Avenue.LEFTWARD_TRAFFIC_DIRECTION)
            return Street.RIGHTWARD_TRAFFIC_DIRECTION;
        else return null;
    }

    public Direction  rightFromAvenue (Direction currentDirection) {
        if (currentDirection == Avenue.RIGHTWARD_TRAFFIC_DIRECTION)
            return Street.RIGHTWARD_TRAFFIC_DIRECTION;
        else if (currentDirection == Avenue.LEFTWARD_TRAFFIC_DIRECTION)
            return Street.RIGHTWARD_TRAFFIC_DIRECTION;
        else return null;
    }

    public Direction  leftFromStreet (Direction currentDirection) {
        if (currentDirection == Street.RIGHTWARD_TRAFFIC_DIRECTION)
            return Avenue.LEFTWARD_TRAFFIC_DIRECTION;
        else if (currentDirection == Street.LEFTWARD_TRAFFIC_DIRECTION)
            return Avenue.RIGHTWARD_TRAFFIC_DIRECTION;
        else return null;
    }

    public Direction  rightFromStreet (Direction currentDirection) {
        if (currentDirection == Street.RIGHTWARD_TRAFFIC_DIRECTION)
            return Avenue.LEFTWARD_TRAFFIC_DIRECTION;
        else if (currentDirection == Street.LEFTWARD_TRAFFIC_DIRECTION)
            return Avenue.RIGHTWARD_TRAFFIC_DIRECTION;
        else return null;
    }
}