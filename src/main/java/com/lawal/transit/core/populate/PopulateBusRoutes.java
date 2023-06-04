package com.lawal.transit.core.populate;

public class PopulateBusRoutes extends Populate {
    /*
    private static int BusLinePerRoad = 1;
    private static ArrayList<String> expressLines = new ArrayList<String>(Arrays.asList("Downtown", "Midtown", "Uptown"));



    public static void populate () {
        for (Iterator<Road> iterator = Arteries.getInstance().iterator(); iterator.hasNext()) {
            Road artery = (Road) iterator.next();
            TransitRoute busRoute = getBusLine();
            busRoute.getRoads().add(artery);
            RegularBusRoutes.getInstance().add(busRoute);
        }
    } // close populate

    private static TransitRoute getBusLine () {
        String name = getUniqueRouteName();
        TransitRouteCategory category = categoryFromName(name);
        return new TransitRoute(RegularBusRoutes.nextSerialNumber(), name, category);
    } // close getBusLine
    private static String getUniqueRouteName () {
        String name = randomName();
        while (RegularBusRoutes.getInstance().search(name) != null) {
            name = randomName();
        }
        name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        return name;
    } // close getName

   private static TransitRouteCategory categoryFromName(String name) {
        if (expressLines.contains(name)) {
            return TransitRouteCategory.EXPRESS;
        }
        return TransitRouteCategory.REGULAR;
    } // close getCategory



     */
} // end class RegularBusRoutes
