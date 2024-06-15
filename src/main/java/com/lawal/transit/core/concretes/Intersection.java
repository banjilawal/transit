package com.lawal.transit.core.concretes;
import com.lawal.transit.core.abstracts.Coordinate;

import java.util.*;

public class Intersection extends Coordinate {
    private int id;
    private String name;

    public Intersection (int id, ConcreteAvenue concreteAvenue, ConcreteStreet concreteStreet) {
        super(concreteAvenue, concreteStreet);
        this.id = id;
        this.name = concreteAvenue.getName() + "-" + concreteStreet.getName();
    }

    public int getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public ConcreteAvenue getAvenue () {
        return (ConcreteAvenue) getXPath();
    }

    public ConcreteStreet getStreet () {
        return (ConcreteStreet) getYPath();
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
