package com.lawal.transit.creation;

import com.lawal.transit.globals.*;
import com.lawal.transit.graph.*;
import com.lawal.transit.road.*;

import java.util.*;

public class AvenueFactoryDriver {

    public static void printStations (VertexCollection vertices) {
        Iterator<Vertex> iterator =  vertices.iterator();
        while(iterator.hasNext()) {
            System.out.println("\t" + iterator.next());
        }
    }

    public static void printBuildings (AddressableCollection buildings) {
        Iterator<Addressable> iterator =  buildings.iterator();
        while(iterator.hasNext()) {
            System.out.println("\t" + iterator.next());
        }
    }

    public static void printAvenueDetails (Avenue avenue) {
        System.out.println(avenue.toString());
        printStations(avenue.getLeftSideStations());
        printStations(avenue.getRightSideStations());
        printBuildings(avenue.getLeftSideBuildings());
        printBuildings(avenue.getRightSideBuildings());
    }

    public static void main (String[] args) throws Exception {
        AvenueFactory factory = new AvenueFactory(1, 1, 16);
        String[] names = {"alpah", "beta", "delta", "gamma"};
        Avenues avenues = factory.make(Constant.AVENUE_NAMES);
        for(Avenue avenue : avenues.getAvenues()) {
//            System.out.println(avenue);
            printAvenueDetails(avenue);
        }
//        while(avenues.iterator().hasNext()) {
//            printAvenueDetails(avenues.iterator().next());
//        }

//        while(avenues.iterator().hasNext()) {
//            System.out.println(avenues.iterator().next());
//        }
    }
}
