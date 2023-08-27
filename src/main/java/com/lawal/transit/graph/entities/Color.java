package com.lawal.transit.graph.entities;

public enum Color {
    WHITE,
    GRAY,
    BLACK,
    NONE;

    public String abbreviation () {
        switch (this) {
            case WHITE:
                return "W";
            case GRAY:
                return "G";
            case BLACK:
                return "B";
            case NONE:
                return "NA";
            default:
                return "Abbreviation not set";
        }
    } //
} // end enum
