package com.lawal.transitcraft.common.exception;

public class TransitCraftIdNullException extends TransitCraftException {
    public static final String MESSAGE = "TransitCraftId Entity's ID is null.";
    public TransitCraftIdNullException (String message) {
        super(message);
    }
}