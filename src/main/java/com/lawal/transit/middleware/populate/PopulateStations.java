package com.lawal.transit.middleware.populate;

public class PopulateStations extends Populate {
    /*
    private int stationPerRoad;
    private int stationCount;
    private static int startNumber = 10000;
    private static String prefix = "mt-";

    public static void populate () {
        Arteries arteries = Arteries.getInstance();

        if (arteries.getTotal() == 0) {
            PopulateSingletons.populate();
        }
        Road avenue = new Road();
        for (Iterator<Road> iterator = arteries.iterator(); iterator.hasNext();) {
            Road artery = (Road) iterator.next();
            populateRoads(arteries, artery);
        }
    } // close populate

    private static void populateRoads (Arteries arteries, Road artery) {
        RoadCategory crossArteryCategory = RoadCategory.NONE;

        for (Iterator<Road> iterator = arteries.iterator(); iterator.hasNext();) {
            Road crossArtery = (Road) iterator.next();
            if (crossArtery.getCategory() == RoadCategory.getOppositeCategory(artery.getCategory())) {
                addStation(artery, crossArtery, artery.getLeftLane());
                addStation(artery, crossArtery, artery.getRightLane());
            }
        }

        if (artery.getCategory() == RoadCategory.AVENUE) {
            crossArteryCategory = RoadCategory.STREET;
        }

        for (Road crossRoad : arteries) {
            if (crossRoad.getCategory() == crossArteryCategory) {
                addStation(artery,crossRoad,artery.getLeftLane());
                addStation(artery,crossRoad,artery.getRightLane());
            }
        }


    } // close crossRoadIterator

    private static void addStation (Road artery, Road crossArtery, Direction direction) {
        int id = 0;
        int number = 0;
        Stations stations = Stations.getInstance();

        id = stations.nextSerialNumber();
        number = startNumber + id;
        String name = prefix + Integer.toString(number);
    //    System.out.println(artery.getName() + " crossroad:" + crossArtery.getName() + " id:" + id + " name:" + name);
        stations.add(new Station(id, name, crossArtery, artery, direction));
    } // close addStation
*/
} // end class PopulateStations