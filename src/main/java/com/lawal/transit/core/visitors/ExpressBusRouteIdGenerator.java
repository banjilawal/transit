package com.lawal.transit.core.visitors;

public enum ExpressBusRouteIdGenerator {
    INSTANCE;

    private int id = 1;

    public int nextId () {
        return id++;
    }

} // end class ExpressBusRouteIdGenerator



