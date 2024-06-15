package com.lawal.transit.test.populator;

import com.lawal.transit.core.concretes.*;
import com.lawal.transit.core.concretes.ConcreteAvenue;
import com.lawal.transit.core.global.Constant;
import com.lawal.transit.core.interfaces.Populator;
import com.lawal.transit.core.singletons.Avenues;
import com.lawal.transit.core.singletons.Roads;
import com.lawal.transit.core.singletons.Streets;
import com.lawal.transit.core.visitors.SerialNumberGenerator;

import java.util.Iterator;

public enum RoadPopulator implements Populator {
    INSTANCE;
    private String avenueName;
    private String streetName;
    private int id;

    public void populate () {
        createStreetsAndAvenues();
        roadsSingletonHandler();
    } // close populate

    private void createStreetsAndAvenues () {
        int totalNames = Constant.AVENUE_NAMES.length;
        addBorderRoads(Constant.START_BORDER_ID);

        for (int index = 0; index < totalNames; index++) {
            id = SerialNumberGenerator.INSTANCE.assignNumber(this);
            avenueName = Constant.AVENUE_NAMES[index];
            streetName = Integer.toString(index + 1);
            Avenues.INSTANCE.add(new ConcreteAvenue(id, avenueName));
            Streets.INSTANCE.add(new ConcreteStreet(id, streetName));
        }
        addBorderRoads(Constant.END_BORDER_ID);
    } // close populateSubClassCollections

    private void roadsSingletonHandler () {
        Iterator<ConcreteAvenue> avenueIterator = Avenues.INSTANCE.iterator();
        Iterator<ConcreteStreet> streetIterator = Streets.INSTANCE.iterator();

        while (avenueIterator.hasNext() && streetIterator.hasNext()) {
            ConcreteAvenue concreteAvenue = avenueIterator.next();
            ConcreteStreet concreteStreet = streetIterator.next();

            Roads.INSTANCE.add(concreteAvenue);
            Roads.INSTANCE.add(concreteStreet);
        }
    } // close populateSuperClassCollection

    private void addBorderRoads (int borderID) {
        switch (borderID) {
            case 100:
                Avenues.INSTANCE.add(new ConcreteAvenue(Constant.START_BORDER_ID, Constant.WEST_BORDER_NAME));
                Streets.INSTANCE.add(new ConcreteStreet(Constant.START_BORDER_ID, Constant.NORTH_BORDER_NAME));
                break;
            case 200:
                Avenues.INSTANCE.add(new ConcreteAvenue(Constant.END_BORDER_ID, Constant.EAST_BORDER_NAME));
                Streets.INSTANCE.add(new ConcreteStreet(Constant.END_BORDER_ID, Constant.SOUTH_BORDER_NAME));
                break;
        }
    } // close addBorderRoads
} // end class RoadPopulator