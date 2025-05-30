package com.lawal.transit;

import com.lawal.transit.infrastructure.block.Block;
import com.lawal.transit.common.build.TransitSystemBuilder;
import com.lawal.transit.infrastructure.avenue.Avenue;
import com.lawal.transit.infrastructure.bus.BusRoute;
import com.lawal.transit.infrastructure.catalog.*;
import com.lawal.transit.infrastructure.house.House;
import com.lawal.transit.infrastructure.junction.Junction;
import com.lawal.transit.graph.search.StationSearch;
import com.lawal.transit.infrastructure.road.Road;
import com.lawal.transit.infrastructure.station.Station;
import com.lawal.transit.infrastructure.street.Street;
import com.lawal.transit.report.BusRouteReport;

import java.util.List;
import java.util.Queue;
import java.util.Set;


public class TransitSystemDriver {


    public static Station pathToString (Queue<Block> path) {
//        int i = 1;
        for(Block block : path) {
//            System.out.println("hop count:" + i + " " + block + block.getStation());
            if (block.getStation() != null) return block.getStation();
//            i++;
        }
        return null;
    }

    public static void shortestPathHandler() {

        House source = HouseCatalog.INSTANCE.randomHouse();
        House destination = HouseCatalog.INSTANCE.randomHouse();

        System.out.println("Testing Nearest Station Discovery with Randomly Selected Source and Destination Addresses");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("Source:" + source);
        System.out.println("Destination:" + destination);


        Queue<Block> path = StationSearch.search(source);
        Station station = pathToString(StationSearch.search(source));

        if (station != null) {
            System.out.println("\nWalk " + path.size() + " blocks from " + source.toString()
                + " to embark the " + station.getRouteNames() + " bus at station:"
                + station.getName() + " on " + station.getLocationName());
        } else {
            System.out.println("no embarkation station");
        }

        path = StationSearch.search(destination);
        station = pathToString(StationSearch.search(destination));

        if (station != null) {
            System.out.println("Disembark the " + station.getRouteNames() + " bus at station:"
                + station.getName() + " at " + station.getLocationName()
                + " then walk " + path.size() + " blocks to " + destination.toString());

        } else {
            System.out.println("no disembarkation station");
        }
    }

    public static void main(String[] args) throws Exception {
        TransitSystemBuilder.INSTANCE.run();
        Street street = StreetCatalog.INSTANCE.findById(1L);
        Avenue avenue = AvenueCatalog.INSTANCE.findById(1L);
        Junction junction = JunctionCatalog.INSTANCE.findById(1L);
        Road road = avenue.getRoad();


        Set<Station> orphanStations = StationCatalog.INSTANCE.getGhostStations();
        Set<BusRoute> orphanBusRoutes = BusRouteCatalog.INSTANCE.getGhostBusRoutes();

        System.out.println("Summary of Transit System Generated by COMPAS");
        System.out.println("-----------------------------------------------");
        System.out.println("number of stations:" + StationCatalog.INSTANCE.size());
        System.out.println("Max Station density:" + TransitSystemBuilder.MAX_STATION_DENSITY);
        System.out.println("Number of blocks:" + BlockCatalog.INSTANCE.size());
        System.out.println("Number of Streets:" + StreetCatalog.INSTANCE.size());
        System.out.println("Number of Avenues:" + AvenueCatalog.INSTANCE.size());
        System.out.println("Number of Junctions:" + JunctionCatalog.INSTANCE.size());
        System.out.println("Number of Bus Routes:" + BusRouteCatalog.INSTANCE.size());
        System.out.println("Total Orphan Stations:" + orphanStations.size());
        System.out.println("Total Orphan BusRoutes:" + orphanBusRoutes.size());
        System.out.println("-----------------------------------------------\n");

//        System.out.println(StationCatalog.INSTANCE.ghostStationReport());
//        System.out.println(BusRouteCatalog.INSTANCE.ghostBusRoutesReport());

        System.out.println(BusRouteCatalog.INSTANCE.getSummary());
        System.out.println(StationCatalog.INSTANCE.getOrphansSummary());

        shortestPathHandler();
    }
}