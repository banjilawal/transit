package com.lawal.transitcraft.infrastructure.road.exception;

import com.lawal.transitcraft.common.exception.TransitCraftException;

public class RoadRequiredException extends TransitCraftException {

    public static final String MESSAGE = "Road must be provided - null value is not allowed";

    public RoadRequiredException (String message) {
        super(message);
    }
}