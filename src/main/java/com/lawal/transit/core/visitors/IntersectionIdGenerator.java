package com.lawal.transit.core.visitors;

public enum IntersectionIdGenerator {
    INSTANCE;
    private int id = 1;


    public int nextId() {
        return id++;
    }
} // end class IntersectionIdGenerator



