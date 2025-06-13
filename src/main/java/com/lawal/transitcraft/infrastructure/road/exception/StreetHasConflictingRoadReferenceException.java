package com.lawal.transitcraft.infrastructure.road.exception;

import com.lawal.transitcraft.common.exception.TransitCraftException;

public class StreetHasConflictingRoadReferenceException extends TransitCraftException {

    public static final String MESSAGE = "Cannot establish road-street relationship - street is already linked to another road";

    public StreetHasConflictingRoadReferenceException (String message) {
        super(message);
    }
}