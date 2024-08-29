package com.lawal.transit.globals;

import java.io.*;

public enum NameGenerator {
    INSTANCE;

    private int avenueNameIndex = 0;

    public static final String CITY_NAMES = "worldcities.txt";

    public static final String[] AVENUE_NAMES = {
        "Alpha", "Bravo", "Charlie", "Delta", "Echo",
        "Foxtrot", "Golf", "Hotel", "Igloo", "Juliet",
        "Kilo", "Lima", "Mike", "November", "Oscar",
        "Papa", "Quebec", "Rome", "Sierra", "Tango",
        "Uniform", "Victor", "Whiskey", "Xray", "Yankee",
        "Zeta"
    };

    public static final String[] EXPRESS_BUS_ROUTE_NAMES = { "Downtown", "Midtown", "Uptown", "Sundown", "Noon",
        "Zocalo", "Early Bird"
    };

    public static final String[] REGULAR_BUS_ROUTE_NAMES = {
        "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet", "Gold", "Olive",
        "Juno", "Silver", "Pearl", "Oak", "Fig", "Pine", "Elm", "Cedar", "Venus", "Pluto",
        "Neptune", "Cobalt", "Hemlock", "Saturn", "Mercury", "Mars", "Platinum", "Amber",
        "Teak", "Iroko", "Ebony", "Mahogany", "Fir", "Cypress", "A", "B", "C", "D", "E",
        "F", "G", "H", "J", "k", "L", "M", "N", "Q", "R", "S", "T", "U", "V", "W", "X",
        "Y", "Z", "Alpha", "Beta", "Delta", "Epsilon", "Gamma", "Omega", "Sigma", "Theta",
        "Lambda", "Zeta", "Kappa", "Tau", "Micron", "11", "22", "33", "44", "55", "66",
        "77", "88", "99", "3", "4", "5", "6", "7", "9", "10", "12", "13", "14", "15", "16",
        "17", "18", "19", "Zaria", "Kano", "Yola", "Ogbomosho", "Manzikert"
    };

    public String avenueName () throws Exception {
        if (avenueNameIndex < AVENUE_NAMES.length)
            return AVENUE_NAMES[avenueNameIndex++];
        else {
            RandomWordProducer producer = new RandomWordProducer.Builder().file(CITY_NAMES).build();
            return producer.word();
        }
    }

    public String scheduleName () {
        return REGULAR_BUS_ROUTE_NAMES[(int) (Math.random() * REGULAR_BUS_ROUTE_NAMES.length)];
    }
}
