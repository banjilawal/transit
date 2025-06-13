package com.lawal.transitcraft.infrastructure.road.exception;

public class StreetAssignmentConflictsWithExistingAvenueException extends RuntimeException {

    public static final String MESSAGE = "Street and avenue cannot occupy the same road" +
        " - avenue already present";

    public StreetAssignmentConflictsWithExistingAvenueException (String message) {
        super(message);
    }
}