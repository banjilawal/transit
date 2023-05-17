package com.lawal.transit.middleware.populator;
/*
import com.lawal.transit.middleware.entities.Avenue;
import com.lawal.transit.middleware.entities.Intersection;
import com.lawal.transit.middleware.entities.Street;
import com.lawal.transit.middleware.interfaces.NumberAcceptor;
import com.lawal.transit.middleware.singletons.Avenues;
import com.lawal.transit.middleware.singletons.Intersections;
import com.lawal.transit.middleware.singletons.Streets;
import com.lawal.transit.middleware.visitors.NameGenerator;
import com.lawal.transit.middleware.visitors.SerialNumberGenerator;

public enum IntersectionPopulator implements Populator, NumberAcceptor {
    INSTANCE;
    private Avenue avenue;
    private Street street;
    private Street southStreet;
    private int streetBorderCount = 2;
    private int avenueBorderCount = 2;

    @Override
    public void populate() {
        Intersections intersections = Intersections.INSTANCE;
        Streets streets = Streets.INSTANCE;
        Avenues avenues = Avenues.INSTANCE;
        int totalStreets = streets.size() - 1; //(streetBorderCount + 1);
        int totalAvenues = avenues.size() - 1; //(avenueBorderCount + 1); //avenues.size();

        int streetCounter = 0;
        while (streetCounter < totalStreets) {
            street = (Street) streets.getBag().get(streetCounter);
            int avenueCounter = 0;
            while (avenueCounter < totalAvenues) {
                avenue = (Avenue) avenues.getBag().get(avenueCounter);
                String name = acceptName();
                int id = acceptNumber();
                Intersection intersection = new Intersection(id, name, street, avenue);
                intersections.add(intersection);
                System.out.println(intersection.toString());
                avenueCounter++;
            }
            streetCounter++;
        }
    } // close Populate

    public String acceptName () {
        return NameGenerator.INSTANCE.assignName(this, street, avenue);
    }

     @Override
    public int acceptNumber () {
        return SerialNumberGenerator.INSTANCE.assignNumber(this);
    }
} // end enum IntersectionPopulator
 */
