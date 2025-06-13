package com.lawal.transitcraft.infrastructure.road.exception;

import com.lawal.transitcraft.common.exception.TransitCraftException;

public class ImmutableStreetModificationException extends TransitCraftException {

    public static final String MESSAGE = "Cannot modify street in road" +
        " - street assignments are final once created";

    public ImmutableStreetModificationException (String message) { super(message); }
}