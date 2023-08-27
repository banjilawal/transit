package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.Location;
import com.lawal.transit.core.abstracts.TransitVehicle;

import java.util.Objects;

public class Bus extends TransitVehicle {

    private RegularBusRoute route;

    public Bus (int id, String name, Station currentStation, RegularBusRoute route) {
        super(id, name, currentStation);
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
