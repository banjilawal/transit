//package com.lawal.transit.creation;
//
//public class AvenueFactoryDriver {
//
//    public static void printStations (Stationables vertices) {
//        Iterator<OldStationable> iterator =  vertices.iterator();
//        while(iterator.hasNext()) {
//            System.out.println("\t" + iterator.next());
//        }
//    }
//
//    public static void printBuildings (Addressables buildings) {
//        Iterator<Addressable> iterator =  buildings.iterator();
//        while(iterator.hasNext()) {
//            System.out.println("\t" + iterator.next());
//        }
//    }
//
//    public static void printAvenueDetails (Avenue avenue) {
//        System.out.println(avenue.toString());
//        printStations(avenue.getLeftFrontage().stations());
//        printStations(avenue.getRightFrontage().stations());
//        printBuildings(avenue.getLeftFrontage().buildings());
//        printBuildings(avenue.getRightFrontage().buildings());
//    }
//
//    public static void main (String[] args) throws Exception {
//        AvenueCreator factory = new AvenueCreator(1, 1, 16, 4);
//        Avenues avenues = factory.make(Constant.AVENUE_NAMES);
//        for(Avenue avenue : avenues.getAvenues()) {;
//            printAvenueDetails(avenue);
//        }
//    }
//}
