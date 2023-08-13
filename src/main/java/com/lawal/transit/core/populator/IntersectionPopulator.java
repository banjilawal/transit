package com.lawal.transit.core.populator;

import com.lawal.transit.core.entities.Avenue;
import com.lawal.transit.core.entities.Intersection;
import com.lawal.transit.core.entities.Street;
import com.lawal.transit.core.interfaces.Populator;
import com.lawal.transit.core.singletons.Avenues;
import com.lawal.transit.core.singletons.Intersections;
import com.lawal.transit.core.singletons.Streets;
import com.lawal.transit.core.visitors.NameGenerator;
import com.lawal.transit.core.visitors.SerialNumberGenerator;

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
        for (int yIndex = 0; yIndex < Streets.INSTANCE.size(); yIndex++) {
            Street street = Streets.INSTANCE.getBagContents().get(yIndex);
            for (int xIndex = 0; xIndex < Avenues.INSTANCE.size(); xIndex++) {
                Avenue avenue = Avenues.INSTANCE.getBagContents().get(xIndex);
                Intersections.INSTANCE.add(
                    new Intersection(
                        SerialNumberGenerator.INSTANCE.assignNumber(this),
                        NameGenerator.INSTANCE.assignName(this, xIndex, yIndex),
                        avenue,
                        street,
                        xIndex,
                        yIndex
                    )
                );
            }
        }
    } // close populate
} //end enum  IntersectionPopulator

