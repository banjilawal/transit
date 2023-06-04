package com.lawal.transit.core.populator;

import com.lawal.transit.core.entities.Avenue;
import com.lawal.transit.core.entities.GlobalConstant;
import com.lawal.transit.core.entities.Street;
import com.lawal.transit.core.singletons.Avenues;
import com.lawal.transit.core.singletons.Roads;
import com.lawal.transit.core.singletons.Streets;
import com.lawal.transit.core.visitors.NameGenerator;
import com.lawal.transit.core.visitors.SerialNumberGenerator;

import java.util.Iterator;
import java.util.function.Predicate;

public enum RoadPopulator implements Populator {
    INSTANCE;
    private String avenueName;
    private String streetName;
    private int id;

//    public static String WEST_BORDER_NAME = "WestBorder";
//    public static String EAST_BORDER_NAME = "EastBorder";
//    public static String NORTH_BORDER_NAME = "NorthBorder";
//    public static String SOUTH_BORDER_NAME = "SouthBorder";
//    public int START_BORDER_ID = 100;
//    public int END_BORDER_ID = 200;

    public void populate () {
        populateSubClassCollections();
        populateSuperClassCollection();
    } // close populate

    private void populateSubClassCollections () {
        int totalNames = NameGenerator.INSTANCE.AVENUE_NAMES.length;
        addBorderRoads(GlobalConstant.START_BORDER_ID);
        for (int index = 0; index < totalNames; index++) {
            id = SerialNumberGenerator.INSTANCE.assignNumber(this);
            avenueName = NameGenerator.INSTANCE.AVENUE_NAMES[index];
            streetName = Integer.toString(index + 1);
            Avenues.INSTANCE.getAvenues().add(new Avenue(id, avenueName));
            Streets.INSTANCE.getStreets().add(new Street(id, streetName));
        }
        addBorderRoads(GlobalConstant.END_BORDER_ID);
    } // close populateSubClassCollections

    private void populateSuperClassCollection () {
        Iterator<Avenue> avenueIterator = Avenues.INSTANCE.iterator();
        Iterator<Street> streetIterator = Streets.INSTANCE.iterator();
        while (avenueIterator.hasNext()) {
            Avenue avenue = avenueIterator.next();
            while (streetIterator.hasNext()) {
                Street street = streetIterator.next();
                Roads.INSTANCE.roads.add(avenue);
                Roads.INSTANCE.roads.add(street);
            }
        }
    } // close populatwSuperClassCollection

    private void addBorderRoads (int borderID) {
        switch (borderID) {
            case 100:
                Avenues.INSTANCE.getAvenues().add(new Avenue(GlobalConstant.START_BORDER_ID, GlobalConstant.EAST_BORDER_NAME));
                Streets.INSTANCE.getStreets().add(new Street(GlobalConstant.START_BORDER_ID, GlobalConstant.NORTH_BORDER_NAME));
                break;
            case 200:
                Avenues.INSTANCE.getAvenues().add(new Avenue(GlobalConstant.END_BORDER_ID, GlobalConstant.WEST_BORDER_NAME));
                Streets.INSTANCE.getStreets().add(new Street(GlobalConstant.END_BORDER_ID, GlobalConstant.SOUTH_BORDER_NAME));
                break;
        }
    } // close addBorderRoads
} // end class RoadPopulator