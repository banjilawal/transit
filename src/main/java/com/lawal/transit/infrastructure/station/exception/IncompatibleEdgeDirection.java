package com.lawal.transit.infrastructure.station.exception;

import java.io.Serial;

public class IncompatibleEdgeDirection extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    public static final String MESSAGE = "There is incompatibility between the edge direction and head/tail station";

    public IncompatibleEdgeDirection (String message) {
        super(message);
    }
}