package com.lawal.transit.station;


import com.lawal.transit.block.Block;
import com.lawal.transit.block.Blocks;
import com.lawal.transit.global.Address;
import com.lawal.transit.catalog.StationCatalog;
import com.lawal.transit.global.Direction;
import com.lawal.transit.global.IdGenerator;
import com.lawal.transit.global.NameGenerator;

public final class StationsCreator {
//
//    private Blocks targetBlocks;
//
//    public StationsCreator() {}
//
//    public Blocks getTargetBlocks () {
//        return targetBlocks;
//    }
//
//    public StationsCreator targetBlocks (Blocks targetBlocks) {
//        this.targetBlocks = targetBlocks;
//        return this;
//    }
//
//    public Stations getProduct (Blocks blocks) throws Exception {
//        StationCatalog stationCatalog = StationCatalog.INSTANCE;
//
//        if (targetBlocks == null || targetBlocks.isEmpty() ) { return new Stations();   }
//        else {
//            Direction travelDirection = targetBlocks.get(0).getTag().curbMarker().travelDirection();
//            Stations stations = new Stations();
//            for (Block targetBlock : targetBlocks) {
//                Address address = new Address.Builder().id(IdGenerator.INSTANCE.nextStationID())
//                    .name(NameGenerator.INSTANCE.stationName(travelDirection))
//                    .blockTag(targetBlock.getTag())
//                    .build();
//                Station station = new Station(address, );
//
//                stationCatalog.getCatalog().add(station);
//                stations.add(new Station(address, ));
//            }
//            return stations;
//        }
//    }
}