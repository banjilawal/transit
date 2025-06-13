package com.lawal.transitcraft.common.exception;

public class TransitCraftNegativeIdException extends TransitCraftException {
    public static final String MESSAGE = "TransitCraftId Entity's ID cannot be negative.";
    public TransitCraftNegativeIdException (String message) {
        super(message);
    }
}