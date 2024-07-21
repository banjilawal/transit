package com.lawal.transit.graph;

import java.util.*;

public class Weight implements Weightable {

    public static final String SET_WEIGHT_VALUE_ERROR = "Cannot set the weight\'s value to a negative number";
    private int value;

    public Weight (int value) {
        this.value = value;
    }


    @Override
    public int getValue () {
        return value;
    }

    @Override
    public void setValue (int value) throws Exception {
        if (value < 0)
            throw new Exception(SET_WEIGHT_VALUE_ERROR);
        this.value = value;
    }

    @Override
    public boolean equals (Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Weightable weightable)
            return value == weightable.getValue();
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(value);
    }

    @Override
    public String toString () {
        return getClass().getSimpleName() + " value:" + value;
    }
}
