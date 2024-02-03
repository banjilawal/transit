package com.lawal.transit.core.concretes;

import com.lawal.transit.core.abstracts.*;

import java.util.ArrayList;
import java.util.Objects;

public class Passenger extends Person {

    ArrayList<Station> path;

    public Passenger(int id, String name, Location currentLocation, Building destination, Departure departure) {
       super(id, name, currentLocation, destination);
       this.path = new ArrayList<Station>();
    }
    public ArrayList<Station> getPath () { return path; }

    public void setPath (ArrayList<Station> stations) { ;}

    @Override
    public void embark (Vehicle vehicle) {

    }

    @Override
    public void disembark () {

    }

    @Override
    public void arriving () {

    }

    @Override
    public void departing () {

    }

    @Override
    public boolean equals (Object object) {
        if (object instanceof  Person person) return super.equals(person);
        return false;
    }

    @Override
    public int hashCode () {
        return Objects.hash(super.hashCode(), path);
    }

    @Override
    public String toString () { return super.toString(); }



} // end class Person
