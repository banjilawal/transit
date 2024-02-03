package com.lawal.transit.test.populator;

import com.lawal.transit.core.concretes.Avenue;
import com.lawal.transit.core.concretes.Street;
import com.lawal.transit.core.interfaces.Populator;
import com.lawal.transit.core.singletons.Avenues;
import com.lawal.transit.core.singletons.Intersections;
import com.lawal.transit.core.singletons.Streets;

public enum IntersectionPopulator implements Populator {
    INSTANCE;

    @Override
    public void populate() {
        /**
         * ABOUT THE COORDINATES
         * ------------------------
         * Avenues are West-to-East (latitudes) so they are the x-coordinates.
         * Streets are North-to-South (longitudes) so they are y-coordinates.
         * We build these with nested for loops.
         *
         * Loop Configuration
         * ---------------------
         * Outer loop --> iterates y-coords
         * Inner loop --> iterates x-coords
         * Produces Intersection series in natural Cartesian order --> (0,0), (1,0), (2, 0),...(X_n-1, Y_n-1)
         *
         * WARNING
         * ---------
         * Changing this breaks Block ordering and just makes setting neighbors really hard for Blocks and Locations.
         */
        for (Street street : Streets.INSTANCE.getStreets()) {
            for (Avenue avenue : Avenues.INSTANCE.getAvenues()) {
                Intersections.INSTANCE.add(avenue, street);
            }
        }
    } // close populate
} //end enum  IntersectionPopulator

