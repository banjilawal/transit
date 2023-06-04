package com.lawal.transit.core.populate;

/*
public class PopulateStationRoutes extends Populate {
    private static int BusLinePerRoad = 1;
    private int stationPerRoad;
    private int stationCount;
    private static int stationStartNumber = 10000;
    private static String stationNamePrefix = "MT-";
    private static ArrayList<String> expressBusRouteNames = new ArrayList<String>(Arrays.asList("Downtown", "Midtown", "Uptown"));
    private static ArrayList<String> busRouteNames = new ArrayList<String>(
            Arrays.asList("Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet", "Gold","Olive",
                    "Juno", "Silver", "Pearl", "Oak", "Pine", "Elm", "Cedar", "Venus", "Pluto", "Neptune",
                    "Cobalt", "Hemlock", "Saturn", "Mercury", "Mars", "Platinum", "Amber", "Teak", "Iroko",
                    "Ebony", "Mahagony", "Fir", "Cypress", "Downtown", "Midtown", "Uptown", "A", "B", "C",
                    "D", "E", "F", "G", "H", "J", "k", "L", "M", "N", "Q", "R", "S", "T", "U", "V", "W", "X",
                    "Y", "Z", "alpha", "beta", "delta", "epsilon", "gamma", "omega", "sigma", "theta", "lambda",
                    "zeta", "kappa", "tau", "micron", "11", "22", "33", "44", "55", "66", "77", "88", "99",
                    "3", "4", "5", "6", "7", "9", "10", "12", "13", "14", "15", "16", "17", "18", "19"
            ));

    public static void populateStationRoutes () {
        PopulateSingletons.populate();
        for (Iterator<Road> iterator = Arteries.getInstance().iterator(); iterator.hasNext();) {
            Road artery = (Road) iterator.next();
            TransitRoute busRoute = createBusRoute();
            busRoute.getRoads().add(artery);
            RegularBusRoutes.getInstance().add(busRoute);
            iterateCrossRoads(artery, busRoute);
        }
    } // close populateStationRoutes
    private static void iterateCrossRoads (Road artery,  TransitRoute busRoute) {
        for (Iterator<Road> iterator = Arteries.getInstance().iterator(); iterator.hasNext();) {
            Road crossRoad = (Road) iterator.next();
            if (crossRoad.getCategory() == RoadCategory.getOppositeCategory(artery.getCategory())) {
               insertStations(busRoute, crossRoad, artery);
            }
        }
    } // close iterateCrossRoads
    public static void insertStations (TransitRoute busRoute, Road crossRoad, Road artery) {
        Station stationA = createStation(artery,crossRoad, artery.getLeftLane());
        Station stationB = createStation(artery,crossRoad, artery.getRightLane());
        stationA.getBuses().add(busRoute);
        stationB.getBuses().add(busRoute);

        Stations.getInstance().add(stationA);
        Stations.getInstance().add(stationB);
    } // close insertStations

    private static Station createStation (Road artery, Road crossRoad, Direction direction) {
        int id = Stations.nextSerialNumber();
        String name = stationNamePrefix + Integer.toString(stationStartNumber + id);
        return new Station(id, name, crossRoad, artery, direction);
    } // close createStation

    private static TransitRoute createBusRoute () {
        String name = getRouteName();
        TransitRouteCategory category = busCategoryFromName(name);
        return new TransitRoute(RegularBusRoutes.nextSerialNumber(), name, category);
    } // close getBusLine
    private static String getRouteName () {
        String name = randomName();
        while (RegularBusRoutes.getInstance().search(name) != null) {
            name = randomName();
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

    private static String randomName () {
        int index = (int) (Math.random() * (busRouteNames.size() - 1));
        return busRouteNames.get(index);
    }
} // end class RegularBusRoutes

 */
