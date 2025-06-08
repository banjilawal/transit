package com.lawal.transitcraft.infrastructure.station.exception;

public class StationNameNullException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "Station name cannot be null, empty or blank";
    public StationNameNullException (String message) {
        super(message);
    }
}