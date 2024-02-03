package com.lawal.transit.core.visitors;

public enum RegularBusRouteIdGenerator {
    INSTANCE;

    private int id = 1;

    public int nextId () {
        return id++;
    }

} // end class RegularBusRouteIdGenerator



