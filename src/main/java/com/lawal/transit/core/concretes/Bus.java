package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.Vehicle;

import java.util.Objects;

public class Bus extends Vehicle {

    private RegularBusRoute route;

    public Bus (int id, String name, OldAbstractStation currentOldAbstractStation, RegularBusRoute route) {
        super(id, name, currentOldAbstractStation);
        this.route = route;
    }

    @Override
    public void arriving () {}

    @Override
    public void departing () { }

    public RegularBusRoute getRoute () {
        return route;
    }

    public void setRoute (RegularBusRoute route) {
        this.route = route;
    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof Bus bus) {
            return super.equals(bus) && route.equals(bus.getRoute());
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), route);
    }

    @Override
    public String toString () {
        return super.toString() + " " + route.getName();
    }
} // end class
