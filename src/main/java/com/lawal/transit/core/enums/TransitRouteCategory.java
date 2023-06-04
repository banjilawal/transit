package com.lawal.transit.core.enums;

public enum TransitRouteCategory {
    REGULAR,
    EXPRESS,
    NONE;

    public String print() {
        String string = this.toString().substring(0, 1).toUpperCase()
                + this.toString().substring(1).toLowerCase();
        return string;
    }
} // end enum RouteCategory
