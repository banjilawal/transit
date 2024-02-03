package com.lawal.transit.core.visitors;

public enum AvenueIdGenerator {

    INSTANCE;
    private int id = 1;


    public int nextId() {
        return id++;
    }
} // end class AvenueIdGenerator



