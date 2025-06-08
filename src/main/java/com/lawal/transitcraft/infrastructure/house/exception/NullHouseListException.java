package com.lawal.transitcraft.infrastructure.house.exception;

public class NullHouseListException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "A null HouseList cannot be passed be passed to a method";

    public NullHouseListException (String message) {
        super(message);
    }
}