package com.lawal.transit.global;

public enum VertexColor {
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
    }

    public String print() {
        return this.toString().substring(0, 1).toUpperCase() + this.toString().substring(1).toLowerCase();
    }
} // end enum VertexColor