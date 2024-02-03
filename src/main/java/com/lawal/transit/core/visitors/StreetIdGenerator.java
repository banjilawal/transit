package com.lawal.transit.core.visitors;

public enum StreetIdGenerator {
    INSTANCE;
    private int id = 1;


    public int nextId() {
        return id++;
    }
} // end class StreetIdGenerator



