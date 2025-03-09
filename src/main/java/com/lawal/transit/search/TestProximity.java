package com.lawal.transit.search;

import com.lawal.transit.FactoryDriver;
import com.lawal.transit.address.model.Address;
import com.lawal.transit.block.model.Block;
import com.lawal.transit.catalog.AddressCatalog;

public class TestProximity {

    public static void main(String[] args) {
        // Set up avenues, streets, blocks, junctions, and address


//        Address address = AddressCatalog.INSTANCE.findById(1L);
//        System.out.println(address);

//
//        Avenue avenue1 = new Avenue(1L, "First Avenue");
//        Street street1 = new Street(2L, "Main Street");
//
//        // Blocks
//        Block avenueBlock = new Block(1L, "Block A", new Curb());
//        avenueBlock.setAvenue(avenue1);
//
//        Block streetBlock = new Block(2L, "Block B", new Curb());
//        streetBlock.setStreet(street1);
//
//        Block connectedBlock = new Block(3L, "Connected Block", new Curb());
//        Station station = new Station(101L, "Station Alpha", connectedBlock);
//        connectedBlock.setStation(station);
//
//        // Junction and corners
//        Junction junction = new Junction(1L, avenue1, street1);
//        JunctionCorner corner = new JunctionCorner(1L, "Corner 1", junction, Direction.NORTHEAST, avenueBlock, streetBlock);
//
//        // Associated junctions
//        List<Junction> junctions = List.of(junction);
//
//        // Address setup
//        Address address = new Address(1L, "123 Main St.", avenueBlock);
//
//        // Find the closest block with a station
//        Block closestBlock = ClosestStationFinder.findClosestBlockWithStation(address, junctions);
//
//        if (closestBlock != null) {
//            System.out.println("Closest block with a station: " + closestBlock.getName());
//        } else {
//            System.out.println("No block with a station found.");
//        }
    }
}