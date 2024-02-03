package com.lawal.transit.core.enums;

public enum VehicleState {
    ENGINE_OFF,
    ENGINE_RUNNING,
    STOPPED,
    CRUISING,
    ACCELERATING,
    DECELERATING,
    OPENING_DOORS,
    DOORS_OPEN,
    CLOSING_DOORS,
    DOORS_CLOSED;

    public String print () {
        return this.toString().substring(0, 1).toUpperCase() + this.toString().substring(1).toLowerCase();
    }
} // end enum VehicleState
