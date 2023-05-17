package com.lawal.transit.middleware.entities;

import com.lawal.transit.middleware.abstracts.Coordinate;
import com.lawal.transit.middleware.abstracts.DuplexPath;

public class Intersection extends Coordinate {

    public Intersection (int id, String name, DuplexPath xCoordinate, DuplexPath yCoordinate) {
        super(id, name, xCoordinate, yCoordinate);
    }

    public Street getStreet () {
        return (Street) getXCoordinate();
    } // close getStreet

    public Avenue getAvenue () {
        return (Avenue) getYCoordinate();
    } // close getStreet

    public void setStreet (Street street) {
        setXCoordinate(street);
    } // close getStreet

    public void setAvenue (Avenue avenue) {
        setYCoordinate(avenue);
    } // close getStreet

    @Override
    public boolean equals(Object object) {
        boolean isEqual =  false;
        if (object instanceof Intersection intersection) {

            if (this.getStreet().equals(intersection.getStreet())) {
                if (this.getAvenue().equals(intersection.getAvenue())) {
                    isEqual = true;
                }
            }
        }
        return isEqual;
    } // close equals

    @Override
    public int hashCode () {
        return super.hashCode();
    } // close hashCode

    @Override
    public String toString () {
        String string = this.getClass().getSimpleName()
                + " id:" + getId()
                + " [" + getStreet().getName()
                + " and " + getAvenue().getName() + "]";
        return string;
    } // close toString

    public String fullString () {
        String string = toString(); // + " id:" + getId()
               // + " (street:" + getStreet().getName()
               // + " avenue:" + getAvenue().getName() + ")";
        return string;
    }
} // end class Intersection
