package com.lawal.transit.core.populate;
/*
import com.lawal.transit.middleware.abstracts.TransitRoute;
import com.lawal.transit.middleware.abstracts.Item;
import com.lawal.transit.middleware.abstracts.Road;
import com.lawal.transit.middleware.entities.*;
import com.lawal.transit.middleware.enums.RoadCategory;
import com.lawal.transit.middleware.enums.TransitRouteCategory;
import com.lawal.transit.middleware.enums.Direction;
import com.lawal.transit.middleware.singletons.*;
import com.lawal.transit.middleware.singletons.StationPaths;

import java.util.*;

public class PopulateSingletons {

    private static int baseAddressNumber = 1000;
    private static int addressesPerBlockSide = 4;

    private static int blocksPerRoadSide;
    private static int addressesPerRoadSide;

    private static int BusLinePerRoad = 1;
    private int stationPerRoad;
    private int stationCount;
    private static int stationStartNumber = 10000;
    private static String stationNamePrefix = "MT-";

    private static  String[] roadNames = {
            "Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot",
            "Golf", "Hotel", "Igloo", "Juliet", "Kilo", "Lima",
            "Mike", "November", "Oscar", "Papa", "Quebec", "Rome",
            "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "Xray",
            "Yankee","Zeta"
    };
    private static ArrayList<String> expressBusRouteNames = new ArrayList<String>(Arrays.asList("Downtown", "Midtown", "Uptown"));
    private static ArrayList<String> busRouteNames = new ArrayList<String>(
            Arrays.asList (
                    "Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet", "Gold","Olive",
                    "Juno", "Silver", "Pearl", "Oak", "Pine", "Elm", "Cedar", "Venus", "Pluto", "Neptune",
                    "Cobalt", "Hemlock", "Saturn", "Mercury", "Mars", "Platinum", "Amber", "Teak", "Iroko",
                    "Ebony", "Mahagony", "Fir", "Cypress", "Downtown", "Midtown", "Uptown", "A", "B", "C",
                    "D", "E", "F", "G", "H", "J", "k", "L", "M", "N", "Q", "R", "S", "T", "U", "V", "W", "X",
                    "Y", "Z", "alpha", "beta", "delta", "epsilon", "gamma", "omega", "sigma", "theta", "lambda",
                    "zeta", "kappa", "tau", "micron", "11", "22", "33", "44", "55", "66", "77", "88", "99",
                    "3", "4", "5", "6", "7", "9", "10", "12", "13", "14", "15", "16", "17", "18", "19"
            )
    );

    public static void populate() {
        populateArteries();
        populateAddresses();
        populateStationRoutes();
   //     populateEdges();
    }

    public static void populateArteries () {
        for (int index = 0; index < roadNames.length; index++) {
            Arteries.getInstance().getArteries().add(new Road((index + 1), roadNames[index], RoadCategory.AVENUE));
            Arteries.getInstance().getArteries().add(new Road((index + 27), Integer.toString(index + 1), RoadCategory.STREET));
        }
    } // close populateArteries

    public static void populateAddresses () {
        blocksPerRoadSide = Arteries.getInstance().getArteries().size() / 2;
        addressesPerRoadSide =  addressesPerBlockSide * blocksPerRoadSide;
        System.out.println("addresses per roadside:" + addressesPerRoadSide);
        for (Iterator<Item> iterator = Arteries.getInstance().getArteries().iterator(); iterator.hasNext();) {
            Road road = (Road) iterator.next();
            insertAddresses(road);
        }
    } // close populateAddresses

    private static void insertAddresses (Road road) {
        int id = 0;
        int nameInterval = 2;
        String name = "";
        int rightStartNumber = baseAddressNumber;
        int leftStartNumber = baseAddressNumber + 1;

        Direction leftAddressOrientation = Direction.WEST;
        Direction rightAddressOrientation  = Direction.EAST;
        if (road.getCategory() == RoadCategory.AVENUE) {
            leftAddressOrientation = Direction.NORTH;
            rightAddressOrientation = Direction.SOUTH;
        }

        for (int index = 0; index < addressesPerRoadSide; index +=nameInterval) {
            id = Addresses.nextSerialNumber();
            name = Integer.toString(leftStartNumber + index);
            Addresses.getInstance().getAddresses().add(new Address(id, name, road, leftAddressOrientation));

            id = Addresses.nextSerialNumber();
            name = Integer.toString(rightStartNumber + index);
            Addresses.getInstance().getAddresses().add(new Address(id, name, road, rightAddressOrientation));
        }
    } // close insertAddresses

    public static void populateStationRoutes () {
        //PopulateSingletons.populate();
        for (Iterator<Item> iterator = Arteries.getInstance().iterator(); iterator.hasNext();) {
            Road road = (Road) iterator.next();
            TransitRoute transitRoute = createBusRoute();
            transitRoute.getRoads().add(road);
            RegularBusRoutes.getInstance().getBusRoutes().add(transitRoute);
            iterateCrossRoads(road, transitRoute);
        }
    } // close populateStationRoutes

/*
    public static void populateEdges () {
        for (Iterator<NamedEntity> iterator = RegularBusRoutes.getInstance().getBusRoutes().iterator(); iterator.hasNext();) {
            TransitRoute transitRoute = (TransitRoute) iterator.next();
            iterateNodes(transitRoute);
        }
    } // close populateEdges

    public static void iterateNodes (TransitRoute transitRoute) {
        String name = "";
        String prefix = "";
        String suffix = "";
        String medial = transitRoute.getName();

        for (int index = 0; index < transitRoute.getStops().size(); index++) {
            Station tail = (Station) transitRoute.getStops().get(index + 1);
            Station head = (Station) transitRoute.getStops().get(index + 1);
            prefix = head.getName(); //transitRoute.getStops().get(index).getName();
            suffix = tail.getName(); //transitRoute.getStops().get(index + 1).getName();
            medial =  transitRoute.getName() + Integer.toString(index + 1);
            name = prefix + medial + suffix;
            Edge edge = new Edge(Edges.nextSerialNumber(), name, transitRoute,head, tail);
            Edges.getInstance().getEdges().add(edge);
        }
    } // close iterateNodes


    private static void iterateCrossRoads (Road road, TransitRoute transitRoute) {
        for (Iterator<Item> iterator = Arteries.getInstance().iterator(); iterator.hasNext();) {
            Road crossRoad = (Road) iterator.next();
            if (crossRoad.getCategory() == RoadCategory.getOppositeCategory(road.getCategory())) {
                insertStations(transitRoute, crossRoad, road);
            }
        }
    } // close iterateCrossRoads
    public static void insertStations (TransitRoute transitRoute, Road crossRoad, Road road) {
        Station leftLaneStation = createStation(road,crossRoad, road.getLeftLane(), "increase");
        Station rightLaneStation = createStation(road,crossRoad, road.getRightLane(), "decrease");
        leftLaneStation.addBusRoute(transitRoute);
        rightLaneStation.addBusRoute(transitRoute);

        Stations.getInstance().add(leftLaneStation);
        Stations.getInstance().add(rightLaneStation);
        StationPaths.getInstance().getStations().add(leftLaneStation);

        transitRoute.getStops().add(leftLaneStation);
        transitRoute.getStops().add(rightLaneStation);
    } // close insertStations

    private static Station createStation (Road road, Road crossRoad, Direction direction, String idOperation) {
        int id = 0;
        int numberOfStations = 5408;

        if (idOperation.equalsIgnoreCase("decrease")) {
            id = numberOfStations - Stations.nextSerialNumber() ;
        }
        else {
            id = Stations.nextSerialNumber();
        }
        String name = stationNamePrefix + Integer.toString(stationStartNumber + id);
        return new Station(id, name, direction, road, crossRoad);
    } // close createStation

    private static TransitRoute createBusRoute () {
        String name = getRouteName();
        TransitRouteCategory category = busCategoryFromName(name);
        return new TransitRoute(RegularBusRoutes.nextSerialNumber(), name, category);
    } // close getBusLine
    private static String getRouteName () {
        String name = randomBusRouteName();
        while (RegularBusRoutes.getInstance().getBusRoutes().search(name) != null) {
            name = randomBusRouteName();
        }
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        return name;
    } // close getName

    private static TransitRouteCategory busCategoryFromName(String name) {
        if (expressBusRouteNames.contains(name)) {
            return TransitRouteCategory.EXPRESS;
        }
        return TransitRouteCategory.REGULAR;
    } // close getCategory

    private static String randomBusRouteName () {
        int index = (int) (Math.random() * (busRouteNames.size() - 1));
        return busRouteNames.get(index);
    } // close
} // end class PopulateSingletons
 */