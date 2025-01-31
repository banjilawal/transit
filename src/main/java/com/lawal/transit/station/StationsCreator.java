package com.lawal.transit.station;


import com.lawal.transit.global.Address;
import com.lawal.transit.block.interfaces.RoadSegment;
import com.lawal.transit.catalog.StationCatalog;
import com.lawal.transit.global.Direction;
import com.lawal.transit.global.IdGenerator;
import com.lawal.transit.global.NameGenerator;

import java.util.ArrayList;

public final class StationsCreator {

    private ArrayList<RoadSegment> targetBlocks;

    public StationsCreator() {}

    public ArrayList<RoadSegment> getTargetBlocks () {
        return targetBlocks;
    }

    public StationsCreator targetBlocks (ArrayList<RoadSegment> targetBlocks) {
        this.targetBlocks = targetBlocks;
        return this;
    }

    public Stations getProduct () throws Exception {
        StationCatalog stationCatalog = StationCatalog.INSTANCE;

        if ( targetBlocks == null || targetBlocks.isEmpty() ) { return new Stations();   }
        else {
            Direction travelDirection = targetBlocks.get(0).getTag().curbsideMarker().travelDirection();
            Stations stations = new Stations();
            for (RoadSegment targetBlock : targetBlocks) {
                Address address = new Address.Builder().id(IdGenerator.INSTANCE.nextStationID())
                    .name(NameGenerator.INSTANCE.stationName(travelDirection))
                    .blockTag(targetBlock.getTag())
                    .build();
                Station station = new Station(address);

                stationCatalog.getCatalog().add(station);
                stations.add(new Station(address));
            }
            return stations;
        }
    }
}