package com.lawal.transit.core.populator;

import com.lawal.transit.core.entities.Avenue;
import com.lawal.transit.core.entities.GlobalConstant;
import com.lawal.transit.core.entities.Street;
import com.lawal.transit.core.interfaces.Populator;
import com.lawal.transit.core.singletons.Avenues;
import com.lawal.transit.core.singletons.Roads;
import com.lawal.transit.core.singletons.Streets;
import com.lawal.transit.core.visitors.NameGenerator;
import com.lawal.transit.core.visitors.SerialNumberGenerator;

import java.util.Iterator;

public enum RoadPopulator implements Populator {
    INSTANCE;
    private String avenueName;
    private String streetName;
    private int id;

    public void populate () {
        populateSubClassCollections();
        populateSuperClassCollection();
    } // close populate

    private void populateSubClassCollections () {
        int totalNames = GlobalConstant.AVENUE_NAMES.length;
        addBorderRoads(GlobalConstant.START_BORDER_ID);

        for (int index = 0; index < totalNames; index++) {
            id = SerialNumberGenerator.INSTANCE.assignNumber(this);
            avenueName = GlobalConstant.AVENUE_NAMES[index];
            streetName = Integer.toString(index + 1);
            Avenues.INSTANCE.add(new Avenue(id, avenueName));
            Streets.INSTANCE.add(new Street(id, streetName));
        }
        addBorderRoads(GlobalConstant.END_BORDER_ID);
    } // close populateSubClassCollections

    private void populateSuperClassCollection () {
        Iterator<Avenue> avenueIterator = Avenues.INSTANCE.iterator();
        Iterator<Street> streetIterator = Streets.INSTANCE.iterator();

        while (avenueIterator.hasNext() && streetIterator.hasNext()) {
            Avenue avenue = avenueIterator.next();
            Street street = streetIterator.next();

            Roads.INSTANCE.add(avenue);
            Roads.INSTANCE.add(street);
        }
    } // close populateSuperClassCollection

    private void addBorderRoads (int borderID) {
        switch (borderID) {
            case 100:
                Avenues.INSTANCE.add(new Avenue(GlobalConstant.START_BORDER_ID, GlobalConstant.WEST_BORDER_NAME));
                Streets.INSTANCE.add(new Street(GlobalConstant.START_BORDER_ID, GlobalConstant.NORTH_BORDER_NAME));
                break;
            case 200:
                Avenues.INSTANCE.add(new Avenue(GlobalConstant.END_BORDER_ID, GlobalConstant.EAST_BORDER_NAME));
                Streets.INSTANCE.add(new Street(GlobalConstant.END_BORDER_ID, GlobalConstant.SOUTH_BORDER_NAME));
                break;
        }
    } // close addBorderRoads
} // end class RoadPopulator