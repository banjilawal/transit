package com.lawal.transit.core.entities;

import com.lawal.transit.core.abstracts.Coordinate;

public class Intersection extends Coordinate {

    public Intersection (int id, String name, Avenue xPath, Street yPath) {
        this(id, name, xPath, yPath, 0, 0);
    } // close
    public Intersection (int id, String name, Avenue xPath, Street yPath, int xCoordinateIndex, int yCoordinateIndex) {
        super(id, name, xPath, yPath, xCoordinateIndex, yCoordinateIndex);
    } // close

    public Avenue getAvenue () {
        return (Avenue) getXPath();
    } // close getStreet

    public Street getStreet () { return (Street) getYPath(); } // close getStreet

    public void setStreet (Street street) {
        setYPath(street);
    } // close getStreet

    public void setAvenue (Avenue avenue) {
        setXPath(avenue);
    } // close getStreet

    public Intersection copy () {
        return new Intersection(getId(), getName(), getAvenue(), getStreet(), getXCoordinateIndex(), getYCoordinateIndex());
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Intersection intersection) {
            return super.equals(intersection) && sameAvenue(intersection.getAvenue()) && sameStreet(intersection.getStreet());
        }
        return false;
    } // close equals

    @Override
    public int hashCode () {
        return super.hashCode();
    } // close hashCode

    private boolean sameStreet (Street street) { return getStreet().equals(street); }

    private boolean sameAvenue (Avenue avenue) { return getAvenue().equals(avenue); }
} // end class Intersection
