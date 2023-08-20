package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.*;

import java.util.ArrayList;

public class Passenger extends Person {

    ArrayList<Station> path;

    public Passenger(int id, String name, Location currentLocation, Building destination, Departure departure) {
        super(id, name, currentLocation, destination, departure);
        this.path = new ArrayList<Station>();
    }

    public Passenger(int id, String name, Location currentLocation, Building destination, Departure departure, Arrival arrival) {
        super(id, name, currentLocation, destination, departure, arrival);
        this.path = new ArrayList<Station>();
    }

    public ArrayList<Station> getPath () { return path; }
    public void setPath (ArrayList<Station> stations) { ;}

    @Override
    public Location getCurrentLocation() {
        re
    }

    @Override
    public void setCurrentLocation(Location currentLocation) {

    }
} // end class Person
