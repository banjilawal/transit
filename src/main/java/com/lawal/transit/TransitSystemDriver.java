package com.lawal.transit;

import com.lawal.transit.infrastructure.block.Block;
import com.lawal.transit.common.build.TransitSystemBuilder;
import com.lawal.transit.infrastructure.avenue.Avenue;
import com.lawal.transit.infrastructure.catalog.*;
import com.lawal.transit.infrastructure.house.House;
import com.lawal.transit.infrastructure.junction.Junction;
import com.lawal.transit.graph.search.StationSearch;
import com.lawal.transit.infrastructure.street.Street;

import java.util.Queue;


public class TransitSystemDriver {

    public static void main(String[] args) throws Exception {
        TransitSystemBuilder.INSTANCE.run();
        Street street = StreetCatalog.INSTANCE.findById(1L);
        Avenue avenue = AvenueCatalog.INSTANCE.findById(1L);
        Junction junction = JunctionCatalog.INSTANCE.findById(1L);

        House source = HouseCatalog.INSTANCE.randomHouse();
        House destination = HouseCatalog.INSTANCE.randomHouse();

        Queue<Block> sourceStationPath = StationSearch.search(source);
        Queue<Block> destinationStationPath = StationSearch.search(destination);

        System.out.println("source: " + source + "\ndestination: " + destination);
        System.out.println("source path: ");
        int i = 1;
        for(Block block : sourceStationPath) {
            System.out.println("i=" + i + " hop count:" + block.getHopCount() + " " + block + block.getStation());
            i++;
        }

        i = 1;
        System.out.println("destination path: ");
        for(Block block : destinationStationPath) {
            System.out.println("i=" + i + " hop count:" + block.getHopCount() + " " + block + block.getStation());
            i++;
        }
    }
}