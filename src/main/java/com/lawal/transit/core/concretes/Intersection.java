package com.lawal.transit.core.concretes;
import com.lawal.transit.core.abstracts.Coordinate;

import java.util.*;

public class Intersection extends Coordinate {
    private int id;
    private String name;

    public Intersection (int id, Avenue avenue, Street street) {
        super(avenue, street);
        this.id = id;
        this.name = avenue.getName() + "-" + street.getName();
    }

    public int getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public Avenue getAvenue () {
        return (Avenue) getXPath();
    }

    public Street getStreet () {
        return (Street) getYPath();
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (object instanceof Intersection intersection) {
            return super.equals(intersection)
                && id == intersection.getId()
                && getAvenue().equals(intersection.getAvenue())
                && getStreet().equals(intersection.getStreet());
        }
        return false;
    }


    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), id);
    }


    @Override
    public String toString () {
        return getClass().getSimpleName() + ":" + id + " name:" + name;
    }
} // end class Intersection
