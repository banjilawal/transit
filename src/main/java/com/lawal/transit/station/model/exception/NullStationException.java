package com.lawal.transit.station.model.exception;

public class NullStationException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Station cannot be null";
    public NullStationException (String message) {
        super(message);
    }
}